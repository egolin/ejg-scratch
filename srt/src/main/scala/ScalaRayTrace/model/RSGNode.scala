package ScalaRayTrace.model

import ScalaRayTrace.geometry.{Ray, Transform3D, Vector}

/**
 * RSGNode - Rendered Scene Graph Node
 * Created by egolin on 6/23/14.
 */
abstract class RSGNode(val transMat: Transform3D, val invTransMat: Transform3D, val surfaceMaterial: Material) {
  def M() = transMat;

  def invM() = invTransMat;

  def material = surfaceMaterial;

  def intersect(r: Ray): Double;

  // returns -1.0 if no intersection
  def surfaceNormal(r: Ray, t: Double): Vector;
}
