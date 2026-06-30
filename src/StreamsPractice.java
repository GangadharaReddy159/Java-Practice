import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class StreamsPractice {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Venkat", 50000,4,24,"Hyderabad"),
                new Employee("Bablu", 50000,3,23,"Bengaluru"),
                new Employee("Reddy", 60000,5,25,"Vijayawada"),
                new Employee("Gangadhar", 100000,6,26,"Hyderabad"),
                new Employee("Venkatesh", 30000,2,22,"Bengaluru")
        );

        //average salary of list of employees
        double avgSalary = employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();

        System.out.println(avgSalary);

        //group employees by city
        Map<String,List<Employee>> employeesByCity = employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.toList()));
        System.out.println(employeesByCity);

        //sort by salary
        List<Employee> salarySortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(salarySortedEmployees);

        List<Employee> salaryReverseSortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(salaryReverseSortedEmployees);

        //multiple comparisions
        List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getExperience)).toList();
        System.out.println(sortedEmployees);

        //counting
        Map<String, Long> employeesPerCity = employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        System.out.println(employeesPerCity);

        employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).ifPresent(s->{
                    System.out.println(s.getKey()+" "+s.getValue());
                });

    }
}
