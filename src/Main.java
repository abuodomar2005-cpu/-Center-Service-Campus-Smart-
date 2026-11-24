

void main(String[] args) {

    Scanner input=new Scanner(System.in);



    SimpleQueue<ServiceRequest>requestSimpleQueue=new SimpleQueue<>(500);
    PriorityQueue<ServiceRequest>requestPriorityQueue=new PriorityQueue<>(500);
    RequestInput requestInput = new NormalRequestInput();
    Deque<ServiceRequest>requestDeque=new Deque<>();
    Stack<ServiceRequest>requestStack=new Stack<>(100);
    String lastOperation = "No operation has been performed yet.";

    //متغير الx لأجل الخروج من الحلقة
    int x = 1;
    //متغير الnum لأجل الswitch في حالة التراجع
    int num = -1;

    //العدادات الأربعة لأجل إحصاء عمليات المعالجة والتراجع
    int count=0;
    int count2=0;
    int count3=0;
    int count4=0;


    int pr=0;

    do {
        int choice;
        try {

        System.out.println("""
        ======= CAMPUS SERVICE CENTER =======
        1. Add New Normal Request
        2. Process Normal Request
        3. Display Normal Requests
        4. Add Priority Request
        5. Process Priority Request
        6. Manage Deque
        7. Undo Last Operation
        8. Display Last Operation
        9. Display System Statistics
        0. Exit
        ===================================
        """);
            choice =input.nextInt();

            switch (choice) {



                case 1:
                    ServiceRequest request = requestInput.inputRequest(input,false);
                    requestSimpleQueue.enqueue(request);
                    requestStack.push(request);
                    num=1;
                    lastOperation = "Normal Request Added";
                    break;

                case 2:
                    ServiceRequest request2 = requestSimpleQueue.dequeue();

                    if (request2 != null) {
                        System.out.println("Processing successfully.");
                        System.out.println(request2);
                        requestStack.push(request2);
                        num=2;
                        count++;
                    }
                    lastOperation="Normal Request Processed";


                    break;

                case 3:
                   requestSimpleQueue.displayAllItems();
                   lastOperation="Normal Requests Displayed";
                    break;

                case 4:
                  ServiceRequest request3=requestInput.inputRequest(input,true);
                    requestPriorityQueue.enqueue(request3,request3.getPriority());
                    requestStack.push(request3);
                    num=3;
                    lastOperation="Priority Request Added";
                    break;

                case 5:
                    ServiceRequest request4=requestPriorityQueue.dequeue();
                    if (request4 != null) {
                        System.out.println("Processing successfully.");
                        System.out.println(request4);
                        requestStack.push(request4);
                        num=4;
                        lastOperation=	"Priority Request Processed";
                        count2++;
                        pr= request4.getPriority();

                    }

                    break;

                case 6:
                    int x2=1;


                        do{
                            try {
                                int choice2;
                        System.out.println("""
                                ======= MANAGE DEQUE =======
                                1. Add At The Beginning
                                2. Add At The End
                                3. Process From The Beginning
                                4. Process From The Last
                                5. Display All Requests
                                6. Show First Request
                                7. Show Last Request
                                0. Exit
                                ===================================
                                """);
                            choice2 =input.nextInt();
                          switch (choice2){

                              case 1:
                                  ServiceRequest request5 = requestInput.inputRequest(input,false);
                               requestDeque.addFirst(request5);
                                  num=5;
                                  lastOperation="Request Added to Deque Front";

                              break;

                              case 2:
                                  ServiceRequest request6 = requestInput.inputRequest(input,false);
                                  requestDeque.addLast(request6);
                             num=6;
                             lastOperation="Request Added to Deque Rear";
                              break;

                              case 3:
                                  ServiceRequest request7 = requestDeque.removeFirst();
                                  requestStack.push(request7);
                                  num=7;
                                 lastOperation= "Request Removed from Deque Front";
                                 count3++;

                              break;

                              case 4:
                                  ServiceRequest request8 =  requestDeque.removeLast();
                                  requestStack.push(request8);
                                  num=8;
                                 lastOperation= "Request Removed from Deque Rear";
                                  count3++;

                              break;

                              case 5:
                                  requestDeque.displayQueue();
                                  lastOperation = "Deque Requests Displayed";
                              break;


                              case 6:

                                  System.out.println(requestDeque.peekFirst());
                                  lastOperation = "Deque Front Request Viewed";
                              break;

                              case 7:
                                  System.out.println(requestDeque.peekEnd());
                                  lastOperation = "Deque Rear Request Viewed";
                              break;


                              case 0:
                                  System.out.println("Exiting the system...");
                              x2=0;
                              break;

                              default:
                                  System.out.println("Invalid choice. Try again.");
                          }
                            }catch (Exception e) {

                                System.out.println("An error occurred: " + e.getMessage());
                               input.nextLine();
                            }
                        } while (x2 != 0);

                    break;

                case 7:
                    if (requestStack.isEmpty()) {
                        System.out.println("There is no operation to undo.");
                        break;
                    }

                 count4++;
                    switch (num) {

                        case 1:
                            requestSimpleQueue.removLast();
                            lastOperation = "Undo: Normal Request Addition";

                            break;

                        case 2:
                            requestSimpleQueue.addFirst(requestStack.pop());
                            lastOperation = "Undo: Normal Request Processing";
                            break;

                        case 3:
                            requestPriorityQueue.removeBySearch(requestStack.pop());
                            lastOperation = "Undo: Priority Request Addition";
                            break;

                        case 4:
                            requestPriorityQueue.undoDequeue(requestStack.pop(),pr);
                            lastOperation = "Undo: Priority Request Processing";
                            break;

                        case 5:
                            requestDeque.removeFirst();
                            lastOperation = "Undo: Deque Add First";
                            break;

                        case 6:
                            requestDeque.removeLast();
                            lastOperation = "Undo: Deque Add Last";
                            break;

                        case 7:
                            requestDeque.addFirst(requestStack.pop());
                            lastOperation = "Undo: Deque Remove First";
                            break;

                        case 8:
                            requestDeque.addLast(requestStack.pop());
                            lastOperation = "Undo: Deque Remove Last";
                            break;
                    }

                    System.out.println("Undo completed successfully.");
                    break;

                case 8:
                    System.out.println(lastOperation);
                    break;

                case 9:
                    System.out.println("Normal Requests: "+requestSimpleQueue.getSize());
                    System.out.println("Priority Requests: "+requestPriorityQueue.getSize());
                    System.out.println("Deque Requests: "+requestDeque.getSize());

                    int total=requestSimpleQueue.getSize()+requestPriorityQueue.getSize()+requestDeque.getSize();
                    System.out.println("Total Pending Requests: "+total);

                    System.out.println("Normal Requests Processed: " + count);
                    System.out.println("Priority Requests Processed: " + count2);
                    System.out.println("Deque Requests Processed: " + count3);

                    int totalProcessed=count+count2+count3;
                    System.out.println("Total Requests Processed: " + totalProcessed);

                    System.out.println("Total Undo Operations: " + count4);

                    break;

                case 0:
                    System.out.println("Exiting the system...");
                    x=0;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
            
        System.out.println();
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            input.nextLine();

        }
    } while (x!= 0);

}


