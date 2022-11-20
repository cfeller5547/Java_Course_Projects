import java.util.Scanner;

public class SocketManager {

	public static void main(String[] args) {
		
		//first get port for this server.
		System.out.print("Enter port for this server to listen on: ");
		int iPort = new Scanner(System.in).nextInt();

		//Next get IP address and port of server to connect to.
		System.out.print("Enter IP address of server to connect to: ");
		String sOtherServerIP = new Scanner(System.in).nextLine();
		System.out.print("Enter port of server to connect to: ");
		int iOtherServerPort = new Scanner(System.in).nextInt();
		
		//start up the server thread.
		SocketServer oServer = new SocketServer(iPort);
		Thread oServerThread = new Thread(oServer);
		oServerThread.start();
		
		
		try {Thread.sleep(1000);}catch(Exception ex) {}
		
	
		
		// Loop to handle sending messages to server from client.
		while(true) {
			
			SocketClient oClient = new SocketClient();
			//get message to send
			System.out.print("Enter three comma seperated numbers: ");
			String sMessage = new Scanner(System.in).nextLine();
			
			
			String sReply = oClient.connectForOneMessage(sOtherServerIP, iOtherServerPort, sMessage);
			
			System.out.println("[client]: reply received: " + sReply);
			
			
		}
		
	}

}
