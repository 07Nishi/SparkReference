package com.sundogsoftware.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StructType}


object ScalaToSql {

  def main(args : Array[String]) : Unit={

    Logger.getLogger("org").setLevel(Level.ERROR)


    val sparkSession = SparkSession
      .builder()
      .appName("ScalaToMysql")
      .master("local[*]")
      .getOrCreate()


    val studentschema = new StructType()
      .add("id", IntegerType, nullable = true)
      .add("first_name", "String", nullable = true)
      .add("last_name", "String", nullable = true)
      .add("email", "String", nullable = true)
      .add("gender", "String", nullable = true)
      .add("salary", IntegerType, nullable = true)
      .add("dept", "String", nullable = true)

    val dF = sparkSession
      .read
      //.option("multiline", true)
      .schema(studentschema)
      .json("data/MOCK_DATA.json")
  }



}
