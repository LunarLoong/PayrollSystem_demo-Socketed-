package others.visitordp;

import java.util.ArrayList;
import java.util.List;

public class MyMotherLand implements IVisitable{
    private List<IVisitable> visitables = new ArrayList<>();

    @Override
    public void add(IVisitable visitable) {
        visitables.add(visitable);
    }

    @Override
    public void accept(IVisitor visitor) {
        for(IVisitable visitable:visitables){
            visitable.accept(visitor);
        }
    }
}
