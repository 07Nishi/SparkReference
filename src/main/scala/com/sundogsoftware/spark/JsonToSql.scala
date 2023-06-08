

import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}
import org.apache.spark.sql.{SaveMode, SparkSession}

import java.util.Properties
object JsonToSql {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("JSON to MySQL")
      .master("local")
      .getOrCreate()

    val schema = new StructType()
      .add("id", IntegerType, nullable = true)
      .add("first_name", StringType, nullable = true)
      .add("last_name", StringType, nullable = true)
      .add("email", StringType, nullable = true)
      .add("gender", StringType, nullable = true)
      .add("salary", IntegerType, nullable = true)
      .add("dept", StringType, nullable = true)


    val jsonPath = "data/MOCK_DATA.json"  // Replace with the actual path to your JSON file
    val jsonData = spark.read.option("multiline", true).schema(schema).json(jsonPath)

    // Perform transformations if needed

    val connectionProperties = new Properties()
    connectionProperties.put("user", "root")
    connectionProperties.put("password", "root")

    val tableName = "studentrecords"  // Replace with the actual name of your table

    jsonData.write.mode(SaveMode.Append)
      .jdbc("jdbc:mysql://localhost:3306/studentdata", tableName, connectionProperties)

    spark.close()
  }
}