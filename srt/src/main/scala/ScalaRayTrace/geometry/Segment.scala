package ScalaRayTrace.geometry

/**
 * Created by egolin on 6/13/14.
 */
class Segment(val p1:Point, val p2:Point) {
  def _1 = p1
  def _2 = p2

  def this(loc1:(Double, Double, Double), loc2:(Double, Double, Double)) = this(Point(loc1), Point(loc2))
  override def toString():String = "[Segment:" + p1.toString() + "->" + p2.toString() + "]"
}

object Segment {
  def apply(start:Point, end:Point) = new Segment(start, end)
  def apply(l1:(Double, Double, Double), l2:(Double, Double, Double)) = new Segment(l1, l2)
}
