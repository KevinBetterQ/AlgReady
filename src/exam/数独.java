package exam;

// 另外：https://www.cnblogs.com/zhangbaochong/p/5847364.html
// https://www.cnblogs.com/theskulls/p/5289593.html


import java.util.Scanner;
public class 数独{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int[][] A = new int[9][9];
            
            for(int i =0;i<9;i++){
                for(int j =0;j<9;j++){
                    A[i][j] = in.nextInt();
                }
                 
            }
            solvesudoku(A,0);
            for(int i =0;i<9;i++){
                for(int j =0;j<9;j++){
                      if(j != 8)
                        System.out.print(A[i][j] + " ");
                        else
                            System.out.print(A[i][j]);
                }
              if(i != 8)
                System.out.println();   
            }
        }
    }
    // 回溯法
    static boolean solvesudoku(int[][] sd,int index){
        if(index == 81)
            return true;
        int x = index/9;
        int y = index%9;
        if(sd[x][y]==0){
            for(int n=1;n<=9;n++){
                sd[x][y] = n;
                if(CheckrowAndcol(sd,x,y,n) && CheckGrid(sd,x,y,n))
                    if(solvesudoku(sd,index+1))
                        return true;
                sd[x][y] = 0;
            }
        }else
            return solvesudoku(sd,index+1);
        return false;
         
    }
    // 判断 n 所在的行列是否包含 n
     static boolean CheckrowAndcol(int[][] sd,int x ,int y,int n){
        // x 行
        for(int j=0;j<9;j++){
            if(j!=y && sd[x][j] ==n  )
                return false;
        }
        // y列
        for(int i=0;i<9;i++){
            if(i!=x && sd[i][y]==n )
                return false;
        }
        return true;
    }
    // 判断所在的方格是否包含 n
     static boolean CheckGrid(int[][] sd,int x,int y,int n){
        // 根据x y的坐标求其所在方格的左上坐标和右下坐标表示不好想。
        for(int i = (x/3)*3;i<(x/3+1)*3;i++){
            for(int j=(y/3)*3;j<(y/3+1)*3;j++){
                if(i!=x && j!=y && sd[i][j]==n)
                    return false;
            }
        }
        return true;
    }
}