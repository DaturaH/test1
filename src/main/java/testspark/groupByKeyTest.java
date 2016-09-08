package testspark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import scala.Tuple2;

public class groupByKeyTest {
	public static void main(String[] args){
		SparkConf sparkConf = new SparkConf().setAppName("GroupByKey").setMaster("local[1]");
		SparkContext sc = new SparkContext(sparkConf);
		sc.setCheckpointDir("/Users/hutianqi/Downloads/test/test/out/checkpoint");
		List<Tuple2<Integer , Character>> data = new ArrayList<Tuple2<Integer , Character>>(8);
		for(int i = 0 ; i <= 7 ; i++){
			int num = i;
			data.add(new Tuple2(i , (char)('a' + i)));
			System.out.println(data.get(num));
		}
		for(int i = 0 ; i <= 7 ; i++){
			int num = i;
			data.add(new Tuple2(i , (char)('a' + i)));
			System.out.println(data.get(num));
		}
//		JavaRDD pairs = sc.parallelize(data , 3 , Tuple2.class);
//		pairs.checkpoint();
//		pairs.count();
//		JavaPairRDD result = pairs.groupByKey(2);
//		result.foreach
		

	}
}
