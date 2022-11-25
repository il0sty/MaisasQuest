package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Boitata extends Inimigo{

    private static String nome = "Boitatá";
    private static int dadoAtaque = 2;
    private static int dadoDano = 10;
    private static int forca = 2;
    private static int ref = 3;
    private static int con = 5;
    private static int agi = 4;
    private static int valor = 14;
    private static String link = "https://mundoeducacao.uol.com.br/folclore/boitata.htm";
    static Random random = new Random();

    private Boitata(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor, String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Boitata(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(35+random.nextInt(35)+con));
    }

}
