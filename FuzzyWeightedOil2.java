package org.uma.jmetal.algorithm.multiobjective.aRankabili;

import java.text.DecimalFormat;

import com.fuzzylite.Engine;
import com.fuzzylite.defuzzifier.Centroid;
import com.fuzzylite.rule.Rule;
import com.fuzzylite.rule.RuleBlock;
import com.fuzzylite.term.Trapezoid;
import com.fuzzylite.term.Triangle;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;

public class FuzzyWeightedOil2 {

	 static int row = 3;
	static int column = 4;
	static int elem = 4;
	static DecimalFormat df2 = new DecimalFormat("0.0000");

	
//	static double wU[] = {0.3030 ,  0.2433 ,  0.2245 ,  0.2292}; //oil -1-data
//	static double wU[] = {0.2526 ,  0.2526 ,  0.2533 ,  0.2416};
	
//	static double wU[] = {0.2667 ,  0.2667 ,  0.2000 ,  0.2667 }; //oil-2-data
	static double wU[] = {0.2607 ,  0.2607 ,  0.2178 ,  0.2607};
	
//	static double wU[] = {0.2941 ,  0.2647 ,  0.2941 ,  0.1471}; //oil-3-data
//	static double wU[] = {0.3578 ,  0.2844 ,  0.3578 ,  0.0000};
	
	public static void main(String[] args) {
	
		// ---palm Oil---data2--
		double [][][] A = {{{0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8},  {0.7,0.8,0.8,0.9}}, 
				{{0.1,0.2,0.2,0.3}, {0.2,0.3,0.4,0.5}, {0.2,0.3,0.4,0.5}, {0.1,0.2,0.2,0.3}},
				{{0.5,0.6,0.7,0.8},  {0.4,0.5,0.5,0.6},{0.4,0.5,0.5,0.6},{0.5,0.6,0.7,0.8}}};
		
		double [][][] B = {{{0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8}}, 
				{{0.1,0.2,0.2,0.3}, {0.1,0.2,0.2,0.3}, {0.1,0.2,0.2,0.3}, {0.1,0.2,0.2,0.3}},
				{{0.4,0.5,0.5,0.6},{0.4,0.5,0.5,0.6},{0.7,0.8,0.8,0.9},  {0.4,0.5,0.5,0.6}}};
		double [][][] C = {{{0.8,0.9,1.0,1.0},  {0.8,0.9,1.0,1.0},  {0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9}}, 
				{{0.5,0.6,0.7,0.8},  {0.4,0.5,0.5,0.6},{0.2,0.3,0.4,0.5}, {0.2,0.3,0.4,0.5}}, 
				{{0.5,0.6,0.7,0.8},  {0.4,0.5,0.5,0.6},{0.7,0.8,0.8,0.9},  {0.2,0.3,0.4,0.5}}};
		
		double [][][] W = {{{0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8}, {0.2,0.3,0.4,0.5}}, 
				{{0.8,0.9,1.0,1.0},  {0.5,0.6,0.7,0.8}, {0.7,0.8,0.8,0.9},  {0.4,0.5,0.5,0.6}}, 
				{{0.7,0.8,0.8,0.9},  {0.8,0.9,1.0,1.0},  {0.5,0.6,0.7,0.8}, {0.5,0.6,0.7,0.8}} };
		
		// ---SunFlower Oil---data3--
//		double [][][] A = {{{0.8,0.9,1.0,1.0},  {0.4,0.5,0.5,0.6},{0.8,0.9,1.0,1.0},  {0.4,0.5,0.5,0.6}}, 
//				{{0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8}}, 
//				{{0.1,0.2,0.2,0.3}, {0.8,0.9,1.0,1.0},  {0.4,0.5,0.5,0.6},{0.4,0.5,0.5,0.6}}};
//		double [][][] B = {{{0.7,0.8,0.8,0.9},  {0.2,0.3,0.4,0.5}, {0.7,0.8,0.8,0.9},  {0.4,0.5,0.5,0.6}}, 
//				{{0.2,0.3,0.4,0.5}, {0.4,0.5,0.5,0.6},{0.0,0.0,0.1,0.2},  {0.4,0.5,0.5,0.6}}, 
//				{{0.1,0.2,0.2,0.3}, {0.2,0.3,0.4,0.5}, {0.2,0.3,0.4,0.5}, {0.4,0.5,0.5,0.6}}};
//		double [][][] C = {{{0.7,0.8,0.8,0.9},  {0.7,0.8,0.8,0.9},  {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8}}, 
//				{{0.5,0.6,0.7,0.8},  {0.2,0.3,0.4,0.5}, {0.0,0.0,0.1,0.2},  {0.0,0.0,0.1,0.2}}, 
//				{{0.7,0.8,0.8,0.9},  {0.1,0.2,0.2,0.3}, {0.5,0.6,0.7,0.8},  {0.5,0.6,0.7,0.8}}};
		

		double [][][] D = new double [row][column][elem];
		
		WeightedMatrix(A, B, C, W);		
		Aggregation(A,B,C,D);
				
		Normalized(D);
//		System.out.println(D[3][0][0]+" a301="+ D[3][0][1] +" a302=" +D[3][0][2]  +" a303=" +D[3][0][3] );
		printArray(D);
		
		double DefD[][] = new double [row][column];
		Defuzzified(D, DefD);   //defuzzy the aggregated initial decision matrix
//		printArray(DefD);
		NormalizedSecd(DefD);
		printArray(DefD);	
		
		//step 4-1, 
		double mC[][] = new double[row+1][column];
		
//		Calculate_mC(DefD, wU, mC);
		Calculate_mCRankability(DefD, wU, mC);
		System.out.println("---BPAs-----");
		printArray(mC);
		
		 double belief[] = new double[row];

		Calculate_Belief(mC, belief);
		System.out.println("------Final results-------");
		printArray(belief);
	}

