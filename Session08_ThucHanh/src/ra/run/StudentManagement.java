package ra.run;

import ra.entity.IStudentManagement;
import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

public class StudentManagement {
    public static List<StudentClass> studentClassList = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //StudentClass studentClass = new StudentClass();
        //Student student = new Student();
        //studentClass.inputData(sc);
        //studentClass.displayData();
        //student.inputData(sc);
        do {
            System.out.println("-------------QUẢN LÝ HỌC VIỆN----------");
            System.out.println("1- Quản lý lớp");
            System.out.println("2- Quản lý sinh viên");
            System.out.println("3- Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    showMenuClass(sc);
                    break;
                case 2:
                    showMenuStudent(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Nhập lựa chọn từ 1-3");
            }
        } while (true);


    }

    public static void showMenuClass(Scanner sc) {
        boolean isExist = true;
        do {
            System.out.println("1- Thêm mới lớp học");
            System.out.println("2- Cập nhập thông tin lớp học");
            System.out.println("3- Hiển thị thông tin lớp học");
            System.out.println("4- Thống kê các lớp học đang hoạt động");
            System.out.println("5- Tìm kiếm lớp học theo tên lớp");
            System.out.println("6- Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.inputStudentClassList(sc);
                    break;
                case 2:
                    StudentManagement.updateStudentClass(sc);
                    break;
                case 3:
                    StudentManagement.showStudentClassList();
                    break;
                case 4:
                    StudentManagement.statisticsOfActiveClass();
                    break;
                case 5:
                    StudentManagement.findByClassName(sc);
                    break;
                case 6:
                    isExist = false;
                    break;
            }
        } while (isExist);
    }


