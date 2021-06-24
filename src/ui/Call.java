package ui;

import java.io.Serializable;


public class Call implements Serializable {
    //类名
    private String className;
    //方法名
    private String methodName;
    //方法参数类型数组
    private Class[] paramTypes;

    private Object[] paramValues;

    private Object returnObj;

    public Call(String className, String methodName, Class[] paramTypes, Object[] paramValues, Object returnObj) {
        super();
        this.className = className;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.paramValues = paramValues;
        this.returnObj = returnObj;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParamValues() {
        return paramValues;
    }

    public void setParamValues(Object[] paramValues) {
        this.paramValues = paramValues;
    }

    public Object getReturnObj() {
        return returnObj;
    }

    public void setReturnObj(Object returnObj) {
        this.returnObj = returnObj;
    }


}

