package MENU.modelo;

import java.io.Serializable;

public class Dificuldade implements Serializable {
    private static double dificuldade; // Numero para salvar a dificuldade

    public Dificuldade(){
        setDificuldade(1);
    } // Setar dificuldade padrão

    public Dificuldade(double valor){
        setDificuldade(valor);
    } //Carregar Dificuldade

    public static double getDificuldade() {
        return dificuldade;
    } // Retornar valor da Dificuldade

    public static String getDificuldadeName() { // Retornar dificuldade escrita
        if (getDificuldade()==0.75){
            return "Easy";
        } else if(getDificuldade()==1){
            return "Normal";
        } else return "Hard";
    }
    public static void setDificuldade(double dificuldade) {
        Dificuldade.dificuldade = dificuldade;
    }
}
