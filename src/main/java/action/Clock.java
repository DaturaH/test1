/**
 * 
 */package action;
/** 
 * @author  作者 E-mail: hzhutianqi 
 * @date 创建时间：2016年9月8日 上午10:49:57 
 * @version 1.0 
 * @url http://blog.csdn.net/sadfishsc/article/details/23456713
 * @parameter  
 * @since  
 * @return  
 * 
 */
 public class Clock {  
	  
	    private int hour;  
	    private int minute;  
	    private int second;  
	      
	    public int getHour() {  
	        return hour;  
	    }  
	    public void setHour(int hour) {  
	        this.hour = hour;  
	    }  
	    public int getMinute() {  
	        return minute;  
	    }  
	    public void setMinute(int minute) {  
	        this.minute = minute;  
	    }  
	    public int getSecond() {  
	        return second;  
	    }  
	    public void setSecond(int second) {  
	        this.second = second;  
	    }  
	      
	    @Override  
	    public String toString() {  
	        return hour + ":" + minute + ":" + second;  
	    }  
	      
	}  