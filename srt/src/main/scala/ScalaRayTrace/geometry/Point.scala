package ScalaRayTrace.geometry

/**
 * Created by egolin on 6/13/14.
 */
class Point(val x:Double, val y:Double, val z:Double) {

  def +(v:Vector):Point = new Point(x+v.x, y+v.y, z+v.z)
  def -(that:Point):Vector = new Vector(this.x-that.x, this.y-that.y, this.z-that.z)

  override def toString() = "(" + x + ", " + y + ", " + z + ")"

  def toHomogenous() = new Vector4(x,y,z,1.0)
}

object Point {
  def apply(v:(Double, Double, Double)) = new Point(v._1, v._2, v._3)
}
