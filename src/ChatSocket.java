import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import javax.xml.ws.handler.MessageContext.Scope;

public class ChatSocket extends Thread {
	
	Socket socket;
	
	public ChatSocket(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	public void out(String str){
		try {
			socket.getOutputStream().write(str.getBytes("utf-8"));
			sleep(500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader
					(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				ChatManager.getInstance().publish(this, line);
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
