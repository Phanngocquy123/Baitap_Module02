public class main {
    public static void main(String[] args) {
        ClassSt classSt = new ClassSt();

        Student st1 = new Student("N1","M1", "AB",8,5,4);
        Student st2 = new Student("N2","M2", "ED",9,5,4);
        Student st3 = new Student("N3","M3", "DA",7,5,8);
        Student st4 = new Student("N4","M4", "CA",4,5,7);
        Student st5 = new Student("N5","M5", "AA",1,5,4);
        Student st6 = new Student("N6","M6", "AD",1,5,6);
        Student st7 = new Student("N7","M7", "AA",3,5,5);

        classSt.add(st1);
        classSt.add(st2);
        classSt.add(st3);
        classSt.add(st4);
        classSt.add(st5);
        classSt.add(st6);
        classSt.add(st7);
        classSt.edit("N4");
        classSt.show();
    }
}
