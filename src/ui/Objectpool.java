package ui;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Objectpool {
    private static Map<String, Object> instancePool = new HashMap<>();
    public static final String POOLPROPERTIES = "src/ui/objectpool.properties";
    private Objectpool(){

    }

    public static Objectpool getInstance(){
        return new Objectpool();
    }

    public static Object createObject(String className) throws Exception{
        Class<?> clazz = Class.forName(className);
        return clazz.getConstructor().newInstance();
    }

    public static <T> T createObject(Class<T> clazz) throws Exception{
        T t = clazz.newInstance();
        return t;
    }

    static {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(POOLPROPERTIES));
            Set<String> keys = prop.stringPropertyNames();
            for (String className : keys) {
                String classPath = prop.getProperty(className);
                Object instance = createObject(classPath);
                instancePool.put(className, instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getObject(String className) {
        return instancePool.get(className);
    }

}
