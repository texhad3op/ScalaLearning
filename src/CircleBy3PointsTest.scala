object CircleBy3PointsTest {

  case class Point(x: Int, y: Int)
  def main(args: Array[String]): Unit = {

    val p1 = Point(500, 500)
    val p2 = Point(520, 520)
    val p3 = Point(540, 500)
    
    val ma = (p2.y - p1.y)/(p2.x - p1.x)
    val mb = (p3.y - p2.y)/(p3.x - p2.x)
    
    println(ma)
    println(ma)  
    
    val x = (ma*mb*(p1.y - p3.y) + mb*(p1.x + p2.x) - ma*(p2.x + p3.x) )/(2*(mb - ma))
    
    println(x)
    
    val y = -(1/ma)*(x-(p1.x+p2.x)/2)+((p1.y+p2.y)/2)
    println(y)
    
  }

}