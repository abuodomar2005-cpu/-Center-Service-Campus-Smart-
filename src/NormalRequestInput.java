
import java.util.Scanner;

    public class NormalRequestInput implements RequestInput {

        private int size;
        private final int[] arr = new int[1000];
        private int id;

        @Override
        public ServiceRequest inputRequest(Scanner input, boolean enterPriority) {
            //التحقق من الid
            while (true) {
                System.out.println("Enter request id:");
                id = input.nextInt();
                input.nextLine();

                if (id <= 0) {
                    System.out.println("The ID must be positive.");
                } else if (searchByID(id)) {
                    System.out.println("The ID already exists.");
                } else {
                    break;
                }
            }

            // التحقق من سعة المصفوفة
            if (size >= arr.length) {
                System.out.println("The ID storage is full.");
                return null;
            }

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

            // Store ID after completing input
            arr[size] = id;
            size++;

            return new ServiceRequest(
                    id, name, serviceType, priority, description
            );
        }
//دالة للبحث عن الid
        public boolean searchByID(int id) {

            if (id <= 0) {
                return false;
            }

            for (int i = 0; i < size; i++) {
                if (id == arr[i]) {
                    return true;
                }
            }

            return false;
        }
//دالة لحذف الآي دي عند المعالجة بالأخص
        @Override
        public void setID(int id) {

            for (int i = 0; i < size; i++) {

                if (arr[i] == id) {

                    for (int j = i; j < size - 1; j++) {
                        arr[j] = arr[j + 1];
                    }

                    size--;
                    return;
                }
            }
        }
//دالة إرجاع الآي دي
        @Override
        public int getID() {
            return id;
        }
    }


