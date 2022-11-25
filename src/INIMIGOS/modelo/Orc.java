package INIMIGOS.modelo;

import java.util.Random;

public class Orc extends Inimigo{

    private static String nome = "Orc";
    private static int dadoAtaque = 1;
    private static int dadoDano = 10;
    private static int forca = 3;
    private static int ref = -2;
    private static int con = 2;
    private static int agi = -3;
    private static int valor = 8;
    static Random random = new Random();
    private static String link = "https://forgottenrealms.fandom.com/wiki/Orc";
    private Orc(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor,String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new Orc(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return 12+random.nextInt(12)+con;
    }


}
