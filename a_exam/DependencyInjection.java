package a_exam;

import java.io.PrintStream;
import java.util.function.Supplier;
import java.io.ByteArrayOutputStream;


class TimerTest {
    private final MockClock mockClock = new MockClock(100);
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final Timer timer = new Timer(mockClock, new PrintStream(outputStream));
/*
    @Test
    void shouldReturnResultAndPrintElapsedTime() {
        String result = timer.time("test", () -> {
            mockClock.setTime(123);
            return "Hello world!";
        });

        assertEquals("Hello world!", result);
        assertEquals("The operation 'test' took 23 ms\n", outputStream.toString(StandardCharsets.UTF_8));
    }*/
}
interface Clock {
    long getTime();
}

class MockClock implements Clock {
    private long time;

    public MockClock(long time) {
        this.time = time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public long getTime() {
        return time;
    }
}

class RealClock implements Clock {
    @Override
    public long getTime() {
        return System.currentTimeMillis();
    }
}

class Timer {
    private final Clock clock;
    private final PrintStream printStream;

    public Timer(Clock clock, PrintStream printStream) {
        this.clock = clock;
        this.printStream = printStream;
        }

    public <T> T time(String operation, Supplier<T> action) {
        long start = clock.getTime();
        T result = action.get();
        long end = clock.getTime();
        String message = "The operation '%s' took %d ms".formatted(operation, end - start);
        printStream.println(message);
        return result;
    }
}

class UntestableTimer{
    public <T> T time(String operation, Supplier<T> action) {
        long start = System.currentTimeMillis();
        T result = action.get();
        long end = System.currentTimeMillis();
        String message = "The operation '%s' took %d ms".formatted(operation, end - start);
        System.out.println(message);
        return result;
    }

}


public class DependencyInjection {
    public static void main(String[] args) {
        Timer timer = new Timer(new RealClock(), System.out);
    }
}
