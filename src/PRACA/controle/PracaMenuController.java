package PRACA.controle;

import PRACA.visao.PracaInt;
import SAVE.controle.ControlSave;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PracaMenuController implements Initializable, PracaInt {

    @FXML
    private Button coliseuButton;

    @FXML
    private Button ferreiroButton;

    @FXML
    private Button ficha;

    @FXML
    private Button lojistaButton;

    @FXML
    private Button menuButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button tavernaButton;

    @FXML
    private Button helpButton;

    @FXML
    public void showHelp(ActionEvent event) throws IOException { //Mostrar ajuda da praça
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../HELP/visao/pracaHelp.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Maisa's Quest");
        stage.getIcons().add(new Image("Imagens/icon.png"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void goToColiseu(ActionEvent event) throws IOException { // Ir para o coliseu
        Parent root = FXMLLoader.load(getClass().getResource("../../COLISEU/visao/Coliseu.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,700,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToFerreiro(ActionEvent event) throws IOException { // Ir para o ferreiro
        Parent root = FXMLLoader.load(getClass().getResource("../../FERREIRO/visao/Ferreiro2.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToLojista(ActionEvent event) throws IOException { // Ir para a lojista
        Parent root = FXMLLoader.load(getClass().getResource("../../LOJISTA/visao/Lojista2.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToSave(ActionEvent event) throws IOException { // Ir para a tela de save
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../PRACA/visao/SaveGame.fxml"));
        Parent root = loader.load();
        SaveGameController acessControler = loader.getController();
        acessControler.setSaveSlotNames();
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToTaverna(ActionEvent event) throws IOException { // Ir para a taverna
        Parent root = FXMLLoader.load(getClass().getResource("../../TAVERNA/visao/Taverna2.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void returnMenu(ActionEvent event) throws IOException { // Voltar para o menu
        Parent root = FXMLLoader.load(getClass().getResource("../../MENU/visao/MainMenu.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showFicha(ActionEvent event) throws IOException { // Mostrar a ficha do personagem
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/Ficha.fxml"));
        Parent root = loader.load();
        FichaController acessControler = loader.getController();
        acessControler.execStage();
        Stage stage = new Stage();
        stage.setTitle("Maisa's Quest");
        stage.getIcons().add(new Image("Imagens/icon.png"));
        stage.setScene(new Scene(root));
        stage.show();
        ControlSave.autoSave();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControlSave.autoSave();
    }
}
