package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Dreth extends Inimigo{

    private static String nome = "Dretch";
    private static int dadoAtaque = 1;
    private static int dadoDano = 8;
    private static int forca = 1;
    private static int ref = 0;
    private static int con = 0;
    private static int agi = 0;
    private static int valor = 5;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Dretch";
    private Dreth(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Dreth(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(15+random.nextInt(15)+con));
    }

}
