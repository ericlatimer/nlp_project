import scala.io.Source

val PersonalNameRE = """\b([A-Z][a-zA-Z]+[\\b\s$]([A-Z][a-zA-Z]+)?\b?)""".r


//val PersonalNameRE ="""\b([\w\.\']{2,}([\s][\w\.\']{2,})+)\b""".r

val dirName = args(0)

val fileList = new java.io.File(dirName).listFiles //.filter(_.getName.endsWith(".txt"))


for ( file <- fileList) yield {

val document = scala.io.Source.fromFile(file).getLines.toList.mkString(" ")

val first_last = {for {PersonalNameRE(first,last) <- PersonalNameRE findAllIn document} yield (first,last) }.toList

var prevIndex = -1
for (fl <- first_last) yield {
		val index = document.indexOfSlice(fl._1,prevIndex+1)
		val length=  fl._1.length
		println(file.getName +  " " + index + " " + length  )
		//println(document.slice(index,index + length))
		prevIndex = index
}
//println(file.getName + " " + first_last.length)
}


                                 










