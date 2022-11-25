package FERREIRO.controle;

import FERREIRO.visao.FerreiroInt;
import PERSONAGEM.controle.ControlCharacter;
import PERSONAGEM.modelo.Personagem;
import FERREIRO.modelo.Ferreiro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FerreiroViewController implements Initializable, FerreiroInt {

    @FXML
    private Label atkShow;

    @FXML
    private ImageView bg;

    @FXML
    private Label errorLabel;

    @FXML
    private Button helpButton;

    @FXML
    private Label lifeShow;

    @FXML
    private Label moneyShow;

    @FXML
    private Label priceUpgAttack;

    @FXML
    private Label priceUpgLife;

    @FXML
    private Button returnMenuButton;

    @FXML
    private Button upgAttackButton;

    @FXML
    private Button upgLifeButton;

    @FXML
    private Label yorgText;

    @FXML
    public void openHelp(ActionEvent event) throws IOException { // Abre a tela de ajuda do ferreiro
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../HELP/visao/ferreiroHelp.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Maisa's Quest");
        stage.getIcons().add(new Image("Imagens/icon.png"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void returnMenu(ActionEvent event) throws IOException { // Volta para a praça
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void upgAttack(ActionEvent event) { // Compra da melhoria de ataque
        if(Personagem.getDinheiro()<Ferreiro.getPriceAttackUpg()){ // Caso nao tenha dinheiro para a melhoria
            yorgText.setText("YORG: Não está esperando que eu faça esse trabalho de graça, não é?");
            errorLabel.setText("Você não possui dinheiro suficiente para comprar esse upgrade");

        } else if(Ferreiro.getQtyAttackUpg()>=4){ // Caso todas as melhorias tenham sido compradas
            yorgText.setText("YORG: Não acho que sua arma possa ficar melhor do que isso");
            errorLabel.setText("Não há como melhorar mais sua arma");
        } else { // Caso possa melhorar o ataque
            Personagem.setDadoAtaque(Personagem.getDadoAtaque()+1);
            ControlCharacter.pagar(Ferreiro.getPriceAttackUpg());
            Ferreiro.setQtyAttackUpg();
            showMoney();
            showAtk();
            showPriceAtk();
            yorgText.setText("YORG: Aqui está! Só não faça meu trabalho ser em vão!");
            errorLabel.setText("Seu ataque foi melhorado");
        }
    }

    @FXML
    public void upgLife(ActionEvent event) {
        if(Personagem.getDinheiro()<Ferreiro.getPriceLifeUpg()){ // Caso nao tenha dinheiro para a melhoria
            yorgText.setText("YORG: Meus materiais não são criados por mágica!");
            errorLabel.setText("Você não possui dinheiro suficiente para comprar esse upgrade");

        } else if(Ferreiro.getQtyLifeUpg()>=4){ // Caso todas as melhorias tenham sido compradas
            yorgText.setText("YORG: Se eu tocar nela novamente, você mal conseguirá carrega-la!");
            errorLabel.setText("Não há como aumentar mais sua vida");
        } else { // Caso possa melhorar a vida
            switch (Ferreiro.getQtyLifeUpg()){
                case 0,1 ->Personagem.setVida(((Personagem.getVida())*2) + Personagem.getConstituicao());
                case 2 -> Personagem.setVida(Personagem.getVida() + (Personagem.getVida()/2) + Personagem.getConstituicao());
                case 3 -> Personagem.setVida(Personagem.getVida() + (Personagem.getVida()/3) + Personagem.getConstituicao());
            }
            ControlCharacter.pagar(Ferreiro.getPriceLifeUpg());
            Ferreiro.setQtyLifeUpg();
            Personagem.setUpgVida(Personagem.getUpgVida()+1);
            yorgText.setText("YORG: Está feito, só não estrague muito ela!");
            errorLabel.setText("Sua vida foi aumentada");
            showMoney();
            showVida();
            showPriceVida();
        }
    }

    private void defaultYorgText(){
        yorgText.setText("YORG: Minha forja está sempre acesa");
    } // Fala do Ferreiro ao entrar na pagina
    void showVida(){
        lifeShow.setText(String.valueOf(Personagem.getVida()));
    } // Mostrar vida (Total)
    void showAtk(){
        atkShow.setText(Personagem.dado());
    } // Mostrar dado de ataque (Qty de dado + Valor do dado)
    void showPriceVida() { // Mostrar preço da melhoria de vida
        if (Ferreiro.getQtyLifeUpg() >= 4) { // Caso todas as melhorias tenham sido compradas
            priceUpgLife.setText("MAX");
        } else { // Caso existam melhorias disponiveis
            priceUpgLife.setText(String.valueOf(Ferreiro.getPriceLifeUpg()));
        }
    }

    void showPriceAtk(){ // Mostrar preço da melhoria de ataque
        if(Ferreiro.getQtyAttackUpg()>=4){// Caso todas as melhorias tenham sido compradas
            priceUpgAttack.setText("MAX");
        } else { // Caso existam melhorias disponiveis
            priceUpgAttack.setText(String.valueOf(Ferreiro.getPriceAttackUpg()));
        }
    }
    void showMoney(){
        moneyShow.setText(String.valueOf(Personagem.getDinheiro()));
    } // Mostrar dinheiro do personagem

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        defaultYorgText();
        showVida();
        showAtk();
        showMoney();
        showPriceAtk();
        showPriceVida();
        if((Ferreiro.isEndFerreiro() && Ferreiro.getQtyAttackUpg()<4 && Ferreiro.getQtyLifeUpg()<4) ||
                (!Ferreiro.isEndFerreiro() && Ferreiro.getQtyAttackUpg()==4 && Ferreiro.getQtyLifeUpg()==4)){ // Apresentação da história do ferreiro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/FerreiroTalk.fxml"));
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
