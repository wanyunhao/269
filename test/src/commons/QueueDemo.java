package commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

import java.util.Queue;

/**
 * 队列
 */
public class QueueDemo {
    public static void main(String[] args) {
//        circular();
//        readonly();
        predicate();
    }

    /**
     * 断言队列
     */
    public static void predicate() {
        CircularFifoQueue<String> queue = new CircularFifoQueue<>(2);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        Predicate notNull = NotNullPredicate.INSTANCE;

        Queue<String> queue1 = PredicatedQueue.predicatedQueue(queue,notNull);
//        queue1.add(null);

    }

    /**
     * 只读队列
     */
    public static void readonly() {
        CircularFifoQueue<String> queue = new CircularFifoQueue<>(2);
        queue.add("a");
        queue.add("b");
        queue.add("c");

        Queue<String> readonlyque = UnmodifiableQueue.unmodifiableQueue(queue);
//        readonlyque.add("d");
    }

    /**
     * 循环队列
     */
    public static void circular() {
        CircularFifoQueue<String> queue = new CircularFifoQueue<>(2);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        
        //查看
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i));
        }
    }
}
