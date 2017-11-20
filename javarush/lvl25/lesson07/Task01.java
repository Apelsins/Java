package lvl25.lesson07;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* Работать в поте лица!
Реализуйте логику метода interrupt, который должен прерывать трэд предварительно закрыв используемые ресурсы
Используйте метод super-класса в блоке finally
*/
public class Task01 extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Task01(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt()  {
        try {
            //implement logic here
            socket.close();
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {}
    }
}