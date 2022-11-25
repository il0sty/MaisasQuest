package INIMIGOS.modelo;

import MENU.modelo.Dificuldade;

import java.util.Random;

public class Aaracocka extends Inimigo{

    private static String nome = "Aaracocka";
    private static int dadoAtaque = 2;
    private static int dadoDano = 10;
    private static int forca = 2;
    private static int ref = 2;
    private static int con = 2;
    private static int agi = 4;
    private static int valor = 15;
    private static String link = "https://www.aidedd.org/dnd/monstres.php?vo=aarakocra";
    static Random random = new Random();

    private Aaracocka(String nome, double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor, String link) {
        super (nome, vida, dadoAtaque, dadoDano, forca, reflexos, constituicao, agilidade, valor,link);
    } // Definir o tipo do inimigo como o inimigo do combate

    public static void criarInimigo() { // Definição dos atributos do tipo de inimigo
        double vida = calcularVida();
        new Aaracocka(nome, vida, dadoAtaque, dadoDano, forca, ref, con, agi,valor,link);
    }

    // Calculo da vida do inimigo
    private static double calcularVida(){
        return (int)(Dificuldade.getDificuldade()*(30+random.nextInt(30)+con));
    }

}
