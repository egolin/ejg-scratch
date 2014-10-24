package ScalaRayTrace.geometry

import scala.math.sqrt

/**
 * Created by egolin on 6/13/14.
 */
class Vector(val xc:Double, val yc:Double, val zc:Double) extends Point(xc,yc,zc) {

  override def toHomogenous() = new Vector4(x,y,z,0.0)

  def * (scale:Double):Vector = new Vector(xc*scale, yc*scale, zc*scale)

  def * (that:Vector) : Double = this.xc*that.xc + this.yc*that.xc + this.zc*that.zc

  def normalize() = {
    val m = sqrt(this * this)
    new Vector(x/m, y/m, z/m)
  }
}

object Vector {
  def apply(x:Double, y:Double, z:Double) = new Vector(x,y,z)
  def apply(p:Point) = new Vector(p.x, p.y, p.z)
}
