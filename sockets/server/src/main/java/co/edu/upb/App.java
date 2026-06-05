package co.edu.upb;

import java.net.ServerSocket;
import java.util.ArrayList;

import co.edu.upb.java_server_socket.JavaServerSocket;
import co.edu.upb.server.Server;
import co.edu.upb.server.SocketProcess;

/**
 * Hello world!
 *
 */
public class App {
    public static void main() {
        System.out.println("Java Server Socket");

        /*
         * New Java Socket instance
         */
        JavaServerSocket javaServerSocket = new JavaServerSocket(1802, 100);
        ServerSocket serverSocket = javaServerSocket.get();
        if (serverSocket == null) {
            System.out.println("ServerSocket is null");
            return;
        }

        /*
         * New server instance
         */
        SocketProcess server = new Server(serverSocket);

        /*
         * Bind server accept
         */
        if (!server.bind()) {
            System.out.println("Server bind failed");
            return;
        }

        /*
         * Session get requests from client
         */
        ArrayList<Object> dataRequest = (ArrayList<Object>) server.listen();

        /*
         * Response to client
         */
        ArrayList<Object> dataResponse = new ArrayList<>();
        dataResponse.add("Hello from server your request is: ");
        dataRequest.forEach(dataResponse::add);
        dataResponse.add(0);
        server.response(dataResponse);

        /*
         * Close server
         */
        if (!server.close()) {
            System.out.println("Server close failed");
            return;
        }

        System.out.println("Java Server Socket closed");
    }
}
