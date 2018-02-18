package main

import java.io.PrintWriter

class DataWriter(val file: String) {
  def write(result: Array[(String, String)]) = {
    new PrintWriter(file) {
      result.foreach {
        case (a, b) =>
          write(a + ":" + b)
          write("\n")
      }
      close()
    }
  }
}