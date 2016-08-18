package fx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Principal extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		
		 abrirVentana(stage,"Juego Principal","jugarPregunta.fxml");
		
	}
	
	@FXML
	public void clickBotonContestarPregunta(Stage stage) throws IOException{
		
		abrirVentana(stage,"Pregunta","panelPregunta.fxml");
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void abrirVentana(Stage stage,String titulo,String panelFXML) throws IOException{

		Button btn = new Button();
        btn.setText("Abrir pregunta");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	Parent panel;
				try {
					panel = FXMLLoader.load(getClass().getResource("panelPregunta.fxml"));
				
					Scene scene = new Scene(panel);
	            	
					Stage stagePregunta = new Stage();
					
	            	stagePregunta.setScene(scene);
	            	stagePregunta.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}           	
            }
        });
        
        stage.setTitle("Pregunta");       
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
		
	}
}
