import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        int total = 0;
        Product[] products = null;
        boolean calculateDone = false;
        do {
            System.out.println(" 1- Nhập tổng số sản phẩm\n 2- Tính giá bán\n 3- Hiển thị danh sách sản phẩm (giá tăng dần)\n 4- Thoát");
            System.out.print("Chọn chúc năng: ");
            number = Integer.parseInt(sc.nextLine());

            switch (number){
                case 1:
                    System.out.print("Nhập số lượng sản phẩm: ");
                    total = Integer.parseInt(sc.nextLine());

                    products = new Product[total];
                    for (int i = 0; i < total; i++){
                        Product pro = new Product();
                        System.out.print("Nhập id: ");
                        pro.setId(sc.nextLine());
                        System.out.print("Nhập tên: ");
                        pro.setName(sc.nextLine());
                        System.out.print("Nhập giá: ");
                        pro.setPrice(Double.parseDouble(sc.nextLine()));
                        System.out.print("Nhập giảm giá (%): ");
                        pro.setDiscount(Double.parseDouble(sc.nextLine()));
                        products[i] = pro;
                        System.out.println("----------");
                    }
                    break;
                case 2:
                    if (total != 0){
                        for (Product salePrice : products){
                            salePrice.calculateSalePrice();
                        }
                        System.out.println("Đã tính xong giá");
                        calculateDone = true;
                    } else {
                        System.out.println("Chưa có sản phảm nào, chọn 1 để nhập số sản phẩm");
                    }
                    break;
                case 3:
                    if (total !=0 && calculateDone){
                        for (int i = 0; i < total; i++){
                            for (int j = i + 1; j < total; j++){
                                if (Double.compare(products[j].getSalePrice(),products[i].getSalePrice())<0){
                                    Product temp = products[i];
                                    products[i] = products[j];
                                    products[j] = temp;
                                }
                            }
                        }
                        for (int i = 0; i < products.length; i++){
                            System.out.println("Id: " + products[i].getId());
                            System.out.println("SalePrice: " + products[i].getSalePrice());
                            System.out.println("_____");
                        }
                    } else if (!calculateDone && total !=0){
                        System.out.println("Chưa tính giá, chọn 2 để tính giá");
                    } else {
                        System.out.println("Chưa có sản phảm nào, chọn 1 để nhập số sản phẩm");
                    }
                    break;
                case 4:
                    System.out.println("Thoát");
                    break;
                default:

            }
        }while (number != 4);
    }
}
