package ScalaRayTrace.geometry

/**
 * Created by egolin on 6/9/14.
 */
class Matrix4x4 (val r1:Vector4, val r2:Vector4, val r3:Vector4, val r4:Vector4){

  def this(v1:(Double, Double, Double, Double), v2:(Double, Double, Double, Double), v3:(Double, Double, Double, Double), v4:(Double, Double, Double, Double))
    = this(Vector4(v1), Vector4(v2), Vector4(v3), Vector4(v4))
  def this() = this(Vector4(0.0,0.0,0.0,0.0),Vector4(0.0,0.0,0.0,0.0),Vector4(0.0,0.0,0.0,0.0),Vector4(0.0,0.0,0.0,0.0))
//  def this(rv1:Vector4, rv2:Vector4, rv3:Vector4, rv4:Vector4) = this(rv1.asTuple, rv2.asTuple, rv3.asTuple, rv4.asTuple)

  def row(i:Int) : Vector4 = {
    i match {
      case 1 => r1
      case 2 => r2
      case 3 => r3
      case 4 => r4
      case _ => throw new ArrayIndexOutOfBoundsException("invalid row")
    }
  }

  def col(i:Int) : Vector4 = {
    i match {
      case 1 => new Vector4(r1._1, r2._1, r3._1, r4._1)
      case 2 => new Vector4(r1._2, r2._2, r3._2, r4._2)
      case 3 => new Vector4(r1._3, r2._3, r3._3, r4._3)
      case 4 => new Vector4(r1._4, r2._4, r3._4, r4._4)
      case _ => throw new ArrayIndexOutOfBoundsException("invalid column")
    }
  }

  def transpose() : Matrix4x4 = new Matrix4x4(col(1),col(2),col(3),col(4))

  override def toString():String = "((" + r1._1 + "," + r1._2 + "," + r1._3 + "," + r1._4 + "), (" +
    r2._1 + "," + r2._2 + "," + r2._3 + "," + r2._4 + "), (" +
    r3._1 + "," + r3._2 + "," + r3._3 + "," + r3._4 + "), (" +
    r4._1 + "," + r4._2 + "," + r4._3 + "," + r4._4 + "))";

  def * (p : Vector4) : Vector4 =
    new Vector4(p.x*this(1,1)+p.y*this(1,2)+p.z*this(1,3)+p.w*this(1,4),
      p.x*this(2,1)+p.y*this(2,2)+p.z*this(2,3)+p.w*this(2,4),
      p.x*this(3,1)+p.y*this(3,2)+p.z*this(3,3)+p.w*this(3,4),
      p.x*this(4,1)+p.y*this(4,2)+p.z*this(4,3)+p.w*this(4,4))

  def * (mr : Matrix4x4) : Matrix4x4 =
    new Matrix4x4( (row(1)*mr.col(1), row(1)*mr.col(2), row(1)*mr.col(3), row(1)*mr.col(4)),
      (row(2)*mr.col(1), row(2)*mr.col(2), row(2)*mr.col(3), row(2)*mr.col(4)),
      (row(3)*mr.col(1), row(3)*mr.col(2), row(3)*mr.col(3), row(3)*mr.col(4)),
      (row(4)*mr.col(1), row(4)*mr.col(2), row(4)*mr.col(3), row(4)*mr.col(4)))


  def apply(row:Int, col:Int) = {
    (row,col) match {
      case (1,1) => r1._1
      case (1,2) => r1._2
      case (1,3) => r1._3
      case (1,4) => r1._4
      case (2,1) => r2._1
      case (2,2) => r2._2
      case (2,3) => r2._3
      case (2,4) => r2._4
      case (3,1) => r3._1
      case (3,2) => r3._2
      case (3,3) => r3._3
      case (3,4) => r3._4
      case (4,1) => r4._1
      case (4,2) => r4._2
      case (4,3) => r4._3
      case (4,4) => r4._4
      case _ => throw new ArrayIndexOutOfBoundsException("invalid matrix location (" + row + "," + col + ")")
    }

  }

}

object Matrix4x4 {
  def apply(v1:(Double, Double, Double, Double), v2:(Double, Double, Double, Double), v3:(Double, Double, Double, Double), v4:(Double, Double, Double, Double)) =
    new Matrix4x4(Vector4(v1), Vector4(v2), Vector4(v3), Vector4(v4))
}

