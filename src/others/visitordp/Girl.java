package others.visitordp;

public class Girl implements IVisitable{
    @Override
    public void add(IVisitable guy) {
        //不实现
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitGirl(this);
    }

    public void dance(){
        System.out.println(" Girl dance ");
    }

    public void kill() {
        System.out.println(" Girl kill ");
    }
}
