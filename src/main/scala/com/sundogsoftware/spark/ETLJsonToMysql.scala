package com.sundogsoftware.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StructType}
import org.apache.spark.sql.functions._
object ETLJsonToMysql {

  def main(args : Array[String]) : Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val sparkSession = SparkSession
      .builder()
      .appName("JSON_TO_MYSQL")
      .master("local[*]")
      .getOrCreate()


    val schema = new StructType()
      .add("id", IntegerType, nullable = true)
      .add("first_name", "String", nullable = true)
      .add("last_name", "String", nullable = true)
      .add("email", "String", nullable = true)
      .add("gender", "String", nullable = true)
      .add("salary", IntegerType, nullable = true)
      .add("dept", "String", nullable = true)


    val dataF = sparkSession.read.schema(schema).json("data/MOCK_DATA.json")

    //Transformation time

    val transformData = dataF.groupBy("dept").agg(sum("salary").alias("Salary"))

    val finalResult = transformData.withColumn("Salary",col("Salary").cast(IntegerType))


    //connection to demo database
    val jdbcHostname = "localhost" // Replace with your MySQL server hostname
    val jdbcPort = 3306 // Replace with your MySQL server port
    val jdbcDatabase = "studentdata" // Replace with your MySQL database name
    val jdbcUrl = s"jdbc:mysql://${jdbcHostname}:${jdbcPort}/${jdbcDatabase}"
    val jdbcUsername = "root" // Replace with your MySQL username
    val jdbcPassword = "root" // Replace with your MySQL password

    val tableName = "deptSalaryData" // Replace with your MySQL table name

    //writing data of result to deptSalData table
    finalResult.write
      .format("jdbc")
      .option("url", jdbcUrl)
      .option("driver", "com.mysql.cj.jdbc.Driver")
      .option("dbtable", tableName)
      .option("user", jdbcUsername)
      .option("password", jdbcPassword)
      .mode("append") // Change to "overwrite" if you want to replace the data in the table
      .save()


  }

}
