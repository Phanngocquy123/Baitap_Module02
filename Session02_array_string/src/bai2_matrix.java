import java.util.Scanner;

public class bai2_matrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập kích thước ma trận vuông:");
        int a = input.nextInt();
        int[][] arr = new int[a][a];

        for (int i=0;i<a;i++){
            for (int j=0;j<a;j++){
                System.out.printf("\narr[%d,%d]:",i,j);
                arr[i][j] = input.nextInt();
            }
        }
        System.out.println("Ma trận đã nhập:");
        for (int i=0;i<a;i++){
            for (int j=0;j<a;j++){
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println("\n");
        }
        int sum=0;
        for (int i=0;i<a;i++){
            for (int j=0;j<a;j++){
                if (i==j){
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Tổng đường chéo chính:"+sum);
    }
}
