
class Vector3[T](val v1:T, val v2:T, val v3:T) {
  override def toString(): String = ("(" + v1 + "," + v2 + "," + v3 + ")")
}
class Point3D(v1:Double, v2:Double, v3:Double) extends Vector3[Double](v1, v2, v3) {
  val pt = (v1, v2, v3);
  def x() = pt._1;
  def y() = pt._2;
  def z() = pt._3;
}
val p = new Point3D(1.5, 3.3, -7.2)
println(p)

p.x
p.y
p.z
p.x + p.y + p.z

var l = List(1.1, 1.2, 1.3, 2.1, 2.2, 2.3, 3.1, 3.2, 3.3);


