package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    // employees listesine veriler ekleniyor
    static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(1, "Dogancan", "Yılmaz"),
            new Employee(2, "Burak", "Demir"),
            new Employee(3, "Murat", "Aydın"),
            new Employee(1, "Dogancan", "Yılmaz"), // Duplicate
            new Employee(4, "Ahmet", "Kaya"),
            new Employee(2, "Burak", "Demir") // Duplicate
    ));

    public static void main(String[] args) {
        // Main metodunda testleri çalıştırarak çıktıları kontrol edebilirsiniz.

        // Test: Find duplicates
        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: " + duplicates);

        // Test: Find uniques
        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("Uniques: " + uniques);

        // Test: Remove duplicates
        List<Employee> noDuplicates = removeDuplicates(employees);
        System.out.println("List without duplicates: " + noDuplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Integer> seen = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee emp : list) {
            if (emp != null && !seen.add(emp.getId())) {
                duplicates.add(emp);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> resultMap = new LinkedHashMap<>();

        // Çalışanların ID'lerini sayıyoruz
        for (Employee emp : list) {
            if (emp != null) {
                countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
            }
        }

        // Her çalışanı map'e ekliyoruz, ancak 1'den fazla tekrar edilmişse de onları da ekliyoruz
        for (Employee emp : list) {
            if (emp != null) {
                resultMap.put(emp.getId(), emp);
            }
        }

        return resultMap;
    }


    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> result = new ArrayList<>();

        for (Employee emp : list) {
            if (emp != null) {
                countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
            }
        }

        for (Employee emp : list) {
            if (emp != null && countMap.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }

        return result;
    }
}
