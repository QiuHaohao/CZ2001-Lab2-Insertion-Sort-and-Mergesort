class InsertionSort{
	static int[] sort(int[] arr, int n){
		int temp;
		for(int i=0;i<n;i++){
			for(int j=i;j>0;j--){
				if (arr[j]<arr[j-1]){
					swap(arr,j,j-1);
				}
				else{
					break;
				}
			}
		}
		return arr;
	}
	public static void swap(int[] arr, int a, int b){
	  int temp = arr[a];
	  arr[a] = arr[b];
	  arr[b] = temp;
	}
}
