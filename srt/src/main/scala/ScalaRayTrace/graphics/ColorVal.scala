package ScalaRayTrace.graphics

/**
 * Created by egolin on 6/13/14.
 */
class ColorVal(red_intensity:Float, green_intensity:Float, blue_intensity:Float ) {
  require (red_intensity >= 0.0 && red_intensity <= 1.0)
  require (green_intensity >= 0.0 && green_intensity <= 1.0)
  require (blue_intensity >= 0.0 && blue_intensity <= 1.0)

  def r() = red_intensity
  def g() = green_intensity
  def b() = blue_intensity

  override def toString():String = "(" + r + ", " + g + ", " + b + ")"

  def RGB() : (Short, Short, Short) = (ColorVal.quantize(r), ColorVal.quantize(g), ColorVal.quantize(b))
}

object ColorVal {
  def apply(rv:Float, gv:Float, bv:Float) = new ColorVal(rv, gv, bv)
  def quantize(intensity:Float) = ((intensity*255.0f)+0.5f).toShort
}
