package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Owlbear extends Inimigo{

    private static String nome = "Owlbear";
    private static int dadoAtaque = 2;
    private static int dadoDano = 8;
    private static int forca = 4;
    private static int ref = 0;
    private static int con = 6;
    private static int agi = 2;
    private static int valor = 10;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Owlbear";
    private Owlbear(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Owlbear(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(30+random.nextInt(30)+con));
    }

}
