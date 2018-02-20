package histogram

class FileImageHistogram extends ImageHistogram {
  override def getNormalizedHistogram(filePath: String): List[Double] = {
    List(1.6, 7.2, 0)
  }
}
