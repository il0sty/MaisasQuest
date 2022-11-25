package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Gorila extends Inimigo{

    private static String nome = "Gorila";
    private static int dadoAtaque = 1;
    private static int dadoDano = 12;
    private static int forca = 4;
    private static int ref = 2;
    private static int con = 5;
    private static int agi = 2;
    private static int valor = 13;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Gorilla";
    private Gorila(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Gorila(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(35+random.nextInt(35)+con));
    }

}
