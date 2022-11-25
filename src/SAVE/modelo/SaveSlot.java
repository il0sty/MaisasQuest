package SAVE.modelo;

import PERSONAGEM.modelo.Personagem;
import FERREIRO.modelo.Ferreiro;
import LOJISTA.modelo.Lojista;
import TAVERNA.modelo.Taverna;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveSlot implements Serializable {
    private String nome = null;
    private String classe;
    private int vida;
    private int vidaAtual;
    private int dadoAtaque;
    private int dadoDano;
    private int upgVida;
    private int forca;
    private int reflexos;
    private int constituicao;
    private int agilidade;
    private int especial;
    private int sorte;
    private int dinheiro;
    private int potions;
    private int lutasGanhas;
    private boolean deathState;
    private int limPotions;
    private int pocoesVendidas;
    private int qtyAttackUpg;
    private int qtyLifeUpg;
    private boolean endGame;
    private boolean endTaverna;
    private boolean endFerreio;
    private boolean endLojista;
    private ArrayList<Integer> itensLoja;

    public void setSaveSlot(){ // setar informações do save slot
        setNome(Personagem.getNome());
        setClasse(Personagem.getClasse());
        setVida(Personagem.getVida());
        setVidaAtual(Personagem.getVidaAtual());
        setDadoAtaque(Personagem.getDadoAtaque());
        setDadoDano(Personagem.getDadoDano());
        setUpgVida(Personagem.getUpgVida());
        setForca(Personagem.getForca());
        setReflexos(Personagem.getReflexos());
        setConstituicao(Personagem.getConstituicao());
        setAgilidade(Personagem.getAgilidade());
        setEspecial(Personagem.getEspecial());
        setSorte(Personagem.getSorte());
        setDinheiro(Personagem.getDinheiro());
        setPotions(Personagem.getPotions());
        setLutasGanhas(Personagem.getLutasGanhas());
        setDeathState(Personagem.isDeathState());
        setLimPotions(Taverna.getLimPotions());
        setPocoesVendidas(Taverna.getPotionsVendidas());
        setQtyAttackUpg(Ferreiro.getQtyAttackUpg());
        setQtyLifeUpg(Ferreiro.getQtyLifeUpg());
        setItensLoja(Lojista.getItensLoja());
        setEndGame(Personagem.isEndgame());
        setEndFerreio(Ferreiro.isEndFerreiro());
        setEndTaverna(Taverna.isEndTaverna());
        setEndLojista(Lojista.isEndLojista());
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getDadoAtaque() {
        return dadoAtaque;
    }

    public int getDadoDano() {
        return dadoDano;
    }

    public int getUpgVida() {
        return upgVida;
    }

    public int getForca() {
        return forca;
    }

    public int getReflexos() {
        return reflexos;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getEspecial() {
        return especial;
    }

    public int getSorte() {
        return sorte;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public int getPotions() {
        return potions;
    }

    public int getPocoesVendidas() {
        return pocoesVendidas;
    }

    public int getLutasGanhas() {
        return lutasGanhas;
    }

    public boolean isDeathState() {
        return deathState;
    }

    public int getLimPotions() {
        return limPotions;
    }

    public int getQtyAttackUpg() {
        return qtyAttackUpg;
    }

    public int getQtyLifeUpg() {
        return qtyLifeUpg;
    }

    public ArrayList<Integer> getItensLoja() {
        return itensLoja;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public void setDadoAtaque(int dadoAtaque) {
        this.dadoAtaque = dadoAtaque;
    }

    public void setDadoDano(int dadoDano) {
        this.dadoDano = dadoDano;
    }

    public void setUpgVida(int upgVida) {
        this.upgVida = upgVida;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setReflexos(int reflexos) {
        this.reflexos = reflexos;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public void setEspecial(int especial) {
        this.especial = especial;
    }

    public void setSorte(int sorte) {
        this.sorte = sorte;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public void setPocoesVendidas(int pocoesVendidas) {
        this.pocoesVendidas = pocoesVendidas;
    }

    public void setLutasGanhas(int lutasGanhas) {
        this.lutasGanhas = lutasGanhas;
    }

    public void setDeathState(boolean deathState) {
        this.deathState = deathState;
    }

    public void setLimPotions(int limPotions) {
        this.limPotions = limPotions;
    }

    public void setQtyAttackUpg(int qtyAttackUpg) {
        this.qtyAttackUpg = qtyAttackUpg;
    }

    public void setQtyLifeUpg(int qtyLifeUpg) {
        this.qtyLifeUpg = qtyLifeUpg;
    }

    public void setItensLoja(ArrayList<Integer> itensLoja) {
        this.itensLoja = itensLoja;
    }

    public void setEndTaverna(boolean endTaverna) {
        this.endTaverna = endTaverna;
    }

    public void setEndLojista(boolean endLojista) {
        this.endLojista = endLojista;
    }

    public void setEndFerreio(boolean endFerreio) {
        this.endFerreio = endFerreio;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public boolean isEndTaverna() {
        return endTaverna;
    }

    public boolean isEndLojista() {
        return endLojista;
    }

    public boolean isEndFerreio() {
        return endFerreio;
    }

    public boolean isEndGame() {
        return endGame;
    }
}
