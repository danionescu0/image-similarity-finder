package histogram

trait ImageHistogram {
  def getNormalizedHistogram(filePath: String) : List[Double]
}