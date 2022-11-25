package HELP.controle;

import HELP.visao.HelpInt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PersonagemHelpController implements HelpInt {

    Image atributos = new Image("Imagens/helpScreen/atributos.png");
    Image barbaro = new Image("Imagens/helpScreen/barbaro.png");
    Image guerreiro = new Image("Imagens/helpScreen/guerreiro.png");
    Image ladrao = new Image("Imagens/helpScreen/ladrao.png");
    Image mago = new Image("Imagens/helpScreen/mago.png");
    Image forasteiro = new Image("Imagens/helpScreen/forasteiro.png");


    @FXML
    private MenuButton box;

    @FXML
    private ImageView helpShow;

    @FXML
    public void showAtributos(ActionEvent event) { // Apresenta a tela de ajuda dos atributos
        helpShow.setImage(atributos);
        box.setText("Atributos");
    }

    @FXML
    public void showBarbaro(ActionEvent event) { // Apresenta a tela de ajuda da classe Bárbaro
        helpShow.setImage(barbaro);
        box.setText("Bárbaro");
    }

    @FXML
    public void showForasteiro(ActionEvent event) { // Apresenta a tela de ajuda da classe Forasteiro
        helpShow.setImage(forasteiro);
        box.setText("Forasteiro");
    }

    @FXML
    public void showGuerreiro(ActionEvent event) { // Apresenta a tela de ajuda da classe Guerreiro
        helpShow.setImage(guerreiro);
        box.setText("Guerreiro");
    }

    @FXML
    public void showLadrao(ActionEvent event) { // Apresenta a tela de ajuda da classe Ladrão
        helpShow.setImage(ladrao);
        box.setText("Ladrão");
    }

    @FXML
    public void showMago(ActionEvent event) { // Apresenta a tela de ajuda da classe Mago
        helpShow.setImage(mago);
        box.setText("Mago");
    }

}
