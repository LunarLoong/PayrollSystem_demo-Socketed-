package staffManagement;

import ui.Call;

public class EmployeeServiceImpl implements IService{

    public EmployeeServiceImpl(){

    }

    @Override
    public Call add(Employee employee){
        return new Call("EmployeeDaoMysqlImpl", "add",
                //方法参数类型数组
                new Class[]{Employee.class},
                new Object[]{employee},
                TimeEmployee.class
        );
    }

    @Override
    public Call delete(Employee employee){
        return new Call("EmployeeDaoMysqlImpl", "delete",
                //方法参数类型数组
                new Class[]{Employee.class},
                new Object[]{employee},
                TimeEmployee.class
        );
    }

    @Override
    public Call query(Employee employee){
        return new Call("EmployeeDaoMysqlImpl", "query",
                //方法参数类型数组
                new Class[]{Employee.class},
                new Object[]{employee},
                TimeEmployee.class
        );
    }

    @Override
    public Call detail(Employee employee){
        return new Call("EmployeeDaoMysqlImpl", "detail",
                //方法参数类型数组
                new Class[]{Employee.class},
                new Object[]{employee},
                TimeEmployee.class
        );
    }



}
