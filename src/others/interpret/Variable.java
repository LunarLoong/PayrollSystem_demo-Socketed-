package cn.edu.bnuz.interpret;

public class Variable implements IExpress {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double interpret(Context context) {
        return context.lookup(this);

    }
}
