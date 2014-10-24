package ScalaRayTrace.model

import ScalaRayTrace.geometry.Segment

/**
 * Created by egolin on 6/13/14.
 */
class Cube extends SceneNode with Shape {
  override def toString() = "[Cube]"

  override def renderWireframe() = Cube.unitCubeDefinition()

}

object Cube {
  def unitCubeDefinition() = List(Segment((0.0, 0.0, 0.0), (0.0, 1.0, 0.0)),
    Segment((0.0, 1.0, 0.0), (1.0, 1.0, 0.0)),
    Segment((1.0, 1.0, 0.0), (1.0, 0.0, 0.0)),
    Segment((1.0, 0.0, 0.0), (0.0, 0.0, 0.0)),
    Segment((0.0, 0.0, 1.0), (0.0, 1.0, 1.0)),
    Segment((0.0, 1.0, 1.0), (1.0, 1.0, 1.0)),
    Segment((1.0, 1.0, 1.0), (1.0, 0.0, 1.0)),
    Segment((1.0, 0.0, 1.0), (0.0, 0.0, 1.0)),
    Segment((0.0, 0.0, 0.0), (0.0, 0.0, 1.0)),
    Segment((1.0, 0.0, 0.0), (1.0, 0.0, 1.0)),
    Segment((1.0, 1.0, 0.0), (1.0, 1.0, 1.0)),
    Segment((0.0, 1.0, 0.0), (0.0, 1.0, 1.0)))

}
