package TestJava2;

public class Student {
    private String studentID;
    private String name;
    private String address;
    private String phoneNumber;

    public Student(String studentID, String name, String address, String phoneNumber) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public  static Student createStudent(String studentID,String name,String address,String phoneNumber){
        return new Student(studentID,name,address,phoneNumber);
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
