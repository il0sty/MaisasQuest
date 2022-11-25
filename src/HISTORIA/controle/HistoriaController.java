package HISTORIA.controle;

import COLISEU.controle.ColiseuController;
import INIMIGOS.controle.ControlInimigoCombat;
import INIMIGOS.modelo.Inimigo;
import PERSONAGEM.modelo.Personagem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoriaController implements Initializable {

    Image welcome = new Image("Imagens/historia/welcome.png");
    Image desempenho = new Image("Imagens/historia/desempenho.png");
    Image ameaca = new Image("Imagens/historia/ameaca.png");
    Image principe = new Image("Imagens/historia/principe.png");
    Image pista = new Image("Imagens/historia/pista.png");
    Image ritual = new Image("Imagens/historia/ritual.png");
    Image magia = new Image("Imagens/historia/magia.png");
    Image resposta = new Image("Imagens/historia/resposta.png");
    Image pedido = new Image("Imagens/historia/pedido.png");
    Image batalha = new Image("Imagens/historia/batalha.png");

    @FXML
    private ImageView showStory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Apresenta a história (Dependendo da quantidade de Lutas Ganhas)
        if(Personagem.getLutasGanhas() == 0){ //
            showStory.setImage(welcome);
        } else if(Personagem.getLutasGanhas() == 20){
            showStory.setImage(desempenho);
        } else if(Personagem.getLutasGanhas() == 40){
            showStory.setImage(ameaca);
        } else if(Personagem.getLutasGanhas() == 60){
            showStory.setImage(principe);
        } else if(Personagem.getLutasGanhas() == 80){
            showStory.setImage(pista);
        } else if(Personagem.getLutasGanhas() == 100){
            showStory.setImage(ritual);
        } else if(Personagem.getLutasGanhas() == 120){
            showStory.setImage(magia);
        } else if(Personagem.getLutasGanhas() == 140){
            showStory.setImage(resposta);
        } else if(Personagem.getLutasGanhas() == 160 && !ColiseuController.isFinalBoss()){
            showStory.setImage(pedido);
        } else {
            showStory.setImage(batalha);
        }
    }
}
