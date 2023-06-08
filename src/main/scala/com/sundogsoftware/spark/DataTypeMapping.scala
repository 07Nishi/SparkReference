package com.sundogsoftware.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{IntegerType, StructType}

object DataTypeMapping {

  //  case class StudentData(id: Int, first_name: String, last_name: String, email: String, gender: String, salary: Int, dept: String)


  def main(args: Array[String]): Unit = {



    /** Our main function where the action happens */
    Logger.getLogger("org").setLevel(Level.ERROR)

    val sparkSession = SparkSession
      .builder()
      .appName("studentsdata")
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

    // dF.show(numRows = 2000)

    //    val result = dF.groupBy("id").agg(sum("salary").alias("salary")).show()

//    dF.printSchema()
    dF.show()

  }
}