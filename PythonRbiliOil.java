package org.uma.jmetal.algorithm.multiobjective.aRankabili;

import java.text.DecimalFormat;

public class PythonRbiliOil {

	// Oil data--of the third one-----
//	static String A[][] = {{"VG", "F", "VG", "F" },
//			{"MG", "MG", "MG", "MG" },
//			{"P", "VG", "F", "F" }};
//	static String B[][] = {{"G", "MP", "G", "F" },
//			{"MP", "F", "VP", "F" },
//			{"P", "MP", "MP", "F" }};
//	static String C[][] = {{"G", "G", "MG", "MG" },
//			{"MG", "MP", "VP", "VP"}, 
//			{"G", "P", "MG", "MG"}};

	// Oil data--of the first one-----
	static String A[][] = {{"F", "MP", "MP", "VG"},
			{"G", "F", "F", "MG"},
			{"MP", "VG", "MG", "G"}, 
			{"P", "VP", "P", "MP"}};
	static String B[][] = {{"P", "G", "MP", "F"},
			{"F", "G", "MG", "F"},
			{"VG", "MP", "VG", "VG"},
			{"MP", "MG", "F", "MG"}};
	static String C[][] = {{"MP", "F", "G", "MG"}, 
			{"VG", "P", "G", "G"}, 
			{"P", "G", "G", "G"},
			{"F", "P", "G", "G"}};

	// Oil data--of the second one-----
//	static String A[][] = {{"G", "MG", "MG", "G"}, 
//			{"P", "MP", "MP", "P"}, 
//			{"MG", "F", "F", "MG"}};
//	static String B[][] = {{"G", "MG", "MG", "MG"}, 
//			{"P", "P", "P", "P"}, 
//			{"F", "F", "G", "F"}};
//	static String C[][] = {{"VG", "VG", "G", "G"}, 
//			{"MG", "F", "MP", "MP"}, 
//			{"MG", "F", "G", "MP"}};
	
	static int row = A.length, column = A[0].length;
	static  double admatrix[][][] = new double[column][row][row]; //critera * [ alternative * alternative]
	static DecimalFormat df2 = new DecimalFormat("0.0");
	
	public static void main(String[] args) {
		
		int An[][] = new int [row][column], Bn[][] = new int [row][column], Cn[][] = new int [row][column];
		translateStr2int(A, An); translateStr2int(B, Bn);translateStr2int(C, Cn);
		
//		printTranNum(An);  
		
		createAdjacentM(An, Bn, Cn);
		printAdjacentM();
	}

	private static void printAdjacentM() {
		
		for( int attribute = 0; attribute < column; attribute ++) {
			System.out.print("np.array([");
			
			for(int i = 0; i < row; i ++) {
				System.out.print("["+df2.format(admatrix[attribute][i][0])+", ");
				for( int j = 1; j < (row-1); j ++) {
					System.out.print(df2.format(admatrix[attribute][i][j])+", ");
				}
				if(i == (row -1)) {
					System.out.print(df2.format(admatrix[attribute][i][row-1])+"]]), ");
				}else {
					System.out.print(df2.format(admatrix[attribute][i][row-1])+"], ");
				}			
			}
			System.out.println();
		}
		
	}

	/*create adjacentM for python to calculate the rankability*/
	private static void createAdjacentM(int[][] an, int[][] bn, int[][] cn) {
		int idx[] = new int[row];
		for(int attritute = 0; attritute < column; attritute ++) {  //for each attribute
			 //for A
			fillidx(idx);
			minFastSort(idx, row, attritute, an); 
			 //for B
			fillidx(idx);
			minFastSort(idx, row, attritute, bn); 
			 //for C
			fillidx(idx);
			minFastSort(idx, row, attritute, cn); 
		}			
	}

	
	  public static  void minFastSort(int idx[], int n, int attribute, int[][] data) {
		  double help[] = new double[n];
		  fillhelper(help, attribute, data);  
		  
		  for (int i = 0; i < n; i++) {
		      for (int j = i + 1; j < n; j++) {
		        if (help[i] < help[j]) {
		          double temp = help[i];
		          help[i] = help[j];
		          help[j] = temp;
		          int id = idx[i];
		          idx[i] = idx[j];
		          idx[j] = id;
		        }
		      }
		    }

		  filladjcentM(help, idx, attribute);
	}
	  
	  private static void filladjcentM(double[] help, int[] idx, int attribute) {
			
			for(int i = 0; i < (row-1); i ++){		
				int x = idx[i];
				for(int j = i+1; j < row; j ++) {
					int y = idx[j];
					if(help[i] != help[j]) {
						admatrix[attribute][x][y] +=  0.1;					
					}
				}
			}
		}	  
	  
	public static void fillhelper(double help[], int obj, int data[][]) {
		for(int i = 0; i < row; i ++) {
			help[i] = data[i][obj];
		}
	}	  
	  
	public  static void fillidx(int idx[]) {
		for(int i = 0; i < idx.length; i ++) {
			idx[i] = i;
		}
	}

	private static void printTranNum(int[][] an) {
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < (column-1); j ++) {
				System.out.print(an[i][j]+" ");
			}System.out.println(an[i][column - 1]);
		}		
	}

	private static int[][] translateStr2int(String[][] str, int[][] num) {
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < column; j ++) {
				Blah value = Blah.fromString(str[i][j]);
				int ascii =  value.ordinal();
				num[i][j] = ascii;
			}
		}
		
		return num;
	}

	public enum Blah {
	    A("VP"),//0
	    B("P"),//1
	    C("MP"), //2
	    D("F"),//3
	    F("MG"),//4
	    G("G"), //5
	    H("VG"); //6
		
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
}
