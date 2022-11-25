package LOJISTA.modelo;

import PERSONAGEM.modelo.Personagem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Lojista implements Serializable {
    static ArrayList<Integer> itensLoja = new ArrayList<>();

    private static boolean endLojista;

    public Lojista(ArrayList itensLoja, boolean endLojista){
        setItensLoja(itensLoja);
        setEndLojista(endLojista);
    }

    private static int itemForAvl;
    private static int itemAgiAvl;
    private static int itemConAvl;
    private static int itemRefAvl;
    private static int itemEspAvl;
    private static int itemSorAvl;

    public Lojista(){
    }
    public static void setLojista(){ // Criação do lojista a partir de um novo jogo
        ArrayList<Integer> itensStart = new ArrayList<>(Arrays.asList(1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3));
        setItensLoja (itensStart);
        setEndLojista(true);
    }

    public static void setItensLoja(ArrayList<Integer> itensLoja) {
        Lojista.itensLoja = itensLoja;
    } // Carregar um lojista de um jogo ja criado
    public static ArrayList<Integer> getItensLoja() {
        return itensLoja;
    }

    public static int calcularPreço(int i){ // Calcular preço do item
        int preco = 0;
        switch (i){
            case 0,3,6,9,12,15 -> preco = 45 - Personagem.getSorte();
            case 1,4,7,10,13,16 -> preco = 75 - Personagem.getSorte();
            case 2,5,8,11,14,17 -> preco = 110 - Personagem.getSorte();
        }
        return preco;
    }

    public static int countLoja(){ // Contar itens da loja
        int cont = 0;
        ArrayList<Integer> itensLoja = Lojista.getItensLoja();
        for (int n = 0; n<itensLoja.size(); n++){
            if(itensLoja.get(n)!=0){
                cont += itensLoja.get(n);
            }
        }
        return cont;
    }

    public static int getItemForAvl() {
        return itemForAvl;
    }

    public static int getItemAgiAvl() {
        return itemAgiAvl;
    }

    public static int getItemConAvl() {
        return itemConAvl;
    }

    public static int getItemRefAvl() {
        return itemRefAvl;
    }

    public static int getItemEspAvl() {
        return itemEspAvl;
    }

    public static int getItemSorAvl() {
        return itemSorAvl;
    }

    public static void setItemForAvl(int itemForAvl) {
        Lojista.itemForAvl = itemForAvl;
    }

    public static void setItemAgiAvl(int itemAgiAvl) {
        Lojista.itemAgiAvl = itemAgiAvl;
    }

    public static void setItemConAvl(int itemConAvl) {
        Lojista.itemConAvl = itemConAvl;
    }

    public static void setItemRefAvl(int itemRefAvl) {
        Lojista.itemRefAvl = itemRefAvl;
    }

    public static void setItemEspAvl(int itemEspAvl) {
        Lojista.itemEspAvl = itemEspAvl;
    }

    public static void setItemSorAvl(int itemSorAvl) {
        Lojista.itemSorAvl = itemSorAvl;
    }

    public static boolean isEndLojista() {
        return endLojista;
    }

    public static void setEndLojista(boolean endLojista) {
        Lojista.endLojista = endLojista;
    }
}
