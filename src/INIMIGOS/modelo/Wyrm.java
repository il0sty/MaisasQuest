package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Wyrm extends Inimigo{

    private static String nome = "Pseudo Dragão";
    private static int dadoAtaque = 1;
    private static int dadoDano = 12;
    private static int forca = 3;
    private static int ref = 1;
    private static int con = 1;
    private static int agi = 2;
    private static int valor = 11;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Pseudodragon";
    private Wyrm(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Wyrm(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(30+random.nextInt(30)+con));
    }

}
