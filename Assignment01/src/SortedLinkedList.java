
public class SortedLinkedList {
	
	private NodeType head;
	
	public SortedLinkedList() {
		head = new NodeType(); 
		head = null;
		
	} 
	public int getLength() {
		int cnt=0; 
		NodeType location=head;
		while(location!=null) {
			cnt++;
			location=location.next;
		}
		return cnt;
	}
	public void insertItem(ItemType item) {
		NodeType now=new NodeType();
		now.info=item;
		now.info=null;
		NodeType predloc =head;
		if(head==null||head.info.compareTo(item)>=0) {
			now.next=head;
			head=now;
		}
		else {
			while(predloc.next.info.compareTo(item)<0&&predloc.next!=null) {
				predloc=predloc.next;
			} 
			if(predloc.info.compareTo(item)==0) {
				System.out.println("Sorry. You cannot insert the duplicate item");
				return;
			}
			now.next=predloc.next;
			predloc.next=now;
		}
		
	}
	public void deleteItem(ItemType item) {
		NodeType predloc=null;
		NodeType now=head;
		if(now==null) {
			System.out.println("You cannot delete from an empty list");
			return;
		}
		while(now!=null) {
			if(now.info.equals(item)) {
				predloc=now;
				if(predloc==null) head=now.next;
				else predloc.next=now.next;
				break;
			}
			now=now.next;
		}
		if(now==null) {
			System.out.println("The item is not present in the list");
			return;
		}
		
	}
	public int searchItem(ItemType item) {
		int index=0;
		NodeType predloc =head;
		while(predloc!=null) {
			if(predloc.info.equals(item))return index;
			predloc=predloc.next; 
			index++;
		}
		System.out.println("Item is not present in the list");
		return -1;
	}
}
