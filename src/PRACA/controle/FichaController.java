package PRACA.controle;

import PERSONAGEM.modelo.Personagem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FichaController {

    @FXML
    private Label agiLabel;

    @FXML
    private Label attackLabel;

    @FXML
    private Label classeLabel;

    @FXML
    private Label conLabel;

    @FXML
    private Label espLabel;

    @FXML
    private Label forLabel;

    @FXML
    private Label lifeLabel;

    @FXML
    private Label moneyLabel;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label refLabel;

    @FXML
    private Label sorLabel;

    @FXML
    private Label winsLabel;

    public void execStage() {
        nomeLabel.setText(Personagem.getNome());
        classeLabel.setText(Personagem.getClasse());
        lifeLabel.setText(String.valueOf(Personagem.getVida()));
        attackLabel.setText(Personagem.dado());
        winsLabel.setText(String.valueOf(Personagem.getLutasGanhas()));
        forLabel.setText(String.valueOf(Personagem.getForca()));
        agiLabel.setText(String.valueOf(Personagem.getAgilidade()));
        conLabel.setText(String.valueOf(Personagem.getConstituicao()));
        refLabel.setText(String.valueOf(Personagem.getReflexos()));
        espLabel.setText(String.valueOf(Personagem.getEspecial()));
        sorLabel.setText(String.valueOf(Personagem.getSorte()));
        moneyLabel.setText(String.valueOf(Personagem.getDinheiro()));
    }

}
