package SAVE.controle;

import MENU.modelo.Dificuldade;
import SAVE.modelo.SaveSlot;
import PERSONAGEM.modelo.Personagem;
import FERREIRO.modelo.Ferreiro;
import LOJISTA.modelo.Lojista;
import TAVERNA.modelo.Taverna;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ControlSave implements Serializable {
    private static ArrayList<Object> savedGames = new ArrayList<>(); // lista de saves
    public static void salvar(int selectedSlot) { // salvar jogo
        importSavedGames();
        SaveSlot slot = new SaveSlot();
        slot.setSaveSlot();
        savedGames.remove(selectedSlot);
        savedGames.add(selectedSlot, slot);
        exportSavedGames();
    }

    public static void load(int selectedSlot){ // carregar jogo
        SaveSlot slot = (SaveSlot) savedGames.get(selectedSlot);
        loadSaveSlot(slot);
    }

    public static void autoSave(){ // funcionamento do autosave
        SaveSlot slot = new SaveSlot();
        slot.setSaveSlot();
        try{
            FileOutputStream fos = new FileOutputStream("autosave.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(slot);
            os.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadAutoSave(){ // carregamento do autosave
        SaveSlot continueGame;
        try{
            FileInputStream fis = new FileInputStream("autosave.txt");
            ObjectInputStream is = new ObjectInputStream(fis);
            continueGame = (SaveSlot) is.readObject();
            is.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(Objects.equals(continueGame.getNome(), null)){
            System.out.println("No AutoSave Game Found");
        } else {
            System.out.println("AutoSave Game Found");
            loadSaveSlot(continueGame);
        }
    }
    public static void importSavedGames(){ // importar jogos salvos
        try{
            FileInputStream fis = new FileInputStream("savefiles.txt");
            ObjectInputStream is = new ObjectInputStream(fis);
            savedGames = (ArrayList) is.readObject();
            is.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void exportSavedGames() { // exportar jogos salvos
        try{
            FileOutputStream fos = new FileOutputStream("savefiles.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(savedGames);
            os.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createSaveFile(){ // criar arquivos necessarios para a persistencia do jogo
        File saveFiles = new File("savefiles.txt");
        try{
            if(saveFiles.createNewFile()){
                System.out.println("SaveFiles Created");
                ControlSave.setSavedGames();
                ControlSave.exportSavedGames();

            } else {
                System.out.println("SaveFiles Already Created");
                ControlSave.importSavedGames();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        File autoSave = new File("autosave.txt");
        try{
            if(autoSave.createNewFile()){
                System.out.println("AutoSave File Created");
                autoSave();
                loadAutoSave();
            } else {
                System.out.println("AutoSave File Already Created");
                loadAutoSave();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        File difficultySave = new File("difficultysave.txt");
        try{
            if(difficultySave.createNewFile()){
                System.out.println("Difficulty Save File Created");
                setDefaultDificulty();
                loadDifficulty();
            } else {
                loadDifficulty();
                System.out.println("Difficulty Save File Already Created");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void setDefaultDificulty(){ // setar dificuldade padrão
        try{
            FileOutputStream fos = new FileOutputStream("difficultysave.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeDouble(1);
            os.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadDifficulty(){ // carregar dificuldade
        double dificuldade = 1;
        try{
            FileInputStream fis = new FileInputStream("difficultysave.txt");
            ObjectInputStream is = new ObjectInputStream(fis);
            dificuldade = is.readDouble();
            Dificuldade.setDificuldade(dificuldade);
            is.close();
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveDifficulty(){ // salvar dificuldade
        try{
            FileOutputStream fos = new FileOutputStream("difficultysave.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeDouble(Dificuldade.getDificuldade());
            os.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setSavedGames(){ // setar jogo salvo
        for (int i = 0; i<5; i++){
            SaveSlot ss = new SaveSlot();
            savedGames.add(ss);
        }
    }

    public static void loadSaveSlot(SaveSlot slot){ // carregar salve slot
        new Personagem(slot.getNome(),slot.getClasse(),slot.getVida(),
                slot.getVidaAtual(),slot.getDadoAtaque(),slot.getDadoDano(),
                slot.getUpgVida(),slot.getForca(),slot.getReflexos(),slot.getConstituicao(),
                slot.getAgilidade(),slot.getEspecial(),slot.getSorte(),slot.getDinheiro(),
                slot.getPotions(),slot.getLutasGanhas(),slot.isDeathState(), slot.isEndGame());
        new Taverna(slot.getLimPotions(),slot.getPocoesVendidas(), slot.isEndTaverna());
        new Ferreiro(slot.getQtyAttackUpg(),slot.getQtyLifeUpg(),slot.isEndFerreio());
        new Lojista(slot.getItensLoja(),slot.isEndLojista());
    }

    public static String writeSaveSlot1(){ // escrever informações do save slot 1
        SaveSlot read = (SaveSlot) savedGames.get(0);
        String text;
        if(read.getNome()==null){
            text = "Espaço 1 - Vazio";
        } else text = "Espaço 1 - Nome: "+read.getNome()+"  ///  Classe: "+read.getClasse()+"  ///  Lutas Ganhas: "+read.getLutasGanhas();
        return text;
    }

    public static String writeSaveSlot2(){ // escrever informações do save slot 2
        SaveSlot read = (SaveSlot) savedGames.get(1);
        String text;
        if(read.getNome()==null){
            text = "Espaço 2 - Vazio";
        } else text = "Espaço 2 - Nome: "+read.getNome()+"  ///  Classe: "+read.getClasse()+"  ///  Lutas Ganhas: "+read.getLutasGanhas();
        return text;
    }

    public static String writeSaveSlot3(){ // escrever informações do save slot 3
        SaveSlot read = (SaveSlot) savedGames.get(2);
        String text;
        if(read.getNome()==null){
            text = "Espaço 3 - Vazio";
        } else text = "Espaço 3 - Nome: "+read.getNome()+"  ///  Classe: "+read.getClasse()+"  ///  Lutas Ganhas: "+read.getLutasGanhas();
        return text;
    }

    public static String writeSaveSlot4(){ // escrever informações do save slot 4
        SaveSlot read = (SaveSlot) savedGames.get(3);
        String text;
        if(read.getNome()==null){
            text = "Espaço 4 - Vazio";
        } else text = "Espaço 4 - Nome: "+read.getNome()+"  ///  Classe: "+read.getClasse()+"  ///  Lutas Ganhas: "+read.getLutasGanhas();
        return text;
    }

    public static String writeSaveSlot5(){ // escrever informações do save slot 5
        SaveSlot read = (SaveSlot) savedGames.get(4);
        String text;
        if(read.getNome()==null){
            text = "Espaço 5 - Vazio";
        } else text = "Espaço 5 - Nome: "+read.getNome()+"  ///  Classe: "+read.getClasse()+"  ///  Lutas Ganhas: "+read.getLutasGanhas();
        return text;
    }
}
