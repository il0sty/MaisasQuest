package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Beholder extends Inimigo{

    private static String nome = "Beholder";
    private static int dadoAtaque = 3;
    private static int dadoDano = 12;
    private static int forca = 5;
    private static int ref = 5;
    private static int con = 2;
    private static int agi = 6;
    private static int valor = 20;
    private static String link = "https://forgottenrealms.fandom.com/wiki/Beholder";
    static Random random = new Random();

    private Beholder(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor, String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Beholder(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(60+random.nextInt(60)+con));
    }

}
