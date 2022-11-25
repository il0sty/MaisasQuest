package PRACA.visao;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface PracaInt {
    void showHelp(ActionEvent event) throws IOException;
    void goToColiseu(ActionEvent event) throws IOException;
    void goToFerreiro(ActionEvent event) throws IOException;
    void goToLojista(ActionEvent event) throws IOException;
    void goToSave(ActionEvent event) throws IOException;
    void goToTaverna(ActionEvent event) throws IOException;
    void returnMenu(ActionEvent event) throws IOException;
    void showFicha(ActionEvent event) throws IOException;
}