    public static void inputStudentClassList(Scanner sc) {
        System.out.print("Số lượng lớp học muốn nhập: ");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.printf("Lớp học thứ %d: \n", i + 1);
            StudentClass studentClass = new StudentClass();
            studentClass.inputData(sc);
            studentClassList.add(studentClass);
        }
        System.out.println("--> Thêm lớp học thành công");
    }

    public static void showStudentClassList() {
        studentClassList.forEach(x -> x.displayData());
    }

    public static void updateStudentClass(Scanner sc) {
        System.out.print("Nhập Id lớp học muốn cập nhập: ");
        String updateIdInput = sc.nextLine();
        int index = checkExistId(updateIdInput);
        if (index == -1) {
            System.out.println("Không tồn tại Id bạn muốn tìm");
            return;
        }
        studentClassList.get(index).inputClassName(sc);
        studentClassList.get(index).inputDescriptions(sc);
        studentClassList.get(index).inputClassStatus(sc);
        System.out.printf("--> Cập nhập lớp học %s thành công", updateIdInput);
    }

    public static int checkExistId(String id) {
        for (int i = 0; i < studentClassList.size(); i++) {
            if (studentClassList.get(i).getClassId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void statisticsOfActiveClass() {
        int count = 0;
        for (StudentClass activeClass : studentClassList) {
            if (activeClass.getClassStatus() == 1) {
                count++;
            }
        }
        System.out.printf("Có %d lớp đang hoạt động\n", count);
    }

    public static void findByClassName(Scanner sc) {
        int countFound = 0;
        System.out.print("Nhập vào tên lớp muốn tìm: ");
        String classNameInput = sc.nextLine();
        for (StudentClass name : studentClassList) {
            if (name.getClassName().toLowerCase().contains(classNameInput.toLowerCase())) {
                name.displayData();
                countFound++;
            }
        }
        if (countFound == 0) {
            System.out.println("Không tìm thấy têm lớp");
        }
    }

    ////////////////////////////////////////////////
    public static void showMenuStudent(Scanner sc) {

        boolean isExist = true;
        do {
            System.out.println("1- Thêm mới sinh viên");
            System.out.println("2- Cập nhật thông tin sinh viên");
            System.out.println("3- Hiển thị thông tin sinh viên");
            System.out.println("4- Tính điểm trung bình");
            System.out.println("5- Xếp loại sinh viên");
            System.out.println("6- Sắp xếp sinh viên theo điểm tăng dần");
            System.out.println("7- Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8- Thống kê sinh viên đạt loại giỏi, khá, trung bình, yếu");
            System.out.println("9- Thống kê sinh viên Pass các môn học");
            System.out.println("10- Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.inputStudent(sc);
                    break;
                case 2:
                    StudentManagement.updateStudent(sc);
                    break;
                case 3:
                    StudentManagement.showStudent();
                    break;
                case 4:
                    StudentManagement.avgMarkCal();
                    break;
                case 5:
                    StudentManagement.getGPACal();
                    break;
                case 6:
                    StudentManagement.sortStudentByMark();
                    StudentManagement.showStudent();
                    break;
                case 7:
                    StudentManagement.findStudentByName(sc);
                    break;
                case 8:
                    StudentManagement.statisticByGetGpa();
                    break;
                case 9:
                    StudentManagement.statisticStudentPass();
                    break;
                case 10:
                    isExist = false;
                    break;
            }
        } while (isExist);
    }

    public static void inputStudent(Scanner sc) {
        System.out.print("Nhập số lượng học sinh muốn nhập: ");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.printf("Học sinh thứ %d: \n", i + 1);
            Student student = new Student();
            student.inputData(sc);
            studentList.add(student);
        }
    }

    public static void updateStudent(Scanner sc) {
        System.out.print("Nhập mã sinh viên muốn cập nhật: ");
        String studentIdInput = sc.nextLine();
        int index = checkStudentIdExist(studentIdInput);
        if (index == -1){
            System.out.println("-->Không tồn tại mã SV bạn muốn tìm");
            return;
        }
        studentList.get(index).inputStudentName(sc);
        studentList.get(index).inputStudentAge(sc);
        studentList.get(index).inputStudentSex(sc);
        studentList.get(index).inputStudentClassType(sc);
        studentList.get(index).inputMark("Java Core",sc);
        studentList.get(index).inputMark("Java Scrip",sc);
        studentList.get(index).inputMark("Java Web",sc);
        studentList.get(index).inputSudentStatus(sc);
        avgMarkCal();
        getGPACal();
        System.out.println("--> Cập nhập thông tin thành công");
    }

    public static int checkStudentIdExist(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public static void showStudent() {
        studentList.forEach(x -> x.displayData());
    }

    public static void avgMarkCal() {
        studentList.forEach(x -> x.avgMarkCalculate());
    }

    public static void getGPACal() {
        studentList.forEach(x -> x.getGpaByAvgMark());
    }

    public static void sortStudentByMark() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.getAvgMark() > t1.getAvgMark()) {
                    return 1;
                } else if (student.getAvgMark() == t1.getAvgMark()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    public static void findStudentByName(Scanner sc) {
        System.out.print("Nhập tên sinh viên muốn tìm: ");
        String nameInput = sc.nextLine();
        int count = 0;
        for (Student student : studentList) {
            if (student.getStudentName().toLowerCase().contains(nameInput.toLowerCase())) {
                student.displayData();
                count++;
            }
        }
        System.out.printf("Có %d kết quả được tìm thấy theo tên %s", count, nameInput);
    }

    public static void statisticByGetGpa() {
        int countVeryGood = 0;
        int countGood = 0;
        int countAverage = 0;
        int countWeak = 0;
        for (Student student : studentList) {
            switch (student.getGpa()) {
                case "Giỏi":
                    countVeryGood++;
                    break;
                case "Khá":
                    countGood++;
                    break;
                case "Trung bình":
                    countAverage++;
                    break;
                case "Yếu":
                    countWeak++;
                    break;
            }
        }
        System.out.printf("Thống kê xếp loại: <Giỏi - %d>  <Khá - %d>  <Trung bình - %d>  <Yếu - %d>\n",
                countVeryGood, countGood, countAverage, countWeak);
    }

    public static void statisticStudentPass() {
        int count = 0;
        for (Student student : studentList) {
            if (student.getAvgMark() >= IStudentManagement.MARK_PASS) {
                count++;
            }
        }
        System.out.printf("Có %d học sinh vượt qua môn học\n", count);
    }

}
