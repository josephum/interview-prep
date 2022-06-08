package classSolution;

public class PhoneNode {
    PhoneNode next;

    Contact contact;

    public PhoneNode(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "PhoneNode{" +
                "contact=" + contact +
                '}';
    }
}

