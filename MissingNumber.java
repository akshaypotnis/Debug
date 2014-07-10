package com.gslab;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class MissingNumber {
	String[] temp= new String[20];
	private int CalculateSum(int len) {
		int sum =0;
		if(len==0){
			return sum;
		}
		else{
			sum=CalculateSum(len-1);
			sum+=Integer.parseInt(this.temp[len]);
		}
		return sum;
	}
	
	private int expected(int start,int len) {
		int sum=0;
		if(len==0)
			return start;
		else{
			sum=start;
			sum+=expected(start+1, len-1);
		}
		return sum;
	}
    public static void main(String[] args) {
        try {
            File file = new File("number.txt");
            BufferedReader buf = new BufferedReader(new FileReader("number.txt"));
            MissingNumber obj = new MissingNumber();
            String str;
            while((str=buf.readLine())!=null){
            	obj.temp = str.split(",");
            }
            int actualSum = obj.CalculateSum(obj.temp.length-1)+Integer.parseInt(obj.temp[0]);
            int expectedSum = obj.expected(Integer.parseInt(obj.temp[0]),obj.temp.length);
            System.out.println("Number Missing: "+(expectedSum-actualSum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

