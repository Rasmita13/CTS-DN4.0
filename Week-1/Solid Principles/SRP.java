class Staff {
    private String fullName;
    private int staffId;

    public Staff(String fullName, int staffId) {
        this.fullName = fullName;
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getStaffId() {
        return staffId;
    }
}

class StaffReportGenerator {
    public void generateReport(Staff staff) {
        System.out.println("Staff Report: " + staff.getFullName() + " (ID: " + staff.getStaffId() + ")");
    }
}

public class SRP {
    public static void main(String[] args) {
        Staff staff = new Staff("Rasmita", 104);
        StaffReportGenerator report = new StaffReportGenerator();
        report.generateReport(staff);
    }
}

