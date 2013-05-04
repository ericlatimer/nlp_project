import scala.io.Source


val predicted = scala.io.Source.fromFile(args(0)).getLines.toList.map(line => line.split(" ")).map(array => Array(array(0),array(1),array(2))).map(_.mkString)
val gold= scala.io.Source.fromFile(args(1)).getLines.toList.map(line => line.split(" ")).map(array => Array(array(1),array(2),array(3))).map(_.mkString)


val predNum = predicted.length
val goldNum =gold.length
val correct = {for (line <- predicted) yield {
	if(gold.contains(line)){	
		line
	}
	else
		"bad"
}}.filterNot(_ == "bad")	
val correctNum = correct.length
val recall = (correctNum*(1.0) / goldNum)
val precision = (correctNum*(1.0)/ predNum)
val f1 = (2 * (precision*recall)) / (precision + recall)

println("Found Entities: " + predNum)
println("Actual Number of Entities: " + goldNum)
println("Correct Entities: " + correctNum)
println("Recall: " + recall)
println("Precision: " + precision)
println("F1:  " + f1)


