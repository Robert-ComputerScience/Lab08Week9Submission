/*
Instructions
Write a program that uses a SinglyLinkedList that gets populated by prime numbers from 0 to n.
Then move the prime numbers that has the digit '3' into another linked list.
After that find the sum of numbers in the second list.  (n should be less than 1,000,000).

Due date is extended till Monday 04/10/2023 11:59 pm.
For example, the sum of the prime numbers (with 3 digit) between 0 and n=100 is (3+ 13+  23+ 31+ 37+ 43+  53+73+83 )= 359.





 */
class Lab08Demo
{
    LinkedList firstList = new LinkedList();
    LinkedList secondList = new LinkedList();
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public  void addPrimesToList(int n) {
        int sum = 0;
        System.out.println("Prime numbers from 0 to " + n + ":");
        for (int i = 0; i <= n; i++) {
            int val = i;
            if (isPrime(val)) {
                firstList.append(new Node(val));
                String valAsString = String.valueOf(val);
                if (valAsString.contains("3")) {
                    secondList.append(new Node(val));
                    sum += val;

                }

            }

        }
        System.out.println("Sum Secondlist equal val:" + sum);
    }



    public static void main(String[] args)
    {
        Lab08Demo demo = new Lab08Demo();
        demo.addPrimesToList(50);



    }





}
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void append(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void prepend(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }



    public void insertAfter(Node currentNode, Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else if (currentNode == tail) {
            tail.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }


    public void removeAfter(Node currentNode) {
        if (currentNode == null && head != null) {
            // Special case: remove head
            Node succeedingNode = head.next;
            head = succeedingNode;
            if (succeedingNode == null) {
                // Last item was removed
                tail = null;
            }
        }
        else if (currentNode.next != null) {
            Node succeedingNode = currentNode.next.next;
            currentNode.next = succeedingNode;
            if (succeedingNode == null) {
                // Remove tail
                tail = currentNode;
            }
        }
    }




}