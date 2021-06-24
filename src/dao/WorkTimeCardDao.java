package dao;

import staffManagement.WorkTimeCard;

import java.util.List;

public interface WorkTimeCardDao {
    //定义类似的方法：增加、修改、删除、条件查询、详细等相关方法
    void add(WorkTimeCard workTimeCard);

    void delete(WorkTimeCard workTimeCard);

    void update(WorkTimeCard workTimeCard);

    List query(WorkTimeCard workTimeCard);

    void detail(WorkTimeCard workTimeCard);

}
