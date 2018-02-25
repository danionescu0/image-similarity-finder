package histogram

import scala.io.Source

class FileImageHistogram extends ImageHistogram {
  override def getNormalizedHistogram(filePath: String): List[Double] = {
    Source.fromFile(filePath)
      .getLines()
      .mkString
      .split(" ")
      .map(token => token.toDouble)
      .toList
  }
}