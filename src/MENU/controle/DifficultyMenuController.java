package MENU.controle;

import MENU.modelo.Dificuldade;
import MENU.visao.DifficultyInt;
import SAVE.controle.ControlSave;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DifficultyMenuController implements DifficultyInt {

    @FXML
    private Button buttonEasy;

    @FXML
    private Button buttonHard;

    @FXML
    private Button buttonNormal;

    @FXML
    private Text difficultyShow;

    @FXML
    private Button menuButton;

    @FXML
    public void returnMenu(ActionEvent event) throws IOException { // voltar para o menu
        Parent root = FXMLLoader.load(getClass().getResource("../../MENU/visao/MainMenu.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setEasy(ActionEvent event) { // Setar dificuldade como fácil
        Dificuldade.setDificuldade(0.75);
        setDifficultyShow(Dificuldade.getDificuldadeName());
        ControlSave.saveDifficulty();
    }

    @FXML
    public void setHard(ActionEvent event) { // Setar dificuldade como hard
        Dificuldade.setDificuldade(1.5);
        setDifficultyShow(Dificuldade.getDificuldadeName());
        ControlSave.saveDifficulty();
    }

    @FXML
    public void setNormal(ActionEvent event) { // Setar dificuldade como normal
        Dificuldade.setDificuldade(1);
        setDifficultyShow(Dificuldade.getDificuldadeName());
        ControlSave.saveDifficulty();
    }

    void setDifficultyShow(String dif){
        difficultyShow.setText(dif);
    } // Escrever dificuldade
    public void execScene(){
        setDifficultyShow(Dificuldade.getDificuldadeName());
    }


}
