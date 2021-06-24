package dao.factory;


import dao.*;

public class MysqlDaoFactory extends AbstractDaoFactory {

    private MysqlDaoFactory(){

    }

    public static MysqlDaoFactory getInstance(){
        return new MysqlDaoFactory();
    }
    //生成各张表的dao对象
    //1、生成EmployeeDao对象的方法
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoMysqlImpl();
    }

    //2、生成WordTimeCardDao对象的方法
    public WorkTimeCardDao getWordTimeCardDao() {
        return new WorkTimeCardDaoMysqlImpl();
    }

}
