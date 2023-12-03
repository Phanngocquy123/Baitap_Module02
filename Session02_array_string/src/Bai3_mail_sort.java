import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Bai3_mail_sort {
    public static void main(String[] args) {
        int emailTotal;
        emailTotal = 10;
        String mailValue;
        Scanner input = new Scanner(System.in);
        System.out.println("\n Hãy nhập email của 10 người:");
        String[] emailArr = new String[emailTotal];

        Pattern validEmail = Pattern.compile("^[\\w.]+@[\\w.-]+\\.[a-z]{2,5}$");
        for (int i = 0; i < emailTotal; i++){
            do {
                System.out.println("Người thứ " +(i+1)+ ":");
                mailValue = input.nextLine();
            } while (!validEmail.matcher(mailValue).matches());
            emailArr[i] = mailValue;
        }

        String temporary;
        for (int i = 0; i < emailTotal; i++){
            for (int j = i+1; j < emailTotal; j++){
                if (emailArr[i].compareTo(emailArr[j])>0){
                    temporary = emailArr[i];
                    emailArr[i] = emailArr[j];
                    emailArr[j] = temporary;
                }
            }
        }
        System.out.println("+----------------------+");
        System.out.println("|   Danh sách email    |");
        System.out.println("+----------------------+");
        for (String item : emailArr){
            System.out.printf("|%-22s|",item);
            System.out.println("\n");
        }
        System.out.println("+----------------------+");
    }
}
// Viết chương trình java, nhập vào danh sách email của 10 bạn trong lớp.
//         * Có kiểm tra định dạng email.
//         * Hiển thị email của các bạn trong lớp theo thứ tự A-Z, định dạng bảng giống như sau:
//         *  +----------------------+
//         *  |   Danh sách email    |
//         *  +----------------------+
//         *  | trunghv@gmail.com    |
//         *  | trunghv.lsd@gmail.com|
//         *  | trung.abc@gmail.com  |
//         *  | trunghv@gmail.com    |
//         *  +----------------------+
//         */