public class Program {
    public static void main(String[] args) {
        Manager students = new Manager();
        Manager employees = new Manager();

        Student st1 = new Student();
        st1.setId("SV01");
        st1.setName("Nam");
        st1.setClassName("Ra 01");

        Student st2 = new Student();
        st2.setId("SV02");
        st2.setName("Hoa");
        st2.setClassName("Ra 02");

        students.add(st1);
        students.add(st2);
        //students.show();

        Employee em1 = new Employee(123,"A",1.1);
        Employee em2 = new Employee(456,"B",1.2);
        Employee em3 = new Employee(789,"C",1.3);
        employees.add(em1);
        employees.add(em2);
        employees.add(em3);
        //employees.show();

        students.findId("SV02").show();
        employees.findId(0).show();

        //Predicate predicate = obj -> obj.equals("B");
        //System.out.println(predicate.test("B"));



    }
}
