package ServerEx.Server;

import java.net.*;
import java.io.*;

public class MultiEchoServerEx {
    ServerSocket server; // 서버 소켓
    Socket child; // 클라이언트와 통신하기 위한 소켓

    // 생성자는 오픈할 포트 번호를 전달 받음
    public MultiEchoServerEx(int port) {
        try {
            // 1. 에코 서버 프로그램은 포트를 지정해서 서버 소쳇 생성부터 한다.
            server = new ServerSocket(port);
        } catch (Exception e) { // 서버 소켓 생성에 실패하면
            e.printStackTrace(); // 에러 메시지를 출력하고
            System.exit(0); // 프로그램을 종료한다.
        }

        // 2. 클라이언트의 접속을 항상 받아들일 수 있도록 무한루프를 돌림
        System.out.println("**** 채팅 서버*****");
        System.out.println("서버는 클라이언트 소켓의 접속 요청을 기다리고 있음");

        while (true) {
            try {
                // 클라이언트의 요청이 없으면 대기 상태에 들어감
                // 클라이언트가 접속하는 순간 클라이언트와 통신할 수 있는 소켓을 반환함
                child = server.accept();
                // ****************************************************************************************
                // 접속을 계속 유지하면서 데이터 송수신 하기 위해서 스레드 객체 생성
                EchoServerThread childThread = new EchoServerThread(child);
                Thread t = new Thread(childThread);
                t.start();
                // ****************************************************************************************
            } catch (Exception e) {
                e.printStackTrace(); // 에러 메시지를 출력하고
                System.exit(0); // 프로그램을 종료한다.
            }
        } // while 끝
    }// 생성자 끝

    public static void main(String[] args) {
        new MultiEchoServerEx(5000);// 포트 번호 5000을 오픈한다.
    }// main끝
}// ChatServerEx
 // ****************************************************************************************
 // 접속을 계속 유지하면서 데이터 송수신 하기 위해서 스레드 클래스 생성

class EchoServerThread implements Runnable {
    Socket child; // 클라이언트와 통신하기 위한 소켓

    InputStream is; // 클라이언트와 연결된 입력 스트림 저장
    ObjectInputStream ois; // 클라이언트로부터 데이터를 전송받기 위한 스트림

    OutputStream os; // 클라이언트와 연결된 출력 스트림 저장
    ObjectOutputStream oos;// 클라이언트에게 데이터를 전송하기 위한 스트림

    String receiveData; // 클라이언트로부터 전송받은 데이터를 저장하기 위한 변수

    // 접속 요청한 소켓 객체가 생성자로 보내진다.
    public EchoServerThread(Socket s) {
        // 클라이언트와 통신할 수 있는 소켓 정보를 child에 저장함
        child = s;
        try {
            // 3. 접속이 되면 클라이언트로 부터 아이피 주소를 얻어 출력함
            System.out.println(child.getInetAddress() + "로 부터 연결요청 받음");

            // 4. 클라이언트로 부터 보내진 데이터를 읽이 위해서 클라이언트로부터 입력 스트림을 얻어옴
            is = child.getInputStream();
            // 4-1. 입력 스트림을 ObjectInputStream으로 변환한다.
            ois = new ObjectInputStream(is);

            // 5. 클라이언트로부터 받은 메시지를 다시 보내기 위해서 출력 스트림 생성
            os = child.getOutputStream();
            // 5_1. 출력 스트림을 ObjectOutputStream으로 변환한다.
            oos = new ObjectOutputStream(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                // 4-2. 스트림을 통해 데이터를 읽어옴
                receiveData = (String) ois.readObject();
                // 4-3. 받은 데이터를 확인하기 위해서 서버 화면에 출력
                System.out.println(child.getInetAddress() + "의 메시지:" + receiveData);

                // 5-2. 클라이언트로 부터 받은 데이터를 클라이언트에게 다시 전송함-> 에코:메아리
                oos.writeObject(receiveData);
                oos.flush();
            }
        } catch (Exception e) {
            System.out.println("클라이언트가 강제 종료");
        } finally {
            try {
                is.close();
                os.close();
                ois.close();
                oos.close();
                child.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
};
// ****************************************************************************************
