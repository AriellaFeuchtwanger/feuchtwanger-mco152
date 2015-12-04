package feuchtwanger.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket = new Socket("www.google.com", 80); // 80 is the http port

		String httpRequestString = "GET /index.html\n\n"; // *request your
															// computer sends to
															// the server
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write(httpRequestString);
		out.flush();
		
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String s;
		while((s = reader.readLine()) != null){
			System.out.println(s);
		}
		
		socket.close();
	}
}
