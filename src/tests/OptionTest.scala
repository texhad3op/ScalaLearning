package tests

case class Person(id: Long, name: String)



object OptionTest {

  val list = List(Person(1,"aaa"),Person(2,"bbb"))
  def main(args: Array[String]): Unit = {
    
   val p: Option[Person] = getPerson(1)
    println(p.map(_.name).getOrElse("fignia"))
    
  }

  def getPerson(id:Long):Option[Person] = {
    Some(Person(1,"aaa"))
  }
  
}