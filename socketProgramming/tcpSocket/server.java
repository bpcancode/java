import java.io.*;
import java.net.*;
import java.util.*;

class MsgServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1245);
        Socket cs = ss.accept();

        Scanner ins = new Scanner(cs.getInputStream());
        PrintWriter outs = new PrintWriter(cs.getOutputStream(), true);

        String s = ins.nextLine();
        System.out.println("From client:" + s);
        outs.println("Hello Client");

        outs.close();
        ins.close();
        cs.close();
        ss.close();
    }
}
