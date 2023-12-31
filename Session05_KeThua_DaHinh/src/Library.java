import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AuthorClass authorClass = new AuthorClass();
        BookClass bookClass = new BookClass();
        int chooseLibrary;
        int chooseAuthor;
        int chooseBook;

    showLibrary();
    do {
        System.out.print("Chọn chức năng LIBRARY LIST (NUMBER): ");
        chooseLibrary = Integer.parseInt(sc.nextLine());
        switch (chooseLibrary){
            case 1:                                                                // AUTHOR
                System.out.println("");
                showAuthor();
                do {
                    System.out.print("Chọn chức năng AUTHORS (NUMBER): ");
                    chooseAuthor = Integer.parseInt(sc.nextLine());
                    switch (chooseAuthor){
                        case 1:                                                    // THÊM
                            Author authorObj = new Author();

                            System.out.println("------Thêm tác giả------");
                            System.out.print("Nhập Id: ");
                            authorObj.setId(sc.nextLine());
                            System.out.print("Nhập Tên: ");
                            authorObj.setName(sc.nextLine());
                            System.out.print("Nhập Email: ");
                            authorObj.setEmail(sc.nextLine());
                            System.out.print("Nhập Giới tính: ");
                            authorObj.setGender(sc.nextLine());
                            System.out.print("Nhập Tuổi: ");
                            authorObj.setAge(Integer.parseInt(sc.nextLine()));

                            authorClass.add(authorObj);
                            break;
                        case 2:
                            authorClass.show();                                      // HIỂN THỊ
                            break;
                        case 3:
                            System.out.print("Nhập Id tác giả muốn cập nhập: ");     // UPDATE
                            String idEdit = sc.nextLine();
                            authorClass.edit(idEdit);
                            break;
                        case 4:
                            System.out.print("Nhập tác giả muốn xóa (NAME): ");       // REMOVE tác giả
                            String removeAuthor = sc.nextLine();
                            if (!bookClass.existBookWithAuthor(removeAuthor)){
                                authorClass.remove(removeAuthor);
                            } else {
                                System.out.println("---> Tác giả đã có sách, không xóa được");
                            }
                            break;
                        default:
                            break;
                    }
                } while (chooseAuthor != 5);
                break;
            case 2:                                                                   // BOOK
                if (authorClass.checkAuthorsLength()){
                    System.out.println("Chưa có tác giả trong thư viện, vui lòng thêm tác giả");
                    break;
                }
                showBook();
                do {
                    System.out.print("Chọn chức năng BOOK (NUMBER): ");
                    chooseBook = Integer.parseInt(sc.nextLine());
                    switch (chooseBook){
                        case 1:                                                       // THÊM
                            System.out.println("------ Thêm sách ------");
                            Book bookObj = new Book();
                            System.out.print("Nhập Id sách: ");
                            bookObj.setId(sc.nextLine());
                            System.out.print("Nhập tiêu đề sách: ");
                            bookObj.setTitle(sc.nextLine());
                            System.out.print("Nhập giá sách: ");
                            bookObj.setPrice(Double.parseDouble(sc.nextLine()));

                            authorClass.show();
                            System.out.print("Chọn tác giả muốn thêm (index): ");
                            int indexAuthor = Integer.parseInt(sc.nextLine());
                            // CHỌN VỊ TRÍ INDEX tác giả TRONG LIST AUTHORS
                            bookObj.setAuthor(authorClass.chooseAuthor(indexAuthor));
                            bookClass.add(bookObj);
                            break;
                        case 2:                                                         // SHOW
                            bookClass.show();
                            break;
                        case 3:                                                         // SEARCH TITLE
                            System.out.print("Nhập Title tìm kiếm: ");
                            String titleInput = sc.nextLine();
                            bookClass.findTitle(titleInput);
                            break;
                        case 4:                                                         // SEARCH NAME
                            System.out.print("Nhập tên tác giả muốn tìm: ");
                            String findAuthor = sc.nextLine();
                            bookClass.findAuthor(findAuthor);
                            break;
                        case 5:
                            System.out.print("Nhập id sách muốn cập nhật: ");            // UPDATE
                            String idAuthorUpdate = sc.nextLine();
                            if (bookClass.updateCheckId(idAuthorUpdate) != -1){
                                Book bookObjUpdate = new Book();
                                bookObjUpdate.setId(idAuthorUpdate);

                                System.out.print("Nhập tiêu đề sách: ");
                                bookObjUpdate.setTitle(sc.nextLine());
                                System.out.print("Nhập giá sách: ");
                                bookObjUpdate.setPrice(Double.parseDouble(sc.nextLine()));

                                authorClass.show();
                                System.out.print("Chọn tác giả muốn cập nhật (index): ");
                                System.out.println("");
                                int indexAuthorUpdate = Integer.parseInt(sc.nextLine());
                                // authorClass.chooseAuthor(indexAuthorUpdate);
                                bookObjUpdate.setAuthor(authorClass.chooseAuthor(indexAuthorUpdate));
                                bookClass.update(bookObjUpdate);
                            } else {
                                System.out.println("---> Không có Id bạn muốn tìm");
                            }
                            break;
                        default:
                    }
                } while (chooseBook != 6);
                break;
            default:
        }
    }while (chooseLibrary != 3);
    }

    public static void showLibrary(){
        System.out.println("---------LIBRARY LIST----------");
        System.out.println("1 - Quản lý tác giả");
        System.out.println("2 - Quản lý sách");
        System.out.println("3 - Thoát ");
    }
    public static void showAuthor(){
        System.out.println("-----------------AUTHORS-------");
        System.out.println("1 - Thêm tác giả");
        System.out.println("2 - Hiển thị tác giả");
        System.out.println("3 - Cập nhập thông tin tác giả theo id");
        System.out.println("4 - Xóa tác giả (không xóa tác giả đã có sách");
        System.out.println("5 - LIBRARY LIST");
    }
    public static void showBook(){
        System.out.println("------------------BOOKS--------");
        System.out.println("1 - Thêm sách");
        System.out.println("2 - Hiển thị sách");
        System.out.println("3 - Tìm kiếm sách theo tiêu đề");
        System.out.println("4 - Tìm kiếm sách theo tên giác giả");
        System.out.println("5 - Cập nhập sách (theo id)");
        System.out.println("6 - LIBRARY LIST");
    }
}


/*
 * Viết chương trình Java quản lý thư viện. Quản lý 2 loại thông tin về sách và tác giả
 * Menu chính
 *      1. Quản lý tác giả
 *      2. Quản lý sách
 *      3. Thoát
 * Khi chọn menu 1. Quản lý tác giả
 *      1. Thêm tác giả
 *      2. Hiển thị tác giả
 *      3. Cập nhật thông tin tác giả (theo id)
 *      4. Xóa tác giả (Không xóa tác giả có đã sách)
 *      5. Quay lại (quay trở về menu chính)
 * Khi chọn menu 2. Quản lý sách
 *      1. Thêm sách
 *      2. Tìm kiếm sách theo tiêu đề
 *      3. Tìm kiếm sách theo tên tác giả
 *      4. Cập nhật sách (theo id)
 *      5. Quay lại (Quay về menu chính)
 */