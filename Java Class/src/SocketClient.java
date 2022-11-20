import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {

	public String connectForOneMessage(String sIP, int iPort, String sMessage) {
		
		try(Socket oSocket = new Socket()){
			
			oSocket.connect(new InetSocketAddress(sIP, iPort), 5000);
			
			
			//preparing for output
			OutputStream output = oSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			
			writer.println(sMessage);
			writer.flush();
			
			//preparing for input
			InputStream input = oSocket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			//get reply back from server
			String sReturn = reader.readLine();
			
			oSocket.close();
			
			return sReturn;
		}
		catch(IOException ex){
			System.out.println("error msg: " + ex.getMessage());
			ex.printStackTrace();
			return null;
			
		}
	}
	
	
}
