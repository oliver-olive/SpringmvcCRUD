package org.pkg;

import org.pkg.classes.Employee;
import org.pkg.dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDao");
        Employee employee = new Employee();

        employee.setId(103);
        employee.setFirstName("Gyanendra");
        employee.setLastName("Yadav");
        int result = empDao.create(employee);
        System.out.println("Number of records inserted are: " + result);
        List<Employee> l1 = empDao.read();
        for(Employee e: l1){
            System.out.println(e.getFirstName());
        }
    }

}
