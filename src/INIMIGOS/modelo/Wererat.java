package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Wererat extends Inimigo{

    private static String nome = "Wererat";
    private static int dadoAtaque = 2;
    private static int dadoDano = 10;
    private static int forca = 2;
    private static int ref = 2;
    private static int con = 2;
    private static int agi = 4;
    private static int valor = 15;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Wererat#:~:text=A%20wererat%20in%20humanoid%20form,often%20have%20thin%2C%20ragged%20mustaches";
    private Wererat(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Wererat(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(30+random.nextInt(30)+con));
    }

}
