public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

        employeeManager.addEmployee("001", new Employee("Carlos Henrique", "Software Engineer", 5000));
        employeeManager.addEmployee("002", new Employee("Ana Santos", "Designer", 4200));
        employeeManager.addEmployee("003", new Employee("Pedro Oliveira", "Manager", 8000 ));

        employeeManager.listAllEmployees();

        employeeManager.getEmployeeInfo("002");

        employeeManager.addEmployee("001", new Employee("Carlos Henrique", "developer Sênior", 6000));

        employeeManager.calculateTotalSalaries();

        employeeManager.removeEmployee("003");

        employeeManager.listAllEmployees();
    }
}