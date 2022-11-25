package MENU.visao;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface MainInt {
    void ngButtonAction(ActionEvent event) throws IOException;
    void loadButtonAction(ActionEvent event) throws IOException;
    void difficultyButtonAction(ActionEvent event) throws IOException;
    void continueButtonAction(ActionEvent event) throws IOException;
}
