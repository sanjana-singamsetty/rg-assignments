import java.util.*;



public class EmployeeCRUDNative {
    private Map<Integer, Employee> db = new HashMap<>();

    public void create(Employee e) {
        db.put(e.getId(), e);
        System.out.println("Inserted: " + e);
    }

    public void readAll() {
        db.values().forEach(System.out::println);
    }

    public void update(int id, String newName, String newDept) {
        Employee e = db.get(id);
        if (e != null) {
            e.setName(newName);
            e.setDepartment(newDept);
            System.out.println("Updated: " + e);
        }
    }

    public void delete(int id) {
        db.remove(id);
        System.out.println("Deleted employee with id: " + id);
    }

    public static void main(String[] args) {
        EmployeeCRUDNative crud = new EmployeeCRUDNative();
        Employee e1 = new Employee(1, "Alice", "IT");
        Employee e2 = new Employee(2, "Bob", "HR");

        crud.create(e1);
        crud.create(e2);

        System.out.println("All employees:");
        crud.readAll();

        crud.update(1, "AliceUpdated", "Finance");
        System.out.println("After update:");
        crud.readAll();

        crud.delete(2);
        System.out.println("After delete:");
        crud.readAll();
    }
}
