package TAVERNA.visao;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface TavernaInt {
    void returnMenu(ActionEvent event) throws IOException;
    void restAction(ActionEvent event);
    void helpAction(ActionEvent event) throws IOException;
    void buyPotAction(ActionEvent event);
}
