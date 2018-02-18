import similarity.HistogramCompare

object Demo {
  def main (args: Array[String]) : Unit = {
    val img1 = List(2.3, 7.1 ,2)
    val img2 = List(1.3, 5.1 ,2)
    println(HistogramCompare.chiDistance(img1, img2))
  }
}
