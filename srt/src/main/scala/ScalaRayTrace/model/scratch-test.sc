import java.io.File._
object FileMatcher {
  def filesHere = (new java.io.File(".")).listFiles

  def filesEnding(query: String) = {
    for (file <- filesHere if file.getName.endsWith(query))
    yield file
  }
}

println("hello")
//val fh = (new java.io.File(".")).listFiles
//for (file <- fh)
//  println("next file is '" + file.getPath + file.getName)
//val mf = for (file <- fh if file.getName.endsWith("lib")) yield file
//println("mf contains " + mf.length + " files.")
//for (m <- mf) println("next mf file is '" + m.getName)


val f = FileMatcher.filesEnding("lib")
println("number of files is " + f.length)
