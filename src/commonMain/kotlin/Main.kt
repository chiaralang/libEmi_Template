import com.soywiz.korge.view.addUpdater
import com.soywiz.korim.color.Colors
import me.emig.engineEmi.*

val engineConfig = EngineConfig(width = 1600, height = 750)

suspend fun main() = Engine(engineConfig) {
	//val hut = Bild(150,20,"hut.png")
	//addChild(hut)

    val spaceArray : DoubleArray =  doubleArrayOf(10.0, 50.0, 200.0)


	val iceFloe1 = IceFloe(100, 600, 1000, 50, 3.0)
	addChild(iceFloe1)
	val iceFloe2 = IceFloe(iceFloe1.width + 10, 0, 1000, 50, 3.0, Colors.PURPLE)
	addChild(iceFloe2)
	//val iceFloe3 = IceFloe(1100, 0, 1000, 50, 3.0, Colors.PURPLE)
	//iceFloe1.addChild(iceFloe3)

	val penguin = Player (100, 100, 20, 50, 0.0, Colors.RED)
	addChild(penguin)

	val a = 100.0 //Beschleunigung in y-Richtung -> ≙ Erdanziehung g
	val ax = 10.0 //Beschleunigung in x-Richtung -> Schwierigkeitsgrad erhöhen

	//vy -> Geschwindigkeit in y-Richtung (Pinguin)
	//vx -> Geschwindigkeit in x-Richtung (Eisscholle)

	addUpdater { dt ->
		//iceFloe wird in x Richtung mit ax beschleunigt
		val ifvxAlt = iceFloe1.vx
		val ifvxNeu = iceFloe1.vx + (-ax)*dt.seconds

		iceFloe1.x += 0.5*(ifvxAlt + ifvxNeu) * dt.seconds

		iceFloe1.vx = ifvxNeu

		//penguin wird in y Richtung mit a beschleunigt (Fall)
		val pvyAlt = penguin.vy
		val pvyNeu = penguin.vy + a*dt.seconds

		penguin.y += 0.5*(pvyAlt + pvyNeu) * dt.seconds

		penguin.vy = pvyNeu

		//penguin stößt sich mit vy ab, wenn er die Scholle trifft, wenn nicht fällt er hinunter
		if (penguin.y + penguin.height >= iceFloe1.y && penguin.x < iceFloe1.x + iceFloe1.width && penguin.x > iceFloe1.x) {
			penguin.vy = -150.0
			penguin.y = iceFloe1.y - penguin.height
		}

	}

}