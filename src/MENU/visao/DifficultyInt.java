package MENU.visao;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface DifficultyInt {
    void returnMenu(ActionEvent event) throws IOException;
    void setEasy(ActionEvent event);
    void setHard(ActionEvent event);
    void setNormal(ActionEvent event);
}
