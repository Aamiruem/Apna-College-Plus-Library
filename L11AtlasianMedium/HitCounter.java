
import java.util.Deque;
import java.util.LinkedList;

public class HitCounter {

    @SuppressWarnings("FieldMayBeFinal")
    private Deque<int[]> deque;
    private int total;

    public HitCounter() {
        deque = new LinkedList<>();
        total = 0;
    }

    // Record a hit at the given timestamp
    public void hit(int timestamp) {
        if (deque.isEmpty() || deque.getLast()[0] != timestamp) {
            deque.addLast(new int[]{timestamp, 1});
        } else {
            deque.getLast()[1]++;
        }
        total++;
    }

    // Return the number of hits in the past 300 seconds
    public int getHits(int timestamp) {
        while (!deque.isEmpty()) {
            int firstTimestamp = deque.getFirst()[0];
            if (timestamp - firstTimestamp >= 300) {
                total -= deque.getFirst()[1];
                deque.pollFirst();
            } else {
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        HitCounter recordHit = new HitCounter();
        recordHit.hit(1);
        recordHit.hit(2);
        recordHit.hit(3);
        recordHit.hit(4);
        System.out.println(recordHit.getHits(300) + " " + recordHit.getHits(301));
    }
}
