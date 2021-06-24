package others.visitordp;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
//        被访者对象聚集对象
        IVisitable mml=new MyMotherLand();
//        具体被访者对象
        IVisitable guy=new Guy();
        IVisitable girl=new Girl();
        mml.add(guy);
        mml.add(girl);
//        访问者
        IVisitor friend=new Friend();
        IVisitor wolf=new Wolf();
//        完成访问过程
        mml.accept(friend);
        mml.accept(wolf);
    }
}
