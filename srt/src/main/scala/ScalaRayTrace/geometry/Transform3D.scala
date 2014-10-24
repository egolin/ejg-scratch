package ScalaRayTrace.geometry

import scala.math.{cos, sin}

/**
 * Created by egolin on 6/11/14.
 */
//class Transform3D(val tr1:(Double, Double, Double, Double), val tr2:(Double, Double, Double, Double), val tr3:(Double, Double, Double, Double), val tr4:(Double, Double, Double, Double)) extends OldMatrix4x4(tr1, tr2, tr3, tr4) {
//
//  def Scale(sx:Double, sy:Double, sz:Double) : Transform3D = (this * Transform3D.Scale(sx, sy, sz)).asInstanceOf[Transform3D]
//
//}


class Transform3D(val transformMatrix : Matrix4x4) {
  def this(tr1:Vector4, tr2:Vector4, tr3:Vector4, tr4:Vector4) = this(new Matrix4x4(tr1, tr2, tr3, tr4))
  def this(tr1:(Double,Double,Double,Double), tr2:(Double,Double,Double,Double), tr3:(Double,Double,Double,Double), tr4:(Double,Double,Double,Double))
    = this(new Matrix4x4(tr1, tr2, tr3, tr4))

  def M() = transformMatrix

  override def toString():String = "M[" + M.toString() + "]"

  def Transform(p:Vector4) = M * p
  def Transform(p:Point) = M * p.toHomogenous()

  implicit val logging : Boolean = true

  def *(that:Transform3D):Transform3D = {
    if (logging) println("combining transformations:  " + this + " X " + that)
    val newM = this.M * that.M
    new Transform3D(newM)
  }

  def Scale(sx:Double, sy:Double, sz:Double) : Transform3D = {
    if (logging) println("Scaling by (" + sx + ", " + sy + ", " + sz + ")")
    val newM = Transform3D.Scale(sx, sy, sz).M * this.M
      new Transform3D(newM)
  }

  def Translate(dx:Double, dy:Double, dz:Double) : Transform3D = {
    if (logging) println("Translating by (" + dx + ", " + dy + ", " + dz + ")")
    val newM = Transform3D.Translate(dx, dy, dz).M * this.M
    new Transform3D(newM)
  }

  def RotateZ(theta:Double) : Transform3D = {
    if (logging) println("RotateZ by (" + theta + ")")
    val newM = Transform3D.RotateZ(theta).M * this.M
    new Transform3D(newM)
  }
  def RotateX(theta:Double) : Transform3D = {
    if (logging) println("RotateX by (" + theta + ")")
    val newM = Transform3D.RotateX(theta).M * this.M
    new Transform3D(newM)
  }
  def RotateY(theta:Double) : Transform3D = {
    if (logging) println("RotateY by (" + theta + ")")
    val newM = Transform3D.RotateY(theta).M * this.M
    new Transform3D(newM)
  }

}
object Transform3D {
  def Identity() = new Transform3D(Matrix4x4((1.0, 0.0, 0.0, 0.0), (0.0, 1.0, 0.0, 0.0), (0.0, 0.0, 1.0, 0.0), (0.0, 0.0, 0.0, 1.0)))
  def Scale(sx:Double, sy:Double, sz:Double) = new Transform3D((sx, 0.0, 0.0, 0.0), (0.0, sy, 0.0, 0.0), (0.0, 0.0, sz, 0.0), (0.0, 0.0, 0.0, 1.0))
  def RotateZ(theta:Double) = new Transform3D((cos(theta), -sin(theta), 0.0, 0.0), (sin(theta), cos(theta), 0.0, 0.0), (0.0, 0.0, 1.0, 0.0), (0.0, 0.0, 0.0, 1.0))
  def RotateX(theta:Double) = new Transform3D((1.0, 0.0, 0.0, 0.0), (0.0, cos(theta), -sin(theta), 0.0), (0.0, sin(theta), cos(theta), 0.0), (0.0, 0.0, 0.0, 1.0))
  def RotateY(theta:Double) = new Transform3D((cos(theta), 0.0, sin(theta), 0.0), (0.0, 1.0, 0.0, 0.0), (-sin(theta), 0.0, cos(theta), 0.0), (0.0, 0.0, 0.0, 1.0))
  def Translate(dx:Double, dy:Double, dz:Double) = new Transform3D((1.0, 0.0, 0.0, dx), (0.0, 1.0, 0.0, dy), (0.0, 0.0, 1.0, dz), (0.0, 0.0, 0.0, 1.0))
}
