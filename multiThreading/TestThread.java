import javax.naming.ldap.Rdn;

class RunnableDemo implements Runnable {

    String tname;

    RunnableDemo(String n) {
        tname = n;
        System.out.println("Creating:" + tname);
    }

    public void run() {
        System.out.println("Running:" + tname);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + tname + " Printing: " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread: " + tname + " interrupted");
        }
        System.out.println("Thread: " + tname + " exiting");
    }
}

public class TestThread {

    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("One");
        Thread t1 = new Thread(R1);
        t1.start();
        RunnableDemo R2 = new RunnableDemo("Two");
        Thread t2 = new Thread(R2);
        t2.start();
    }
}
