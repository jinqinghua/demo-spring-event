package kim.springevent.async;

public class ObjectContext {
    public static final ThreadLocal<String> objectThreadLocal = new ThreadLocal<>();

    public static void set(String str) {
        objectThreadLocal.set(str);
    }

    public static void remove() {
        objectThreadLocal.remove();
    }

    public static String get() {
        return objectThreadLocal.get();
    }
}
