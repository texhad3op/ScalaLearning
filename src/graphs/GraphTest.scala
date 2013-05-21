package graphs

import scalax.collection.GraphPredef._,scalax.collection.GraphEdge._
import scalax.collection.constrained._
import scalax.collection.constrained.constraints.Connected

object GraphTest {

  def main(args: Array[String]): Unit = {
//implicit val conf: Config = Connected // ConstrainedConfig(…)
    
val e = scalax.collection.Graph(1) // Graph()
//val g = Graph(1~2, 2~4) // Graph(1, 2, 4, 1~2, 2~4)
//val h = g + 3 // Graph(1, 2, 4, 1~2, 2~4)
//val i = g + 2~3 // Graph(1, 2, 3, 4, 1~2, 2~3, 2~4)
  }

}