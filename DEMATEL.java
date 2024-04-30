package org.uma.jmetal.algorithm.multiobjective.aRankabili;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class DEMATEL {

	static int DM = 5; static int C= 6; static int item = 3;
	static double initialdata[][][][] = new double[DM][C][C][item];

	static double Wg[] = {0.15, 0.15, 0.15, 0.25, 0.3};
	static double aggregate[][][] = new double[C][C][item];
	static double Ptotal[][][] = new double[C][C][item];
	static DecimalFormat df2 = new DecimalFormat("0.0000");
	
	static double fD[][] = new double[C][C];
	static double fR[][] = new double[C][C];
	static double Def[][] = new double[C][C];
	public static void main(String[] args) throws FileNotFoundException {
		Readfile read = new Readfile("demateldata.txt", " ");
		read.run();
		initialdata = read.getData();
		WeightedAggregate();
		printArray(aggregate);
		

		
		double r = find_r();
		Normalize(r);
		printArray(aggregate);
		
		DefuzzyProcess();
		printArray(Def);
		
//		printFuzzyArrayThree(aggregate);
//		getPtotal();
//		System.out.println("-ptotal---");
//		printArray(Ptotal);
//		getIRM();
//		printArray(fD);
//		System.out.println("----");
//		printArray(fR);
	}


	private static void DefuzzyProcess() {
		for(int i = 0; i < C; i ++) {
			for(int j = 0; j < C; j ++) {
				double a =  aggregate[i][j][0] +aggregate[i][j][1]*4 + aggregate[i][j][2];
				Def[i][j] = a/6;
			}
		}	
		
	}


	private static void getIRM() {
		for(int i = 0; i < C; i ++) {
			for(int j = 0; j < C; j ++) {
				for(int k = 0; k < item; k ++) {
				  fR[i][k] += Ptotal[i][j][k] ;
				  fD[j][k] += Ptotal[i][j][k] ;
				}
			}
		}	
	}

	private static void getPtotal() {
		for(int i = 0; i < C; i ++) {
			for(int j = 0; j < C; j ++) {
				for(int k = 0; k < item; k ++) {
					Ptotal[i][j][k] = aggregate[i][j][k]/(1- aggregate[i][j][k]);
				}
			}
		}			
	}


	
	private static void Normalize(double r) {
		for(int i = 0; i < C; i ++) {
			for(int j = 0; j < C; j ++) {
				for(int k = 0; k < item; k ++) {
					aggregate[i][j][k] = aggregate[i][j][k]/r;
				}
			}
		}		
	}

	private static double find_r() {
		double r[] = new double[C];
		for(int j = 0; j < C; j ++) {
			for(int i = 0; i < C; i ++) {
				r[j] += aggregate[i][j][item-1];
			}
		}
		double max = r[0]; 
		for(int j = 1; j < C; j ++) {
			max = max > r[j] ? max : r[j];
		}
		System.out.println("max is " + max);
		return max;
	}

	private static void WeightedAggregate() {
		//weighted process
		double tempdata[][][][] = new double[DM][C][C][item];
		for( int d = 0 ; d < DM; d ++) {
			for(int i = 0; i < C; i ++) {
				for(int j = 0; j < C; j ++) {
					for(int k = 0; k < item; k ++) {
						tempdata[d][i][j][k] = initialdata[d][i][j][k]*Wg[d];
					}
				}
			}
		}
		
		//Aggregated proces
		for(int i = 0; i < C; i ++) {
			for(int j = 0; j < C; j ++) {
				for(int k = 0; k < item; k ++) {
					for( int d = 0 ; d < DM; d ++) {
						aggregate[i][j][k] += tempdata[d][i][j][k];
					}
					aggregate[i][j][k] = aggregate[i][j][k]/(double)DM;
				}
			}
		}
		System.out.println("aggregate finished");
	}

	private static void printArray(double[][][] data) {
		 int rowdata = data.length, columndata = data[0].length;
		 for(int i = 0; i < rowdata; i ++) {
				for(int j = 0; j < columndata; j ++) {	
					System.out.print("{");
					for(int k = 0; k < item; k ++) {
						System.out.print(df2.format( data[i][j][k])+" ");
					}
					System.out.print("},");
				}
				System.out.println();
		}
	}
	

	private static void printArray(double[][] data) {
		 int rowdata = data.length; int column = data[0].length;
		 for(int i = 0; i < rowdata; i ++) {
				System.out.print("{");
				for(int k = 0; k < column; k ++) {
					System.out.print(df2.format( data[i][k])+" ");
				}
				System.out.print("},");
				System.out.println();
		}		
	}

	private static void printFuzzyArrayThree(double[][][] data) {
		 int rowdata = data.length; int column = data[0].length;
		 
		 for(int term = 0; term < 3; term ++) {
			 for(int i = 0; i < rowdata; i ++) {
					for(int k = 0; k < column; k ++) {
						System.out.print(df2.format( data[i][k][term])+" ");
					}
					System.out.println();
			}
			 System.out.println("-----");
		 }
	
	}
	
//	private static void printAdjacentM(double [][] data) {
//		
//		for( int attribute = 0; attribute < C; attribute ++) {
//			System.out.print("np.array([");
//			
//			for(int i = 0; i < C; i ++) {
//				System.out.print("["+df2.format(data[attribute][i][0])+", ");
//				for( int j = 1; j < (row-1); j ++) {
//					System.out.print(df2.format(admatrix[attribute][i][j])+", ");
//				}
//				if(i == (C-1)) {
//					System.out.print(df2.format(admatrix[attribute][i][row-1])+"]]), ");
//				}else {
//					System.out.print(df2.format(admatrix[attribute][i][row-1])+"], ");
//				}			
//			}
//			System.out.println();
//		}
//		
//	}
}
