package model;
import service.SchoolService;


public class Admin extends Person {

    private String department;

    public Admin(String id, String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;
    }


    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public void showDashboard() {
        System.out.println("\n|=====================================|");
        System.out.println("|          ADMIN DASHBOARD              |");
        System.out.println("|=======================================|");
        System.out.println("  Name       : " + getName());
        System.out.println("  ID         : " + getId());
        System.out.println("  Department : " + department);
        System.out.println("----------------------------------------");
        System.out.println("  Options:");
        System.out.println("  [1] Add Student");
        System.out.println("  [2] Add Teacher");
        System.out.println("  [3] View All Students");
        System.out.println("  [4] View All Teachers");
        System.out.println("  [5] Update Fee Status");
        System.out.println("  [6] View All Records (File)");
        System.out.println("  [0] Logout");
    }

    public String getDepartment()              { return department; }
    public void setDepartment(String dept)     { this.department = dept; }

    @Override
    public String toString() {
        return super.toString() + " | Dept: " + department;
    }
}
