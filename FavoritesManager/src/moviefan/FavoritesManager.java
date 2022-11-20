package moviefan;

public class FavoritesManager {

	String favorite_movie;
	String favorite_actor;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean checkFavoriteMovie(String input) {
		
		if(input.equals(favorite_movie)) {
			return true;
		}
		else {
			return false;
		}
	}
	
public boolean checkFavoriteActor(String input) {
		
		if(input.equals(favorite_actor)) {
			return true;
		}
		else {
			return false;
		}
	}

}
