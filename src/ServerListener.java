import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	
	@Override
	public void run() {
		
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			while(true){
				Socket socket = serverSocket.accept();
				JOptionPane.showMessageDialog(null, "已连接");
				//将socket传递给新的线程
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getInstance().add(cs);
			}
	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
