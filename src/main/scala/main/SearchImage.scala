package main

import histogram.{FileImageHistogram, HistogramCompare}
import org.apache.spark.{SparkConf, SparkContext}

object SearchImage {
  def main(args: Array[String]) : Unit = {
    val indexFileLocation = args(0)
    val searchedHistogramFileLocation = args(1)
    val nrSimilarMatches = args(2).toInt
    var sparkContext = getSparkContext()
    val imageHistogram = new FileImageHistogram
    val referenceHistogram = imageHistogram.getNormalizedHistogram(searchedHistogramFileLocation)

    val distFile = sparkContext.textFile(indexFileLocation)
      .map(line => line.split(" "))
      .map(histogram => histogram.toList)
      .map(localHistogram => (
          localHistogram.take(1).mkString,
          HistogramCompare.chiDistance(localHistogram.drop(1).map(_.toDouble), referenceHistogram))
        )
      .sortBy(x => x._2, ascending = false)
      .take(nrSimilarMatches)
      .foreach(println)
  }

  def getSparkContext(): SparkContext = {
    val conf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")
    new SparkContext(conf)
  }
}