package test1.test1;

/**
 * Created by hutianqi on 16/9/7.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class TestIterable {

    public static class M1 extends Mapper<Object, Text, Text, Text> {
        private Text oKey = new Text();
        private Text oVal = new Text();
        String[] lineArr;

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            lineArr = value.toString().split(" ");
            oKey.set(lineArr[0]);
            oVal.set(lineArr[1]);
            context.write(oKey, oVal);
        }
    }

    public static class R1 extends Reducer<Text, Text, Text, Text> {
        List<String> valList = new ArrayList<String>();
        List<Text> textList = new ArrayList<Text>();
        String strAdd;

        public void reduce(Text key , Iterable<Text> values , Context context){
            valList.clear();
            textList.clear();
            strAdd = "";
            for(Text val : values){
                valList.add(val.toString());
            }
            for(String val : valList){
                strAdd += val + " , ";
            }
            System.out.println(key.toString() + " : " + strAdd);

//            valList.clear();
//            strAdd = "";
//            for(Text val : values){
//                valList.add(val.toString());
//            }
//            for(String val : valList){
//                strAdd += val + " , ";
//            }
            System.out.println(key.toString() + " : " + strAdd);

        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("mapred.job.queue.name", "regular");
      //  String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
//        if (otherArgs.length != 2) {
//            System.err.println("Usage: wordcount <in> <out>");
//            System.exit(2);
//        }
        System.out.println("------------------------");
        Job job = new Job(conf, "TestIterable");
        job.setJarByClass(TestIterable.class);
        job.setMapperClass(M1.class);
        job.setReducerClass(R1.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        // 输入输出路径
//        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
//        FileSystem.get(conf).delete(new Path(otherArgs[1]), true);
//        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

        String inputPath = "/Users/hutianqi/Downloads/test/test/test/input/input";
        String outputPath = "/Users/hutianqi/Downloads/test/test/test/output";

        FileInputFormat.addInputPath(job , new Path(inputPath));
        FileSystem.get(conf).delete(new Path(outputPath) , true);
        FileOutputFormat.setOutputPath(job , new Path(outputPath));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}