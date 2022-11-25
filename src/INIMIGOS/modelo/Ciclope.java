package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Ciclope extends Inimigo{

    private static String nome = "Ciclope";
    private static int dadoAtaque = 1;
    private static int dadoDano = 12;
    private static int forca = 4;
    private static int ref = 0;
    private static int con = 4;
    private static int agi = 0;
    private static int valor = 12;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Cyclops#:~:text=Cyclopes%20were%20one%20of%20the,that%20blended%20with%20their%20surroundings";
    private Ciclope(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor, String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Ciclope(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(35+random.nextInt(35)+con));
    }

}
