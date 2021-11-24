package Event.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MyFrame {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null; // 바이트기반
        OutputStreamWriter os = null; // 문자기반 출력스트림 write()

        // 파일에 있는 내용(Data)를 가지고 올려고 합니다.
        try {
            // 바이트기반 파일 입력 스트림
            fis = new FileInputStream("test.txt");

            // 문자기반의 파일 입력 스트림으로 변경
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            String line = null;

            while ((line = br.readLine()) != null) {
                // 파일로 출력 output.txt

            }

        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("읽을 문자가 없습니다.");
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (isr != null)
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("정상종료");
    }
};
