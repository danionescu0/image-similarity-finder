# Image similarity finder

..Work in progress..

I'm building a "more like this" image similarity finder with scala and spark.

The project will support live image indexing, and will use color histogram to store image details.
Spark will be used to rapidly compare all stored images histograms to a given image histogram



*To run project in console:*

Assumming you got the spark cluster running on localhost and spark submit in this folder: "/usr/local/spark-2.1.0-bin-hadoop2.7/bin/spark-submit"


````
sbt package

/usr/local/spark-2.1.0-bin-hadoop2.7/bin/spark-submit --class "main.SearchImage" --master local[*] target/scala-2.11/image-similarity-finder_2.11-1.0.jar
````