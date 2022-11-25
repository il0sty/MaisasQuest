package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class FeraDeslocadora extends Inimigo{

    private static String nome = "Fera Deslocadora";
    private static int dadoAtaque = 2;
    private static int dadoDano = 12;
    private static int forca = 4;
    private static int ref = 5;
    private static int con = 2;
    private static int agi = 5;
    private static int valor = 15;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Displacer_beast";
    private FeraDeslocadora(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new FeraDeslocadora(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(50+random.nextInt(50)+con));
    }

}
