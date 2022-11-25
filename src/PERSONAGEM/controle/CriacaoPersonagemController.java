package PERSONAGEM.controle;

import PERSONAGEM.visao.PersonagemInt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.Objects;

public class CriacaoPersonagemController implements PersonagemInt {

    int valueFor = 0;
    int valueAgi = 0;
    int valueCon = 0;
    int valueRef = 0;
    int valueEsp = 0;
    int valueSor = 0;

    @FXML
    private TextField nameField;
    @FXML
    private MenuButton classBox;
    @FXML
    private MenuButton forBox;
    @FXML
    private MenuButton agiBox;
    @FXML
    private MenuButton conBox;
    @FXML
    private MenuButton refBox;
    @FXML
    private MenuButton espBox;
    @FXML
    private MenuButton sorBox;
    @FXML
    private Button startButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button menuButton;
    @FXML
    private Label errorLabel;
    @FXML
    public void selectGuerreiro(ActionEvent event) {
        classBox.setText("Guerreiro");
    }

    @FXML
    public void selectBarbaro(ActionEvent event) {
        classBox.setText("Bárbaro");
    }

    @FXML
    public void selectLadrao(ActionEvent event) {
        classBox.setText("Ladrão");
    }

    @FXML
    public void selectMago(ActionEvent event) {
        classBox.setText("Mago");
    }

    @FXML
    public void selectForasteiro(ActionEvent event) {
        classBox.setText("Forasteiro");
    }

    @FXML
    void for0(ActionEvent event) {
        forBox.setText("0");
        valueFor=0;
    }

    @FXML
    void for1(ActionEvent event) {
        forBox.setText("1");
        valueFor=1;
    }

    @FXML
    void for2(ActionEvent event) {
        forBox.setText("2");
        valueFor=2;
    }

    @FXML
    void for3(ActionEvent event) {
        forBox.setText("3");
        valueFor=3;
    }

    @FXML
    void agi0(ActionEvent event) {
        agiBox.setText("0");
        valueAgi = 0;
    }

    @FXML
    void agi1(ActionEvent event) {
        agiBox.setText("1");
        valueAgi = 1;
    }

    @FXML
    void agi2(ActionEvent event) {
        agiBox.setText("2");
        valueAgi = 2;
    }

    @FXML
    void agi3(ActionEvent event) {
        agiBox.setText("3");
        valueAgi = 3;
    }

    @FXML
    void con0(ActionEvent event) {
        conBox.setText("0");
        valueCon = 0;
    }

    @FXML
    void con1(ActionEvent event) {
        conBox.setText("1");
        valueCon = 1;
    }

    @FXML
    void con2(ActionEvent event) {
        conBox.setText("2");
        valueCon = 2;
    }

    @FXML
    void con3(ActionEvent event) {
        conBox.setText("3");
        valueCon = 3;
    }

    @FXML
    void ref0(ActionEvent event) {
        refBox.setText("0");
        valueRef = 0;
    }

    @FXML
    void ref1(ActionEvent event) {
        refBox.setText("1");
        valueRef = 1;
    }

    @FXML
    void ref2(ActionEvent event) {
        refBox.setText("2");
        valueRef = 2;
    }

    @FXML
    void ref3(ActionEvent event) {
        refBox.setText("3");
        valueRef = 3;
    }
    @FXML
    void esp0(ActionEvent event) {
        espBox.setText("0");
        valueEsp = 0;
    }
    @FXML
    void esp1(ActionEvent event) {
        espBox.setText("1");
        valueEsp = 1;
    }

    @FXML
    void esp2(ActionEvent event) {
        espBox.setText("2");
        valueEsp = 2;
    }

    @FXML
    void esp3(ActionEvent event) {
        espBox.setText("3");
        valueEsp = 3;
    }

    @FXML
    void sor0(ActionEvent event) {
        sorBox.setText("0");
        valueSor = 0;
    }

    @FXML
    void sor1(ActionEvent event) {
        sorBox.setText("1");
        valueSor = 1;
    }

    @FXML
    void sor2(ActionEvent event) {
        sorBox.setText("2");
        valueSor = 2;
    }

    @FXML
    void sor3(ActionEvent event) {
        sorBox.setText("3");
        valueSor = 3;
    }

    @FXML
    public void returnMenuButton(ActionEvent event) throws IOException { // Voltar para o menu
        Parent root = FXMLLoader.load(getClass().getResource("../../MENU/visao/MainMenu.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void openHelpWindow(ActionEvent event) throws IOException{ // Abrir janela de ajuda
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../HELP/visao/personagemHelp.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Maisa's Quest");
        stage.getIcons().add(new Image("Imagens/icon.png"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void goToPraca(ActionEvent event) throws IOException{ // Ir para praça
        Parent root = FXMLLoader.load(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
        FXMLLoader story = new FXMLLoader(getClass().getResource("../../HISTORIA/visao/historia.fxml"));
        Parent roottwo = story.load();
        Stage storyshow = new Stage();
        storyshow.setTitle("Maisa's Quest");
        storyshow.getIcons().add(new Image("Imagens/icon.png"));
        storyshow.setScene(new Scene(roottwo));
        storyshow.show();
    }

    @FXML
    public void validCharacter(ActionEvent event) throws IOException { // Verificar se o personagem criado é valido
        int totalAtb = valueFor+valueAgi+valueCon+valueRef+valueEsp+valueSor;
        if(totalAtb != 12){
            errorLabel.setText("Distribuição dos Atributos Inválida!");
        } else if (Objects.equals(classBox.getText(), "")){
            errorLabel.setText("Por Favor, Selecione uma Classe!");
        } else if (Objects.equals(nameField.getText(), "")){
            errorLabel.setText("Por Favor, Digite um Nome!");
        } else {
            ControlCharacterCreation.CreateCharacter(nameField.getText(),classBox.getText(),valueFor,valueRef
                    ,valueCon,valueAgi,valueEsp,valueSor);
            goToPraca(event);
        }
    }
}
