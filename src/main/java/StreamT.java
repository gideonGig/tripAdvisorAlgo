import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamT {

    public static class Employee {
        private int id;
        private String name;
        private String address;
        private Boolean isContractor;
        private BigDecimal salary;

        public Employee(int id, String name, String address, Boolean isContractor, BigDecimal salary) {
             this.id = id;
             this.address = address;
             this.isContractor = isContractor;
             this.salary = salary;
        }  

        public int getId(){
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
        public Boolean getIsContractor() {
            return isContractor;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public Employee[] getEmployeeArray() {
            return StreamT.employees;
        }
    }

    public static Employee[] employees = new Employee[] { new Employee(1, "Gideon", "Estate", true, new BigDecimal(9000.00)), 
    new Employee(3, "Gideon", "Estate", true, new BigDecimal(6000.00)), new Employee(2, "Gideon", "Estate", true, new BigDecimal(7000.00)) };
    public static List<Employee> employeeList = Arrays.asList(employees);
    public static List<BigDecimal> salaryList = new ArrayList<BigDecimal>();

    public static void testStream() {
       long numberOfEmployees =  employeeList.stream().count();
       System.out.println(numberOfEmployees);

       List<BigDecimal> salaryList = employeeList.stream().map(x -> x.salary).collect(Collectors.toList());
       System.out.println(salaryList.toString());

       
       List<BigDecimal> salaryListGreaterThan500 = employeeList.stream().filter(x -> x.getSalary().compareTo(BigDecimal.valueOf(6500.00)) > 0)
       .map(x -> x.salary).sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toList());
       System.out.println(salaryListGreaterThan500.toString());

    }

    public List<BigDecimal> mapSalary(BigDecimal salary) {
        salaryList.add(salary);
        return salaryList;
    }
    
}
