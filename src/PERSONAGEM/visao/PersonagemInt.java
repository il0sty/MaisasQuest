package PERSONAGEM.visao;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface PersonagemInt {
    void selectGuerreiro(ActionEvent event);
    void selectBarbaro(ActionEvent event);
    void selectLadrao(ActionEvent event);
    void selectMago(ActionEvent event);
    void selectForasteiro(ActionEvent event);
    void returnMenuButton(ActionEvent event) throws IOException;
    void openHelpWindow(ActionEvent event) throws IOException;
    void goToPraca(ActionEvent event) throws IOException;
    void validCharacter(ActionEvent event) throws IOException;
}
