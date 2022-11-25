package TAVERNA.controle;

import SAVE.controle.ControlSave;
import PERSONAGEM.controle.ControlCharacter;
import PERSONAGEM.modelo.Personagem;
import TAVERNA.modelo.Taverna;
import TAVERNA.visao.TavernaInt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class TavernaViewController implements Initializable, TavernaInt {

    @FXML
    private Button buyPotionButton;

    @FXML
    private Label duncanTalk;

    @FXML
    private Label errorLabel;

    @FXML
    private Button helpButton;

    @FXML
    private Label lifeShow;

    @FXML
    private Label moneyShow;

    @FXML
    private Label potPriceShow;

    @FXML
    private Label potShow;

    @FXML
    private Button restButton;

    @FXML
    private Button returnButton;

    @FXML
    public void buyPotAction(ActionEvent event) { // ação de comprar poção
        if (Personagem.getDinheiro()<Taverna.getPricePotion()){
            duncanTalk.setText("DUNCAN: Não posso lhe vender nada que não possa pagar!");
            errorLabel.setText("Você não posssui dinheiro suficiente para comprar as poções!");
        } else if (Personagem.getPotions()>=Taverna.getLimPotions()){
            duncanTalk.setText("DUNCAN: Desse jeito vai ter que guardar dentro de suas calças");
            errorLabel.setText("A sua algibeira de poções está cheia!");
        } else {
            Personagem.setPotions(Personagem.getPotions()+1);
            Taverna.increasePotionsVendidas();
            ControlCharacter.pagar(Taverna.getPricePotion());
            duncanTalk.setText("DUNCAN: Uma boa compra, de fato");
            errorLabel.setText("Poção Comprada!");
            writePotions();
            writeMoney();
        }
    }

    @FXML
    public void helpAction(ActionEvent event) throws IOException { // abrir janela de ajuda
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../HELP/visao/tavernaHelp.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Maisa's Quest");
        stage.getIcons().add(new Image("Imagens/icon.png"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void restAction(ActionEvent event) { // configurações de descanso da taverna
        if(Personagem.getVida()==Personagem.getVidaAtual()){
            duncanTalk.setText("DUNCAN: Novo em folha e querendo descansar mais?");
            errorLabel.setText("Sua vida está cheia");
        } else {
            Random random = new Random();
            int randomQuote = (random.nextInt(3)+1);
            switch (randomQuote){
                case 1->{
                    duncanTalk.setText("DUNCAN: Os melhores bardos de Ka'arn você só encontra aqui");
                    errorLabel.setText(Personagem.getNome() + " ouviu um pouco da musica do bardo local e recuperou suas energias");
                } case 2 ->{
                    duncanTalk.setText("DUNCAN: Nada melhor que cerveja e amigo para limpar a alma");
                    errorLabel.setText(Personagem.getNome() + " bebeu um pouco com as pessoas da taverna e recuperou suas energias");
                }
                case 3 ->{
                    duncanTalk.setText("DUNCAN: Está tinindo! Parece que acabou de sair da forja");
                    errorLabel.setText(Personagem.getNome() + " tomou um bom banho no lavatório e recuperou suas energias");
                }
            }
            Personagem.setVidaAtual(Personagem.getVida());
            writeLife();
        }

    }

    @FXML
    public void returnMenu(ActionEvent event) throws IOException { // voltar para a praça
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
        ControlSave.autoSave();

    }

    void writeLife(){
        lifeShow.setText(Personagem.getVidaAtual()+"/"+Personagem.getVida());
    }

    void writePotions(){
        potShow.setText(Personagem.getPotions()+"/"+ Taverna.getLimPotions());
    }

    void writeMoney(){
        moneyShow.setText(String.valueOf(Personagem.getDinheiro()));
    }

    void writePricePotions(){
        potPriceShow.setText(String.valueOf(Taverna.getPricePotion()));
    }

    void defaultDuncanTalk(){
        duncanTalk.setText("DUNCAN: Bem vindo a Freedom Ballad, "+Personagem.getNome()+"!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        defaultDuncanTalk();
        writeLife();
        writePotions();
        writeMoney();
        writePricePotions();
        if((Taverna.isEndTaverna() && Taverna.getPotionsVendidas()==0) ||
                (!Taverna.isEndTaverna() && Taverna.getPotionsVendidas()>=25)){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/TavernaTalk.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setTitle("Maisa's Quest");
            stage.getIcons().add(new Image("Imagens/icon.png"));
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
