public class Stack<T> {
    private int capacity;
    private T[] arr;
    private int top;


    public Stack(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        this.top = -1;


    }

    //التحقق من فراغ القائمة
    public boolean isEmpty() {
        return top == -1;
    }

    //التحقق من امتلاء القائمة
    public boolean isFull() {
        return top == capacity - 1;
    }

    //إضافة عنصر جديد للقائمة
    public void push(T item) {
        if (isFull()) {
            System.out.println("There is no empty space to add.");
            return;
        }

        top++;
        arr[top] = item;

    }

    //حذف عنصر من القائمة
    public T pop() {
        if (isEmpty()) {
            System.out.println("There are no items to remove.");
            return null;
        }
        T localO=arr[top];
        arr[top] = null;
        top--;
        return (T)localO;
    }

    //إرجاع آخر عنصر دون حذفه
    public T peek() {
        if (isEmpty()) {
            System.out.println("There are no items");
            return null;
        }
        return arr[top];
    }

}