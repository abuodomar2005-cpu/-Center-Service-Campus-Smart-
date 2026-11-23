public class PriorityQueue<T>{
    private int capacity;
    private T []arr;
    private int front;
    private int rear;
    private int []priority;


    public PriorityQueue(int capacity){
        this.capacity=capacity;
        arr=(T[])new Object[capacity];
        this.priority=new int[capacity];
        rear=-1;
        front=0;

    }
    public boolean isFull(){
        return rear==capacity-1;
    }
    public boolean isEmpty(){
        return front>rear;
    }

    public T enqueue(T item,int pr){
        if(isFull()){
            System.out.println("There is no empty space to add.");
            return null;
        }
        if (isEmpty()){
            priority[0]=pr;
            return arr[++rear]=item;

        }
        int []arr2= priority.clone();
        T []arr3=arr.clone();
        for (int i = 0; i <= rear; i++){

            if(pr < priority[i]){

           priority[i]=pr;
           arr[i]=item;
                for (int j = i+1; j <=rear+1 ; j++) {
                    priority[j]=arr2[j-1];
                    arr[j]=arr3[j-1];

                }
                rear++;
               return arr[i]=item;
            }
            if (pr==priority[i]){
                int j = i + 1;

                while (j <= rear && priority[j] == pr) {
                    j++;
                }

                for (int k = rear; k >= j; k--) {
                    priority[k + 1] = priority[k];
                    arr[k + 1] = arr[k];
                }

                priority[j] = pr;
                rear++;
                return arr[j] = item;
            }
        }

        rear++;
        priority[rear] = pr;
       return arr[rear] = item;
    }

//حذف عنصر من الطابور
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
//حذف بواسطة الid
public T removeBySearch(T ob){
    if (isEmpty()) {
        System.out.println("There are no items to remove.");
        return null;
    }
    T ob2=arr[Compear(ob)];
    for (int i = Compear(ob); i <rear ; i++) {
        arr[i]=arr[i+1];
        priority[i]=priority[i+1];
    }
    rear--;
      return ob2;

}


//دالة لعرض جميع العناصر في الطابور
public void displayAllItems(){
    for (int i = 0; i <=rear; i++) {
        System.out.println("arr[i]: "+arr[i]);

    }
}

public T displayTheFirstItem(){
        return arr[front];
}


//مقارنة العناصر
    public int Compear(T item) {
        for (int i = 0; i <= rear; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;
    }
    //إرجاع عدد العناصر في الطابور
public int getSize(){return rear+1;}
}
