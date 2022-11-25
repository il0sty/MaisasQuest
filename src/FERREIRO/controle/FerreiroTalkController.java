package FERREIRO.controle;

import COLISEU.controle.ColiseuController;
import FERREIRO.modelo.Ferreiro;
import PERSONAGEM.controle.ControlCharacter;
import PERSONAGEM.modelo.Personagem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class FerreiroTalkController implements Initializable {

    @FXML
    ImageView showStory;

    Image first = new Image("Imagens/historia/ferreiroFirst.png");
    Image end = new Image("Imagens/historia/endFerreiro.png");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Ferreiro.isEndFerreiro() && Ferreiro.getQtyAttackUpg()==0 && Ferreiro.getQtyLifeUpg()==0){
            showStory.setImage(first);
            Ferreiro.setEndFerreiro(false);
        } else {
            showStory.setImage(end);
            Ferreiro.setEndFerreiro(true);
            Personagem.setDadoAtaque(Personagem.getDadoAtaque()+1);
            Personagem.setVida(Personagem.getVida()*2);
        }
    }
}
