package LOJISTA.controle;

import FERREIRO.modelo.Ferreiro;
import LOJISTA.modelo.Lojista;
import PERSONAGEM.controle.ControlCharacter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LojistaTalkController implements Initializable {
    @FXML
    ImageView showStory;

    Image first = new Image("Imagens/historia/lojistaFirst.png");
    Image end = new Image("Imagens/historia/endLojista.png");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Lojista.isEndLojista() && Lojista.countLoja()!=0){
            showStory.setImage(first);
            Lojista.setEndLojista(false);
        } else {
            showStory.setImage(end);
            Lojista.setEndLojista(true);
            ControlCharacter.ModFor(1);
            ControlCharacter.ModAgi(1);
            ControlCharacter.ModCon(1);
            ControlCharacter.ModRef(1);
            ControlCharacter.ModEsp(1);
            ControlCharacter.ModSor(1);
        }
    }
}
