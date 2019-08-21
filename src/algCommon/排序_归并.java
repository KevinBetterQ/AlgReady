package algCommon;

// 归并排序
/*
 * 核心：排左边、排右边、合并。（其实就一个函数递归就可以了）
 */

public class 排序_归并 {
	
	//开始就申请一个与原数组大小相同的数组，因为重复new数组会频繁申请内存
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
   

   // 其他方式==============================================
    public static void merSort(int[] arr,int left,int right){

        if(left<right){
            int mid = (left+right)/2;
            merSort(arr,left,mid);//左边归并排序，使得左子序列有序
            merSort(arr,mid+1,right);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right);//合并两个子序列
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//ps：也可以从开始就申请一个与原数组大小相同的数组，因为重复new数组会频繁申请内存
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
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[k++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[k++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }
    }
    
}
