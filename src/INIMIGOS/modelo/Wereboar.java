package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Wereboar extends Inimigo{

    private static String nome = "Wereboar";
    private static int dadoAtaque = 2;
    private static int dadoDano = 10;
    private static int forca = 2;
    private static int ref = 2;
    private static int con = 2;
    private static int agi = 4;
    private static int valor = 15;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Wereboar#:~:text=A%20wereboar%20tended%20to%20be,humanoid%2Fboar%20hybrid%20with%20tusks";
    private Wereboar(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Wereboar(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(30+random.nextInt(30)+con));
    }

}
