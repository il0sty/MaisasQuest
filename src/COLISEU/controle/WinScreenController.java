package COLISEU.controle;

import PERSONAGEM.modelo.Personagem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class WinScreenController implements Initializable {
    @FXML
    private Label winCounts;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        winCounts.setText(String.valueOf(Personagem.getLutasGanhas()));
    }
}
