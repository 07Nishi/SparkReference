package com.sundogsoftware.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession


object JsonToMySql {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)


    val sparkSession = SparkSession
      .builder()
      .appName("JsonAppName")
      .master("local[*]")
      .getOrCreate()

    val readJson = sparkSession.read.option("multiline", true).json("data/MOCK_DATA.json")
    //     readJson.show()
    readJson.printSchema()
  }
}


         /*---------------------------DropColumn code
          val dropcolumn = if (readJson.columns.contains("_corrupt_record")) {

            readJson.drop("_corrupt_record")
          }else{

            readJson
          }
          dropcolumn.show(false)


          dropcolumn.show()
        }
  */


