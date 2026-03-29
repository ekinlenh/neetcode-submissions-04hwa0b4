class LinkedList {
    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head, tail; 
    int currentSize;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    public int get(int index) {
        Node current = head;
        int i = 0;

        while (current != null) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
            i++;
        }

        return -1;
    }

    public void insertHead(int val) {
        Node node = new Node(val);

        node.next = head;
        head = node;

        if (node.next == null) {
            tail = node;
        }

        currentSize++;
    }

    public void insertTail(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
            currentSize++;
            return;
        }

        tail.next = node;
        tail = node; 
        currentSize++;
    }

    public boolean remove(int index) {
        Node current = head;
        Node previous = null;
        int i = 0;

        while (current != null) {
            if (i == index) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }

                if (current == tail) {
                    tail = previous;
                }

                currentSize--;
                return true;
            }

            previous = current;
            current = current.next;
            i++;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> arr = new ArrayList<>();
        Node current = head;

        for (int i = 0; i < currentSize; i++) {
            arr.add(current.data);
            current = current.next;
        }

        return arr;
    }
}
