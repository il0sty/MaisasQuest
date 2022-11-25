import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage MainMenu) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MENU/visao/MainMenu.fxml"));
        Parent root = loader.load();
        MainMenu.setScene(new Scene(root,600,400));
        MainMenu.show();
        MainMenu.setTitle("Maisa's Quest");
        MainMenu.getIcons().add(new Image(Start.class.getResourceAsStream("Imagens/icon.png")));
    }
}

