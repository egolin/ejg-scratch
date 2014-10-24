import ScalaRayTrace.geometry.{Transform3D, Matrix4x4, Vector4}

val v = Vector4(1.0, 2.0, 3.0, 4.0)

val m3 = new Matrix4x4((1.0,0.0,0.0,5.0),(0.0,1.0,0.0,7.0),(0.0,0.0,1.0,1.0),(0.0,0.0,0.0,1.0))
println("M3 is " + m3)


println("M3 Transpose is " + m3.transpose())


val p5 = new Vector4(1,1,1,1)
val p6 = m3 * p5
println("p6 is " + p6)


val m4 = new Matrix4x4(Vector4(2, 0, 0, 0), Vector4(0, 3, 0, 0), Vector4(0, 0, 1, 0), Vector4(0, 0, 0, 1))
val m5 = m3 * m4
val p7 = m5 * p5
println("p7 is " + p7)



println(Transform3D.Identity())


println(Transform3D.Scale(1.0, 2.0, 3.0))


val pi:Double = 3.14159
val tm = Transform3D.Identity().Scale(1.0, 2.0, 3.0).RotateZ(pi).RotateX(0.0).Translate(100,50,-200)








println("Transformation Matrix is " + tm)



val p0 = new Vector4(0,0,0,1)
val tp0 = tm.Transform(p0)
println("P0=" + p0 + " and transforms to " + tp0)


val p1 = new Vector4(1,1,1,1)
val tp1 = tm.Transform(p1)
println("P1=" + p1 + " and transforms to " + tp1)



println("scaling test is " + Transform3D.Identity.Scale(1.0, 2.0, 3.0).Transform(p1))




println("rotateZ test is " + Transform3D.Identity.RotateZ(pi).Transform(new Vector4(1.0, 2.0, 3.0, 1.0)))



import ScalaRayTrace.graphics.ColorVal

val px1 = ColorVal(0.33f, 0.25f, 0.9999f)
println("px1 is " + px1 + " which yeilds " + px1.RGB())







