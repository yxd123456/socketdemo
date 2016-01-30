import java.net.Socket;
import java.util.Vector;

/*
 * 用于连接各个客户端
 * @author Administrator
 *
 */
public class ChatManager {
	
	private static ChatManager chatManager;
	
	private ChatManager(){
		
	}
	
	public static ChatManager getInstance(){
		if(chatManager == null){
			chatManager = new ChatManager();
		}
		return chatManager;
	}
	
	Vector<ChatSocket> 	vector = new Vector<ChatSocket>();
	
	public void add(ChatSocket chatSocket){
		vector.add(chatSocket);
	}
	
	public void publish(ChatSocket chatSocket, String str){
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket cs = vector.get(i);
			if(!cs.equals(chatSocket)){
				cs.out(str);
			}
		}
	}
	
}
