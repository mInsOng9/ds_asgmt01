
public class ItemType {
	private int value;
	
	/*
	 *  Compares the value of item with the current object's
	 *  value and return -1 if value of the current object is less than value in item , 
	 *  0 if equal and 1 if greater
	 */
	 
	//? 다른 질문 : mergeList, DeleteAlternate nodes, Intersection은 다른 function인가? 
	// 그러면 어느 class에 해야되지 ? SortedLinkedList?
	//? Sample Output에 있는 code를 LinkedListDriver에다가 쓰는건가?
	//? 사용자에게 물어보고 반응하는 그런 main function은 어느 파일에??
	//? Readme.txt는 뭔지?
	//? Do I have to read text file(input.txt) ? 
	public int compareTo(ItemType item) {
		if(item.value<value)return 1; 
		else if (item.value>value) return -1;
		else return 0;
	}
	public int getValue() {
		return value;
	}
	public void initialize(int num) {
		value=num;
	}
}
