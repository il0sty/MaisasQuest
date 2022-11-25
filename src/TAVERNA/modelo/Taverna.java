package TAVERNA.modelo;

import PERSONAGEM.modelo.Personagem;

import java.io.Serializable;

public class Taverna implements Serializable {
    private static int limPotions;
    private static int potionsVendidas;

    private static boolean endTaverna;

    public static void setTaverna(){ // Setar taverna quando cria um novo jogo
        setLimPotions(5);
        setPotionsVendidas(0);
        setEndTaverna(true);

    }

    public Taverna(int limPotions, int potionsVendidas, boolean endTaverna){ // Setar taverna quando se carrega um jogo
        setLimPotions(limPotions);
        setPotionsVendidas(potionsVendidas);
        setEndTaverna(endTaverna);
    }
    public Taverna(){
    }
    public static int getLimPotions() {
        return limPotions;
    }

    public static int getPotionsVendidas() {
        return potionsVendidas;
    }

    public static boolean isEndTaverna() {
        return endTaverna;
    }

    public static void setLimPotions(int limPotions) {
        Taverna.limPotions = limPotions;
    }

    public static void setPotionsVendidas(int potionsVendidas) {
        Taverna.potionsVendidas = potionsVendidas;
    }

    public static void setEndTaverna(boolean endTaverna) {
        Taverna.endTaverna = endTaverna;
    }

    public static void increasePotionsVendidas(){
        Taverna.potionsVendidas++;
    }

    public static int getPricePotion() { // calcular preço da poção

        return  (25- Personagem.getSorte());

    }
}
