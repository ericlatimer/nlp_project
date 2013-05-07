import scala.io.Source

// possible iterations of DateRE:
//   -just 3 letter abbr
//   -3 letter abbr + full endings
// adding Day xx?
// adding \d\d

val DateRE1 = """\b((Mon|Tue|Wed|Thu|Fri|Sat|Sun|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(day|sday|nesday|rsday|urday|uary|ruary|ch|il|e|y|ust|tember|ober|ember)?)\b""".r
val DateRE2 = """\b(((Mon|Tue|Wed|Thu|Fri|Sat|Sun|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(day|sday|nesday|rsday|urday|uary|ruary|ch|il|e|y|ust|tember|ober|ember)?)|(Day \d\d?))\b""".r
val DateRE3 = """\b(((Mon|Tue|Wed|Thu|Fri|Sat|Sun|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(day|sday|nesday|rsday|urday|uary|ruary|ch|il|e|y|ust|tember|ober|ember)?)|(Day \d\d?)|([01]\d))\b""".r

val DateRE4 = """\b(((Mon|Tue|Wed|Thu|Fri|Sat|Sun|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)(day|sday|nesday|rsday|urday|uary|ruary|ch|il|e|y|ust|tember|ober|ember)?)|(Day \d\d?)|((?![01]\d[: ]|:[01]\d)[01]\d))\b""".r

// possible iterations of TimeRE:
//   -just xx:xx:xx
//   - above + xx:xx PM|AM
//   - making AM|PM optional
//   - making 1 digit optional in XX:xx PM|AM
//   - including x(am|pm|AM|PM)
//   - adding white space (\s?) after \d\d

val TimeRE1 = """\b(\d\d:\d\d:\d\d)\b""".r
val TimeRE2 = """\b((\d\d:\d\d:\d\d)|(\d\d?:\d\d\s?(AM|PM)))\b""".r
val TimeRE3 = """\b((\d\d:\d\d:\d\d)|(\d\d?:\d\d\s?(AM|PM)?))\b""".r
val TimeRE4 = """\b((\d\d:\d\d:\d\d)|(\d\d?:\d\d\s?(AM|PM)?)|(\d(am|pm|AM|PM)))\b""".r

val DateRE = DateRE3
val TimeRE = TimeRE3

val dirName = args(0)

val fileList = new java.io.File(dirName).listFiles //.filter(_.getName.endsWith(".txt"))


for ( file <- fileList) yield {
val document = scala.io.Source.fromFile(file,"8859_1").getLines.toList.mkString(" ")

val dates = {for {DateRE(date,_,_,_,_,_) <- DateRE findAllIn document} yield (date) }.toList

val times = {for {TimeRE(time,_,_,_,_) <- TimeRE findAllIn document} yield (time) }.toList

//val dates = {for {DateRE(date,_,_,_,_,_) <- DateRE findAllIn document} yield (date) }.toList

//val times = {for {TimeRE(time,_,_) <- TimeRE findAllIn document} yield (time) }.toList

var prevIndex = -1
for (date <- dates) yield {
		val index = document.indexOfSlice(date,prevIndex+1)
		val length=  date.length
		
		println(file.getName +  " " + index + " " + length  )
		//println(document.slice(index,index + length))
	
		prevIndex = index
}

prevIndex = -1
for (time <- times) yield{
	val index = document.indexOfSlice(time,prevIndex+1)
	val length = time.length

	println(file.getName +  " " + index + " " + length  )
	//println(document.slice(index,index + length))
	prevIndex = index
}

//println(file.getName + " " + first_last.length)
}
