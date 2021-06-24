package others.visitordp;

public class Wolf implements IVisitor {

    @Override
    public void visitGuy(Guy guy) {
        guy.useBlade();//将回答调用放在访问者这，为了实现对不同访问者做出不同回答
    }
    @Override
    public void visitGirl(Girl girl) {
        girl.kill();
    }
}