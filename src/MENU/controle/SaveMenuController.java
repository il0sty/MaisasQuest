package MENU.controle;

import MENU.visao.SaveMenuInt;
import SAVE.controle.ControlSave;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SaveMenuController implements SaveMenuInt {

    @FXML
    private Label errorLabel;

    @FXML
    private Button menuButton;

    @FXML
    private Button save1;

    @FXML
    private Button save2;

    @FXML
    private Button save3;

    @FXML
    private Button save4;

    @FXML
    private Button save5;

    @FXML
    public void loadSave1(ActionEvent event) throws IOException { // Carregar Save Slot 1
        if(Objects.equals(save1.getText(), "Espaço 1 - Vazio")){
            errorLabel.setVisible(true);
        } else{
            ControlSave.load(0);
            Parent root = FXMLLoader.load(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void loadSave2(ActionEvent event) throws IOException { // Carregar Save Slot 2
        if(Objects.equals(save2.getText(), "Espaço 2 - Vazio")){
            errorLabel.setVisible(true);
        }else{
            ControlSave.load(1);
            Parent root = FXMLLoader.load(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void loadSave3(ActionEvent event) throws IOException { // Carregar Save Slot 3
        if(Objects.equals(save3.getText(), "Espaço 3 - Vazio")){
            errorLabel.setVisible(true);
        }else{
            ControlSave.load(2);
            Parent root = FXMLLoader.load(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void loadSave4(ActionEvent event) throws IOException { // Carregar Save Slot 4
        if(Objects.equals(save4.getText(), "Espaço 4 - Vazio")){
            errorLabel.setVisible(true);
        }else{
            ControlSave.load(3);
            Parent root = FXMLLoader.load(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void loadSave5(ActionEvent event) throws IOException { // Carregar Save Slot 5
        if(Objects.equals(save5.getText(), "Espaço 5 - Vazio")){
            errorAppearence();
        }else{
            ControlSave.load(4);
            Parent root = FXMLLoader.load(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }

    private void errorAppearence(){
        errorLabel.setVisible(true);
    } // Aparecer Erro

    public void execScene(){
        setSaveSlotNames();
    }

    @FXML
    public void returnMenu(ActionEvent event) throws IOException { // retornar para o menu
        Parent root = FXMLLoader.load(getClass().getResource("../visao/MainMenu.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    void setSaveSlotNames() { // setar save slots que aparecerão
        save1.setText(ControlSave.writeSaveSlot1());
        save2.setText(ControlSave.writeSaveSlot2());
        save3.setText(ControlSave.writeSaveSlot3());
        save4.setText(ControlSave.writeSaveSlot4());
        save5.setText(ControlSave.writeSaveSlot5());
    }
}