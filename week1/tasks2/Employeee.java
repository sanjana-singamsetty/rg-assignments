public class Employeee {
    private int id;
    private String name;

    // Getter and setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // main method to test
    public static void main(String[] args) {
        Employeee e = new Employeee();  // Create an instance
        e.setId(1);                   // Set values
        e.setName("John");

        System.out.println(e.getId() + " " + e.getName());  // Output
    }
}