	 private static void printArray(double[] belief) {
		int length = belief.length;
		for(int i = 0; i < length; i ++) {
			System.out.print(df2.format(belief[i])+" ");
		}System.out.println();
		
	}

		private static void Calculate_Belief(double[][] mC, double together[]) {
			
			double up[] = new double[row], down = 0.0;
			for(int item = 0; item < row; item ++) {
				up[item] = mC[item][0] * mC[item][1] + mC[item][0]*mC[row][1] + mC[item][1]*mC[row][0];
				down = 0.0;
				for(int it = 0; it < row; it ++) {
					down += mC[it][0]*mC[it][1] + mC[it][0]*mC[row][1] + mC[it][1]*mC[row][0];
				}
				together[item] = up[item]/down;
			}
			double K = mC[row][0]*mC[row][1];
			for(int attribute = 2; attribute < column; attribute ++) {	
				for(int item = 0; item < row; item ++) {
					up[item] = together[item] * mC[item][attribute] + together[item]*mC[row][attribute] + mC[item][attribute]*K;
					down = 0.0;
					for(int it = 0; it < row; it ++) {
						down += together[it]*mC[it][attribute] + together[it]*mC[row][attribute] + mC[it][attribute]*K;
					}
					together[item] = up[item]/down;
					K = K*mC[row][attribute];
				}
			}
		}
	
		/*step 4-1*/	
	private static void Calculate_mC(double[][] defD, double[] wU2, double [][] Cm) {
		 for(int attribute = 0; attribute < column; attribute ++) {				
			 double sum = 0.0;
			 for(int item = 0; item < row; item ++) {
				Cm[item][attribute]  = defD[item][attribute]*(1 - wU2[attribute]);
				sum += Cm[item][attribute];
			 }
			 Cm[row][attribute] = 1 - sum;
		  } 		
	}

	/*step 4-1*/
	private static void Calculate_mCRankability(double[][] defD, double[] wU2, double [][] Cm) {
		 for(int attribute = 0; attribute < column; attribute ++) {				
			 double sum = 0.0;
			 for(int item = 0; item < row; item ++) {
				Cm[item][attribute]  = defD[item][attribute]*(wU2[attribute]);
				sum += Cm[item][attribute];
			 }
			 Cm[row][attribute] = 1 - sum;
		  } 		
	}
	
	private static void NormalizedSecd(double[][] defD) {
		 double norData[] = new double[column];	 
		 
			for(int attribute = 0; attribute < column; attribute ++) {				
				for(int item = 0; item < row; item ++) {
					norData[attribute]  += defD[item][attribute];
				}
			}  //find the sum values
			
			for(int attribute = 0; attribute < column; attribute ++) {
				for(int item = 0; item < row; item ++) {
					defD[item][attribute] = defD[item][attribute] / norData[attribute];
				}
			} // normalize process
		
	}

