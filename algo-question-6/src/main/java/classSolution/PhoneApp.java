package classSolution;

public class PhoneApp {

    public static void main(String[] args) {

        Contact contact1 = new Contact("Tom", "Joe", "qwe@gmail.com", "23454321");
        Contact contact2 = new Contact("John", "Smith", "qweee@gmail.com", "23567321");
        Contact contact3 = new Contact("Mark", "Sel", "qwert@gmail.com", "2345454321");
        Contact contact4 = new Contact("Andrei", "Sel", "qderwe@gmail.com", "4545678");
        Contact contact5 = new Contact("Segrei", "Rt", "qwe@gmail.com", "567876");


        PhoneBook book = new PhoneBook();
        book.add(contact1);
        book.add(contact2);
        book.add(contact3);
        book.add(contact4);
        book.add(contact5);


        book.print();

//        System.out.println(book.findByName("Markk"));

//        System.out.println(book.findAllByLastName("Sel123"));
        System.out.println(book.findAll());

    }

}
