package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Norvan extends Inimigo{
    private static String nome = "Principe Novan";
    private static int dadoAtaque = 5;
    private static int dadoDano = 20;
    private static int forca = 10;
    private static int ref = 10;
    private static int con = 10;
    private static int agi = 10;
    private static int valor = 100;
    static Random random = new Random();



    private Norvan(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor, "");
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Norvan(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor);
    }

    private static double calcularVida(){
        return Dificuldade.getDificuldade()*(120+random.nextInt(120)+con);
    }
}
