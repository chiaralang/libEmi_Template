import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import me.emig.engineEmi.graphics.shapes.Rechteck

class Player(x: Number = 0.0,
             y: Number = 0.0,
             width: Number = 100.0,
             height: Number = 100.0,
             var vy: Double = 0.0,
             fillColor: RGBA = Colors.BLACK,
             strokeColor: RGBA = Colors.RED,
             strokeThickness : Number = 0.0
            )
    : Rechteck(x, y, height, width, fillColor, strokeColor, strokeThickness) {


    }