package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Jackal extends Inimigo{

    private static String nome = "Jackal";
    private static int dadoAtaque = 1;
    private static int dadoDano = 8;
    private static int forca = 1;
    private static int ref = 2;
    private static int con = 1;
    private static int agi = 3;
    private static int valor = 7;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Jackal";
    private Jackal(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Jackal(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(8+random.nextInt(8)+con));
    }

}
