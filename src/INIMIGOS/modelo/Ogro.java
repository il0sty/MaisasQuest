package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Ogro extends Inimigo{

    private static String nome = "Ogro";
    private static int dadoAtaque = 1;
    private static int dadoDano = 10;
    private static int forca = 3;
    private static int ref = 0;
    private static int con = 3;
    private static int agi = 0;
    private static int valor = 10;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Ogre";
    private Ogro(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Ogro(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(35+random.nextInt(35)+con));
    }

}
