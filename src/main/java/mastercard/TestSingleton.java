package mastercard;

public class TestSingleton {
    private static volatile TestSingleton singleton = null;
    //private static final Object lockObj = new Object();

    private TestSingleton() {
        if (singleton != null) {
            throw new IllegalStateException("Singleton already initialized.");
        }

    }

    public static TestSingleton initialize() {
        if (singleton == null) {
            synchronized(TestSingleton.class) {
                if (singleton == null) {
                    singleton = new TestSingleton();
                }
            }
        }

        return singleton;
    }
}
