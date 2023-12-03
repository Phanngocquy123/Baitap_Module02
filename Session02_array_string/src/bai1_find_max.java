import java.util.Scanner;

public class bai1_find_max {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total;
        do {
            System.out.println("nhập vào số phần tử của danh sách:");
            total = input.nextInt();
        }while (total>20);
        int[] numbers;
        numbers = new int[total];
        for (int i=0;i<numbers.length;i++){
            System.out.println("Số thứ " + (i + 1) + ":");
            numbers[i]=input.nextInt();
        }
        int max = numbers[0];
        int index = 1;
        for (int j=0;j<numbers.length;j++){
            if (numbers[j]>max){
                max = numbers[j];
                index = j+1;
            }
        }
        System.out.printf("\n Số lớn nhất: %d , vị trí thứ: %d",max,index);
    }
}