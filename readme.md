# Image similarity finder

..Work in progress..


Thanks to pyimagesearch.com and this tutorial https://www.pyimagesearch.com/2014/12/01/complete-guide-building-image-search-engine-python-opencv/

So far it can be used to search a similar image hsv (from a file) in a preindexed file. 
Please check the article above. 



*To run project in console:*

Assuming you got the spark cluster running on localhost and spark submit in this folder: "/usr/local/spark-2.1.0-bin-hadoop2.7/bin/spark-submit"


````
sbt package

/usr/local/spark-2.1.0-bin-hadoop2.7/bin/spark-submit --class "main.SearchImage" --master local[*] target/scala-2.11/image-similarity-finder_2.11-1.0.jar /path_to_index_csv_file.csv /path_to_refference_file number_of number_similar_matches
````