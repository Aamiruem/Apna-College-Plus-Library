
import java.util.*;

class Pair {

    String x;
    int y;

    public Pair(int y, String x) {
        this.x = x;
        this.y = y;
    }

    int getFirst() {
        return y;
    }

    String getSecond() {
        return x;
    }
}

public class LoggerRateLimiter {

    public static void main(String[] args) {
        Pair[] logs = new Pair[5];
        logs[0] = new Pair(1, "foo");
        logs[1] = new Pair(2, "bar");
        logs[2] = new Pair(3, "foo");
        logs[3] = new Pair(8, "fba");
        logs[4] = new Pair(11, "foo");

        Hashtable<String, Integer> hash = new Hashtable<>();

        for (Pair log : logs) {
            if (hash.containsKey(log.getSecond())) {
                int oldTime = hash.get(log.getSecond());
                if (log.getFirst() - oldTime >= 10) {
                    System.out.print("true ");
                    hash.put(log.getSecond(), log.getFirst());
                } else {
                    System.out.print("false ");
                }
            } else {
                System.out.print("true ");
                hash.put(log.getSecond(), log.getFirst());
            }
        }
    }
}
