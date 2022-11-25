package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class AranhaGigante extends Inimigo{

    private static String nome = "Aranha Gigante";
    private static int dadoAtaque = 1;
    private static int dadoDano = 12;
    private static int forca = 2;
    private static int ref = 3;
    private static int con = 2;
    private static int agi = 4;
    private static int valor = 11;
    private static String link = "https://www.dndbeyond.com/monsters/16895-giant-spider";
    static Random random = new Random();

    private AranhaGigante(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor, String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor, link);
    }

    public static void criarInimigo() {
        double vida = calcularVida();
        new AranhaGigante(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(25+random.nextInt(25)+con));
    }

}
