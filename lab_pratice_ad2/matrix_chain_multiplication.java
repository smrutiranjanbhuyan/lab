package lab_pratice_ad2;

public class matrix_chain_multiplication {
	  public static int matrixChainOrder(int[] p) {
	        int n = p.length - 1; 
	        int[][] dp = new int[n][n];

	        for (int i = 0; i < n; i++) {
	            dp[i][i] = 0;
	        }

	       
	        for (int length = 2; length <= n; length++) {
	            for (int i = 0; i < n - length + 1; i++) {
	                int j = i + length - 1;
	                dp[i][j] = Integer.MAX_VALUE;
	                for (int k = i; k < j; k++) {
	                    int cost = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
	                    if (cost < dp[i][j]) {
	                        dp[i][j] = cost;
	                    }
	                }
	            }
	        }

	        return dp[0][n - 1];
	    }

	    public static void main(String[] args) {
	        int[] dimensions = {10, 30, 5, 60};
	        int minMultiplications = matrixChainOrder(dimensions);
	        System.out.println("Minimum number of multiplications: " + minMultiplications);
	    }
}
