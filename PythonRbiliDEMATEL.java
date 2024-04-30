package org.uma.jmetal.algorithm.multiobjective.aRankabili;

import java.text.DecimalFormat;

public class PythonRbiliDEMATEL {

    static double all[][] = {{0.0092, 0.1354, 0.1589, 0.1644, 0.1437, 0.1286, },
    						{ 0.0698, 0.0092, 0.2043, 0.1235, 0.1905, 0.1694, },
    						{ 0.0601, 0.2112, 0.0092, 0.1198, 0.0882, 0.1074, },
    						{ 0.2112, 0.0395, 0.0932, 0.0092, 0.0799, 0.1129, },
    						{ 0.1116, 0.1341, 0.1240, 0.1129, 0.0092, 0.2043, },
    						{ 0.0670, 0.0840, 0.1488, 0.0744, 0.0923, 0.0092, }};
	
	
	static int row = all.length - 1, column = all[0].length -1;
	static DecimalFormat df2 = new DecimalFormat("0.0000");
	
	public static void main(String[] args) {
		
		double Ann[][][] = new double [6][row][column];
		for( int i = 0; i < 6; i ++)
			translateStr2int(all, Ann, i); 
		
		printTranNum(Ann);  
		
		printAdjacentM(Ann);
	}

	private static void printAdjacentM(double Ann[][][]) {
		
		for( int attribute = 0; attribute < 6; attribute ++) {
			System.out.print("np.array([");
			
			for(int i = 0; i < row; i ++) {
				System.out.print("["+df2.format(Ann[attribute][i][0])+", ");
				for( int j = 1; j < (row-1); j ++) {
					System.out.print(df2.format(Ann[attribute][i][j])+", ");
				}
				if(i == (row -1)) {
					System.out.print(df2.format(Ann[attribute][i][row-1])+"]]), ");
				}else {
					System.out.print(df2.format(Ann[attribute][i][row-1])+"], ");
				}			
			}
			System.out.println();
		}
		
	}


	private static void printTranNum(double[][][] ann) {
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < (column-1); j ++) {
				System.out.print(ann[0][i][j]+" ");
			}System.out.println(ann[0][i][column - 1]);
		}		
	}

	private static double[][][] translateStr2int(double[][] all, double[][][] num, int label) {
		int ii = 0, jj = 0;
		for(int i = 0; i < (row+1); i ++) {
			if( label != i) {
				jj = 0;
				for(int j = 0; j < (column+1); j ++) {
					if(j != label) {
						num[label][ii][jj] = all[i][j];
						jj ++;
					}

				}
				ii ++;
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
