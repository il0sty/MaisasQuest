package LOJISTA.controle;

import LOJISTA.modelo.Lojista;
import LOJISTA.visao.LojistaInt;
import SAVE.controle.ControlSave;
import PERSONAGEM.controle.ControlCharacter;
import PERSONAGEM.modelo.Personagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LojistaViewController implements Initializable, LojistaInt {

    @FXML
    private Button buyButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Button helpButton;

    @FXML
    private Label hildaTalk;

    @FXML
    private Label listItens;

    @FXML
    private Label moneyShow;

    @FXML
    private MenuItem n1;

    @FXML
    private MenuItem n2;

    @FXML
    private MenuItem n3;

    @FXML
    private MenuItem n4;

    @FXML
    private MenuItem n5;

    @FXML
    private MenuItem n6;

    @FXML
    private MenuButton numberBox;

    @FXML
    private Button returnButton;

    @FXML
    public void buyItem(ActionEvent event) { // Ação de comprar item
        int selectItem = getItemAvl(Integer.parseInt(numberBox.getText()));
        if (selectItem==20) {
            hildaTalk.setText("HILDA: Sei que meus produtos são excelentes, mas não posso compra-los de você para vender novamente!");
            errorLabel.setText("Você já comprou todos itens disponiveis desse atributo");
        }else if(Personagem.getDinheiro()<Lojista.calcularPreço(selectItem)){
            hildaTalk.setText("HILDA: Não está tentando me passar a perna, não está?");
            errorLabel.setText("Você não possui dinheiro suficiente para comprar esse item");
        } else {
            comprar(selectItem);
            hildaTalk.setText("HILDA: Uma excelente escolha!");
            errorLabel.setText("Item Comprado");
            listItens.setText(String.valueOf(writeLoja()));
            moneyShow.setText(String.valueOf(Personagem.getDinheiro()));
        }
    }

    @FXML
    public void openHelp(ActionEvent event) throws IOException { // Abrir janela de ajuda da lojista
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../HELP/visao/lojistaHelp.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Maisa's Quest");
        stage.getIcons().add(new Image("Imagens/icon.png"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void returnPraca(ActionEvent event) throws IOException { // Retornar para a praça
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
        ControlSave.autoSave();
    }

    @FXML
    void setNumber1(ActionEvent event) {
        numberBox.setText("1");
    }

    @FXML
    void setNumber2(ActionEvent event) {
        numberBox.setText("2");
    }

    @FXML
    void setNumber3(ActionEvent event) {
        numberBox.setText("3");
    }

    @FXML
    void setNumber4(ActionEvent event) {
        numberBox.setText("4");
    }

    @FXML
    void setNumber5(ActionEvent event) {
        numberBox.setText("5");
    }

    @FXML
    void setNumber6(ActionEvent event) {
        numberBox.setText("6");
    }
    public static void comprar(int n){ // Configurações apos comprar um item
        ControlCharacter.pagar(Lojista.calcularPreço(n));
        ArrayList<Integer> attLoja = Lojista.getItensLoja();
        attLoja.set(n, 0);
        Lojista.setItensLoja(attLoja);
        switch (n){
            case 0,1,2 -> ControlCharacter.ModFor(1);
            case 3,4,5 -> ControlCharacter.ModRef(1);
            case 6,7,8 -> ControlCharacter.ModCon(1);
            case 9,10,11 -> ControlCharacter.ModAgi(1);
            case 12,13,14 -> ControlCharacter.ModEsp(1);
            case 15,16,17 -> ControlCharacter.ModSor(1);
        }
    }
    StringBuilder writeLoja(){ // Escrever a loja para mostrar na tela (Baseado no preço e nos itens disponiveis)
        setItemAvl();
        StringBuilder lista = new StringBuilder();
        ArrayList<Integer> itensLoja = Lojista.getItensLoja();
        for (int n = 0; n<itensLoja.size(); n++){
            if(itensLoja.get(n)==1){
                lista.append(setItemNum(n)).append(itensLoja(n)).append(Lojista.calcularPreço(n)).append("\n");
                setItemAvl(n);
            } else if (itensLoja.get(n)==2 && itensLoja.get(n-1)==0){
                lista.append(setItemNum(n)).append(itensLoja(n)).append(Lojista.calcularPreço(n)).append("\n");
                setItemAvl(n);
            } else if (itensLoja.get(n)==3 && itensLoja.get(n-1)==0){
                lista.append(setItemNum(n)).append(itensLoja(n)).append(Lojista.calcularPreço(n)).append("\n");
                setItemAvl(n);
            } else if (itensLoja.get(n)== 0 && n%3==2){
                lista.append("PRODUTOS ESGOTADOS\n");
            }
        }
        return lista;
    }

    String itensLoja(int n){ // Nome dos itens da loja
        String lista = null;
        switch (n){
            case 0 -> lista = " - Luvas Reforçadas de Trolls (+ FORÇA) - $";
            case 1 -> lista = " - Bracelete da Força de Gigantes (+ FORÇA) - $";
            case 2 -> lista = " - Elixir Mágico de Brutus, O Colosso (+ FORÇA) - $";
            case 3 -> lista=" - Diminuição do Peso da Armadura (+ REFLEXOS) - $";
            case 4 -> lista=(" - Tiara da Visão Além do Alcance (+ REFLEXOS) - $");
            case 5 -> lista=(" - Elixir Mágico de Davaran, O Sagaz (+ REFLEXOS) - $");
            case 6 -> lista=(" - Melhoria no Acolchoamento da Armadura (+ CONSTITUIÇÃO) - $");
            case 7 -> lista=(" - Camadas Extras de Aço Dracónico (+ CONSTITUIÇÃO) - $");
            case 8 -> lista=(" - Elixir Mágico de Grung, O Imparável (+ CONSTITUIÇÃO) - $");
            case 9 -> lista=(" - Lubrificamento das Dobras da Armadura (+ AGILIDADE) - $");
            case 10 -> lista=(" - Botas dos Ventos Alpinos (+ AGILIDADE) - $");
            case 11 -> lista=(" - Elixir Mágico de Arslan, O Escorregadio (+ AGILIDADE) - $");
            case 12 -> lista=(" - Encantamentos Recitados pelos Magos Azuis (+ ESPECIAL) - $");
            case 13 -> lista=(" - Runas Ritualisticas de Druidas (+ ESPECIAL) - $");
            case 14 -> lista=(" - Elixir Mágico de Barnatok, O Sábio (+ ESPECIAL) - $");
            case 15 -> lista=(" - Trevo de Quatro Folhas do Quintal da Rainha (+ SORTE) - $");
            case 16 -> lista=(" - Canto da Fortuna dos Corsários Negros (+ SORTE) - $");
            case 17 -> lista=(" - Elixir Mágico de Kythan, O Abençoado (+ SORTE) - $");
        }
        return lista;
    }

    void setItemAvl(int n){ // Setar itens vendidos
        switch(n){
            case 0,1,2 -> Lojista.setItemForAvl(n);
            case 3,4,5 -> Lojista.setItemAgiAvl(n);
            case 6,7,8 -> Lojista.setItemConAvl(n);
            case 9,10,11 -> Lojista.setItemRefAvl(n);
            case 12,13,14 -> Lojista.setItemEspAvl(n);
            case 15,16,17 -> Lojista.setItemSorAvl(n);
        }
    }

    int setItemNum(int n){ // Configuração do numero do tipo baseado em qual item é
        int num = 0;
        switch(n){
            case 0,1,2 -> num = 1;
            case 3,4,5 -> num = 2;
            case 6,7,8 -> num = 3;
            case 9,10,11 -> num = 4;
            case 12,13,14 -> num = 5;
            case 15,16,17 -> num = 6;
        }
        return num;
    }

    void setItemAvl(){ // definição padrao dos itens da loja
        Lojista.setItemForAvl(20);
        Lojista.setItemAgiAvl(20);
        Lojista.setItemConAvl(20);
        Lojista.setItemRefAvl(20);
        Lojista.setItemEspAvl(20);
        Lojista.setItemSorAvl(20);
    }

    int getItemAvl(int n){ // Obter itens da loja
        int avl = 0;
        switch(n){
            case 1 -> avl = Lojista.getItemForAvl();
            case 2 -> avl = Lojista.getItemAgiAvl();
            case 3 -> avl = Lojista.getItemConAvl();
            case 4 -> avl = Lojista.getItemRefAvl();
            case 5 -> avl = Lojista.getItemEspAvl();
            case 6 -> avl = Lojista.getItemSorAvl();
        }
        return avl;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listItens.setText(String.valueOf(writeLoja()));
        hildaTalk.setText("HILDA: Bons negócios são minha expecialidades!");
        moneyShow.setText(String.valueOf(Personagem.getDinheiro()));
        numberBox.setText("1");
        if((Lojista.isEndLojista() && Lojista.countLoja()!=0)||(!Lojista.isEndLojista() && Lojista.countLoja()==0)){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/LojistaTalk.fxml"));
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
