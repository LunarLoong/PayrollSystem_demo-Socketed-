package dao;

import staffManagement.TimeEmployee;
import sqlManagement.JDBCExecutor;
import staffManagement.Employee;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoMysqlImpl implements EmployeeDao {
    private JDBCExecutor executor;

    public EmployeeDaoMysqlImpl() {
        executor = JDBCExecutor.getJDBCExecutor();
    }

    @Override
    public void add(Employee employee) {
        // TODO Connection,sql语句 insert
        executor.executeUpdate("insert into Employee(ename,age) values('"
                + employee.getName() + "','" + employee.getAge() + "')");
    }

    @Override
    public void delete(Employee employee) {
        // TODO Connection,sql语句 delete
        executor.executeUpdate("delete from Employee where id='"
                + employee.getEID() + "')");
    }

    @Override
    public void update(Employee employee) {
        // TODO Connection,sql语句 update

    }

    @Override
    public List query(Employee employee) {
        // TODO Connection,sql语句 select
        List list = new ArrayList();
        java.sql.ResultSet rs = executor.executeQuery("select * from Employee where name like '%"
                + employee.getName() + "'");
        while (true) {
            try {
                if (!rs.next()) break;
                String name = rs.getString("name");
                String age = rs.getString("age");
                Employee e = new Employee() {
                    @Override
                    public double getSalary() {
                        return 0;
                    }
                };
                list.add(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return list;

    }

    @Override
    public Employee detail(Employee employee) {
        java.sql.ResultSet rs = executor.executeQuery("select employees.id,employees.name,employees.password,employees.sex,employees.age,employees.address,employees.phone,salaries.time,salaries.unit from salaries,employees where salaries.id = " + employee.getEID() + " and employees.id = " + employee.getEID() + " and employees.password = " + employee.getPassword());
        TimeEmployee timeEmployee = new TimeEmployee();

        while (true) {
            try {
                if (!rs.next()) break;
                timeEmployee.setName(rs.getString("name"));
                timeEmployee.setAge(rs.getString("age"));
                timeEmployee.setSex(rs.getString("sex"));
                timeEmployee.setAddress(rs.getString("address"));
                timeEmployee.setEID(rs.getString("id"));
                timeEmployee.setPhone(rs.getString("phone"));
                timeEmployee.setPassword(rs.getString("password"));
                timeEmployee.getWorkTimeCard().setTime(rs.getInt("time"));
                timeEmployee.getWorkTimeCard().setUnit(rs.getInt("unit"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return timeEmployee;
    }

}
