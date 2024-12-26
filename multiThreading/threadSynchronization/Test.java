class Table {

    synchronized void printTable(int n) {
        System.out.print("\nTable of " + n);
        for (int i = 1; i <= 10; i++) {
            System.out.println(i * n + "\t");
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}

class MyThread extends Thread {

    Table t;
    int n;

    MyThread(Table t, int n) {
        this.t = t;
        this.n = n;
    }

    public void run() {
        t.printTable(n);
    }
}

class Test {

    public static void main(String[] args) {
        Table t = new Table();
        MyThread x = new MyThread(t, 4);
        MyThread y = new MyThread(t, 5);
        MyThread z = new MyThread(t, 9);
        x.start();
        y.start();
        z.start();
    }
}
