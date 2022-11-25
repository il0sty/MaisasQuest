package TAVERNA.controle;

import LOJISTA.modelo.Lojista;
import TAVERNA.modelo.Taverna;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TavernaTalkController implements Initializable {
    @FXML
    ImageView showStory;

    Image first = new Image("Imagens/historia/tavernaFirst.png");
    Image end = new Image("Imagens/historia/tavernaEnd.png");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Taverna.isEndTaverna() && Taverna.getPotionsVendidas()==0){
            showStory.setImage(first);
            Taverna.setEndTaverna(false);
        } else{
            showStory.setImage(end);
            Taverna.setEndTaverna(true);
            Taverna.setLimPotions(10);
        }
    }
}
