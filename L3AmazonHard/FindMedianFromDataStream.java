import java.util.*;
public class FindMedianFromDataStream {
        private final PriorityQueue<Integer> minHeap; // Stores the larger half
        private final PriorityQueue<Integer> maxHeap; // Stores the smaller half

        public FindMedianFromDataStream() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            maxHeap.offer(num); // Add to maxHeap first
            minHeap.offer(maxHeap.poll()); // Balance by moving the largest from maxHeap to minHeap

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll()); // Ensure maxHeap has at least as many elements as minHeap
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek(); // If maxHeap has more elements, it's the median
            }
            return (minHeap.peek() + maxHeap.peek()) / 2.0; // Average of the two middle values
        }

        public static void main(String[] args) {
            FindMedianFromDataStream obj = new FindMedianFromDataStream();
            obj.addNum(1);
            obj.addNum(2);
            System.out.println(obj.findMedian()); // Output: 1.5
            obj.addNum(3);
            System.out.println(obj.findMedian()); // Output: 2.0
        }
    }
