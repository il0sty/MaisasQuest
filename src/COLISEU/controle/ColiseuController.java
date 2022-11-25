package COLISEU.controle;

import COLISEU.visao.ColiseuInt;
import FERREIRO.modelo.Ferreiro;
import INIMIGOS.controle.ControlInimigoCombat;
import INIMIGOS.modelo.*;
import LOJISTA.modelo.Lojista;
import MENU.modelo.Dificuldade;
import PERSONAGEM.controle.ControlCharacter;
import PERSONAGEM.controle.ControlCharacterCombat;
import PERSONAGEM.modelo.Personagem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class ColiseuController implements Initializable, ColiseuInt {

    public static StringBuilder combatLogText = new StringBuilder();

    private Random random = new Random();

    private static boolean finalBoss;

    private int round;

    @FXML
    private ImageView attackButton;

    @FXML
    private ImageView defenderButton;

    @FXML
    private ImageView especialButton;

    @FXML
    private ImageView potionButton;

    @FXML
    private ImageView sairButton;

    @FXML
    private ImageView helpButton;

    @FXML
    private ImageView infoButton;

    @FXML
    private Text combatLog;

    @FXML
    private Label condition;

    @FXML
    private ImageView fugirButton;

    @FXML
    private Label inimigoName;

    @FXML
    private Label showEspecial;

    @FXML
    private Label showLife;

    @FXML
    private Label showPocoes;

    public static void setFinalBoss(boolean finalBoss) {ColiseuController.finalBoss = finalBoss;}

    public static boolean isFinalBoss() {
        return finalBoss;
    }

    void nextRound(){
        round++;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @FXML
    public void attackButomClicked(MouseEvent event) { //Usado para executar a ação de ataque no combate
        combatLogText.append("<----- TURNO "+ round+" ----->\nSEU TURNO\n");
        ControlCharacterCombat.ataqueJogador();
        ControlCharacterCombat.increaseEspecialPoints();
        if (!Inimigo.isDeathState()) {
            combatLogText.append("\n TURNO DO INIMIGO\n");
            ControlInimigoCombat.ataqueInimigo();
        }
        reload();
    }

    @FXML
    public void defenderButtonClicked(MouseEvent event) { //Usado para executar a ação de defesa no combate
        combatLogText.append("<----- TURNO "+ round+" ----->\n SEU TURNO\n");
        combatLogText.append(Personagem.getNome()).append(" fica na defensiva");
        ControlCharacterCombat.setDefenseMode(true);
        ControlCharacterCombat.increaseEspecialPoints();
        if (!Inimigo.isDeathState()) {
            combatLogText.append("\n TURNO DO INIMIGO\n");
            ControlInimigoCombat.ataqueInimigo();
        }
        ControlCharacterCombat.setDefenseMode(false);
        reload();
    }

    @FXML
    public void especialButtonClicked(MouseEvent event) { //Usado para executar a ação de usar o especial no combate
        if (Objects.equals(Personagem.getClasse(), "Bárbaro")){
            combatLogText.append("Personagens da classe Bárbaro ativam seu especial passivamente!");
            combatLog.setText(String.valueOf(combatLogText));
            combatLogText.setLength(0);
        } else if (ControlCharacterCombat.getEspecialPoints()<ControlCharacterCombat.calcularEspecial()){
            combatLogText.append("Você não possui pontos o suficiente para usar seu especial!");
            combatLog.setText(String.valueOf(combatLogText));
            combatLogText.setLength(0);
        } else if (Personagem.getEspecial()==ControlCharacterCombat.getForeignPoints()){
            combatLogText.append("A bença do forasteiro está no seu limite!");
            combatLog.setText(String.valueOf(combatLogText));
            combatLogText.setLength(0);
        } else {
            combatLogText.append("<----- TURNO " + round + " ----->\n SEU TURNO\n");
            ControlCharacterCombat.ativarEspecial();
            if (!Inimigo.isDeathState()) {
                combatLogText.append("\n TURNO DO INIMIGO\n");
                ControlInimigoCombat.ataqueInimigo();
            }
            reload();
        }
    }

    @FXML
    public void potionButtonClicked(MouseEvent event){ //Usado para executar a ação de usar poção no combate
        if(Personagem.getPotions()==0){
            combatLogText.append("A algibeira de poções de ").append(Personagem.getNome()).append(" está vazia!");
            combatLog.setText(String.valueOf(combatLogText));
            combatLogText.setLength(0);
        } else if(Personagem.getVida()==Personagem.getVidaAtual()){
            combatLogText.append("A vida de ").append(Personagem.getNome()).append(" já está cheia!");
            combatLog.setText(String.valueOf(combatLogText));
            combatLogText.setLength(0);
        }else {
            combatLogText.append("<----- TURNO ").append(round).append(" ----->\n SEU TURNO\n");
            combatLogText.append(Personagem.getNome()).append(" usa uma poção ");
            ControlCharacterCombat.usarPotion();
            if (!Inimigo.isDeathState()) {
                combatLogText.append("\n TURNO DO INIMIGO\n");
                ControlInimigoCombat.ataqueInimigo();
            }
            reload();
        }

    }

    @FXML
    public void sairButtonClicked(MouseEvent event) throws IOException { //Usado para definir o prosseguimento do jogo apos o fim do combate
        if(isFinalBoss()){ // Caso seja o chefe final
            FXMLLoader story = new FXMLLoader(getClass().getResource("../../HISTORIA/visao/endStory.fxml"));
            Parent roottwo = story.load();
            Stage storyshow = new Stage();
            storyshow.setTitle("Maisa's Quest");
            storyshow.getIcons().add(new Image("Imagens/icon.png"));
            storyshow.setScene(new Scene(roottwo));
            storyshow.show();
            if (Personagem.isDeathState()){ // Caso o personagem tenha morrido
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/DeathScreen.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
            } else { // Caso o vilão tenha morrido
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/WinScreen.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
            }
        } else { // Caso não seja o chefe final
            if (Personagem.isDeathState()) { // Caso o personagem tenha morrido
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/DeathScreen.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
            } else { // Caso o inimigo tenha morrido
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
                if (Personagem.getLutasGanhas() % 20 == 0 && Personagem.getLutasGanhas() <= 160) { // Configuração para apresentação da história (A cada 20 lutas ganhas, a história avança)
                    FXMLLoader story = new FXMLLoader(getClass().getResource("../../HISTORIA/visao/historia.fxml"));
                    Parent roottwo = story.load();
                    Stage storyshow = new Stage();
                    storyshow.setTitle("Maisa's Quest");
                    storyshow.getIcons().add(new Image("Imagens/icon.png"));
                    storyshow.setScene(new Scene(roottwo));
                    storyshow.show();
                }
            }
        }
    }

    @FXML
    public void helpButtonClicked(MouseEvent event) throws  IOException{ // Usado para abrir a janela de ajuda do combate
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../HELP/visao/combateHelp.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Maisa's Quest");
        stage.getIcons().add(new Image("Imagens/icon.png"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void runButomClicked(MouseEvent event) throws IOException { //Usado para executar a ação de desistir do combate
        if(isFinalBoss()){ // Caso seja o chefe final
            combatLogText.append("Você nao pode fugir de Novan!");
            combatLog.setText(String.valueOf(combatLogText));
            combatLogText.setLength(0);
        } else { // Caso seja um combate normal
            if (Dificuldade.getDificuldade() == 0.75 || Personagem.getDinheiro() >= (int) (Dificuldade.getDificuldade() * Personagem.getDadoAtaque() * 5)) { // Caso seja permitido a desistencia
                if (Dificuldade.getDificuldade() != 0.75 && Personagem.getDinheiro() >= (int) ((Dificuldade.getDificuldade() * Personagem.getDadoAtaque() * 5) + Personagem.getLutasGanhas())) { // Caso a desistencia precise ser paga
                    Personagem.setDinheiro(Personagem.getDinheiro() - (int) (((Dificuldade.getDificuldade() * Personagem.getDadoAtaque() * 5) + Personagem.getLutasGanhas())));
                }
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../PRACA/visao/PracaMenu.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
            } else { // Caso a desistencia nao seja autorizada
                combatLogText.append(Personagem.getNome()).append(" não possui dinheiro suficiente para pagar a taxa de desistência!");
                combatLog.setText(String.valueOf(combatLogText));
                combatLogText.setLength(0);
            }
        }
    }

    @FXML
    public void infoButomClicked(MouseEvent event) throws IOException { // Ir para a página do inimigo na internet
        Desktop.getDesktop().browse(URI.create(Inimigo.getLink()));
    }

    private int selectRandomEnemy(){ // Seleciona randomicamente o inimigo que será utilizado no combate
        return (random.nextInt(100)+1);
    }

    void setCombate() throws IOException { // Configura o combate, setando caso seja o chefe final ou um combate padrão
        if (Personagem.getLutasGanhas()>=160 && Ferreiro.isEndFerreiro() && Lojista.isEndLojista()){ // Caso a história esteja concluida
            setInimigo(101);
            setFinalBoss(true);
            infoButton.setVisible(false);
            FXMLLoader story = new FXMLLoader(getClass().getResource("../../HISTORIA/visao/historia.fxml")); // Abre a história relacionado ao chefe final
            Parent roottwo = story.load();
            Stage storyshow = new Stage();
            storyshow.setTitle("Maisa's Quest");
            storyshow.getIcons().add(new Image("Imagens/icon.png"));
            storyshow.setScene(new Scene(roottwo));
            storyshow.show();
        } else { // Caso seja um combate genérico
            setInimigo(selectRandomEnemy());
        }
        ControlCharacterCombat.setCombat();
    }


    public void setInimigo(int code){ // Seta o inimigo que sera usado no combate
        switch (code){
            case 1 -> Goblin.criarInimigo();
            case 2 -> Orc.criarInimigo();
            case 3 -> Hobgoblin.criarInimigo();
            case 4 -> Drow.criarInimigo();
            case 5 -> Harpia.criarInimigo();
            case 6 -> FeraDeslocadora.criarInimigo();
            case 7 -> Vampiro.criarInimigo();
            case 8 -> Golem.criarInimigo();
            case 9 -> Undead.criarInimigo();
            case 10 -> Wyvern.criarInimigo();
            case 11 -> Urso.criarInimigo();
            case 12 -> Ghost.criarInimigo();
            case 13 -> RatoGigante.criarInimigo();
            case 14 -> Diabrete.criarInimigo();
            case 15 -> Lobo.criarInimigo();
            case 16 -> Esqueleto.criarInimigo();
            case 17 -> CuboGelatinoso.criarInimigo();
            case 18 -> Drake.criarInimigo();
            case 19 -> Troll.criarInimigo();
            case 20 -> Quimera.criarInimigo();
            case 21 -> Manticora.criarInimigo();
            case 22 -> Hidra.criarInimigo();
            case 23 -> HellHound.criarInimigo();
            case 24 -> Leao.criarInimigo();
            case 25 -> Beholder.criarInimigo();
            case 26 -> VermeDaAreia.criarInimigo();
            case 27 -> Centauro.criarInimigo();
            case 28 -> Ogro.criarInimigo();
            case 29 -> Ciclope.criarInimigo();
            case 30 -> Minotauro.criarInimigo();
            case 31 -> AranhaGigante.criarInimigo();
            case 32 -> Lobisomen.criarInimigo();
            case 33 -> Mumia.criarInimigo();
            case 34 -> Lamia.criarInimigo();
            case 35 -> CaracolGigante.criarInimigo();
            case 36 -> Boitata.criarInimigo();
            case 37 -> Wyrm.criarInimigo();
            case 38 -> Gorila.criarInimigo();
            case 39 -> Yeti.criarInimigo();
            case 40 -> Werebear.criarInimigo();
            case 41 -> Weretiger.criarInimigo();
            case 42 -> Wereboar.criarInimigo();
            case 43 -> Kobold.criarInimigo();
            case 44 -> Balgura.criarInimigo();
            case 45 -> BugBear.criarInimigo();
            case 46 -> MindFlayer.criarInimigo();
            case 47 -> Vecna.criarInimigo();
            case 48 -> Demogorgon.criarInimigo();
            case 49 -> Strahd.criarInimigo();
            case 50 -> Lolth.criarInimigo();
            case 51 -> Tiamat.criarInimigo();
            case 52 -> Acererak.criarInimigo();
            case 53 -> Xanathar.criarInimigo();
            case 54 -> Halaster.criarInimigo();
            case 55 -> Basilisco.criarInimigo();
            case 56 -> Cocatrice.criarInimigo();
            case 57 -> Dreth.criarInimigo();
            case 58 -> ShadowDemon.criarInimigo();
            case 59 -> Doppelganger.criarInimigo();
            case 60 -> Gargula.criarInimigo();
            case 61 -> Ghast.criarInimigo();
            case 62 -> Grell.criarInimigo();
            case 63 -> Bruxa.criarInimigo();
            case 64 -> Homunculo.criarInimigo();
            case 65 -> Medusa.criarInimigo();
            case 66 -> Naga.criarInimigo();
            case 67 -> Oni.criarInimigo();
            case 68 -> Owlbear.criarInimigo();
            case 69 -> Zumbi.criarInimigo();
            case 70 -> Revenant.criarInimigo();
            case 71 -> Espantalho.criarInimigo();
            case 72 -> Ente.criarInimigo();
            case 73 -> YuanTi.criarInimigo();
            case 74 -> Gaviao.criarInimigo();
            case 75 -> EscorpiaoGigante.criarInimigo();
            case 76 -> Jackal.criarInimigo();
            case 77 -> Tigre.criarInimigo();
            case 78 -> Aaracocka.criarInimigo();
            case 79 -> Bullete.criarInimigo();
            case 80 -> Chuul.criarInimigo();
            case 81 -> Imp.criarInimigo();
            case 82 -> Elemental.criarInimigo();
            case 83 -> Caveira.criarInimigo();
            case 84 -> Fantasma.criarInimigo();
            case 85 -> Gigante.criarInimigo();
            case 86 -> Gnoll.criarInimigo();
            case 87 -> Grifo.criarInimigo();
            case 88 -> Hipogrifo.criarInimigo();
            case 89 -> Jackalwere.criarInimigo();
            case 90 -> Wererat.criarInimigo();
            case 91 -> Magmin.criarInimigo();
            case 92 -> Nothic.criarInimigo();
            case 93 -> Salamander.criarInimigo();
            case 94 -> Sátiro.criarInimigo();
            case 95 -> Esfinge.criarInimigo();
            case 96 -> ThriKreen.criarInimigo();
            case 97 -> Wight.criarInimigo();
            case 98 -> Crocodilo.criarInimigo();
            case 99 -> Mamute.criarInimigo();
            case 100 -> Worg.criarInimigo();
            case 101 -> Norvan.criarInimigo();
        }
    }

    String condition(){ // Apresenta a condição atual da vida do inimigo
        String condition = null;
        if (Inimigo.getVidaAtual() / Inimigo.getVida() == 1) {
            condition = "Intácto";
        } else if (Inimigo.getVidaAtual() / Inimigo.getVida() >= 0.7 && Inimigo.getVidaAtual() / Inimigo.getVida() < 1) {
            condition = "Fadigado";
        } else if (Inimigo.getVidaAtual() / Inimigo.getVida() >= 0.4 && Inimigo.getVidaAtual() / Inimigo.getVida() < 0.7) {
            condition = "Dolorido";
        } else if (Inimigo.getVidaAtual() / Inimigo.getVida() > 0 && Inimigo.getVidaAtual() / Inimigo.getVida() < 0.4){
            condition = "Abatido";
        } else condition = "Morto";
        return condition;
    }

    String writeVida(){ // Exibe a vida do personagem (Atual / Total)
        return Personagem.getVidaAtual()+"/"+Personagem.getVida();
    }

    String writeEspecial(){ // Exibe os pontos de especial do personagem (Atual / Total)
        return ControlCharacterCombat.getEspecialPoints() + "/" + ControlCharacterCombat.calcularEspecial();
    }

    void reload() { //Determina o prosseguimento do combate
        writeInfo();
        if (Personagem.isDeathState()) { // Apresentação caso o personagem morra
            combatLogText.append("\n\nVocê Morreu!");
            writeInfo();
            endCombat();
        } else if (Inimigo.isDeathState()) { // Apresentação caso o inimigo morra morra
            if(isFinalBoss()){ // Caso o inimigo seja o chefe final
                Personagem.setEndgame(true);
            }
            int sorte = Personagem.getSorte();
            if (sorte==0) sorte=1;
            int recompensa = (int)(Dificuldade.getDificuldade()*(double)(Inimigo.getValor()*sorte));
            ControlCharacter.receber(recompensa);
            ControlCharacter.lutaGanha();
            writeInfo();
            combatLogText.append("\nVocê ganhou a luta e recebeu $"+recompensa);
            endCombat();
        }
        nextRound();
        combatLog.setText(String.valueOf(combatLogText));
        combatLogText.setLength(0);
    }

    void endCombat(){ // Configurações dos botões ao fim do combate
        fugirButton.setVisible(false);
        attackButton.setVisible(false);
        defenderButton.setVisible(false);
        especialButton.setVisible(false);
        potionButton.setVisible(false);
        sairButton.setVisible(true);
    }

    void writeInfo(){ // Redefinição das informações da tela (Usado ao passar dos rounds)
        inimigoName.setText(Inimigo.getNome());
        condition.setText(condition());
        showLife.setText(writeVida());
        showEspecial.setText(writeEspecial());
        showPocoes.setText(String.valueOf(Personagem.getPotions()));
        showPocoes.setText(String.valueOf(Personagem.getPotions()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setCombate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        combatLog.setText("Combate nº"+ (Personagem.getLutasGanhas()+1)+
                "\n\n<--------------------->\n\n"+
                Personagem.getNome()+" VS "+ Inimigo.getNome());
        writeInfo();
        setRound(1);
    }
}