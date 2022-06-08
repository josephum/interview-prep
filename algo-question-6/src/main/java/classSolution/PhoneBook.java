package classSolution;


import org.w3c.dom.Node;

import java.util.*;

public class PhoneBook {

    PhoneNode head;
    PhoneNode tail;

    Map<String,PhoneNode> map = new HashMap<>();

    int size;


    boolean isEmpty(){
        return head == null;
    }

    void print() {

        PhoneNode current = head;

        if (isEmpty()) throw new NoSuchElementException("List is empty");

        while (current != null){
            System.out.print(current.toString() + " -> ");
            current = current.next;

            if (current == null) System.out.println(" -> null");
        }

    }

    public void add(Contact contact){ // O(1) space , O(1) time

        PhoneNode newNode = new PhoneNode(contact);
        map.put(contact.email,newNode);

        // Empty
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public PhoneNode findByName(String firstName) {

        if (isEmpty()) throw new NoSuchElementException("List is empty");

        PhoneNode current = head;

        while (current != null) {

            if (current.contact.firstName.equalsIgnoreCase(firstName)) {
                return current;
            }

            current = current.next;
        }

        throw new NoSuchElementException("There is no phone contact with firstName: " + firstName);

    }

    public PhoneNode findByNameOptimized(String email) {
        return map.get(email);
    }

    public List<PhoneNode> findAllByLastName(String lastName) {

        if (isEmpty()) throw new NoSuchElementException("List is empty");

        List<PhoneNode> list = new ArrayList<>();

        PhoneNode current = head;

        while (current != null) {

            if (current.contact.lastName.equalsIgnoreCase(lastName)) {
                list.add(current);
            }

            current = current.next;
        }

        if (list.isEmpty()) {
            throw new NoSuchElementException("There is no matching record with lastName: " + lastName);
        }

        return list;
    }

    public List<PhoneNode> findAll() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");

        List<PhoneNode> list = new ArrayList<>();
        PhoneNode current = head;

        while (current != null) {
            list.add(current);
            current = current.next;
        }
        return list;
    }

    public PhoneNode deleteByName(String firstName) {
        if (isEmpty()) throw new NoSuchElementException("List is empty");

        PhoneNode previous = head;
        PhoneNode current = head;

        while (current != null) {

            if (current.contact.firstName.equalsIgnoreCase(firstName)) {
                if (current == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                    }
                } else if (current == tail){
                    previous.next = null;
                    tail = previous;
                } else {
                    previous.next = current.next;
                }

            }

            previous = current;
            current = current.next;

        }
        return null;
    }







}
