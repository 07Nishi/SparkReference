package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

/** Find the superhero with the most co-appearances. */
object MostObscureSuperHeroes {

 case class SuperHeroNames(id: Int, name: String)
 case class SuperHero(value: String)

 /** Our main function where the action happens */
 def main(args: Array[String]) {

  // Set the log level to only print errors
  Logger.getLogger("org").setLevel(Level.ERROR)

  // Create a SpaarkSession using every core of the local machine

  val spark = SparkSession.builder()
    .appName(name = "MostObscureSuperHeroes")
    .master(master = "local[*]")
    .getOrCreate()


  // create schema
   val superHeroNamesSchema = new StructType()
     .add(name = "Id" ,IntegerType ,nullable = true    )

 }





}