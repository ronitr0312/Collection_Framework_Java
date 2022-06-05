package src.main.java.collections.linkedlist;

public class LLInt {

  Node head;

  private  int size;

  public LLInt() {
    this.size = 0;
  }

  class Node {

    int data;
    Node next;

    Node(int data) {

      this.data = data;
      this.next = null;
    }
  }
  //addFirst
  public void addFirst(int data){

    Node newNode = new Node(data);

    if(head==null){
      head = newNode;
      return;
    }
    newNode.next = head;
    head = newNode;

  }
  //addLast
  public void addLast(int data){

    Node newNode = new Node(data);
    if (head == null){
      head = newNode;
      return;
    }
    Node currNode = head;
    while(currNode.next!= null){
      currNode = currNode.next;
    }
    currNode.next = newNode;
  }
  //deleteFirst
  public void removeFirst() {
    size--;
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    head = head.next;
  }
  //deleteLast
  public void removeLast(){
    size--;
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    if(head.next == null){
      head = null;
      return;
    }

    Node secondLast = head;
    Node last = head.next;

    while(last.next!= null){
      last = last.next;
      secondLast =secondLast.next;
    }
    secondLast.next =null;
  }
  public void printList(){

    if(head == null){
      System.out.println("Linked List is empty");
      return;
    }

    Node currNode = head;
    while(currNode!= null){
      System.out.print(currNode.data+" -> ");
      currNode = currNode.next;
    }
    System.out.println("NULL");
  }

  public void reverseIterator(){

    if(head==null || head.next ==null){
      return;
    }
    Node prevNode = head;
    Node currNode  = head.next;

    while(currNode!=null){
        Node nextNode = currNode.next;
        currNode.next =prevNode;
        //update
      prevNode = currNode;
      currNode =nextNode;
    }
    head.next =null;
    head =prevNode;
  }

  //reverseList
  public void reverseList(){

    Node prevNode = head;
    Node currNode = head.next;

    while(currNode!= null){
      Node nextNode = currNode.next;
      currNode.next = prevNode;

      //update
      prevNode = currNode;
      currNode =nextNode;

    }
    head.next=null;
    head = prevNode;
  }

  public Node reverseRecursive(Node head){
    if(head == null || head.next ==null){
      return head;
    }

    Node newHead = reverseRecursive(head.next);
    head.next.next = head;
    head.next=null;

    return newHead;
  }

  public static void main(String[] args) {
    LLInt list = new LLInt();
    list.addFirst(5);
    list.addFirst(4);
    list.addFirst(3);
    list.addFirst(2);
    list.addFirst(1);


    list.printList();
   list.head = list.reverseRecursive(list.head);
    list.printList();

  }
}
