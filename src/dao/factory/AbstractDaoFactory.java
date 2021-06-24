package dao.factory;

import dao.EmployeeDao;
import dao.WorkTimeCardDao;

public abstract class AbstractDaoFactory {
    public AbstractDaoFactory() {

    }

    //抽象工厂定义所有数据访问对象的实例化方法，但不实现，其具体实现由实现（继承）的子类相关方法实现
    public abstract EmployeeDao getEmployeeDao();
    public abstract WorkTimeCardDao getWordTimeCardDao();

}
