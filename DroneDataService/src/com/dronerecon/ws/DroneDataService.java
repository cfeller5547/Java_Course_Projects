package com.dronerecon.ws;

        import javax.servlet.*;

        import javax.servlet.http.*;
        import java.io.*;
import java.net.URL;
import java.util.*;
        import java.security.SecureRandom;
        import com.google.gson.*;
               

/**
 *
 * @author Your Name Here :-)
 */
        
        

	

        
public class DroneDataService extends HttpServlet{
	
	int nextTileX; 
	int nextTileY;
	
	
	public void Move(String sDirection) {
		if(sDirection == "right") {
			nextTileX = nextTileX + 1;
         }
         else if(sDirection == "left") {
        	 nextTileX = nextTileX - 1;
         }
         else if(sDirection == "up") {
        	 nextTileY = nextTileY + 1;
         }
         else if(sDirection == "down") {
        	 nextTileY = nextTileY - 1;
         }
         if(nextTileX == 0 && nextTileY == 0) {
        	 sDirection = "stop";
         }
	}
   
	
    public void moveRight(int nextTileX) {
         Move("right");
    }
    
    public void moveLeft(int nextTileX) {
        Move("left");
   }
    
    public void moveUp(int nextTileY) {
        Move("up");
   }
    
    public void moveDown(int nextTileY) {
        Move("down");
   }
    
    
    
    
        

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

      
        String area_id = request.getParameter("area_id");
        String tilex = request.getParameter("tilex");
        String tiley = request.getParameter("tiley");
        String totalcols = request.getParameter("totalcols");
        String totalrows = request.getParameter("totalrows");
        String r = request.getParameter("r");
        String g = request.getParameter("g");
        //r and g
        
        

    	try {

            // Call API.
            URL url = new URL("http://127.0.0.1:8080/dronereconportal/PortalDBService?area_id=" + area_id +  "&tilex=" + tilex + "&tiley=" + tiley + "&r=" + r + "&g=" + g + "");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

       

     // ##############################
        // 3. Calculate next drone move.

        // Determine next tile to move to.
        // Base this on current x and y.
        // Change sDirection if necessary.
        // Drone must serpentine from top left of grid back and forth down.
        // If rows are done, change sDirection to "stop".
    
     
        
        
    	nextTileX = Integer.parseInt(tilex);
        nextTileY = Integer.parseInt(tiley);
    	
    	
         
         for(int v = 0; v < Integer.parseInt(totalrows)/2; v++) {
        	 for(int h = 0; h < Integer.parseInt(totalcols); h++ ) {
        		 moveRight(nextTileX);
        	 }
        	 moveDown(nextTileY);
        	 for(int h = 0; h < Integer.parseInt(totalcols); h++) {
        		 moveLeft(nextTileX);
        	 }
        	 moveDown(nextTileY);
         }
         if(Integer.parseInt(totalrows) % 2 != 0 ) {
        	 moveDown(nextTileY);
         }
         for(int h = 0; h < Integer.parseInt(totalcols); h++ ) {
        	 moveRight(nextTileX);
         }
         
       
        
        
        
       
        

    

        // ##############################



        // ##############################
        // 4. Format & Return JSON string to caller.

        /* Return via out.println() a JSON string like this:
        {"area_id":"[area id from above]", "nextTileX":"[next tile x]", "nextTileY":"[next tile y]", "direction":"[direction string from above]"}
        */
         
         String json =  "{'area_id':'[area id from above]', 'nextTileX':'[next tile x]', 'nextTileY':'[next tile y]', 'direction':'[direction string from above]'}";

         Gson gson = new Gson();
         
         Helper helper = gson.fromJson(json, Helper.class);
       
        out.println(helper);
         
        // ##############################
        
        
        String sR = request.getParameter("r");
        
        try {

            //call portalDBService api and send this tiles data
            URL url = new URL("http://127.0.0.1:8080/dronereconportal/PortalDBService?" + "area_id=1&tilex=1&tiley=1&r=" + sR + "&g=1");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));


        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("An error occurred in callWeatherWebService() in WeatherServiceManager: " + ex.toString());
        }

   
    }
    
    
    class Helper{}
    
    
    

}


    
    


