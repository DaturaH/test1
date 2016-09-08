package action;

import java.io.Serializable;

public class Person implements Serializable {
    /**
	 *
	 测试类，应用于JavaSparkSQL
	 * 
	 */
	private String name;
    private int age;
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
 
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}