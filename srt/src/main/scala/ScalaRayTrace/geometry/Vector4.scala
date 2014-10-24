package ScalaRayTrace.geometry

/**
  * Created by egolin on 6/9/14.
  */
class Vector4(val v1:Double, val v2:Double, val v3:Double, val v4:Double) {

   def this(v:Tuple4[Double, Double, Double, Double]) = this(v._1, v._2, v._3, v._4)

   override def toString(): String = ("(" + x + "," + y + "," + z + "," + w + ")")
  def x() = v1
  def y() = v2
  def z() = v3
  def w() = v4

   def asTuple() = (x, y, z, w)
   def _1() = x
   def _2() = y
   def _3() = z
   def _4() = w


   def * (m : OldMatrix4x4) =
     new Vector4(x*m(1,1)+y*m(2,1)+z*m(3,1)+w*m(4,1),
     x*m(1,2)+y*m(2,2)+z*m(3,2)+w*m(4,2),
     x*m(1,3)+y*m(2,3)+z*m(3,3)+w*m(4,3),
     x*m(1,4)+y*m(2,4)+z*m(3,4)+w*m(4,4))

  def * (vr : Vector4) : Double = x*vr.x + y*vr.y + z*vr.z + w*vr.w

 }

object Vector4 {
  def apply(v:(Double, Double, Double, Double)) = new Vector4(v._1, v._2, v._3, v._4)
}
