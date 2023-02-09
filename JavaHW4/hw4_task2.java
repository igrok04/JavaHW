// =================================================================
// 2.Реализуйте очередь с помощью LinkedList со следующими методами:
// - enqueue() - помещает элемент в конец очереди,
// - dequeue() - возвращает первый элемент из очереди и удаляет его,
// - first() - возвращает первый элемент из очереди, не удаляя.
// ===========================================================================================================================================

package JavaHW4;
import java.util.LinkedList;


public class hw4_task2 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            enqueue(ll, getRandomNumber()); //заполняем случайными числами
        }
        System.out.println(ll);

        System.out.println(enqueue(ll, dequeue(ll))); // поместили первый элемент в конец очереди
        System.out.println(ll); 

        System.out.println(dequeue(ll)); // удалили первый элемент        
        System.out.println(ll);

        System.out.println(first(ll)); // вывели первый элемент
        System.out.println(ll); 

    }
    
    public static boolean enqueue(LinkedList<Integer> ll, int num) {// помещает элемент в конец очереди
        ll.addLast(num);
        return true;
        
    }

    public static int dequeue(LinkedList<Integer> ll) { // возвращает первый элемент из очереди и удаляет его
        int num = ll.get(0);
        ll.remove(0);
        return num;
    }

    public static int first(LinkedList<Integer> ll) { // возвращает первый элемент из очереди, не удаляя
        int num = ll.get(0);
        return num;
    }

    public static int getRandomNumber() { // генерирует случайное число
        double x = (Math.random() * 99);
        int num = (int) x;
        return num;
    }
}
