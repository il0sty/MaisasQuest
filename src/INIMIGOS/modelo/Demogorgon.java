package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Demogorgon extends Inimigo{

    private static String nome = "* Demogorgon, O Principe dos Demônios";
    private static int dadoAtaque = 2;
    private static int dadoDano = 20;
    private static int forca = 5;
    private static int ref = 5;
    private static int con = 5;
    private static int agi = 5;
    private static int valor = 100;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Demogorgon";
    private Demogorgon(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Demogorgon(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(100+random.nextInt(100)+con));
    }

}
