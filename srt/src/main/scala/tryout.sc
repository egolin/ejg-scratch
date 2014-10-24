import ScalaRayTrace.geometry.Transform3D
import ScalaRayTrace.geometry.{Point4D, Matrix3D, OldMatrix4x4, Vector4}
val p = new Point3D(1.0, 2.1, 3.5);
println("created 3D point " + p)

val p2 = new Point4D(1.0, 2.1, 3.5, 4.9);
println("created 4D point " + p2)

val m = new Matrix3D((1.1, 1.2, 1.3), (2.1, 2.2, 2.3), (3.1, 3.2, 3.3));
println("created matrix " + m)

val m2 = new Matrix4D((1.1, 1.2, 1.3, 1.4), (2.1, 2.2, 2.3, 2.4), (3.1, 3.2, 3.3, 3.4), (4.1, 4.2, 4.3, 4.4));
println("created 4x4 matrix " + m2)

println("3,2 is " + m2(3,2))


val p3 = p2 * m2
println("p3 is " + p3)

val p4 = m2 * p2
println("p4 is " + p4)


val m3 = new OldMatrix4x4((1.0,0.0,0.0,5.0),(0.0,1.0,0.0,7.0),(0.0,0.0,1.0,1.0),(0.0,0.0,0.0,1.0))
val p5 = new Vector4(1,1,1,1)
val p6 = m3 * p5
println("p6 is " + p6)

val m4 = new OldMatrix4x4(Vector4(2, 0, 0, 0), Vector4(0, 3, 0, 0), Vector4(0, 0, 1, 0), Vector4(0, 0, 0, 1))
val m5 = m3 * m4
val p7 = m5 * p5
println("p7 is " + p7)


Transform3D.Identity()
Transform3D.Scale(1.0, 2.0, 3.0)
Transform3D.Identity().Scale(1.0, 2.0, 3.0).Scale(2.0, 2.0, 4.0)








