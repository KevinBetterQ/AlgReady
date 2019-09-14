package algAdvance;

// �ο���https://segmentfault.com/a/1190000014323449
/*
 * �ܽ᣺
 * N����Ʒ��
 * һ������M�ı���(cost����)��
 * A[]����Ʒ���(cost)��
 * V[]����Ʒ��ֵ��value����
 * �󱳰���װ��Ʒ������ֵ(dp[M])
 * 
 * ˼·������ÿһ����Ʒ��˼������һ����Ʒ�Ĵ����������������dp[]���飬dp[M]��Ϊ����ΪM�ı�������װ�µ�����ֵ
 */

public class dp {

// === 01�������⣺=== 
	// N����Ʒ��һ������M�ı���(cost����)��A[]����Ʒ���(cost)��V[]����Ʒ��ֵ��value�����󱳰���װ��Ʒ������ֵ(dp[M])��
    public int pack01Solution(int N, int m, int A[], int V[]){
        int[]dp = new int[m+1];
        for(int i=0; i<N; i++){
            for(int j=m; j>=A[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-A[i]]+V[i]);
            }
        }
        return dp[m];
    }
    // ���԰�01�����ж�һ����Ʒ�Ĵ����ȡΪ������
    public void ZeroOnePack(int cost,int value,int[] dp,int m){
        for(int j=m;j>=cost;j--)
            dp[j] = Math.max(dp[j],dp[j-cost]+value);
    }
    
// === ��ȫ�������� ===
    // N����Ʒ����������ΪM��ÿ�����޼���������Ʒ����ͼ�ֵA[]��V[]��������ֵ��
    public int packComSolution(int N, int m,int[] A,int[] V){
        int[] dp = new int[m+1];
        for(int i=0; i<N; i++){
            for(int j=A[i];j<=m;j++)
                dp[j] = Math.max(dp[j],dp[j-A[i]]+V[i]);
        }
        return dp[m];
    }
    // ���д���һ����ȫ��������Ʒ���Գ�ȡ������
    public  void CompletePack(int cost,int value,int[] dp,int m){
        for(int j=cost; j<=m; j++)
            dp[j] = Math.max(dp[j],dp[j-cost]+value);
    }
    
// === ���ر��� ===(Difficult)
    // ��01���������ϣ���������ÿ����Ʒ�Ŀ�ȡ����n[];
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
        while(s<amount){//������amount-s>0
            ZeroOnePack(s*cost,s*value,dp,m);
            amount -= s;
            s *= 2;
        }
        ZeroOnePack(amount*cost,amount*value,dp,m);
    }
}
