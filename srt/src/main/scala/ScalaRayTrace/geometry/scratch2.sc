import ScalaRayTrace.geometry._

val pt = Point(1.0, 2.0, 3.0)

val vec = Vector(0.1, 0.2, 0.3)

vec * 2.0

pt + vec

pt + vec * 2.0

val r = new Ray(Point(0.0, 0.0, 0.0), Vector(0.0, 1.0, 0.0))

r

r.x0(
)
r.x0

r.d

r.x0 + r.d*3
import ScalaRayTrace.model._

val m = Transform3D.Scale(2.0, 1.0, 1.0)
val im = Transform3D.Scale(0.5, 1.0, 1.0)

val m2 = m * im
println("m2 is " + m2.toString())
val mx = new Material()
val s = RSGSphereNode(m, im, mx)
r.x0
val ray2 = new Ray(Point(5.0, 0.0, 0.0), Vector(-1.0, 0.0, 0.0))
s.intersect(ray2)
val s2 = RSGSphereNode(Transform3D.Identity(), Transform3D.Identity(), mx)
s2.intersect(ray2)
ray2.d






