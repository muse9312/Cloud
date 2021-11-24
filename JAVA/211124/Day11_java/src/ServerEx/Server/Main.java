package ServerEx.Server;

import java.io.IOException;

import ServerEx.Client.EchoClientEx;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            EchoClientEx client = new EchoClientEx();
        } catch (IOException e) {
            System.out.println("Sorket Create Error");
        }

    }

}
