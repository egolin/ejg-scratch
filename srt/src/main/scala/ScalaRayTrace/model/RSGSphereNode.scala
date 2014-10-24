package ScalaRayTrace.model

import ScalaRayTrace.geometry.{Point, Vector, Ray, Transform3D}

import scala.math.sqrt

/**
 * Created by egolin on 6/24/14.
 */
class RSGSphereNode(m: Transform3D, iM: Transform3D, sm: Material) extends RSGNode(m, iM, sm) {
  override def intersect(r: Ray): Double = {
    val b: Double = 2.0 * (r.x0.x*r.d.x + r.x0.y*r.d.y + r.x0.z*r.d.z)
    val c: Double = r.x0.x * r.x0.x + r.x0.y * r.x0.y + r.x0.z * r.x0.z - 1.0
    val disc: Double = b * b - 4.0 * c // b**2 - 4ac

    if (disc < 0.0)
      -1.0
    else if (disc == 0.0)
      -b / 2.0
    else {
      val s = sqrt(disc)
      if (-b > s)
        (-b - s) / 2.0
      else
        (-b + s) / 2.0
    }
  }

  // returns -1.0 if no intersection
  override def surfaceNormal(r: Ray, t: Double): Vector = {
    val intersection_pt:Point = r.x0() + r.d * t
    Vector(intersection_pt)normalize()
  }
}

object RSGSphereNode {
  def apply(xm:Transform3D, ixm:Transform3D, smat:Material) = new RSGSphereNode(xm, ixm, smat)
}
