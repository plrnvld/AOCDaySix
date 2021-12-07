import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val fish = Source.fromFile("Input.txt").getLines.next.split(",").map(t => t.toInt).toList
    val fishCount = countFishDays(fish)

    println(s"It's day 0, fishes: ${fishCount.total}")

    (1 to 256).foldLeft(fishCount)((f, d) => f.addNewFishes().iterateDay(d))
  }

  def countFishDays(fish: List[Int]): FishDaysCount = {
    FishDaysCount(fish.filter(_ == 0).length, fish.filter(_ == 1).length, fish.filter(_ == 2).length, fish.filter(_ == 3).length,fish.filter(_ == 4).length, fish.filter(_ == 5).length, fish.filter(_ == 6).length, fish.filter(_ == 7).length, fish.filter(_ == 8).length, fish.filter(_ == 9).length)
  }

  case class FishDaysCount(zero: Long, one: Long, two: Long, three: Long, four: Long, five: Long, six: Long, seven: Long, eight: Long, nine: Long) {
    def total = zero + one + two + three + four + five + six + seven + eight + nine

    def addNewFishes(): FishDaysCount = {
      FishDaysCount(zero, one, two, three, four, five, six, seven, eight, zero)
    }

    def iterateDay(day: Int): FishDaysCount = {
      val newCount = FishDaysCount(one, two, three, four, five, six, seven + zero, eight, nine, 0)

      println(s"It's day $day, fishes: ${newCount.total}")

      newCount
    }
  }
}
