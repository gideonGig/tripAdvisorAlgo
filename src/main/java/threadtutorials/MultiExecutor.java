package threadtutorials;

import java.util.List;
import java.util.stream.Collectors;

public class MultiExecutor {
    private final List<Thread> threads;

    public MultiExecutor(List<Runnable> tasks) {
        threads = tasks.stream().map(Thread::new).collect(Collectors.toList());
    }

    public void executeAll() {
        threads.forEach(Thread::start);
    }
}
