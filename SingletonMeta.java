package SmartOffice;

import java.util.HashMap;
import java.util.Map;

public class SingletonMeta {
    private static final Map<Class<?>, Object> instances = new HashMap<>();

    public static <T> T getInstance(Class<T> classType) {
        if (!instances.containsKey(classType)) {
            try {
                instances.put(classType, classType.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return classType.cast(instances.get(classType));
    }
}


