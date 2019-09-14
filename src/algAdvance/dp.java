package algAdvance;

// 参考：https://segmentfault.com/a/1190000014323449
/*
 * 总结：
 * N件物品，
 * 一个容量M的背包(cost限制)，
 * A[]是物品体积(cost)，
 * V[]是物品价值（value），
 * 求背包能装物品的最大价值(dp[M])
 * 
 * 思路：遍历每一件物品，思考对这一件物品的处理方法，处理并保存进dp[]数组，dp[M]即为容量为M的背包所能装下的最大价值
 */

public class dp {

// === 01背包问题：=== 
	// N件物品，一个容量M的背包(cost限制)。A[]是物品体积(cost)，V[]是物品价值（value），求背包能装物品的最大价值(dp[M])。
    public int pack01Solution(int N, int m, int A[], int V[]){
        int[]dp = new int[m+1];
        for(int i=0; i<N; i++){
            for(int j=m; j>=A[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-A[i]]+V[i]);
            }
        }
        return dp[m];
    }
    // 可以把01背包中对一件物品的处理抽取为方法：
    public void ZeroOnePack(int cost,int value,int[] dp,int m){
        for(int j=m;j>=cost;j--)
            dp[j] = Math.max(dp[j],dp[j-cost]+value);
    }
    
// === 完全背包问题 ===
    // N种物品，背包容量为M，每种无限件，给出物品体积和价值A[]、V[]，求最大价值。
    public int packComSolution(int N, int m,int[] A,int[] V){
        int[] dp = new int[m+1];
        for(int i=0; i<N; i++){
            for(int j=A[i];j<=m;j++)
                dp[j] = Math.max(dp[j],dp[j-A[i]]+V[i]);
        }
        return dp[m];
    }
    // 其中处理一种完全背包的物品可以抽取方法：
    public  void CompletePack(int cost,int value,int[] dp,int m){
        for(int j=cost; j<=m; j++)
            dp[j] = Math.max(dp[j],dp[j-cost]+value);
    }
    
// === 多重背包 ===(Difficult)
    // 在01背包基础上，增加条件每件物品的可取件数n[];
    public void packMutiSolutionk(int m,int[] A,int[] V ,int[] N){
        int[] dp = new int[m+1];
        for(int i=0;i<A.length;i++){
            MutiPack(A[i],V[i],N[i],dp,m);
        }
    }
    public void MutiPack(int cost, int value, int amount, int[] dp, int m){
        if(cost*amount>=m){
            CompletePack(cost,value,dp,m);
            return;
        }
        int s=1;
        while(s<amount){//条件：amount-s>0
            ZeroOnePack(s*cost,s*value,dp,m);
            amount -= s;
            s *= 2;
        }
        ZeroOnePack(amount*cost,amount*value,dp,m);
    }
}
