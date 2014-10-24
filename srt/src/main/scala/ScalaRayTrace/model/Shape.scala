package ScalaRayTrace.model

import ScalaRayTrace.geometry._

/**
 * Created by egolin on 6/13/14.
 */
trait Shape {
  def renderWireframe(): List[Segment]

  override def toString(): String = "[Shape]"
}
