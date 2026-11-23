public class SimpleQueue<T> {

private int capacity;
private T []arr;
private int front;
private int rear;

public SimpleQueue(int capacity){
    this.capacity=capacity;
    arr= (T[]) new Object[capacity];
    rear=-1;
    front=0;
}

    //التحقق من فراغ القائمة
    public boolean isEmpty(){
        return front>rear;
    }

    //التحقق من امتلاء القائمة
    public boolean isFull(){
        return rear==capacity-1;
    }


//إضافة عنصر جديد للقائمة
    public T enqueue(T item){
        if(isFull()){
            System.out.println("There is no empty space to add.");
            return null;
        }
        return arr[++rear]=item;
    }

    //إضافة عنصر في البداية
    public T addFirst(T item){
        if(isFull()){
            System.out.println("There is no empty space to add.");
            return null;
        }
        for (int i = rear; i >= front ; i--) {
            arr[i+1]=arr[i];
        }
        rear++;
        return arr[0]=item;

    }

//حذف عنصر من بداية الطابور
public T dequeue(){
    if(front<=rear){
  T data=arr[front];
        for (int i = 0; i < rear ; i++) {
            arr[i]=arr[i+1];
        }
        arr[rear]=null;
        rear--;
    return data;
    }
    System.out.println("There are no items to dequeue.");
    return null;
}
//إزالة عنصر من بداية الطابور
public T removLast(){
    if (isEmpty()) {
        System.out.println("There are no items.");
        return null;
    }
    T localO=arr[front];
    arr[rear]=null;
    rear--;
    return (T)localO;



}



//إرجاع أول عنصر في الطابور
public T peek(){
    if (isEmpty()) {
        System.out.println("There are no items.");
        return null;
    }
    return arr[front];
}

//عرض جميع العناصر في الطابور
public void displayAllItems(){
    if (isEmpty()) {
        System.out.println("There are no items.");
        return;
    }
    for (int i = 0; i <= rear; i++) {
        System.out.println(arr[i]);
    }
    
    
}
    //إرجاع عدد العناصر في الطابور
public int getSize(){return rear+1;}





//    if(isEmpty()){
//        System.out.println("There are no items to dequeue.");
//        return null ;
//    }




}
