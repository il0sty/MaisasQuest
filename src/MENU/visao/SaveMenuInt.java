package MENU.visao;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface SaveMenuInt {
    void loadSave1(ActionEvent event) throws IOException;
    void loadSave2(ActionEvent event) throws IOException;
    void loadSave3(ActionEvent event) throws IOException;
    void loadSave4(ActionEvent event) throws IOException;
    void loadSave5(ActionEvent event) throws IOException;
    void returnMenu(ActionEvent event) throws IOException;
}
