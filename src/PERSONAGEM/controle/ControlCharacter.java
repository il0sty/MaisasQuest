package PERSONAGEM.controle;

import PERSONAGEM.modelo.Personagem;

public class ControlCharacter {
    public static void pagar(int debito){
        Personagem.setDinheiro(Personagem.getDinheiro()-debito);
    } // Pagar por item ou upgrade
    public static void receber(int credito){
        Personagem.setDinheiro(Personagem.getDinheiro()+credito);
    } // Receber dinheiro

    public static void lutaGanha(){
        Personagem.setLutasGanhas(Personagem.getLutasGanhas()+1);
    } // Aumentar o numero de lutas ganhas

    public static void receberDano(int dano){ // Receber dano do inimigo
        Personagem.setVidaAtual(Personagem.getVidaAtual()-dano);
        if(Personagem.getVidaAtual()<=0){
            Personagem.setVidaAtual(0);
            Personagem.death();
        }
    }

    public static void ModFor(int valor){
        Personagem.setForca(Personagem.getForca()+valor);
    } // Modificar força

    public static void ModRef(int valor){
        Personagem.setReflexos(Personagem.getReflexos()+valor);
    } // Modificar reflexos

    public static void ModCon(int valor){
        Personagem.setConstituicao(Personagem.getConstituicao() + valor);
    } // Modificar constituição

    public static void ModAgi(int valor){
        Personagem.setAgilidade(Personagem.getAgilidade()+valor);
    } // Modificar agilidade

    public static void ModEsp(int valor){
        Personagem.setEspecial(Personagem.getEspecial()+valor);
    } // Modificar especial

    public static void ModSor(int valor){
        Personagem.setSorte(Personagem.getSorte()+valor);
    } // Modificar sorte
}
