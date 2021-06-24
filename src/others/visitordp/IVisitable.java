package others.visitordp;

public interface IVisitable {

    void add(IVisitable guy);

    void accept(IVisitor friend);
}

