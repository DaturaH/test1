package testspark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import action.Person;

import org.apache.spark.api.java.function.Function;

public class JavaSparkSQL {
	public static void main(String [] args){
		
		//sparkSql普通读入
		SparkConf sparkConf = new SparkConf().setAppName("JavaSparkSQL").setMaster("local[1]");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		SQLContext sqlContext = new SQLContext(sc);
		JavaRDD<Person> people = sc.textFile("/Users/hutianqi/Downloads/test/test/sampleDir/people.txt").map(new Function<String , Person>(){
			public Person call(String line){
				String[] parts = line.split(",");
				return new Person(parts[0] , Integer.parseInt(parts[1].trim()));
			}
		});
		
        //sparkSql 普通输出               
		DataFrame schemaPeople = sqlContext.createDataFrame(people, Person.class);
		schemaPeople.registerTempTable("persons");
		DataFrame result = sqlContext.sql("select * from persons where age > 10");
		List<Row> list = result.javaRDD().collect();
		for(Row row : list){
			System.out.println(row);
		}
		
		//sparkSql parquet输出
		schemaPeople.write().parquet("people.parquet");
		DataFrame parquetFile = sqlContext.parquetFile("people.parquet");
		parquetFile.registerTempTable("parquetFile");
		DataFrame parquetResult = sqlContext.sql("select * from parquetFile where age > 10");
		for(Row row : parquetResult.collect()){
			System.out.println(row.get(0) + " " + row.get(1));
		}	
	}
}



