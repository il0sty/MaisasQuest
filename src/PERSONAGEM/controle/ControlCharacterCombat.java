package PERSONAGEM.controle;

import COLISEU.controle.ColiseuController;
import INIMIGOS.controle.ControlInimigoCombat;
import INIMIGOS.modelo.Inimigo;
import PERSONAGEM.modelo.Personagem;

import java.util.Objects;
import java.util.Random;

public class ControlCharacterCombat {

    private static int especialPoints;
    private static boolean run;
    private static boolean especial;
    private static boolean crit;

    private static boolean defenseMode;

    private static int foreignPoints;

    public static int ataque(){ // Calcular Ataque do Jogador
        Random random = new Random();
        int rolagem = random.nextInt(20)+1;
        if(rolagem==20){
            ColiseuController.combatLogText.append("ACERTO CRÍTICO!\n");
            setCrit(true);
        }
        return rolagem;
    }

    public static int dano(){ // Calcular dano do jogador
        Random random = new Random();
        int dano = 0;
        for(int i = 0; i<Personagem.getDadoAtaque(); i++){
            dano += random.nextInt(Personagem.getDadoDano())+1;
        }
        if (isCrit()){
            dano += dano;
        }

        return dano;
    }

    public static int defesa(){
        return 10 + Personagem.getReflexos();
    } // calcular defesa do jogador

    public static int resistir(){
        return Personagem.getConstituicao();
    } // calcular resistencia do jogador

    public static int ataqueBonus(){ // calcular bonus somado no ataque
        int bonus = 0;
        if(Objects.equals(Personagem.getClasse(), "Forasteiro")){
            bonus += Personagem.getSorte() + foreignPoints;
        } else bonus += Personagem.getAgilidade();
        if (Objects.equals(Personagem.getClasse(), "Ladrão") && isEspecial()){
            bonus += (10 + Personagem.getEspecial());
        }
        if (Objects.equals(Personagem.getClasse(), "Guerreiro") && isEspecial()){
            bonus += Personagem.getEspecial();
        }

        if (Objects.equals(Personagem.getClasse(), "Bárbaro") && ((double)Personagem.getVidaAtual()/(double)Personagem.getVida())<=0.25){
            bonus += (3 + Personagem.getEspecial());
        }

        return bonus;
    }

    public static int danoBonus(){ // calcular bonus somado ao dano
        int bonus = 0;
        if(Objects.equals(Personagem.getClasse(), "Forasteiro")) {
            bonus = bonus + Personagem.getSorte()+foreignPoints;
        } else if(Objects.equals(Personagem.getClasse(), "Mago")){
            bonus = bonus + Personagem.getEspecial();
        } else bonus = bonus + Personagem.getForca();

        if (Objects.equals(Personagem.getClasse(), "Bárbaro") && ((double)Personagem.getVidaAtual()/(double)Personagem.getVida())<=0.25){
            bonus += (3 + Personagem.getEspecial());
        }
        if (Objects.equals(Personagem.getClasse(), "Guerreiro") && isEspecial()){
            bonus += Personagem.getEspecial();
        }
        if (Objects.equals(Personagem.getClasse(), "Ladrão") && isCrit()){
            bonus += (10 + Personagem.getEspecial());
        }
        return bonus;
    }

    public static int defesaBonus(){ // calcular bonus somado na defesa
        int bonus = 0;
        if(Objects.equals(Personagem.getClasse(), "Forasteiro")) {
            bonus += Personagem.getSorte()+foreignPoints;
        }
        if(Objects.equals(Personagem.getClasse(), "Bárbaro")&& ((double)Personagem.getVidaAtual()/(double)Personagem.getVida())<=0.25) {
            bonus += (3 + Personagem.getEspecial());
        }
        if (ControlCharacterCombat.isDefenseMode()){
            bonus += Personagem.getConstituicao();
        }
        return bonus;
    }

    public static int resistirBonus(){ // calcular bonus somado na resistencia
        int bonus = 0;
        if(Objects.equals(Personagem.getClasse(), "Forasteiro")) {
            bonus += Personagem.getSorte()*Personagem.getUpgVida();
        }
        if (ControlCharacterCombat.isDefenseMode()){
            bonus += Personagem.getReflexos()*Personagem.getUpgVida();
        }
        return bonus;
    }

    public static boolean isCrit() {
        return crit;
    }

    public static boolean isEspecial() {
        return especial;
    }

    public static boolean isDefenseMode() {
        return defenseMode;
    }

    public static boolean isRun() {
        return run;
    }

    public static int getForeignPoints() {
        return foreignPoints;
    }

    public static void resetForeignPoints() {
        ControlCharacterCombat.foreignPoints = 0;
    }

    public static void increaseForeignPoints() {
        ControlCharacterCombat.foreignPoints++;
    }

    public static void setCrit(boolean crit) {
        ControlCharacterCombat.crit = crit;
    }

