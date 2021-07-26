package com.sort;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.junit.Test;

public class SortnamesTests{
	
	/*Console console = System.console();
	
	if(console == null) {
		System.out.println("Console is not available to current JVM process");
		return;
	} */
	@Test
	//public static void main (String[] args) throws IOException{
		public void test() throws IOException
	{
			ArrayList<String> str = new ArrayList<>();
			String line = "";
		//try {
		System.out.println("Enter filename : ");
		Scanner sc = new Scanner(System.in);
		String filename=sc.nextLine();
		//System.out.println(filename); 
		String f=new File(filename).getName();
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		while((line=reader.readLine())!=null){
				str.add(line);
		}
		reader.close();
		
		//}catch (FileNotFoundException e){e.printStackTrace();}
		
		Collections.sort(str);
		
		int dot = f.lastIndexOf('.');
		if (dot == -1) {
            filename = f;
        } else {
            filename = f.substring(0, dot);
        }
        		
		FileWriter writer = new FileWriter(filename+"-sorted.txt");
		String ss="";
		for(String s: str){
				writer.write(s);
				ss=ss.concat(s)+"\n";
				writer.write("\r\n");
			}
		System.out.println(ss);
		assertEquals("BAKER, THEODORE\n"
        	+ "KENT, MADISON\n"
        	+ "SMITH, ANDREW\n"
        	+ "SMITH, FREDRICK\n", ss);
		
		writer.close();
		System.out.println("Finished: created " + filename+"-sorted.txt");
}
}
