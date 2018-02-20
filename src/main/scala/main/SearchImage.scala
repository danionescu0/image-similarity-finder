package main

import histogram.{FileImageHistogram, HistogramCompare}
import org.apache.spark.{SparkConf, SparkContext}

object SearchImage {
  def main(args:Array[String]) : Unit = {
    var sparkContext = getSparkContext()
    val fileLocation = "/some/path"
    val indexFileLocation = "/home/ionescu/Documents/image-searcher.csv"
    val nrSimilarMatches = 2
    val imageHistogram = new FileImageHistogram
    val referenceHistogram = imageHistogram.getNormalizedHistogram(fileLocation)

    val distFile = sparkContext.textFile(indexFileLocation)
      .map(line => line.split(" "))
      .map(histogram => histogram.map(_.toDouble).toList)
      .map(localHistogram => HistogramCompare.chiDistance(localHistogram, referenceHistogram))
      .sortBy(x => x, ascending = false)
      .take(nrSimilarMatches)
      .foreach(println)
  }

  def getSparkContext(): SparkContext = {
    val conf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")
    new SparkContext(conf)
  }
}