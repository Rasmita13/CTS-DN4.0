class Task {
    String id, name, status;

    public Task(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}

class Node {
    Task data;
    Node next;

    public Node(Task data) {
        this.data = data;
    }
}

public class TaskApp {
    Node head;

    public void add(Task t) {
        Node newNode = new Node(t);
        newNode.next = head;
        head = newNode;
    }

    public Node search(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.id.equals(id))
                return current;
            current = current.next;
        }
        return null;
    }

    public void delete(String id) {
        if (head == null) return;

        if (head.data.id.equals(id)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.id.equals(id))
            current = current.next;

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data.id + " | " + current.data.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskApp list = new TaskApp();
        list.add(new Task("T101", "Fix Bug", "Open"));
        list.add(new Task("T102", "Develop Feature", "InProgress"));
        list.add(new Task("T103", "Code Review", "Pending"));
        System.out.println("--- All Tasks ---");
        list.traverse();

        System.out.println("--- After Deleting T102 ---");
        list.delete("T102");
        list.traverse();
    }
}