	 /*The first time normalized, min and max*/
	private static void Normalized(double[][][] d) {
		 double norData[] = new double[column];
		 
		for(int attribute = 0; attribute < column; attribute ++) {
			norData[attribute] = d[0][attribute][0];
			for(int item = 0; item < row; item ++) {
				for( int cont = 0; cont < elem; cont ++) {
					norData[attribute]  = norData[attribute] > d[item][attribute][cont] ? norData[attribute] :d[item][attribute][cont];

				}
			}
		}  //find the max, min values
		
		for(int attribute = 0; attribute < column; attribute ++) {
			for(int item = 0; item < row; item ++) {
				for( int cont = 0; cont < elem; cont ++) {
					if(attribute != 2) {
						d[item][attribute][cont] = d[item][attribute][cont] / norData[attribute];	
					}else {
						d[item][attribute][cont] =  norData[attribute]/ d[item][attribute][cont] ;
					}
					
				}
			}
		} // normalize process
	}

	/*VII table in paper*/
	private static void WeightedMatrix(double[][][] a, double[][][] b, double[][][] c, double[][][] w) {
		
		 for(int i = 0; i < row; i ++) {
			 for(int j = 0; j < column; j ++) {
				 for(int k = 0; k < elem; k ++) {
					 a[i][j][k] = a[i][j][k] * w[0][j][k];
					 b[i][j][k] = b[i][j][k] * w[1][j][k];
					 c[i][j][k] = c[i][j][k] * w[2][j][k];
				 }
			 }
		 }
		
	}

	private static void printArray(double[][] defD) {
		 int rowdata = defD.length, columndata = defD[0].length;
		 for(int i = 0; i < rowdata; i ++) {
				for(int j = 0; j < columndata; j ++) {				
					System.out.print(df2.format( defD[i][j])+" ");
				}
				System.out.println();
		}
	}

	private static void Defuzzified(double[][][] d, double[][] Def) {
		
		 for(int i = 0; i < row; i ++) {
				for(int j = 0; j < column; j ++) {
			
				double tup = -d[i][j][0] * d[i][j][1] + d[i][j][2] * d[i][j][3]
						+ Math.pow(d[i][j][2] - d[i][j][3], 2) / 3 - Math.pow(d[i][j][1] - d[i][j][0], 2) / 3;
				double tdown = -d[i][j][0] - d[i][j][1] + d[i][j][2] + d[i][j][3];
				double val = tup/tdown;
				val = val*10000;
				val = Math.round(val);
				val = val /10000;
				Def[i][j] = val;
				}				
		}
	}

	private static void printArray(double[][][] a) {
		 
//		 int row = a.length, column = a[0].length, elem = a[0][0].length;

		 for(int i = 0; i < row; i ++) {
				for(int j = 0; j < column; j ++) {
					
					System.out.print("(");
					for(int k = 0; k < (elem-1); k ++) {
						System.out.print(df2.format( a[i][j][k])+", ");
					}System.out.print(df2.format( a[i][j][elem-1])+") ");
				}
				System.out.println();
		}
	}

	private static void Aggregation(double[][][] a, double[][][] b, double[][][] c, double[][][] d) {
//		int row = a.length, column = a[0].length, elem = a[0][0].length;

		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < column; j ++) {
				for(int k = 0; k < elem; k ++) {
					if(k ==0) {
						d[i][j][k] = minValue(a[i][j][k], b[i][j][k], c[i][j][k]);
					}else if(k == (elem - 1)) {
						d[i][j][k] = maxValue(a[i][j][k], b[i][j][k], c[i][j][k]);
					}else {
						double val = ((a[i][j][k] + b[i][j][k] + c[i][j][k])/3);
						val = val*100;
						val = Math.round(val);
						val = val /100;
						d[i][j][k] = val;
					}
				}
			}			
		}		
	}
	 
	private static double minValue(double d, double e, double f) {
		double temp = d;
		if( temp > e) {
			temp = e;
		}
		if( temp > f) {
			temp = f;
		}
		return temp;
	}


	private static double maxValue(double d, double e, double f) {
		double temp = d;
		if( temp < e) {
			temp = e;
		}
		if( temp < f) {
			temp = f;
		}
		return temp;
	}

}
