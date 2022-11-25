package PERSONAGEM.modelo;

import java.io.Serializable;

public class Personagem implements Serializable  {

    private static String nome;
    private static String classe;
    private static int vida;
    private static int vidaAtual;
    private static int dadoAtaque;
    private static int dadoDano;
    private static int upgVida;
    private static int forca;
    private static int reflexos;
    private static int constituicao;
    private static int agilidade;
    private static int especial;
    private static int sorte;
    private static int dinheiro;
    private static int potions;
    private static int lutasGanhas;
    private static boolean deathState;

    private static boolean endgame;

    // Criar novo Personagem
    public Personagem(String nome, String classe, int vida,int dano, int forc, int agi, int con, int ref, int esp, int sor, int money){
        setNome(nome);
        setClasse(classe);
        setVida(vida);
        setVidaAtual(vida);
        setDadoAtaque(1);
        setDadoDano(dano);
        setUpgVida(1);
        setForca(forc);
        setReflexos(ref);
        setConstituicao(con);
        setAgilidade(agi);
        setEspecial(esp);
        setSorte(sor);
        setDinheiro(money);
        setPotions(0);
        setLutasGanhas(0);
        setDeathState(false);
        setEndgame(false);
    }

    // Carregar Personagem
    public Personagem(String nome, String classe, int vida, int vidaAtual,int dadoAtaque,int dano, int upgVida,int forc, int ref, int con, int agi, int esp, int sor, int money, int potions, int lutasGanhas, boolean deathState, boolean endgame){
        setNome(nome);
        setClasse(classe);
        setVida(vida);
        setVidaAtual(vidaAtual);
        setDadoAtaque(dadoAtaque);
        setDadoDano(dano);
        setUpgVida(upgVida);
        setForca(forc);
        setReflexos(ref);
        setConstituicao(con);
        setAgilidade(agi);
        setEspecial(esp);
        setSorte(sor);
        setDinheiro(money);
        setPotions(potions);
        setLutasGanhas(lutasGanhas);
        setDeathState(deathState);
        setEndgame(endgame);
    }

    public Personagem(){
    }

    public static String getNome() {
        return nome;
    }

    public static int getVida() {
        return vida;
    }

    public static int getVidaAtual() {
        return vidaAtual;
    }

    public static int getDadoAtaque() {
        return dadoAtaque;
    }

    public static int getDadoDano() {
        return dadoDano;
    }

    public static int getUpgVida() {
        return upgVida;
    }

    public static String getClasse() {
        return classe;
    }

    public static int getForca() {
        return forca;
    }

    public static int getReflexos() {
        return reflexos;
    }

    public static int getConstituicao() {
        return constituicao;
    }

    public static int getAgilidade() {
        return agilidade;
    }

    public static int getEspecial() {
        return especial;
    }

    public static int getSorte() {
        return sorte;
    }

    public static int getDinheiro() {
        return dinheiro;
    }

    public static int getPotions() {
        return potions;
    }

    public static int getLutasGanhas() {
        return lutasGanhas;
    }

    public static boolean isEndgame() {
        return endgame;
    }

    public static void setNome(String nome) {
        Personagem.nome = nome;
    }

    public static void setVida(int vida) {
        Personagem.vida = vida;
    }

    public static void setVidaAtual(int vidaAtual) {
        Personagem.vidaAtual = vidaAtual;
    }

    public static void setDadoAtaque(int dadoAtaque) {
        Personagem.dadoAtaque = dadoAtaque;
    }

    public static void setDadoDano(int dadoDano) {
        Personagem.dadoDano = dadoDano;
    }

    public static void setUpgVida(int upgVida) {
        Personagem.upgVida = upgVida;
    }

    public static void setClasse(String classe) {
        Personagem.classe = classe;
    }

    public static void setForca(int forca) {
        Personagem.forca = forca;
    }

    public static void setReflexos(int reflexos) {
        Personagem.reflexos = reflexos;
    }

    public static void setConstituicao(int constituicao) {
        Personagem.constituicao = constituicao;
    }

    public static void setAgilidade(int agilidade) {
        Personagem.agilidade = agilidade;
    }

    public static void setEspecial(int especial) {
        Personagem.especial = especial;
    }

    public static void setSorte(int sorte) {
        Personagem.sorte = sorte;
    }

    public static void setDinheiro(int dinheiro) {
        Personagem.dinheiro = dinheiro;
    }

    public static void setPotions(int potions) {
        Personagem.potions = potions;
    }

    public static void setLutasGanhas(int lutasGanhas) {
        Personagem.lutasGanhas = lutasGanhas;
    }

    public static boolean isDeathState() {
        return deathState;
    }

    public static void setDeathState(boolean deathState) {
        Personagem.deathState = deathState;
    }

    public static void setEndgame(boolean endgame) {
        Personagem.endgame = endgame;
    }

    public static void death(){
        deathState = true;
    }

    public static String dado(){
        return getDadoAtaque()+"d"+getDadoDano();
    }

}
