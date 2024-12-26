import java.io.*;
import java.net.*;
import java.util.*;

class MsgClient {

    public static void main(String[] args) throws IOException {
        Socket cs = new Socket("localhost", 1245);

        Scanner ins = new Scanner(cs.getInputStream());
        PrintWriter outs = new PrintWriter(cs.getOutputStream(), true);

        outs.println("Hello Server");
        String s = ins.nextLine();
        System.out.println("From Server:" + s);
        ins.close();
        outs.close();
        cs.close();
    }
}
