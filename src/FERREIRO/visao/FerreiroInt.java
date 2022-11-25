package FERREIRO.visao;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface FerreiroInt {
    void openHelp(ActionEvent event) throws IOException;
    void returnMenu(ActionEvent event) throws IOException;
    void upgAttack(ActionEvent event);
    void upgLife(ActionEvent event);
}
