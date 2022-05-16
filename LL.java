
class LL{

  Node head;
  private int size;

  LL(){
    this.size =0;
  }

  class Node{

    String data;
    Node next;

    public Node(String data) {
      this.data = data;
      this.next = null;
      size++;
    }


  }

  //addFirst
  public void addFirst(String data){
    Node newNode = new Node(data);

    if(head==null){
      head =newNode;
      return;
    }
    newNode.next =head;
    head =newNode;
  }

  public void addLast(String data){
    Node newNode = new Node(data);

    if(head==null){
      head =newNode;
      return;
    }

    Node currNode =head;
    while(currNode.next != null){
      currNode = currNode.next;
    }
    currNode.next = newNode;
  }

  //deleteFirst
  public void deleteFirst(){
    size--;
    if(head ==null){
      System.out.println("list is Empty");
    }

    head = head.next;
  }

  //deleteLast
  public void deleteLast() {

    if (head == null) {
      System.out.println("list is Empty");
      return;
    }

    if(head.next ==null){
      head =null;
      return;
    }
    Node secondLast = head;
    Node lastNode = head.next;

    while (lastNode.next != null){
      lastNode = lastNode.next;
      secondLast = secondLast.next;
    }
    secondLast.next = null;
  }
  public void printList(){
      if(head ==null){
        System.out.println("List is empty");
      }
    Node currNode =head;
    while(currNode != null){
      System.out.print(currNode.data+ " -> ");
      currNode = currNode.next;
    }
    System.out.println("NULL");

  }

  public int getSize(){
    return size;
  }

  public void reverseIterator(){
    if(head == null || head.next == null){
      return;
    }
    Node prevNode = head;
    Node currNode = head.next;
    while(currNode != null){
      Node nextNode = currNode.next;
      currNode.next= prevNode;
      //update
      prevNode = currNode;
      currNode = nextNode;
    }
    head.next = null;
    head = prevNode;
  }

  public Node reverseRecursive(Node node){
    if(head == null || head.next == null){
      return head;
    }
    Node newHead = reverseRecursive(head.next);
    head.next.next = head;
    head.next = null;

    return newHead;
  }
  public static void main(String[] args) {
      LL list = new LL();
      list.addFirst("4");
      list.addFirst("3");
      list.addLast("2");
    list.addFirst("1");
    list.addFirst("0");
    //  list.printList();

     // list.deleteFirst();
   //   list.printList();

   //   list.deleteLast();
  //    list.printList();
  //  System.out.println(list.getSize());

    //list.addLast("ronit");
   // System.out.println(list.getSize());

    list.reverseIterator();
    list.printList();
  }
}