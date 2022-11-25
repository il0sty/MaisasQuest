package COLISEU.visao;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public interface ColiseuInt {
    void attackButomClicked(MouseEvent event);
    void defenderButtonClicked(MouseEvent event);
    void especialButtonClicked(MouseEvent event);
    void potionButtonClicked(MouseEvent event);
    void sairButtonClicked(MouseEvent event) throws IOException;
    void helpButtonClicked(MouseEvent event) throws  IOException;
    void runButomClicked(MouseEvent event) throws IOException;
}
