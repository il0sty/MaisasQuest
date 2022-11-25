package LOJISTA.visao;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface LojistaInt {
    void buyItem(ActionEvent event);
    void openHelp(ActionEvent event) throws IOException;
    void returnPraca(ActionEvent event) throws IOException;
}
