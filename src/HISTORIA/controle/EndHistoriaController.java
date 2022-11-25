package HISTORIA.controle;

import PERSONAGEM.modelo.Personagem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class EndHistoriaController implements Initializable {
    @FXML
    ImageView showStory;
    Image vitoria = new Image("Imagens/historia/vitória.png");
    Image derrota = new Image("Imagens/historia/derrota.png");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Personagem.isDeathState()){ // Mostra a tela de derrota caso o jogador morra na luta final
            showStory.setImage(derrota);
        } else showStory.setImage(vitoria); // Mostra a tela de vitoria caso o vilao morra na luta final
    }
}
