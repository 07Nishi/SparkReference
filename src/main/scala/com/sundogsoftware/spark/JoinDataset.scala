package com.sundogsoftware.spark

import org.apache.spark.sql._
import org.apache.spark._
import org.apache.log4j._
import org.apache.spark
import org.apache.spark.sql.types._

object JoinDataset {

  case class movies(id:Int, title:String)

  def extractIdName(line: String): (Int, String) = {
    val fields = line.split("|")
    val id = fields(0).toInt
    val name = fields(1).toString
    (id, name)
  }
  case class rating()
  def main(args:Array[String]){



    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "JoinDataset")

    val spark = SparkSession.builder.appName("join").master("local[*]").getOrCreate()

    val rating = sc.textFile("data/ml-100k/u.item")

    val reqRating = rating.map(extractIdName)


    val df = spark.createDataFrame(reqRating)
    df.show()

  }

}
