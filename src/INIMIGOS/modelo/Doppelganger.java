package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Doppelganger extends Inimigo{

    private static String nome = "Doppelganger";
    private static int dadoAtaque = 1;
    private static int dadoDano = 10;
    private static int forca = 2;
    private static int ref = 2;
    private static int con = 2;
    private static int agi = 2;
    private static int valor = 10;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Doppelganger";
    private Doppelganger(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor, String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor, link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Doppelganger(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(25+random.nextInt(25)+con));
    }

}
