package FERREIRO.modelo;

import PERSONAGEM.modelo.Personagem;

import java.io.Serializable;

public class Ferreiro implements Serializable{
    private static int qtyAttackUpg; // Usado para saber quantas vezes o ataque foi melhorado
    private static int qtyLifeUpg; // Usado para saber quantas vezes a vida foi melhorada
    private static boolean endFerreiro; // Configuração da história do ferreiro

    public Ferreiro(int atkUpg, int hpUpg, boolean endFerreiro){ // Setando o ferreiro a partir de um save
        setQtyLifeUpg(hpUpg);
        setQtyAttackUpg(atkUpg);
        setEndFerreiro(endFerreiro);
    }

    public Ferreiro(){}

    public static void setFerreiro(){ // Setando o ferreiro a partir de um novo jogo
        setQtyAttackUpg(0);
        setQtyLifeUpg(0);
        setEndFerreiro(true);
    }



    public static int getQtyAttackUpg() {
        return qtyAttackUpg;
    }

    public static int getQtyLifeUpg() {
        return qtyLifeUpg;
    }
    public static void setQtyAttackUpg(int qtyAttackUpg) {
        Ferreiro.qtyAttackUpg = qtyAttackUpg;
    }
    public static void setQtyAttackUpg() {
        Ferreiro.qtyAttackUpg++;
    }

    public static void setQtyLifeUpg(int qtyLifeUpg) {
        Ferreiro.qtyLifeUpg = qtyLifeUpg;
    }
    public static void setQtyLifeUpg() {
        Ferreiro.qtyLifeUpg++;
    }

    public static void setEndFerreiro(boolean endFerreiro) {
        Ferreiro.endFerreiro = endFerreiro;
    }

    public static boolean isEndFerreiro() {
        return endFerreiro;
    }

    public static int getPriceLifeUpg() { // Define o preço da melhoria de vida
        int priceLifeUpg = 0;
        switch (qtyLifeUpg){
            case 0 -> priceLifeUpg = (100 - (5* Personagem.getSorte()));
            case 1 -> priceLifeUpg = (150 - (7* Personagem.getSorte()));
            case 2 -> priceLifeUpg = (200 - (10* Personagem.getSorte()));
            case 3 -> priceLifeUpg = (275 - (12* Personagem.getSorte()));
        }
        return priceLifeUpg;
    }

    public static int getPriceAttackUpg() { // Define o preço da melhoria de ataque
        int priceAttackUpg = 0;
        switch (qtyAttackUpg){
            case 0 -> priceAttackUpg = 150 - (5*Personagem.getSorte());
            case 1 -> priceAttackUpg = 185 - (7*Personagem.getSorte());
            case 2 -> priceAttackUpg = 225 - (10*Personagem.getSorte());
            case 3 -> priceAttackUpg = 300 - (12*Personagem.getSorte());
        }
        return priceAttackUpg;
    }
}