    public static void setEspecial(boolean especial) {
        ControlCharacterCombat.especial = especial;
    }

    public static void setDefenseMode(boolean defenseMode) {
        ControlCharacterCombat.defenseMode = defenseMode;
    }

    public static void setEspecialPoints() {
        ControlCharacterCombat.especialPoints = 0;
    }

    public static void increaseEspecialPoints(){
        if(especialPoints<calcularEspecial()) {
            ControlCharacterCombat.especialPoints++;
        }
    }

    public static int getEspecialPoints() {
        return especialPoints;
    }

    public static void setRun() {
        ControlCharacterCombat.run = false;
    }

    public static void run(){
        ControlCharacterCombat.run = true;
    }

    public static void setCombat(){ // setar o inicio do combate
        ControlCharacterCombat.setCrit(false);
        ControlCharacterCombat.setEspecial(false);
        ControlCharacterCombat.setRun();
        ControlCharacterCombat.setEspecialPoints();
        ControlCharacterCombat.setDefenseMode(false);
        ControlCharacterCombat.resetForeignPoints();
    }

    public static void usarPotion(){ // ação de usar opção e calcular cura
        Personagem.setPotions(Personagem.getPotions()-1);
        int cura = (int)((double)Personagem.getVida()/3);
        ColiseuController.combatLogText.append(" e recupera ").append(cura).append(" de vida!");
        Personagem.setVidaAtual((Personagem.getVidaAtual()+cura));
        if (Personagem.getVidaAtual()>Personagem.getVida()){
            Personagem.setVidaAtual(Personagem.getVida());
        }
    }


    public static int calcularEspecial(){ // calcular quantidade de pontos de especial sao necessários para cada classe
        int num = 0;
        switch (Personagem.getClasse()){
            case "Guerreiro","Mago" -> num = 2;
            case "Bárbaro" -> {}
            case "Ladrão" -> num = 5;
            case "Forasteiro" -> num = 1;
        }
        return num;
    }

    public static void ativarEspecial(){ // ativar habilidade especial do personagem
        switch (Personagem.getClasse()){
            case "Forasteiro" -> {
                ColiseuController.combatLogText.append("Os ventos mudam em direção a ").append(Personagem.getNome()).append("\n");
                increaseForeignPoints();
            }
            case "Bárbaro" -> {
                ColiseuController.combatLogText.append("O bárbaro nao pode entrar em fúria agora").append("\n");
            }
            case "Mago" -> {
                ColiseuController.combatLogText.append(Personagem.getNome()).append(" abre seu grimório e conjura sua magia proibida ");
                magiaProibida();
            }
            case "Ladrão" -> {
                ColiseuController.combatLogText.append(Personagem.getNome()).append(" some em plena vista e realiza um ataque mortal!\n");
                setEspecial(true);
                ataqueJogador();
                setEspecial(false);
            }
            case "Guerreiro" -> {
                ColiseuController.combatLogText.append("Em um surto de ação, ").append(Personagem.getNome()).append(" parte para o ataque!\n");
                setEspecial(true);
                ataqueJogador();
                ataqueJogador();
                setEspecial(false);
            }
        }
        especialPoints = 0;
    }


    public static void magiaProibida(){ // configurações do ataque especial do mago
        Random random = new Random();
        int danoMagia = (random.nextInt(10)+1) + (random.nextInt(10)+1) + (random.nextInt(10)+1) + Personagem.getEspecial();
        ControlInimigoCombat.receberDano(danoMagia-ControlInimigoCombat.resistir());
        if(danoMagia-ControlInimigoCombat.resistir()>0) {
            ColiseuController.combatLogText.append(" e causa ").append(danoMagia - ControlInimigoCombat.resistir()).append(" de dano!\n");
        } else {
            ColiseuController.combatLogText.append(" e causa mas o inimigo resiste!\n");
        }
    }

    public static void ataqueJogador(){ // sequencia da ação de ataque do jogador
        int roll = ataque();
        int rollBonus = ataqueBonus();
        int defesaInimigo = ControlInimigoCombat.defesa();
        if (roll+rollBonus>=defesaInimigo){
            ColiseuController.combatLogText.append("O ataque ultrapassou a defesa inimiga\n");
            int dano = dano();
            int danoBonus = danoBonus();
            int resistencia = ControlInimigoCombat.resistir();
            if (dano+danoBonus-resistencia>0){
                ControlInimigoCombat.receberDano(dano+danoBonus-resistencia);
                ColiseuController.combatLogText.append(" e ele recebeu ").append(dano+danoBonus-resistencia).append(" de dano!\n");
            } else {
                ColiseuController.combatLogText.append("mas ele resistiu ao dano!\n");
            }
        } else {
            ColiseuController.combatLogText.append("O ataque não conseguiu ultrapassar a defesa inimiga!\n");
        }
    }
}