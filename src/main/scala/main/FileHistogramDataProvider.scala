package main

import scala.io.Source
import searcher.HistogramDataProvider

class FileHistogramDataProvider(filename: String) extends HistogramDataProvider {

  override def get: List[List[Double]] = {
    Source.fromFile(filename)
      .getLines()
      .map(line => line.split(","))
      .map(el => el.map(_.toDouble).toList)
    .toList
  }
}
