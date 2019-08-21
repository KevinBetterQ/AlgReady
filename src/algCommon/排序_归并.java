package algCommon;

// �鲢����
/*
 * ���ģ�����ߡ����ұߡ��ϲ�������ʵ��һ�������ݹ�Ϳ����ˣ�
 */

public class ����_�鲢 {
	
	//��ʼ������һ����ԭ�����С��ͬ�����飬��Ϊ�ظ�new�����Ƶ�������ڴ�
	   private static void mergeSortFull(int[] arr, int[] copy, int left, int right) {
	   	if(arr==null||arr.length==0) return;
	   	if(left==right) return;
	   	int mid = (left+right)/2;
	   	mergeSortFull(arr, copy, left, mid);
	   	mergeSortFull(arr, copy, mid+1, right);
	   	
	   	int i=left,j=mid+1;
	   	int loc=left;
	   	while(i<=mid&&j<=right) {
	   		if(arr[i]>=arr[j]) {
	   			copy[loc++] = arr[j++];
	   		}else {
	   			copy[loc++] = arr[i++];
	   		}
	   	}
	   	while(i<=mid) copy[loc++] = arr[i++];
	   	while(j<=right) copy[loc++] = arr[j++];
	   	for(int s=left;s<=right;s++) {
	   		arr[s] = copy[s];
	   	}
	   }
	
	public static void main(String args[]){
        int[] test = {9,2,6,3,5,7,10,11,12};
        merSort(test,0,test.length-1);
        for(int i=0; i<test.length;i++){
            System.out.print(test[i] + " ");
        }
        System.out.println();
        
        
        int[] test2 = {9,2,6,3,5,7,10,11,12};
        int[] copy = new int[test2.length];
        mergeSortFull(test2,copy,0,test2.length-1);
        for(int i=0; i<test2.length;i++){
            System.out.print(test2[i] + " ");
        }
    }
   

   // ������ʽ==============================================
    public static void merSort(int[] arr,int left,int right){

        if(left<right){
            int mid = (left+right)/2;
            merSort(arr,left,mid);//��߹鲢����ʹ��������������
            merSort(arr,mid+1,right);//�ұ߹鲢����ʹ��������������
            merge(arr,left,mid,right);//�ϲ�����������
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//ps��Ҳ���Դӿ�ʼ������һ����ԭ�����С��ͬ�����飬��Ϊ�ظ�new�����Ƶ�������ڴ�
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=right){
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){//�����ʣ��Ԫ������temp��
            temp[k++] = arr[i++];
        }
        while(j<=right){//��������ʣ��Ԫ������temp��
            temp[k++] = arr[j++];
        }
        //��temp�е�Ԫ��ȫ��������ԭ������
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }
    }
    
}
