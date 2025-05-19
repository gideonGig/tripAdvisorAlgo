package stream_test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;

public class StreamT {

    public static Employee[] employees = new Employee[]{new Employee(1, "Gideon", "Estate", true, new BigDecimal("9000.00")),
            new Employee(3, "Gideon", "Estate", false, new BigDecimal("6000.00")), new Employee(2, "Gideon", "Estate", true, new BigDecimal("7000.00"))};
    public static List<Employee> employeeList = Arrays.asList(employees);
    public static List<BigDecimal> salaryList = new ArrayList<BigDecimal>();

    public static void testStream() {
        long numberOfEmployees = employeeList.stream().count();
        System.out.println(numberOfEmployees);

        List<BigDecimal> salaryList = employeeList.stream().map(x -> x.salary).collect(Collectors.toList());
        System.out.println(salaryList);


        List<BigDecimal> salaryListGreaterThan500 = employeeList.stream().filter(x -> x.getSalary().compareTo(BigDecimal.valueOf(6500.00)) > 0)
                .map(x -> x.salary).sorted(BigDecimal::compareTo).collect(Collectors.toList());
        System.out.println(salaryListGreaterThan500);

        Map<Boolean,List<Employee>> employeeMap = Arrays.stream(employees).collect(Collectors.groupingBy(x -> x.isContractor));

        employeeMap.entrySet().stream().forEach(System.out::println);

    }

    public static int test(int[] A) {
        int[] positiveArr = Arrays.stream(A).filter(x -> x > 0).distinct().sorted().toArray();
        if (positiveArr.length == 0) {
            return 1;
        }

        int prev = 0;
        int i = 0;
        for (i = 0; i < positiveArr.length; i++) {
            if (positiveArr[i] != prev + 1) {
                return prev + 1;
            }

            prev = positiveArr[i];
        }

        return positiveArr[positiveArr.length - 1] + 1;
    }

    public static HashSet<Integer> getPrimeNumber(int n) {
        HashSet<Integer> str = new HashSet<>();
        str.add(2);
        int startNum = 3;
        while (startNum <= n) {
            int i = 2;
            boolean isPrime = false;
            while (i < startNum) {
                if (startNum % i == 0) {
                    isPrime = true;
                    break;
                }
                i++;
            }
            if (!isPrime) {
                str.add(startNum);
            }

            startNum++;
        }
        return str;
    }

    public static int[] getDistinct(int N, int[] P, int[] Q) {
        int[] ans = new int[P.length];
        int i = 0;
        while (i < P.length) {
            int pNum = P[i];
            int qNum = Q[i];
            int semiPrime = getSemiPrimesBetween(pNum, qNum);
            ans[i] = semiPrime;
            i++;
        }

        return ans;
    }

    public static int getSemiPrimesBetween(int start, int end) {
        HashSet<Integer> primeArr = getPrimeNumber(end);
        HashMap<Integer,Boolean> dp = new HashMap<>();
        int ans = 0;
        while (start <= end) {
            if (Boolean.TRUE.equals(dp.getOrDefault(start, false))) {
                ans++;
                continue;
            }
            for (Integer num : primeArr) {
                if (start % num == 0 && primeArr.contains(start / num)) {
                    ans++;
                    dp.put(start, true);
                    break;
                }
            }
            start++;
        }
        return ans;
    }

    public List<BigDecimal> mapSalary(BigDecimal salary) {
        salaryList.add(salary);
        return salaryList;
    }

    public static class Employee {
        private final int id;
        private String name;
        private final String address;
        private final Boolean isContractor;
        private final BigDecimal salary;

        public Employee(int id, String name, String address, Boolean isContractor, BigDecimal salary) {
            this.id = id;
            this.address = address;
            this.isContractor = isContractor;
            this.salary = salary;
        }

        public int getId() {
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

    public static class EmployeeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getSalary().compareTo(e2.getSalary());
        }
    }

    public static class EmployeePriorityQueue {
        private final PriorityQueue<Employee> employeeQueue;

        public EmployeePriorityQueue() {
            employeeQueue = new PriorityQueue<>(new EmployeeComparator());

        }

        public void addEmployee(Employee employee) {
            employeeQueue.offer(employee);
        }

        public Employee getEmployee() {
            return employeeQueue.poll();
        }

        public boolean isEmpty() {
            return employeeQueue.isEmpty();
        }

        public int size() {
            return employeeQueue.size();
        }

    }

    public static class EmployeeAtomicPriorirtyQueue {
        private final AtomicReference<PriorityQueue<Employee>> atomicEmployeeQueue;

        public EmployeeAtomicPriorirtyQueue() {
            atomicEmployeeQueue = new AtomicReference<>(new PriorityQueue<>(new EmployeeComparator()));
        }

        public void addEmployee(Employee employee) {
            while (true) {
                PriorityQueue<Employee> currentQueue = atomicEmployeeQueue.get();
                PriorityQueue<Employee> newQueue = new PriorityQueue<>(currentQueue);
                newQueue.offer(employee);
                if (atomicEmployeeQueue.compareAndSet(currentQueue, newQueue)) {
                    break;
                } else {
                    LockSupport.parkNanos(1);
                }
            }
        }

        public Employee removeEmployee() {
            PriorityQueue<Employee> currentEmployeeQueue = atomicEmployeeQueue.get();
            return null;

        }

    }

}
