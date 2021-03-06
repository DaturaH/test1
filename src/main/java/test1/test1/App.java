package test1.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 */

class IpMap
{
     // 待路由的Ip列表，Key代表Ip，Value代表该Ip的权重
    public static HashMap<String, Integer> serverWeightMap = 
             new HashMap<String, Integer>();
     
    static
    {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        // 权重为4
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        // 权重为3
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        // 权重为2
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }
}


class RoundRobin
{
    private static Integer pos = 0;
    
    public static String getServer()
    {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = 
                new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        
        String server = null;
        synchronized (pos)
        {
            if (pos > keySet.size())
                pos = 0;
            server = keyList.get(pos);
            pos ++;
        }
        
        return server;
    }
}


public class App 
{	
	static int i = 0;
	static int j;
	static String run(){

    	int n = 5;
    	int[] array = {1,2,3,4,5};
    	j = i;
    	do {
    	j = (j + 1) % n;
    	if (array[j] > 0) {
    	i = j;
//    	System.out.println(array[i]);
    	return array[i] + "";
    	}
    	} while (j != i);
    	return null;
	}
    public static void main( String[] args )
    {
//    	Integer i1 = 100;
//    	Integer i2 = 100;
//    	Integer i3 = new Integer(100);
//    	Integer i4 = new Integer(100);
//    	System.out.println(i1 == i2);
//    	System.out.println(i3 == i4);
        String a = new String("as");
        String b = "as";
        System.out.println(a == "as");
        System.out.println(b == "as");

    }
}
