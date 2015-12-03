import scala.io.Source

/**
  * Created by mark on 11/6/15.
  */
object WordCountApp extends App{

  case class Result(word:String,count:Int)
  import org.json4s.native.Serialization.write
  implicit def formats=org.json4s.DefaultFormats
 val lines=Source.fromFile("/Users/mark/IdeaProjects/word-count/src/main/resources/Scala_Getting_Start.txt").getLines().toList
 val wordCount= lines.flatMap(_.split(" "))
   .groupBy(v=>v)
   .mapValues(_.size)
   .map(v=>Result(v._1,v._2)).map(write(_))

  wordCount.foreach(println)

  //sbt package
  //sbt assembly
}
