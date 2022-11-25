package INIMIGOS.controle;

import COLISEU.controle.ColiseuController;
import INIMIGOS.modelo.Inimigo;
import MENU.modelo.Dificuldade;
import PERSONAGEM.controle.ControlCharacter;
import PERSONAGEM.controle.ControlCharacterCombat;
import PERSONAGEM.modelo.Personagem;

import java.util.Objects;
import java.util.Random;

public class ControlInimigoCombat {

    private static boolean crit; // Definição se o ataque é critico ou não (Rolagem de dado de 20 lados)
    static Random random = new Random();
    public static int ataque(){ // Ataque do inimigo
        int rolagem = random.nextInt(20)+1;
        if(rolagem==20){
            setCrit(true);
        }
        return rolagem;
    }

    public static int dano(){ // Calculo do dano do inimigo
        int dano = 0;
        for(int i = 0; i<Inimigo.getDadoAtaque();i++){ //Rolagem de dados do dano
            dano += random.nextInt(Inimigo.getDadoDano())+1;
        }
        if (isCrit()){
            dano += dano;
            setCrit(false);
        }
        double danoDif = (double) dano * Dificuldade.getDificuldade();

        return (int)danoDif;
    }

    public static int defesa(){
        return 10 + Inimigo.getReflexos();
    } // Definição da defesa do inimigo

    public static int resistir(){
        return Inimigo.getConstituicao();
    } // Definição da resistencia do inimigo

    public static void receberDano(int dano){ // Calculo do dano recebido pelo inimigo
        Inimigo.setVidaAtual(Inimigo.getVidaAtual()-dano);
        if(Inimigo.getVidaAtual()<=0){
            Inimigo.setVidaAtual(0);
            Inimigo.morte();
        }
    }

    public static void ataqueInimigo(){ // Calculo do ataque do inimigo
        int roll = ataque()+Inimigo.getAgilidade();
        int defesa = ControlCharacterCombat.defesa();
        int defesaBonus = ControlCharacterCombat.defesaBonus();
        if (roll>=defesa+defesaBonus){
            ColiseuController.combatLogText.append("O ataque ultrapassou a defesa");
            int dano = dano()+Inimigo.getForca();
            int resistencia = ControlCharacterCombat.resistir();
            int resistenciaBonus = ControlCharacterCombat.resistirBonus();
            if (dano-(resistencia+resistenciaBonus)>0){
                ControlCharacter.receberDano(dano-(resistencia+resistenciaBonus));
                ColiseuController.combatLogText.append(" e ").append(Personagem.getNome()).append(" recebeu ").append((dano-(resistencia+resistenciaBonus))).append(" de dano!");
                if(Objects.equals(Personagem.getClasse(), "Bárbaro") && ((double)Personagem.getVidaAtual()/(double)Personagem.getVida()<0.25)){
                    ColiseuController.combatLogText.append(Personagem.getNome()).append(" ENTRA EM FÚRIA!");
                }
            } else {
                ColiseuController.combatLogText.append(" mas ").append(Personagem.getNome()).append(" resistiu ao dano!\n");
            }
        } else {
            ColiseuController.combatLogText.append("O ataque não conseguiu ultrapassar a defesa de ").append(Personagem.getNome()).append("!\n");
        }
    }

    public static boolean isCrit() {
        return crit;
    }

    public static void setCrit(boolean crit) {
        ControlInimigoCombat.crit = crit;
    }
}
