import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable{

	private int thisServerPort;
	
	/**
	 * 		this constructor forces port to be passed in that is necessary for startup
	 */
	public SocketServer(int iPort) {
		thisServerPort = iPort;
	}
	
	
	/**
	 * this thread listens for connecting clients and receives messages
	 */
	
	public void run() {
		
		
		try(ServerSocket oServerSocket = new ServerSocket(thisServerPort)){
			
			System.out.println("server is listening on port " + thisServerPort);
			
			while(true) {
				
				//wait for client connection
				Socket oSocket = oServerSocket.accept();
				System.out.println("[server]: new client connected: "+ oSocket.getRemoteSocketAddress());
				
				//preparing for input
				InputStream input = oSocket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				
				//preparing for output
				OutputStream output = oSocket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true);
				
				String sReceivedMessage = reader.readLine();
				System.out.println("[server]: server received message: " + sReceivedMessage);
				
				writer.println("Server received your message. ");
				
				//now turn to array
			
				writer.println("Converting message to array");
				
				String arr[] = sReceivedMessage.split(",");
				
				if(arr.length!= 3) {
					System.out.println("incorrect try again");
					
				}
				
				else {
				int var1;
				int var2;
				int var3;
				int add_vars;
				
				var1 =  Integer.parseInt(arr[0]);
				var2 =  Integer.parseInt(arr[1]);
				var3 =  Integer.parseInt(arr[2]);
				add_vars = var1 + var2 + var3;
				
				writer.println("sum: " + add_vars);
				
				writer.flush();
				
				
				}
			}
			
		}
		catch(IOException ex) {
			System.out.println("error msg: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
}
