package MyPrograms.Chapter_5;

/**
 * Created by ATarasevich on 27.06.2017.
 */

class Link {
    public int dData;
    public Link next;

    public Link(int dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}

class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public void insert(int value) {
        Link newLink = new Link(value);
        Link previous = null;
        Link current = first;

        while (current != null && value >= current.dData) {
            previous = current;
            current = current.next;
        }

        // Queue is empty
        if (previous == null) {
            Link temp = first;
            first = newLink;
            newLink.next = temp;
            return;
        }
        // Not found
        if (current == null) {
            previous.next = newLink;
        }
        else { // OK
            previous.next = newLink;
            newLink.next = current;
        }
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void display() {
        Link current  = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

class PriorityQueue {
    private FirstLastList firstLastList;

    public PriorityQueue() {
        firstLastList = new FirstLastList();
    }

    public boolean isEmpty() {
        return firstLastList.isEmpty();
    }

    public void insertData(int data) {
        firstLastList.insert(data);
    }

    public int delete() {
       return firstLastList.deleteFirst().dData;
    }

    public void displayQueue() {
        firstLastList.display();
    }

}

public class PriorityQueue_5_1 {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.insertData(10);
        priorityQueue.insertData(20);
        priorityQueue.insertData(50);
        priorityQueue.insertData(10);
        priorityQueue.insertData(26);

        priorityQueue.displayQueue();

        priorityQueue.insertData(70);
        priorityQueue.insertData(2);

        priorityQueue.displayQueue();

        System.out.println(priorityQueue.delete());
        System.out.println(priorityQueue.delete());
        System.out.println(priorityQueue.delete());
        System.out.println(priorityQueue.delete());

        priorityQueue.displayQueue();
    }
}
