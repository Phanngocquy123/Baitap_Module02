public class Employee implements BaseEntity{
    private int id;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean checkId(Object id) {
        return id.equals(this.id);
    }

    @Override
    public void input() {

    }

    @Override
    public void show() {
        System.out.println("Salary----> " + this.salary);
    }

    @Override
    public void findFirst(int number, Object item) {

    }
}
