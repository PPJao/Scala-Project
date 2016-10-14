/**
  * Created by Paul on 10/06/2016.
  */

import java.io.File;
import  java.io._;

object result
{
  def main(args: Array[String])
  {
    val content = scala.io.Source.fromFile("C:\\Users\\Paul\\Desktop\\scala project\\sample.txt")

      //get the file content for every line of text
      .getLines().toList

      //split every word when a non word character matches
      .flatMap(_.split("\\W+"))

      //check if it only contains letter/s and is not a whitespace
      .filter(x => x.matches("[a-zA-Z]+") && x.length > 1)

      //group all the occurrence of a word whether its in lowercase or uppercase form
      .groupBy(x => x.toLowerCase())

      //set a key value pair for each word with its corresponding number of occurrence
      .map(y => ((y._1).toLowerCase(), y._2.length))

      //sort every word alphabetically
      .toList.sorted


    //create a PrintWriter object with a given file name
    val writer = new PrintWriter(new File("output.txt" ))

    //write to a text file every word with its corresponding number of occurrence (ALPHABETICALLY)
    for(word <- content)
    {
      writer.write(word.toString() + "\n")
    }

    //close the file
    writer.close()
  }
}
