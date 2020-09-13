import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 8001);
             FileInputStream fis = new FileInputStream("client_send.txt");
             FileOutputStream fos = new FileOutputStream("client_recv.txt")) {

            int ch;
            // client_send.txt�̓��e���T�[�o�ɑ��M
            OutputStream output = socket.getOutputStream();
            while ((ch = fis.read()) != -1) {
                output.write(ch);
            }
            // �I�����������߁A�[���𑗐M
            // output.write(0);
            // �T�[�o����̕ԐM��client_recv.txt�ɏo��
            InputStream input = socket.getInputStream();
            while ((ch = input.read()) != -1) {
                fos.write(ch);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
