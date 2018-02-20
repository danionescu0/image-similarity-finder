package histogram

object HistogramCompare {
  val eps = 1e-10

  def chiDistance(firstImage: List[Double], secondImage: List[Double]) : Double = {
    val total : Double =
      firstImage.zip(secondImage)
      .map(a => scala.math.pow(a._1 - a._2, 2) / (a._1 + a._2 + eps) )
      .sum

    total
  }
}