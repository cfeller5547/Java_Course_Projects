package application;
	
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class Main extends Application implements EventHandler<ActionEvent> {
	
	Button button;
	Button button2;
	TextField textField = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
		try {

			HBox hbox = new HBox();
			button = new Button();
			button2 = new Button();
			
			
			button.setText("increment");
			button2.setText("decrement");
			primaryStage.setTitle("Increment Decrement by Three");
			
			hbox.getChildren().addAll(button,button2,textField);
			
			button.setTranslateX(10);
			button.setTranslateY(20);
			button2.setTranslateX(300);
			button2.setTranslateY(20);
			button.setOnAction(this);
			button2.setOnAction(this);
			
			Scene s = new Scene(hbox, 450, 100);
			primaryStage.setScene(s);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == button) {
		textField.setText(String.valueOf(Integer.parseInt(textField.getText())+1));
	}
		if(event.getSource() == button2) {
			textField.setText(String.valueOf(Integer.parseInt(textField.getText())-1));
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
