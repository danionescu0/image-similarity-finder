package main

import org.apache.spark.{SparkConf, SparkContext}
import similarity.HistogramCompare

object SearchImage {
  def main(args:Array[String]) : Unit = {
    var sparkContext = getSparkContext()
    val referenceHistogram = List(1.6, 7.2, 0)

    val distFile = sparkContext.textFile("/home/ionescu/Documents/image-searcher.csv")
      .map(line => line.split(" "))
      .map(histogram => histogram.map(_.toDouble).toList)
      .map(localHistogram => HistogramCompare.chiDistance(localHistogram, referenceHistogram))
      .collect()
      .foreach(println)
  }

  def getSparkContext(): SparkContext = {
    val conf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")
    new SparkContext(conf)
  }
}