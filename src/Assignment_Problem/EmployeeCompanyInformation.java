public class EmployeeCompanyInformation {
    static class Employee {
        private String empName;
        private double salary;
        private static String companyName = "Bright Horizon Technologies";
        private static int employeeCount;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Aarav", 50000);
        new Employee("Diya", 60000);
        new Employee("Kabir", 55000);
        Employee.printCompanyInfo();
    }
}
