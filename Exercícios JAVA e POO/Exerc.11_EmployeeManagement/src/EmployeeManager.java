import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
    private HashMap<String, Employee> employees = new HashMap<>();

    void addEmployee(String id, Employee employee){
        if (employees.containsKey(id)) {
            System.out.format("Atualizando os dados de %s...\n", employee.getName());
            employees.replace(id, employee); // Se o ID existir, substitui o Employee antigo pelo novo
        } else {
            System.out.println("Adicionando funcionário...");
            employees.put(id, employee); // Se o ID não existir, adiciona o ID + Employee
        }
    }

    void removeEmployee(String id) {
        if (employees.containsKey(id)) {
            employees.remove(id);  // Remove usando o id como chave
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }


    void getEmployeeInfo(String id) {
        Employee e = employees.get(id);
        if (employees.containsKey(id)) {
            System.out.print(e.toString());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    void listAllEmployees() {
        System.out.println("Employees:");
        for (Employee e : employees.values()) {
            System.out.print(e.toString());
        }
    }

    void calculateTotalSalaries() {
        double totalSalaries = 0;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            totalSalaries += entry.getValue().getSalary();
        }
        System.out.println("Total Salaries: R$" + totalSalaries);
    }
}
