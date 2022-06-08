public class Tree {

    Node head;

    public Tree() {
        this.head = null;
    }

    public Node insertAtTheEnd(int value){
        Node newNode = new Node();
        newNode.value = value;

        if (head == null) {
            head = newNode;
            newNode.next = null;
            return newNode;
        }

        Node current = head;
        while(current.next != null){ // O(N) time, O(1) space
            current = current.next;
        }
        current.next = newNode;

        return newNode;
    }

    public Node insertAtTheBeginning(int value){ // O(1) time, O(1) space
        Node newNode = new Node();
        newNode.value = value;

        if (head == null) {
            newNode.next = null;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        return newNode;
    }

    public void print(){

        if (head==null) {
            System.out.println("null");
            return;
        }

        Node current = head;
        System.out.println("Nodes are (from header): ");

        while(current!=null){ // O(N) time, O(1) space
            System.out.print(current.value+" -> ");
            current = current.next;
        }
        // Print null after last node
        System.out.println("null");
    }

    public void keepMRemoveN(int m, int n){

        if (head==null) {
            return;
        }

        Node current = head;
        Node beforeRemove = head;
        Node afterRemove;
        int counterToKeep = 0;
        int counterToRemove = 0;
        boolean keepEndFound = false;
        while(current!=null){

            // Start the keep counter
            counterToKeep++;
            // Start the remove counter
            if (keepEndFound) {
                counterToRemove++;

                if (counterToRemove==n+1) {
                    afterRemove=current;
                    beforeRemove.next =afterRemove;
                    counterToKeep=1;
                    counterToRemove=0;
                    keepEndFound=false;
                }

                if (current.next ==null){
                    beforeRemove.next =null;
                }
            }

            if (counterToKeep==m) {
                beforeRemove=current;
                keepEndFound=true;
            }

            current = current.next;
        }

    }

    public void keepMRemoveN_2(int m, int n){

        if (head==null) {
            return;
        }

        Node current = head;
        Node preCurrent = head;

        while(current!=null){ // O(N) time, O(1) space

            for (int i = 0; i < m && current!=null; i++) {
                preCurrent = current;
                current = current.next;
            }

            for (int i = 0; i < n && current!=null; i++) {
                current = current.next;
            }

            if (preCurrent!=current){
                preCurrent.next=current;
            }

        }

    }

    public void delete(int value){

        if (head == null) {
            return;
        }

        Node current = head;
        Node preCurrent = head;

        while (current != null) { // O(N) time, O(1) space

            if (current.value == value){
                if (current == head) {
                    head = current.next;
                } else {
                    preCurrent.next = current.next;
                    current = current.next;
                }
            } else {
                preCurrent = current;
                current = current.next;
            }
        }
    }

    public void deleteRepeatedSorted(){

        if (head == null) return;

        Node current = head;
        Node preCurrent = head;

        while (current != null) { // O(N) time, O(1) space

            if (current.value == preCurrent.value && current != preCurrent){
                if (current == head) {
                    head = current.next;
                } else {
                    preCurrent.next = current.next;
                    current = current.next;
                }
            } else {
                preCurrent = current;
                current = current.next;
            }
        }
    }


}
