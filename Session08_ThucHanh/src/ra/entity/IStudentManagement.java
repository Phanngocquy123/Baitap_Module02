package ra.entity;

import java.util.Scanner;

public interface IStudentManagement {
    float MARK_PASS = 5F;    // static final float MARK_PASS = 5F; mặc định static final là hằng số
    void inputData(Scanner sc);
    void displayData();
}
