import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
	public static void main(String[] args) throws FileNotFoundException,IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose dataset:");
        System.out.println("1. Random");
        System.out.println("2. Descending");
        System.out.println("3. Ascending");
        int choice = sc.nextInt();
        String dataset;
        switch(choice){
            case 1:
                dataset = "Random";
                System.out.println("Using random dataset.");
                break;
            case 2:
                dataset = "Descending";
                System.out.println("Using descending dataset.");
                break;
            case 3:
                dataset = "Ascending";
                System.out.println("Using ascending dataset.");
                break;
            default:
                dataset = "Random";
                System.out.println("Wrong input, using random.");
        }
    	File folder = new File("Data/"+dataset+"/");
    	File[] listOfFiles = folder.listFiles();
    	ArrayList<File> textFileList = new ArrayList<File>();
    	PrintWriter resultOut = new PrintWriter(new BufferedWriter(new FileWriter("result_"+dataset+".csv")));
    	//Scan the list of .txt files in /Data/
        for (int i = 0; i < listOfFiles.length; i++) {
        	if (listOfFiles[i].isFile()) {
        		if(listOfFiles[i].getName().endsWith(".txt"))
            		textFileList.add(listOfFiles[i]);
          		} 
        	}
        Collections.sort(textFileList);
        long sortingTime;
    	long startTime;
    	int numOfKeyComparisms;
        resultOut.print("Dataset: " + dataset+"\n");
    	resultOut.print("Insertion Sort\n");
    	resultOut.print("Data Size,	CPU Time,	Number of Key Comparism\n");
        for(File f:textFileList){
        	Sorter s = new Sorter();
        	Scanner fi = new Scanner(f);
        	String fileName = f.getName();
        	int dataSize = Integer.parseInt(fileName.substring(0,fileName.length()-4));
     		int[] arr = new int[dataSize];
     		//read in data
     		for (int i=0;i<dataSize;i++)
    			arr[i] = Integer.parseInt(fi.next());

     		startTime = System.nanoTime();
     		s.insertionSort(arr,dataSize);
     		sortingTime = System.nanoTime() - startTime;

     		numOfKeyComparisms = s.getInsertionSortKeyComp();
     		resultOut.print(dataSize+",	"+sortingTime+",	"+numOfKeyComparisms+"\n");
        	}
        resultOut.print("MergeSort\n");
        resultOut.print("Data Size,	CPU Time,	Number of Key Comparism\n");
        for(File f:textFileList){
        	Sorter s = new Sorter();
        	Scanner fi = new Scanner(f);
        	String fileName = f.getName();
        	int dataSize = Integer.parseInt(fileName.substring(0,fileName.length()-4));
     		int[] arr = new int[dataSize];
     		//read in data
     		for (int i=0;i<dataSize;i++)
    			arr[i] = Integer.parseInt(fi.next());

     		startTime = System.nanoTime();
     		s.mergeSort(arr,0,dataSize-1);
     		sortingTime = System.nanoTime() - startTime;
     		
     		numOfKeyComparisms = s.getMergeSortKeyComp();
     		resultOut.print(dataSize+",	"+sortingTime+",	"+numOfKeyComparisms+"\n");
        	}

        System.out.println("Experiment Done!");
        resultOut.close();
        }
}