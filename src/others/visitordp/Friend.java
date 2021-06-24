package others.visitordp;

public class Friend implements IVisitor{
    @Override
    public void visitGuy(Guy guy) {
        guy.drinkWine();
    }

    @Override
    public void visitGirl(Girl girl) {
        girl.dance();
    }
}
