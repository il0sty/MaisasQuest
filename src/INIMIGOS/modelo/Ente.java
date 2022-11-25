package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Ente extends Inimigo{

    private static String nome = "Ente";
    private static int dadoAtaque = 2;
    private static int dadoDano = 6;
    private static int forca = 2;
    private static int ref = -2;
    private static int con = 5;
    private static int agi = -3;
    private static int valor = 8;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Treant";
    private Ente(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Ente(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(40+random.nextInt(40)+con));
    }

}
