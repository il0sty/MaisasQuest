package PRACA.controle;

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

public class SaveGameController implements SaveMenuInt {

    @FXML
    private Label errorLabel;

    @FXML
    private Button menuButton;

    @FXML
    private Text messageLoad;

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
    public void loadSave1(ActionEvent event) {
        ControlSave.salvar(0);
        setSaveSlotNames();
    }

    @FXML
    public void loadSave2(ActionEvent event) {
        ControlSave.salvar(1);
        setSaveSlotNames();
    }

    @FXML
    public void loadSave3(ActionEvent event) {
        ControlSave.salvar(2);
        setSaveSlotNames();
    }

    @FXML
    public void loadSave4(ActionEvent event) {
        ControlSave.salvar(3);
        setSaveSlotNames();
    }
    @FXML
    public void loadSave5(ActionEvent event) {
        ControlSave.salvar(4);
        setSaveSlotNames();
    }


    @FXML
    public void returnMenu(ActionEvent event) throws  IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../visao/PracaMenu.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setSaveSlotNames() {
        save1.setText(ControlSave.writeSaveSlot1());
        save2.setText(ControlSave.writeSaveSlot2());
        save3.setText(ControlSave.writeSaveSlot3());
        save4.setText(ControlSave.writeSaveSlot4());
        save5.setText(ControlSave.writeSaveSlot5());
    }

}
