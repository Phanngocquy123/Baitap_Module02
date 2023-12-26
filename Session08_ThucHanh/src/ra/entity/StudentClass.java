package ra.entity;

import ra.run.StudentManagement;

import java.util.Scanner;

public class StudentClass implements IStudentManagement {
    private String classId;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        inputClassId(sc);
        inputClassName(sc);
        inputDescriptions(sc);
        inputClassStatus(sc);
    }

    // các phương thức của input data
    public void inputClassId(Scanner sc) {
        System.out.print("Nhập vào mã lớp: ");
        boolean check = false;
        String classIdCheck;
        do {
            classIdCheck = sc.nextLine();
            if (classIdCheck.length() == 5 && classIdCheck.charAt(0) == 'J') {
                check = true;
                break;
            } else {
                System.err.println("Nhập String bao gồm 5 ký tự, bắt đầu là ký tự 'J'");
            }
        } while (true);
        if (StudentManagement.studentClassList.size() == 0) {
            this.classId = classIdCheck;
        } else {
            if (check && StudentManagement.checkExistId(classIdCheck) != -1) {
                System.out.println("-->Id thêm bị trùng");
                inputClassId(sc);
            } else {
                this.classId = classIdCheck;
            }
        }
    }

    public void inputClassName(Scanner sc) {
        System.out.print("Nhập vào tên lớp: ");
        do {
            this.className = sc.nextLine();
            if (this.className.length() < 11) {
                break;
            } else {
                System.err.print("Nhập String tối đa 10 ký tự: ");
            }
        } while (true);
    }

    public void inputDescriptions(Scanner sc) {
        System.out.print("Nhập mô tả lớp: ");
        this.descriptions = sc.nextLine();
    }

    public void inputClassStatus(Scanner sc) {
        System.out.println("Chọn trạng thái lớp: 0-Chờ lớp || 1-Hoạt động || 2-Tạm dừng || 3-Kết thúc ");
        this.classStatus = Integer.parseInt(sc.nextLine());
    }



    @Override
    public void displayData() {
        String classStatus = "";
        switch (this.classStatus) {
            case 0:
                classStatus = "Chờ lớp";
                break;
            case 1:
                classStatus = "Hoạt động";
                break;
            case 2:
                classStatus = "Tạm dừng";
                break;
            case 3:
                classStatus = "Kết thúc";
                break;
            default:
        }
        System.out.printf("Mã lớp: %s || Tên lớp: %-12s || Mô tả lớp: %-10s || Trạng thái lớp: %s\n",
                this.classId, this.className, this.descriptions, classStatus);
    }
}
