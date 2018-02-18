package searcher

trait HistogramDataProvider {
  def get : List[List[Double]]
}