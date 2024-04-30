package org.uma.jmetal.algorithm.multiobjective.aRankabili;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.util.JMetalException;

public class Readfile {
	String path;	
	 String separator;
	 
	double infor[][] = {{0,0,0.25}, {0,0.25,0.5}, {0.25,0.5,0.75},
			 {0.5,0.75,1}, {0.75,1,1}};
	
	int DM = 5; int C= 6; int item = 3;
	double initialdata[][][][] = new double[DM][C][C][item];
	List<double[]> list = new ArrayList<>();
	
	public Readfile(String fileName, String separator) {
		this.path = fileName;
		this.separator = separator;
	}
	
	public void run() throws FileNotFoundException {
		ReadsensorFile(path, separator);
		parseDatatoArray();
		System.out.println("read file finished");
	}
	
	public double[][][][] getData(){
		return initialdata;
	}
	
	private void parseDatatoArray() {
		int size = list.size();
		int dm, row, column;
		for( int i = 0; i < size; i ++) {
			dm = i/(C*C); row = (i/C)%C; column = i%C;
			initialdata[dm][row][column] = list.get(i);
		}		
	}


	public enum Blah {
	    A("NI"),
	    B("VL"),
	    C("L"),
	    D("HI"),
	    E("VH");

	    private String text;

	    Blah(String text) {
	        this.text = text;
	    }

	    public String getText() {
	        return this.text;
	    }

	    public static Blah fromString(String text) {
	        for (Blah b : Blah.values()) {
	            if (b.text.equalsIgnoreCase(text)) {
	                return b;
	            }
	        }
	        return null;
	    }
	}
	
 public InputStream createInputStream(String fileName) throws FileNotFoundException {
	    InputStream inputStream = getClass().getResourceAsStream(fileName);
	    if (inputStream == null) {
	      inputStream = new FileInputStream(fileName);
	    }

	    return inputStream;
	  }
 public List<double[]> ReadsensorFile(String fileName, String separator) throws FileNotFoundException {

	    InputStream inputStream = createInputStream(fileName);
	    InputStreamReader isr = new InputStreamReader(inputStream);
	    BufferedReader br = new BufferedReader(isr);

		
	    String line;
	    try {
	      line = br.readLine();

	      while (line != null) {
	        String[] stringValues = line.split(separator);
//	        double[] values = new double[stringValues.length];
	        for (int i = 0; i < stringValues.length; i++) {
	        	Blah value = Blah.fromString(stringValues[i]);
				int ascii =  value.ordinal();
				double[] values =  infor[ascii];
				list.add(values);
	        }	        
	        line = br.readLine();
	      }
	      br.close();
	    } catch (IOException e) {
	      throw new JMetalException("Error reading file", e);
	    } catch (NumberFormatException e) {
	      throw new JMetalException("Format number exception when reading file", e);
	    }
	    return list;
 }
}
