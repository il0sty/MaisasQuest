package MENU.controle;

import MENU.visao.MainInt;
import SAVE.controle.ControlSave;
import PERSONAGEM.modelo.Personagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, MainInt {

    @FXML
    private ImageView bgMain;
    @FXML
    private Button continue_buttom;

    @FXML
    private Button difficulty_buttom;

    @FXML
    private Button load_buttom;

    @FXML
    private AnchorPane main_menu_screen;

    @FXML
    private Button ng_buttom;

    @FXML
    private Label errorLabel;

    @FXML
    public void ngButtonAction(ActionEvent event) throws IOException { // Ir para a criação do personagem
        Parent root = FXMLLoader.load(getClass().getResource("../../PERSONAGEM/visao/CriarPersonagem.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void loadButtonAction(ActionEvent event) throws IOException { // Ir para a página de carregar um jogo

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../MENU/visao/SaveMenu.fxml"));
        Parent root = loader.load();
        SaveMenuController acessControler = loader.getController();
        acessControler.execScene();
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void difficultyButtonAction(ActionEvent event) throws IOException{ // Ir para a pagina de dificuldade
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/DifficultyMenu.fxml"));
        Parent root = loader.load();
        DifficultyMenuController acessControler = loader.getController();
        acessControler.execScene();
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void continueButtonAction(ActionEvent event) throws IOException { // Carregar AutoSave

        if(Personagem.getNome()==null){
            errorLabel.setText("Nenhum AutoSave Encontrado");
        } else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControlSave.createSaveFile();
    }
}
