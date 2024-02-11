import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LinkedListDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedLinkedList list=new SortedLinkedList();
		Scanner sc=new Scanner(System.in);
		boolean entering =true;
		try {
			File file=new File("c:\\Users\\\\Public\\\\input.txt");
			if(!file.exists()) {
				file.createNewFile();
				BufferedWriter writer=new BufferedWriter(new FileWriter(file));
				writer.write("3 10 5 12 8 20 1");
				writer.close();
			}
			
			Scanner scReader=new Scanner(new File(file.toString()));
			String str; 
			while(scReader.hasNextLine()) {
				str=scReader.next();
				int num=Integer.parseInt(str);
				ItemType item=new ItemType();
				item.initialize(num);
				list.insertItem(item);
			}
			scReader.close();
			System.out.println(list.print());
			
			while(entering) {
				ItemType item=new ItemType();
				System.out.print("Enter a command : ");
				char user=sc.next().charAt(0);
				switch(user) {
					case 'i' : 
						System.out.print("Enter a number to insert : ");
						int num = sc.nextInt();  
						item.initialize(num);
						System.out.println("Original list : "+list.print());
						list.insertItem(item);
						System.out.println("New list : "+list.print());
						break;
					case 'd' :  
						System.out.print("Enter a number to delete : ");
						int num1 = sc.nextInt();
						item.initialize(num1); 
						System.out.println("Original list : "+list.print());
						list.deleteItem(item);
						System.out.println("New list : "+list.print());
						break;
					case 's' : 
						System.out.print("Enter a number to search : ");
						int num2 = sc.nextInt();
						item.initialize(num2); 
						System.out.println("Original list : "+list.print());
						int result=list.searchItem(item);
						if(result!=-1)System.out.println("The item is present at index "+list.searchItem(item));
						else if(list.getLength()==0)System.out.println("The list is empty");
						else System.out.println("Item is not present in the list");
						break;
					case 'a' : 
						System.out.println("Original list : "+list.print());
						list.deleteAlternateNodes();
						System.out.println("New list : "+list.print());
						break;
					case 'm' : 
						//merge list
						System.out.print("Enter the length of the new list : ");
						int length=sc.nextInt();
						System.out.print("Enter the numbers: ");
						SortedLinkedList list2=new SortedLinkedList();
						while(length>0) {	
							int newInt=sc.nextInt();
							ItemType item2=new ItemType();
							item2.initialize(newInt);
							list2.insertItem(item2);
							length--;
						}
						System.out.println("list 1 : "+list.print());
						System.out.println("list 2 : "+list2.print());
						list.mergeList(list2);
						System.out.println("New list : "+list.print());
						break;
					case 't' : 
						//find intersection
						System.out.print("Enter the length of the new list : ");
						int length1=sc.nextInt();
						System.out.print("Enter the numbers: ");
						SortedLinkedList list3=new SortedLinkedList();
						while(length1>0) {	
							int newInt=sc.nextInt();
							ItemType item3=new ItemType();
							item3.initialize(newInt);
							list3.insertItem(item3);
							length1--;
						}
						System.out.println("list 1 : "+list.print());
						System.out.println("list 2 : "+list3.print());
						System.out.println("Intersection of lists: "+list.intersection(list3));
						break;
					case 'p' : 
						System.out.println(list.print());
						break;
					case 'l' :  
						System.out.println("The length of the list is "+list.getLength());
						break;
					case 'q' : 
						System.out.println("Exiting the program...");
						entering=false;
						break;
					default : 
						System.out.print("Invalid command try again :");
						user=sc.next().charAt(0);
						break;

					
				} 
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}

}
