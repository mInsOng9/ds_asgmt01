import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input.txt 에 있는 list사용 
		SortedLinkedList list=new SortedLinkedList();
		Scanner sc=new Scanner(System.in);
		boolean entering =true;
//		try {
//			File file=new File("input.txt"); 
//			
//		}catch(FileNotFoundException e) {
//			
//		}
		while(entering) {
			ItemType item=new ItemType();
			System.out.println("Enter a command : ");
			char user=sc.next().charAt(0);
			switch(user) {
				case 'i' : 
					System.out.println("Enter the input number : ");
					int num = sc.nextInt();  
					item.initialize(num);
					System.out.println("Original list : "+list.getLength());
					list.insertItem(item);
					System.out.println("New list : "+list.getLength());
					break;
				case 'd' : 
				case 's' : 
				case 'a' : 
				case 'm' : 
				case 't' : 
				case 'p' : 
				case 'l' : 
				case 'q' : 
				
			}
		}
	}

}
