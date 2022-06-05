package src.main.java.collections.linkedlist;



public class LinkedListString {

  Node head;

  private int size;

  public LinkedListString() {
    this.size = 0;
  }

  class Node{

    String data;
    Node next;

    public Node(String data) {
      this.data = data;
    }
  }

  //addFirst
  public void addFirst(String data){


    Node newNode = new Node(data);
    if(head == null){
     head = newNode;
      return;
    }
    newNode.next = head;
    head = newNode;

  }
  //addLast
  public void addLast(String data){

    Node newNode = new Node(data);
    if(head == null){
      System.out.println("List is empty");
      return;
    }
    Node currNode = head;
    while(currNode.next !=null){
          currNode = currNode.next;

    }
    currNode.next = newNode;
  }

  //deleteFirst
  public void removeFirst(){
    size--;
    if(head == null){
      System.out.println("List is empty");
      return;
    }
    head = head.next;

  }
  //deleteLast
  public void removeLast(){
    size--;
    if(head == null){
      System.out.println("List is empty");
      return;
    }
    if(head.next == null){
        head =null;
        return;
    }
    Node secondLast = head;
    Node last = head.next;
    while(last.next !=null){
      last = last.next;
      secondLast = secondLast.next;
    }
    secondLast.next =null;
  }

  public void printList(){
    if(head == null){
      System.out.println("List is empty");
      return;
    }
    Node currNode = head;
    while(currNode !=null){
      System.out.print(currNode.data+" -> ");
      currNode = currNode.next;

    }
    System.out.print("NULL");
    System.out.println();


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

    LinkedListString list = new LinkedListString();
      list.addFirst("list");
      list.addFirst("a");
      list.addFirst("is");
      list.addFirst("This");
  //    list.printList();


      //list.printList();

      list.addLast("confirmed");
    list.head =list.reverseRecursive(list.head);
     list.printList();

     // list.removeLast();
      //list.printList();

    //  list.removeFirst();
    //  list.printList();
  }
}
