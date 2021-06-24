package others.visitordp;

public class Guy implements IVisitable{

    @Override
    public void add(IVisitable guy) {
        //不实现
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitGuy(this);
    }

    public void drinkWine(){
        System.out.println("Guy drinkWine");
    }

    public void useBlade() {
        System.out.println("Guy useBlade");
    }
}
