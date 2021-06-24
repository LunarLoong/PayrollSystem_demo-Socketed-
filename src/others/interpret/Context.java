package cn.edu.bnuz.interpret;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class Context {
    private Map<Variable,Double> variableMap =new HashMap<>();

    public Context() {
    }

    public Context(Map<Variable, Double> variableMap) {
        this.variableMap = variableMap;
    }

    public void assign(Variable variable, double value){
        this.variableMap.put(variable,value);
    }

    public double lookup(Variable variable) {
//        System.out.println(variable.getName());
//        System.out.println(this.variableMap.get(variable));
       return this.variableMap.get(variable);
    }
}
