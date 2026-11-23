public class Deque<T>{
    private class Node<T>{
        T data;
        Node next;
        Node prev;


     public Node(T data){
         this.data=data;
         this.next=null;
         this.prev=null;
     }
    }

    private Node <T> front;
    private Node <T> rear;
    private int size;
    public Deque(){
    this.front=null;
    this.rear=null;
    this.size=0;

    }
    //التحقق من الامتلاء

    // التحقق من الفراغ
    public boolean isEmpty(){
   return front==null;
    }
    //الإضافة
    public void addFirst(T item){
        Node<T> newNode=new Node<>(item);
        if(isEmpty()){
            front=rear=newNode;
        }else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }size++;
        System.out.println("The addition was successful.");
    }
    //الإضافة من النهاية
  public void addLast(T item){
      Node<T> newNode=new Node<>(item);
      if(isEmpty()){
          front=rear=newNode;
      }else {
          newNode.prev = rear;
          rear.next = newNode;
          rear = newNode;
      }
      size++;
      System.out.println("The addition was successful.");
  }
  //الحذف من البداية
    public T removeFirst(){
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }
        Node <T> localV=front;
        if(front==rear){
            front=null;
        }else {
            front = front.next;
            front.prev.next = null;
            front.prev = null;
        }
        size--;
        System.out.println("Removal was successful.");
        return (T) localV.data;
    }



    //الحذف من النهاية
    public T removeLast(){
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }
        Node <T> localV=rear;
        if (front == rear) {

            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        System.out.println("Removal was successful.");
        return (T) localV.data;
    }




    //عرض جميع العناصر في الطابور
public void displayQueue(){
    if (isEmpty()) {
        System.out.println("The queue is empty");
        return;
    }
    Node<T>current=front;
    if (front==rear){
        System.out.println(front.data);
        return;
    }
   while (current.next!=null){
       System.out.println(current.data);
       current=current.next;
   }
    System.out.println(current.data);
}


//إرجاع أول عنصر في الطابور
public T peekFirst(){
      if(isEmpty()){
          System.out.println("The queue is empty.");
          return null;
      }
      return (T) front.data;

}


//إرجاع آخر عنصر في الطابور
    public T peekEnd(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
            return null;
        }
        return (T) rear.data;

    }

    //عرض عدد العناصر الموجودة
    public int getSize(){
        return size;
    }

}
