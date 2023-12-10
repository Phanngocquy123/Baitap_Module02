public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private double markCss;
    private double markHtml;
    private double markJs;
    private double markAvg;
    private int age;
    public Student() {
    }

    public Student(String id, String firstName, String lastName, double markCss, double markHtml, double markJs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.markCss = markCss;
        this.markHtml = markHtml;
        this.markJs = markJs;

    }
    public Student(String id, String firstName, String lastName, double markCss, double markHtml, double markJs, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.markCss = markCss;
        this.markHtml = markHtml;
        this.markJs = markJs;
        this.age = age;
    }  // Ctrl + d copy double

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMarkCss() {
        return markCss;
    }

    public double getMarkHtml() {
        return markHtml;
    }

    public double getMarkJs() {
        return markJs;
    }

    public double getMarkAvg() {
        return markAvg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMarkCss(double markCss) {
        this.markCss = markCss;
    }

    public void setMarkHtml(double markHtml) {
        this.markHtml = markHtml;
    }

    public void setMarkJs(double markJs) {
        this.markJs = markJs;
    }

    public void setMarkAvg(double markAvg) {
        this.markAvg = markAvg;
    }

    public void calculateAvg(){
        this.markAvg = (markCss + markHtml + markJs)/3;
    }

    public void input(){
/**
 * Nhập thông tin cho học viên (có thêm tham số cho hàm nếu cần)
 */
    }
}
