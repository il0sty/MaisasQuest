package PERSONAGEM.controle;

import COLISEU.controle.ColiseuController;
import FERREIRO.modelo.Ferreiro;
import LOJISTA.modelo.Lojista;
import PERSONAGEM.modelo.Personagem;
import TAVERNA.modelo.Taverna;

import java.util.Objects;
import java.util.Random;

public class ControlCharacterCreation {
    static Random random = new Random();

    //Criar personagem
    public static void CreateCharacter(String nome, String classe, int forc, int ref, int con, int agi, int esp, int sor){
        forc = setForca(forc, classe);
        ref = setReflx(ref, classe);
        con = setConst(con, classe);
        agi = setAgilt(agi, classe);
        esp = setEspc(esp, classe);
        int dano = setDano(classe);
        int money = setMoney(sor, classe);
        int vida = setLife(classe, con, sor);
        new Personagem (nome,classe,vida,dano,forc,ref,con,agi,esp,sor,money);
        Ferreiro.setFerreiro();
        Lojista.setLojista();
        Taverna.setTaverna();
        ColiseuController.setFinalBoss(false);
    }

    public static int setForca(int forc, String classe){ //Setar aumento de força por classe
        if (Objects.equals(classe, "Guerreiro")){
            forc++;
        } else if (Objects.equals(classe, "Bárbaro")){
            forc = forc + 2;
        } else if (Objects.equals(classe, "Ladrão")){
            forc++;
        }
        return forc;
    }

    public static int setReflx(int ref, String classe){ //Setar aumento de reflexo por classe
        if (Objects.equals(classe, "Guerreiro")){
            ref++;
        } else if (Objects.equals(classe, "Bárbaro")){
            ref = ref - 2;
        } else if (Objects.equals(classe, "Ladrão")){
            ref = ref + 3;
        }
        return ref;
    }

    public static int setConst(int con, String classe){ //Setar aumento de constituição por classe
        if (Objects.equals(classe, "Guerreiro")){
            con++;
        } else if (Objects.equals(classe, "Bárbaro")){
            con = con + 2;
        }
        return con;
    }

    public static int setAgilt(int agi, String classe){ //Setar aumento de agilidade por classe
        if (Objects.equals(classe, "Guerreiro")){
            agi++;
        } else if (Objects.equals(classe, "Mago")){
            agi++;
        } else if (Objects.equals(classe, "Ladrão")){
            agi = agi + 3;
        }
        return agi;
    }

    public static int setEspc(int esp, String classe){ //Setar aumento de especial por classe
        if (Objects.equals(classe, "Mago")) {
            esp = esp + 2;
        }
        return esp;
    }

    public static int setMoney(int sor, String classe){ //Setar dinheiro por classe
        int money = 0;
        if (sor == 0){
            sor = 1;
        }

        switch (classe){
            case "Guerreiro" -> money = 30*sor;
            case "Bárbaro" -> money = 25*sor;
            case "Ladrão" -> money = 40*sor;
            case "Mago" -> money = 20*sor;
            case "Forasteiro" -> money = 10*sor*sor;
        }

        return money;
    }

    public static int setLife(String classe, int con, int sor){ //Setar vida por classe
        int life = 0;
        switch (classe){
            case "Guerreiro" -> life = (random.nextInt(10)+1)+5+con;
            case "Bárbaro" -> life = (random.nextInt(12)+1)+6+con;
            case "Ladrão" -> life = (random.nextInt(6)+1)+3+con;
            case "Mago" -> life = (random.nextInt(4)+1)+2+con;
            case "Forasteiro" -> life = (random.nextInt(8)+1)+4+sor;
        }
        return life;
    }

    public static int setDano(String classe){ //Setar dano por classe
        int dano=0;
        switch (classe){
            case "Guerreiro" -> dano = 10;
            case "Bárbaro" -> dano = 12;
            case "Ladrão","Forasteiro" -> dano = 8;
            case "Mago" -> dano = 6;
        }
        return dano;
    }

}
