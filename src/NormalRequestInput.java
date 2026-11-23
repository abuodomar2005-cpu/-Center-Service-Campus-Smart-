import java.util.Scanner;

public class NormalRequestInput implements RequestInput {
    private int size;
    private int[]arr=new int[1000];
    @Override
    public ServiceRequest inputRequest(Scanner input, boolean enterPriority) {

        System.out.println("Enter request id:");
        int id = input.nextInt();
        input.nextLine();
        if(searchByID(id)){
        do{
            System.out.println("The id already exists.");
            System.out.println("Enter request id again:");
            id = input.nextInt();
            input.nextLine();
            while(id<0){
                System.out.println("The id can't be negative. ");
                System.out.println("Enter request id again:");
                id = input.nextInt();
                input.nextLine();
            }
        }while (searchByID(id));}
        arr[size]=id;
        size++;


        System.out.println("Enter student name:");
        String name = input.nextLine();

        System.out.println("Enter service type:");
        String serviceType = input.nextLine();

        int priority = 1;

        if (enterPriority) {
            System.out.println("Enter priority:");
            priority = input.nextInt();
            input.nextLine();
        }

        System.out.println("Enter description:");
        String description = input.nextLine();

        return new ServiceRequest(id, name, serviceType, priority, description);
    }
    public boolean searchByID(int id){
        if(id<0){
            return false;
        }
        for (int i=0;i<size;i++){
            if(id==this.arr[i]){
                return true;
            }

        }
        return false;
    }
}
