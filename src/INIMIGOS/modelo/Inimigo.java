package INIMIGOS.modelo;

public class Inimigo {
    private static String nome;
    private static double vida;
    private static double vidaAtual;
    private static int dadoAtaque;
    private static int dadoDano;
    private static int forca;
    private static int reflexos;
    private static int constituicao;
    private static int agilidade;
    private static int valor;
    private static String link;
    private static boolean deathState;

    public Inimigo(String nome,double vida, int dadoAtaque, int dadoDano, int forca, int reflexos, int constituicao, int agilidade, int valor, String link){
        setNome(nome);
        setVida(vida);
        setVidaAtual(vida);
        setDadoAtaque(dadoAtaque);
        setDadoDano(dadoDano);
        setForca(forca);
        setReflexos(reflexos);
        setConstituicao(constituicao);
        setAgilidade(agilidade);
        setValor(valor);
        setLink(link);
        setDeathState(false);
    }

    public static String getNome() {
        return nome;
    }

    public static double getVida() {
        return vida;
    }

    public static double getVidaAtual() {
        return vidaAtual;
    }

    public static int getDadoAtaque() {
        return dadoAtaque;
    }

    public static int getDadoDano() {
        return dadoDano;
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

    public static int getValor() {
        return valor;
    }

    public static boolean isDeathState() {
        return deathState;
    }

    public static String getLink() {
        return link;
    }

    public static void setNome(String nome) {
        Inimigo.nome = nome;
    }

    public static void setVida(double vida) {
        Inimigo.vida = vida;
    }

    public static void setVidaAtual(double vidaAtual) {
        Inimigo.vidaAtual = vidaAtual;
    }

    public static void setDadoAtaque(int dadoAtaque) {
        Inimigo.dadoAtaque = dadoAtaque;
    }

    public static void setDadoDano(int dadoDano) {
        Inimigo.dadoDano = dadoDano;
    }

    public static void setForca(int forca) {
        Inimigo.forca = forca;
    }

    public static void setReflexos(int reflexos) {
        Inimigo.reflexos = reflexos;
    }

    public static void setConstituicao(int constituicao) {
        Inimigo.constituicao = constituicao;
    }

    public static void setAgilidade(int agilidade) {
        Inimigo.agilidade = agilidade;
    }

    public static void setValor(int valor) {
        Inimigo.valor = valor;
    }

    public static void setDeathState(boolean deathState) {
        Inimigo.deathState = deathState;
    }

    public static void setLink(String link) {
        Inimigo.link = link;
    }

    public static void morte(){
        deathState = true;
    }
}
