package ScalaRayTrace.geometry

/**
 * Created by egolin on 6/23/14.
 */
class Ray(pt:Point, dv:Vector) {
  val d = dv.normalize();
  def x0() = pt

  override def toString: String = "[RAY pt:" + x0 + ", d:" + d + "]"
}

object Ray {
  def apply(p:Point, v:Vector) = new Ray(p,v)
}
