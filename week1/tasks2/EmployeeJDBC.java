import java.sql.*;

public class EmployeeJDBC {

    private int id;
    private String name;
    private String department;

    // Constructors
    public EmployeeJDBC() {}
    public EmployeeJDBC(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters & setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }

    // Database connection
    private static final String URL = "jdbc:h2:~/testdb";
    private static final String USER = "";
    private static final String PASSWORD = "";

    public void createTable() throws SQLException {
        String sql = "CREATE TABLE Employee (id INT PRIMARY KEY, name VARCHAR(100), department VARCHAR(100))";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created");
        }
    }

    public void addEmployee(EmployeeJDBC emp) throws SQLException {
        String sql = "INSERT INTO Employee (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getDepartment());
            pstmt.executeUpdate();
            System.out.println("Employee added");
        }
    }

    public void getEmployee(int id) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
            } else {
                System.out.println("Employee not found");
            }
        }
    }

    public void updateEmployee(EmployeeJDBC emp) throws SQLException {
        String sql = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getDepartment());
            pstmt.setInt(3, emp.getId());
            int updated = pstmt.executeUpdate();
            System.out.println(updated + " row(s) updated");
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int deleted = pstmt.executeUpdate();
            System.out.println(deleted + " row(s) deleted");
        }
    }

    public static void main(String[] args) {
        EmployeeJDBC db = new EmployeeJDBC();
        try {
            db.createTable();

            EmployeeJDBC e1 = new EmployeeJDBC(1, "Alia", "IT");
            db.addEmployee(e1);

            db.getEmployee(1);

            e1.setName("Sanjana S");
            e1.setDepartment("HR");
            db.updateEmployee(e1);

            db.getEmployee(1);

            db.deleteEmployee(1);
            db.getEmployee(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
