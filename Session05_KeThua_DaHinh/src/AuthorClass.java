import java.util.Arrays;
import java.util.Scanner;

public class AuthorClass {
    Scanner sc = new Scanner(System.in);
    private Author[] authors;
    private int defaultElement = 5;
    private int index = 0;

    public AuthorClass(){
        this.authors = new Author[defaultElement];
    }

    public boolean add(Author authorObj){

        if (findId(authorObj.getId()) == null){
            if (index == authors.length){
                authors = Arrays.copyOf(authors, authors.length + defaultElement);
            }
            authors[index++] = authorObj;
            System.out.println("---> Thêm tác giả thành công");
            return true;
        } else {
            System.out.println("---> Thêm tác giả bị trùng Id");
            return false;
        }
    }

    public Author chooseAuthor(int indexAuthor){                         // chọn index tác giả
        return authors[indexAuthor];
    }
    public boolean edit(String id){
        if (findId(id) == null){
            System.out.println("---> Không có Id tác giả muốn tìm");
            return false;
        }else {
            System.out.println("-------***-------");
            System.out.println("Cập nhập thông tin tác giả theo Id:");
            for (int i = 0; i < index; i++){
                if (authors[i].getId().equals(id)){
                    Author editAu = new Author();
                    editAu.setId(id);
                    System.out.print("Name: ");
                    editAu.setName(sc.nextLine());
                    System.out.print("Email: ");
                    editAu.setEmail(sc.nextLine());
                    System.out.print("Gender: ");
                    editAu.setGender(sc.nextLine());
                    System.out.print("Age: ");
                    editAu.setAge(Integer.parseInt(sc.nextLine()));

                    authors[i] = editAu;
                    System.out.println("---> Cập nhập thông tin tác giả thành công");
                    return true;
                }
            }
        }
        return false;
    }

    public Author findId(String id){
        for (int i = 0; i < index; i++){
            if (authors[i].getId().equals(id)){
               return authors[i];
            }
        }
        return null;
    }

    public void remove(String author){
        boolean removeAuthorCheck = false;
        for (int i = 0; i < index; i++){
            if (authors[i].getName().equals(author)){
                for (int j = i; j <index; j++){
                    authors[j] = authors[j+1];
                }
                removeAuthorCheck =true;
                break;
            }
        }
        if (removeAuthorCheck){
            authors[index - 1] = null;
            index--;
            System.out.println("---> Hoàn thành xóa tác giả");
        } else {
            System.out.println("---> Tác giả muốn xóa không có trong danh sách");
        }
    }

    public void show(){
        System.out.println("----------------------------*****----------------------****");
        System.out.println("Danh sách tác giả");
        for (int i = 0; i < index; i++){
            System.out.print("Index "+i+"   ");
            System.out.printf("Id: %-5s|| Name: %-15s|| Email: %-20s|| Gender: %-5s|| Age: %-5d ",
                             authors[i].getId(),
                             authors[i].getName(),
                             authors[i].getEmail(),
                             authors[i].getGender(),
                             authors[i].getAge());
            System.out.println();
        }
        System.out.println("----------------------------*****----------------------****");
    }
    public boolean checkAuthorsLength(){
        if (index == 0){
            return true;
        }
        return false;
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
 *      2. Hiển thị sách
 *      3. Tìm kiếm sách theo tiêu đề
 *      4. Tìm kiếm sách theo tên tác giả
 *      5. Cập nhật sách (theo id)
 *      6. Quay lại (Quay về menu chính)
 */