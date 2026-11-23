public class ServiceRequest {

    private int requestID;
    private String studentName;
    private String serviceType;
    private int priority;
    private String description;

    // Constructor
    public ServiceRequest(int requestID, String studentName,String serviceType,
                          int priority,String description) {

        this.requestID = requestID;
        this.studentName = studentName;
        this.serviceType = serviceType;
        this.priority = priority;
        this.description = description;
    }
    public ServiceRequest(int requestID, String studentName,String serviceType
                          ,String description) {

        this.requestID = requestID;
        this.studentName = studentName;
        this.serviceType = serviceType;
        this.description = description;
    }

    // Getters
    public int getRequestID() {
        return requestID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Display request information
    @Override
    public String toString() {
        return "Request ID: " + requestID +
                "\nStudent Name: " + studentName +
                "\nService Type: " + serviceType +
                "\nPriority: " + priority +
                "\nDescription: " + description;
    }
}
