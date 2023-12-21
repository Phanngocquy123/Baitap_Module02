import java.util.Arrays;

public class BookClass {
    private Book[] books;
    private Book[] booksFindTitle;
    private Book[] booksFindAuthor;
    private int defaultElement = 5;
    private int index = 0;
    private int indexFindTitle = 0;
    private int indexFindAuthor = 0;

    public BookClass() {
        this.books = new Book[defaultElement];
        this.booksFindTitle = new Book[defaultElement];
        this.booksFindAuthor = new Book[defaultElement];
    }
                                                                                        // 1 - Thêm sách
    public boolean add(Book bookObj) {
        if (findId(bookObj.getId()) == -1) {
            if (index == books.length) {
                books = Arrays.copyOf(books, books.length + defaultElement);
            }
            books[index++] = bookObj;
            System.out.println("---> Thêm sách thành công");
            return true;
        } else {
            System.out.println("---> Sách thêm bị trùng Id");
            return false;
        }
    }
    int iFindId;
    public int findId(String id) {
        for (int i = 0; i < index; i++) {
            if (books[i].getId().equals(id)){
                iFindId = i;
                return iFindId;
            }
        }
        return -1;
    }
                                                                          // 3 - Tìm kiếm sách theo tiêu đề
    public Book findTitle(String title) {
        for (int i = 0; i < booksFindTitle.length; i++) {
            booksFindTitle[i] = null;
        }
        indexFindTitle = 0;
        Boolean checkTitle = false;
        for (int i = 0; i < index; i++) {
            if (books[i].getTitle().toUpperCase().contains(title.toUpperCase())) {
                if (booksFindTitle.length == defaultElement) {
                    booksFindTitle = Arrays.copyOf(booksFindTitle, booksFindTitle.length + defaultElement);
                }
                booksFindTitle[indexFindTitle++] = books[i];
                checkTitle = true;
            }
        }
        if (checkTitle) {
            System.out.println("....................................SEARCH TITLE.............");
            for (int i = 0; i < indexFindTitle; i++) {
                System.out.printf("Id: %-5s|| Title: %-10s|| Author: %-15s|| Price: %-5.2f",
                        booksFindTitle[i].getId(),
                        booksFindTitle[i].getTitle(),
                        booksFindTitle[i].getAuthor().getName(),
                        booksFindTitle[i].getPrice());
                System.out.println();
            }
            System.out.println("....................................SEARCH TITLE.............");
            System.out.println("");
            return books[1];
        } else {
            System.out.println("---> Không có tiêu đề bạn muốn tìm");
        }
        return null;
    }

    public boolean existBookWithAuthor(String idAuthorCheck) {                 // check tồn tại tác giả muốn xóa
        boolean authorResult = false;
        for (int i = 0; i < index; i++) {
            if (books[i].getAuthor().getName().equals(idAuthorCheck)) {
                authorResult = true;
                break;
            }
        }
        return authorResult;
    }

    public Book findAuthor(String author) {                                    // 4 - Tìm kiếm sách theo tên giác giả
        for (int i = 0; i < booksFindAuthor.length; i++) {
            booksFindAuthor[i] = null;
        }
        indexFindAuthor = 0;

        Boolean checkAuthor = false;
        for (int i = 0; i < index; i++) {
            if (books[i].getAuthor().getName().toUpperCase().equals(author.toUpperCase())) {
                if (booksFindAuthor.length == defaultElement) {
                    booksFindAuthor = Arrays.copyOf(booksFindAuthor, booksFindAuthor.length + defaultElement);
                }
                booksFindAuthor[indexFindAuthor++] = books[i];
                checkAuthor = true;
            }
        }
        if (checkAuthor) {
            System.out.println("...................................SEARCH AUTHOR.............");
            for (int i = 0; i < indexFindAuthor; i++) {
                System.out.printf("Id: %-5s|| Title: %-10s|| Author: %-15s|| Price: %-5.2f",
                        booksFindAuthor[i].getId(),
                        booksFindAuthor[i].getTitle(),
                        booksFindAuthor[i].getAuthor().getName(),
                        booksFindAuthor[i].getPrice());
                System.out.println();
            }
            System.out.println("...................................SEARCH AUTHOR.............");
            System.out.println("");
            return books[1];
        } else {
            System.out.println("---> Không có tác giả bạn muốn tìm");
        }
        return null;
    }


    public void update(Book objUpdate){                                             // update sách
        books[iFindId] = objUpdate;
        System.out.println("---> Cập nhập sách thành công");
    }
                                                                                     // 2 - Hiển thị sách
    public void show() {
        System.out.println("----------------------------*****----------------------****");
        System.out.println("Danh sách SÁCH");
        for (int i = 0; i < index; i++) {
            System.out.printf("Id: %-5s|| Title: %-10s|| Author: %-15s|| Price: %-5.2f",
                    books[i].getId(),
                    books[i].getTitle(),
                    books[i].getAuthor().getName(),
                    books[i].getPrice());
            System.out.println();
        }
        System.out.println("-----------------------------*****----------------------****");
    }

}
/*
 * Viết chương trình Java quản lý thư viện. Quản lý 2 loại thông tin về sách và tác giả
 * Menu chính
 *      1. Quản lý tác giả
 *      2. Quản lý sách
 *      3. Thoát
 *
 * Khi chọn menu 1. Quản lý tác giả
 *      1. Thêm tác giả
 *      2. Hiển thị tác giả
 *      3. Cập nhật thông tin tác giả (theo id)
 *      4. Xóa tác giả (Không xóa tác giả có đã sách)
 *      5. Quay lại (quay trở về menu chính)
 *
 * Khi chọn menu 2. Quản lý sách
 *      1. Thêm sách
 *      2. Hiển thị sách
 *      3. Tìm kiếm sách theo tiêu đề
 *      4. Tìm kiếm sách theo tên tác giả
 *      5. Cập nhật sách (theo id)
 *      6. Quay lại (Quay về menu chính)
 */