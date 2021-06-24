package dao;

import staffManagement.Employee;

import java.sql.SQLException;
import java.util.List;


public interface EmployeeDao {

    void add(Employee employee);

    void delete(Employee employee);

    void update(Employee employee);

    List query(Employee employee);

    Employee detail(Employee employee);

}
