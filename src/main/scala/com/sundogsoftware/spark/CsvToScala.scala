package com.sundogsoftware.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql._

object CsvToScala {

  def main(args : Array[String]) : Unit = {



    Logger.getLogger("org").setLevel(Level.ERROR)

    val sparkSession = SparkSession
      .builder()
      .appName("JsonAppName")
      .master("local[*]")
      .getOrCreate()

    val csvPath = "data/Human Resources.csv"
     val dF = sparkSession.read
       .format("csv")
       .option("header", "true")
       .option("inferSchema" , "true")

       .load(csvPath)

//    dF.show()
   dF.printSchema()

  val selectedColumnData = dF.groupBy("gender").count()
    selectedColumnData.show()

  }

}

