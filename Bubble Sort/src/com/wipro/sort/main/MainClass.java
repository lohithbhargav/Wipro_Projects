package com.wipro.sort.main;

import java.util.Scanner;

import com.wipro.sort.bubblesort.BubbleSort;
import com.wipro.sort.exceptions.EmptyArrayException;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        int length = sc.nextInt();    
        int [] array= new int[5];  
              if(length==0){
            	  array=null;
            	  EmptyArrayException e=new EmptyArrayException();
            	  System.out.println(e.toString());
              }
              else{
              try{
              for (int i=0;i<length ;i++)
              {
                    array[i]= sc.nextInt();
              }
              }catch(NumberFormatException eNum){
                    array=null;
              }
              BubbleSort bSort=new BubbleSort();
              array=bSort.sort(array);
              if(array!=null){
              System.out.println("Output:");
              for (int i=0;i< length ;i++){
            	  System.out.print( "   " + array[i] );
              }
              }
              else{
                    System.out.println("No ouput");
              }
  }
}
}