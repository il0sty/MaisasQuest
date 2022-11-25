package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Ghost extends Inimigo{

    private static String nome = "Espectro";
    private static int dadoAtaque = 1;
    private static int dadoDano = 6;
    private static int forca = 1;
    private static int ref = 8;
    private static int con = 0;
    private static int agi = 8;
    private static int valor = 8;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Specter";
    private Ghost(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Ghost(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(10+random.nextInt(10)+con));
    }

}
