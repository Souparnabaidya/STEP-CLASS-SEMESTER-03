class collegeInfo {

    String name;
    double attendance;

    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    Student(String name, double attendance) {

        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    static void printCollegeInfo() {

        System.out.println(collegeName);
        System.out.println(
                "Students created: " + studentCount);
    }

    public static void main(String[] args) {

        Student s1 =
                new Student("Souparna", 90);

        Student s2 =
                new Student("Rahul", 85);

        System.out.println("2 Student objects created");

        Student.printCollegeInfo();
    }
}
