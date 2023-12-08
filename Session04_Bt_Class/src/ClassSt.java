import java.util.Arrays;
import java.util.Scanner;

public class ClassSt {
    Scanner sc = new Scanner(System.in);
    private Student[] students;
    private int defaultElement = 5;
    private int index = 0;

    public ClassSt (){
        this.students = new Student[defaultElement];
    }

    public boolean add(Student st) {
        if (findId(st.getId()) == null){
            if (index == students.length)
                students = Arrays.copyOf(students,students.length +defaultElement);
            students[index++] = st;
            return true;
        }
        return false;
    }

    public boolean edit(String id){
        for (int i = 0; i < index; i++){
            if (students[i].getId().equals(id)){
                Student editSt = new Student();
                editSt.setId(students[i].getId());

                System.out.print("First Name: ");
                editSt.setFirstName(sc.nextLine());
                System.out.print("Last Name: ");
                editSt.setLastName(sc.nextLine());

                System.out.print("Mark Css: ");
                editSt.setMarkCss(Double.parseDouble(sc.nextLine()));
                System.out.print("Mark Html: ");
                editSt.setMarkHtml(Double.parseDouble(sc.nextLine()));
                System.out.print("Mark Js: ");
                editSt.setMarkJs(Double.parseDouble(sc.nextLine()));

                students[i] = editSt;
                return true;
            }
        }
        return false;
    }

    public Student findId(String id){
        for (int i = 0; i < index; i++){
            if (students[i].getId().equals(id)){
                System.out.println("Id trùng " +students[i].getId());
                return students[i];
            }
        }
        return null;
    }

    public boolean remove(int removeIndex){
        if (removeIndex < 0 || removeIndex > index){
            System.out.println("Vị trí chỉ định không hợp lệ");
            return false;
        }
        for (int i = removeIndex; i < index; i++){
            students[i] = students[i +1];
        }
        students[index - 1] = null;
        index--;
        System.out.println("Ví trí Index thứ " + removeIndex + " đã được xóa");
        return true;
    }

    public void sort(){
        for (int i = 0; i < index; i++){
            for (int j = i + 1; j < index; j++){
                if (students[i].getLastName().compareTo(students[j].getLastName()) > 0){
                    Student temp = students[i];
                    students[i] =  students [j];
                    students[j] = temp;
                }
            }
        }
    }

    public int size(){
        return index;
    }
    public void show(){
        for (int i = 0; i < index; i++){
            System.out.print(students[i].getId() + ", ");
            System.out.print(students[i].getFirstName() + ", ");
            System.out.print(students[i].getLastName() + ", ");
            System.out.print(students[i].getMarkCss() + ", ");
            System.out.print(students[i].getMarkHtml() + ", ");
            System.out.print(students[i].getMarkJs() + ", ");
            students[i].calculateAvg();
            System.out.printf("%.2f",students[i].getMarkAvg());
            System.out.println();
        }
//        for (Student markAvg : students){
//            markAvg.calculateAvg();
//        }
    }

}
