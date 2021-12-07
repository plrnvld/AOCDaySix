import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val fish = Source.fromFile("Example.txt").getLines.next.split(",").map(t => t.toInt).toList

    (1 to 18).foldLeft(fish) { iterateDay }
  }

  def iterateDay(fish: List[Int], day: Int): List[Int] = {
      println(s"It's day $day, fish: $fish")
      fish
  }
}
