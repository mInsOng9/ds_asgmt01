
public class SortedLinkedList {
	
	private NodeType head;
	
	public SortedLinkedList() {
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
	public String print() {
		NodeType loc=head;
		String listSt="";
		while(loc!=null) {
			listSt +=loc.info.getValue()+ " ";
			loc=loc.next;
		}
		return listSt;
	}


	public void insertItem(ItemType item) {
		NodeType predloc=new NodeType(); 
		predloc.info=item;
		if(head==null) {
			predloc.next=head; 
			head=predloc; 
		}
		else if(head.info.compareTo(item)==0) {
				System.out.println("Sorry. You cannot insert the duplicate item");
				return;
			}
		else if(head.info.compareTo(item)>0){
			predloc.next=head; 
			head=predloc; 
		}
		else {
			NodeType now=new NodeType(); 
			now=head; 
			while(now.next!=null&&now.next.info.compareTo(item)<0) {
				now=now.next;
			}
			
			predloc.next=now.next; 
			now.next=predloc;
		}

		/*
		 * NodeType now=new NodeType(); now.info=item; NodeType predloc; if(head==null)
		 * {//||head.info.compareTo(item)>=0) { //when head is null or value of head
		 * >item value now.next=head; head=now; } else { predloc=head;
		 * 
		 * System.out.println(cnt+"---------------------------");
		 * System.out.println("___predloc(info) : "+predloc.info.getValue()+"/ now : "
		 * +now.info.getValue());
		 * 
		 * if(predloc.info.compareTo(item)>0) { //when predloc info value is greater
		 * than item value
		 * System.out.println("iiiif loop"+now.info.getValue()+" pred"+predloc.info.
		 * getValue()); now.next=predloc;
		 * System.out.println("if loop"+now.info.getValue()+" pred"+predloc.info.
		 * getValue()); return; }
		 * 
		 * 
		 * while(predloc.next!=null&&predloc.next.info.compareTo(item)<0) { NodeType
		 * big=predloc.next; predloc.next=now; now.next=big;
		 * System.out.println("while"+predloc.info.getValue()+" / next : "+predloc.next.
		 * info.getValue());; break; } if(predloc.info.compareTo(item)==0) {
		 * System.out.println("Sorry. You cannot insert the duplicate item"); return; }
		 * System.out.println("predloc(info) : "+predloc.info.getValue()+" now : "+now.
		 * info.getValue());
		 * 
		 * now.next=predloc.next; predloc.next=now; // head=head.next; cnt++; }
		 */
		
	}
	public void deleteItem(ItemType item) {
		NodeType predloc=null;
		NodeType now=new NodeType();
		now=head;
		if(head==null) {
			System.out.println("You cannot delete from an empty list");
			return;
		}
		while(now!=null&&!(now.info.compareTo(item)==0)) {
			predloc=now; 
			now=now.next;
		}
		if(now==null) {
			System.out.println("The item is not present in the list");
			return;
		}
	
		if(predloc==null)
			head=now.next;
		else predloc.next=now.next;
		
	}
	public int searchItem(ItemType item) {
		int index=0;
		NodeType predloc =head;
		if(head==null) return -1;
		
		while(predloc!=null) {
			if(predloc.info.compareTo(item)==0)return index;
			predloc=predloc.next; 
			index++;
		}
		return -1;
	}
	public void deleteAlternateNodes() {
		if(head==null)System.out.println("The list is empty");
		NodeType now=head; 
		NodeType predloc=head;
		int index=0;
		while(now!=null) {
			if(index%2!=0) predloc.next=now.next; 
			else {
				predloc=now; 
				if(predloc==null)break;
				now=now.next;
			}
			index++;
		}
		return;
	}
	public String intersection(SortedLinkedList list) {
		NodeType now=head; 
		String intersec="";
		while(now!=null) {
			if(list.searchItem(now.info)!=-1) {
				intersec+=now.info.getValue()+" ";
			}
			now=now.next;
		}
		return intersec;
	}
	public void mergeList(SortedLinkedList list) {
		NodeType now=head;
		NodeType now1=list.head;
		while(now1!=null) {
			if(head.info.compareTo(now1.info)==0)now1=now1.next;
			else if(searchItem(now1.info)==-1) {
				insertItem(now1.info);
				now1=now1.next;
			}
			else now1=now1.next;
		}
	}
	
}
