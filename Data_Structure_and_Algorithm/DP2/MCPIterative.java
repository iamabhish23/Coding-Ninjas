package Data_Structure_and_Algorithm.DP2;

import java.util.Scanner;

public class MCPIterative {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int graph[][]= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                graph[i][j]=s.nextInt();
            }
        }
        System.out.println(MinPath(graph,m,n));
        s.close();

    }

    private static int MinPath(int[][] graph,int m,int n) {
        int dp [][] = new int[m+1][n+1];
        for(int i =0; i<m+1; i++){
            for(int j =0; j<n+1; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i =m-1; i>=0; i--){
            for(int j =n-1; j>=0; j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=graph[i][j];
                    continue;
                }
                int ans1 = dp[i+1][j];
                int ans2 = dp[i][j+1];
                int ans3 = dp[i+1][j+1];

                dp[i][j] = graph[i][j]+Math.min(ans1, Math.min(ans2, ans3));
            }
        }
        return dp[0][0];
    }
}
