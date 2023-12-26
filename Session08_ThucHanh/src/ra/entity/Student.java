package ra.entity;

import ra.run.StudentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String classId;
    private List<Float> listMarkJavascript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new ArrayList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private Float avgMark;
    private String gpa;
    private boolean studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, String classId, List<Float> listMarkJavascript, List<Float> listMarkJavaCore, List<Float> listMarkJavaWeb, Float avgMark, String gpa, boolean studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.classId = classId;
        this.listMarkJavascript = listMarkJavascript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public List<Float> getListMarkJavascript() {
        return listMarkJavascript;
    }

    public void setListMarkJavascript(List<Float> listMarkJavascript) {
        this.listMarkJavascript = listMarkJavascript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public Float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(Float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    // triển khai phương thức trừu tượng
    @Override
    public void inputData(Scanner sc) {

        inputStudentId(sc);
        inputStudentName(sc);
        inputStudentAge(sc);
        inputStudentSex(sc);
        inputStudentClassType(sc);
        inputMark("Java Core", sc);
        inputMark("Java Scrip", sc);
        inputMark("Java Web", sc);
        inputSudentStatus(sc);
    }

    // các phương thức cho input data
    public void inputStudentId(Scanner sc) {
        System.out.print("Nhập mã sinh viên: ");
        String idInput;
        boolean checkId = false;
        do {
            idInput = sc.nextLine();
            if (idInput.length() == 6 && idInput.charAt(0) == 'S') {
                checkId = true;
                break;
            } else {
                System.err.println("Nhập mã sinh viên có 6 ký tự, bắt đầu là ký tự 'S'");
            }
        } while (true);
        if (StudentManagement.studentList.size() == 0) {
            this.studentId = idInput;
        } else {
            if (checkId && StudentManagement.checkStudentIdExist(idInput) != -1) {
                System.out.println("---> Thêm mã sinh viên bị trùng");
                inputStudentId(sc);
            } else {
                this.studentId = idInput;
            }
        }
    }

    public void inputStudentName(Scanner sc) {
        System.out.print("Nhập tên sinh viên: ");
        do {
            this.studentName = sc.nextLine();
            if (20 <= this.studentName.length() && this.studentName.length() <= 50) {
                break;
            } else {
                System.err.println("Nhập tên sinh viên từ 20-50 ký tự");
            }
        } while (true);
    }

    public void inputStudentAge(Scanner sc) {
        System.out.print("Nhập tuổi: ");
        do {
            this.age = Integer.parseInt(sc.nextLine());
            if (this.age >= 18) {
                break;
            } else {
                System.err.println("Nhập tuổi >= 18");
            }
        } while (true);
    }

    public void inputStudentSex(Scanner sc) {
        System.out.println("Nhập giới tính true/false: ");
        this.sex = Boolean.parseBoolean(sc.nextLine());
    }

    public void inputStudentClassType(Scanner sc) {
        System.out.println("Danh sách các loại lớp:");
        int classTypeTotal = StudentManagement.studentClassList.size();
        for (int i = 0; i < classTypeTotal; i++) {
            System.out.printf("STT: %d || ClassId: %s || Class Name: %s\n",
                    i + 1,
                    StudentManagement.studentClassList.get(i).getClassId(),
                    StudentManagement.studentClassList.get(i).getClassName());
        }
        do {
            System.out.print("Chọn STT: ");
            int indexChoice = Integer.parseInt(sc.nextLine());
            if (indexChoice >= 1 && indexChoice <= classTypeTotal) {
                this.classId = StudentManagement.studentClassList.get(indexChoice - 1).getClassId();
                break;
            } else {
                System.err.printf("Nhập lựa chọn từ 1 -> %d\n", classTypeTotal);
            }
        } while (true);
    }

    public void inputMark(String markName, Scanner sc) {
        System.out.printf("Nhập vào điểm %s: ", markName);
        int count = 1;
        do {
            System.out.printf("\nNhập điểm %s lần thứ %d :", markName, count);
            switch (markName) {
                case "Java Core":
                    this.listMarkJavaCore.add(Float.parseFloat(sc.nextLine()));
                    break;
                case "Java Scrip":
                    this.listMarkJavascript.add(Float.parseFloat(sc.nextLine()));
                    break;
                case "Java Web":
                    this.listMarkJavaWeb.add(Float.parseFloat(sc.nextLine()));
                    break;
            }
            System.out.print("\nBạn có muốn nhập tiếp không, Y - có, N - không: ");
            char choice = sc.nextLine().charAt(0);
            if (choice == 'N') {
                break;
            }
            count++;
        } while (true);
    }

    public void inputSudentStatus(Scanner sc){
        System.out.println("Nhập trạng thái Sinh viên true/ false:");
        this.studentStatus = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("--------------> Mã SV: %s || Tên SV: %s || Tuổi: %d || Giới tính: %s \n",
                this.studentId, this.studentName, this.age, this.sex ? "Nam" : "Nữ");
        System.out.printf("Lớp SV đang học - ClassId: %s \n", this.classId);
        System.out.printf("Điểm Java Core: %f || Điểm Java Scrip: %f || Điểm Java Core: %f || Điểm TB: %f \n",
                this.listMarkJavaCore.get(this.listMarkJavaCore.size() - 1),
                this.listMarkJavascript.get(this.listMarkJavascript.size() - 1),
                this.listMarkJavaWeb.get(this.listMarkJavaWeb.size() - 1),
                this.avgMark);
        System.out.printf("Xếp loại: %s || Trạng thái: %s \n", this.gpa, this.studentStatus ? "Đang học" : "Nghỉ học");
    }

    public void avgMarkCalculate() {
        this.avgMark = (this.listMarkJavaCore.get(this.listMarkJavaCore.size() - 1) +
                this.listMarkJavascript.get(this.listMarkJavascript.size() - 1) +
                this.listMarkJavaWeb.get(this.listMarkJavaWeb.size() - 1)) / 3;
    }

    public void getGpaByAvgMark() {
        if (this.avgMark < 5) {
            this.gpa = "Yếu";
        } else if (this.avgMark >= 5 && this.avgMark < 7) {
            this.gpa = "Trung bình";
        } else if (this.avgMark >= 7 && this.avgMark < 9) {
            this.gpa = "Khá";
        } else {
            this.gpa = "Giỏi";
        }
    }
}
