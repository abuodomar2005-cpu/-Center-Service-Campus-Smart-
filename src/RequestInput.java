import java.util.Scanner;

public interface RequestInput {
    ServiceRequest inputRequest(Scanner input, boolean enterPriority);
}