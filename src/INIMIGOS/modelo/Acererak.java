package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Acererak extends Inimigo{

    private static String nome = "* Acererak, O Eterno";
    private static int dadoAtaque = 2;
    private static int dadoDano = 20;
    private static int forca = 5;
    private static int ref = 5;
    private static int con = 5;
    private static int agi = 5;
    private static int valor = 100;

    private static String link = "https://forgottenrealms.fandom.com/wiki/Acererak";

    static Random random = new Random();

    private Acererak(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor, String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor, link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Acererak(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(100+random.nextInt(100)+con));
    }

}
