
package algCommon;

public class ȫ���� {
	public static void permutation(char[]ss,int i){  
        if(ss==null||i<0 ||i>ss.length){//1  
            return;  
        }
        
        if(i==ss.length-1){//2  
            System.out.println(new String(ss));  
        }else{  
            for(int j=i;j<ss.length;j++){//3  
                char temp=ss[j];//����ǰ׺,ʹ֮������һ��ǰ׺  
                ss[j]=ss[i];  
                ss[i]=temp;  
                permutation(ss,i+1);//4  
                temp=ss[j]; //��ǰ׺������,��������һ����ǰ׺����.//5  
                ss[j]=ss[i];  
                ss[i]=temp;  
            }   
        }  
    }  
    public static void main(String args[]){
    	permutation(new char[]{'a','b','c','d'},0);
    }
}

