package staffManagement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;


public class EmployeeService implements InvocationHandler {
    private Object target;
    public EmployeeService(){

    }
    public EmployeeService(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(new Date() + " Before invoke => "  + method.getName());
        Object result = method.invoke(target, args);
        System.out.println(new Date() + " After invoke => " + method.getName());
        return result;
    }
}
