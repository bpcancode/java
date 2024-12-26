import java.io.*;

class Person implements Serializable {

    private String name;
    private int age;
    private String gender;

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name=" + name + "\nAge=" + age + "\nGender" + gender;
    }
}

class RawObject {

    public static void main(String[] args) {
        Person p1 = new Person("Ram", 14, "Male");
        Person p2 = new Person("Hari", 15, "Male");
        Person p3 = new Person("Sita", 15, "FeMale");

        try {
            FileOutputStream out = new FileOutputStream("myObj.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(out);

            objOut.writeObject(p1);
            objOut.writeObject(p2);
            objOut.writeObject(p3);
            out.close();
            objOut.close();

            FileInputStream in = new FileInputStream("myObj.txt");
            ObjectInputStream objIn = new ObjectInputStream(in);

            Person pr1 = (Person) objIn.readObject();
            Person pr2 = (Person) objIn.readObject();
            Person pr3 = (Person) objIn.readObject();

            System.out.println(pr1);
            System.out.println(pr2);
            System.out.println(pr3);

            in.close();
            objIn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
