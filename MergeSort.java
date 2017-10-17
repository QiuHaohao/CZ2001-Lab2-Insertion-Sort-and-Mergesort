class MergenSort{
	static int[] sort(int[] arr, int l, int r){
		if (r-l>1){
			int m = (l+r)/2;
			sort(arr,l,m);
			sort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	static void merge(int[] arr, int l, int m, int r){
		int[] auxl = new int[m-l+1];
		int[] auxr = new int[r-m];
		int lp = 0;
		int rp = 0;
		//copy array
		for(int i=0;i<m-l+1;i++)
			auxl[i] = arr[l+i];
		for(int i=0;i<r-m;i++)
			auxr[i] = arr[m+1+i]; 
		//merge
		for(int i=0;i<r-l+1;)
	}
}
