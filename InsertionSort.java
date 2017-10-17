class InsertionSort{
	static int[] sort(int[] arr, int n){
		int temp;
		for(int i=0;i<n;i++){
			for(int j=i;j>0;j--){
				if (arr[j]<arr[j-1]){
					//swap
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				else{
					break;
				}
			}
		}
		return arr;
	}
}
