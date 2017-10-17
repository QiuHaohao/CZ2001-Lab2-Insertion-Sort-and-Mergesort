class Sorter{
	int mergeSortKeyComp = 0;
	int insertionSortKeyComp = 0;
	public Sorter(){
		
	}
	public void mergeSort(int[] arr, int l, int r){
		if (r-l>1){
			int m = (l+r)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	public void merge(int[] arr, int l, int m, int r){
		int lSize = m-l+1;
		int rSize = r-m;
		int[] auxl = new int[lSize];
		int[] auxr = new int[rSize];
		int lp = 0;
		int rp = 0;
		//copy array
		for(int i=0;i<lSize;i++)
			auxl[i] = arr[l+i];
		for(int i=0;i<rSize;i++)
			auxr[i] = arr[m+1+i]; 
		//merge
		for(int i=0;i<lSize+rSize;i++){
			if (lp>lSize-1){
				for (int j=rp;j<rSize;j++){
					arr[l+lSize+j] = auxr[j];
				}
				break;
			}
			if (rp>rSize-1){
				for (int j=lp;j<lSize;j++){
					arr[l+rSize+j] = auxl[j];
				}
				break;
			}
			mergeSortKeyCompInc();
			if (auxl[lp]<auxr[rp]){
				arr[l+i] = auxl[lp];
				lp++;
			}
			else{
				arr[l+i] = auxr[rp];
				rp++;
			}
		}
	}
	public int[] insertionSort(int[] arr, int n){
		int temp;
		for(int i=0;i<n;i++){
			for(int j=i;j>0;j--){
				insertionSortKeyCompInc();
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
	public void mergeSortKeyCompInc(){
		this.mergeSortKeyComp++;
	}
	public int getMergeSortKeyComp(){
		return this.mergeSortKeyComp;
	}
	public void insertionSortKeyCompInc(){
		this.insertionSortKeyComp++;
	}
	public int getInsertionSortKeyComp(){
		return this.insertionSortKeyComp;
	}
}
