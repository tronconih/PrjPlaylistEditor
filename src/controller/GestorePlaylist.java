/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Playlist;
import model.Traccia;

/**
 *
 * @author studente
 */
public final class GestorePlaylist {
    Scanner scan = new Scanner(System.in);  // Create a Scanner object
    private int cont = 0;
    private String messaggio= "";
    private String canzoni = "";
    private Playlist p = new Playlist();
    private ArrayList <Traccia> t = new ArrayList <>();
    private String scelta, sceltaGenere, sceltaArtista;
    
    
    
    
    public GestorePlaylist() throws IOException, Exception{
        
        Playlist p1 = new Playlist();

        BufferedReader br = new BufferedReader(new FileReader("elenco-tracce.csv"));
        String line;

        ArrayList <Traccia> t2 = new ArrayList <>();// arraylist di tracce, ogni elemento della lista Ã¨ una playlist di genere

        while((line = br.readLine()) != null) {
            //System.out.println(line);
            String[] info = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // esplode una riga in una array di stringhe
            /*System.out.println(info[0]); //info[0] = titolo
            System.out.println(info[1]); //info[1] = artista
            System.out.println(info[2]); //info[2] = genere
            System.out.println(info[3]); //info[3] = percorso*/
            Traccia t1 = new Traccia(info[0], info[1], info[2], info[3]);
            t2.add(t1);
        }
        
        setT(t2);
        setP(p1);
    }

    public Playlist getP() {
        return p;
    }

    public void setP(Playlist p) {
        this.p = p;
    }

    public ArrayList<Traccia> getT() {
        return t;
    }

    public void setT(ArrayList<Traccia> t) {
        this.t = t;
    }
    
    public int selectAll(){
        int k = 0;
        for(Traccia traccia : t){
            p.aggiungiTraccia(traccia);
            k++;
        }
        writeToFile(p);
        System.out.println("Tutte le " + k + " canzoni sono state aggiunte alla playlist");
        return k;
    }
    public void setMessaggio(String msg){
        this.messaggio = msg;
    }
    public String getMessaggio(){
        return this.messaggio;
    }
    
    public void visuaCanzoni(){
        for(Traccia traccia : p.getPlaylist()){
            this.canzoni += traccia.getTitolo() + " - " + traccia.getArtista() + "\n"; //aggiungo le canzoni alla stringa
        }
    }
    
    public String getCanzoni(){
        return this.canzoni;//restituisco una stringa con l'intero elenco di canzoni
    }
    
    
    public int selectByGenere(String genere){
        int i = 0;
        for(Traccia traccia : t){
            if(genere.equals(traccia.getGenere())){
                p.aggiungiTraccia(traccia);
                i++;
                cont++;
            }
        } 
        writeToFile(p);
        messaggio = "\n"+ i +" canzoni aggiunte per il genere " + genere+ "\nCanzoni attualmente nella playlist: " + cont;
        System.out.println(messaggio);
        setMessaggio(messaggio);
        return i;
    }
    
    public int selectByArtista(String artista){
        int j = 0;
        for(Traccia traccia : t){
            if(artista.equals(traccia.getArtista())){
                p.aggiungiTraccia(traccia);
                j++;
                cont++;
            }
        } 
        writeToFile(p);
        messaggio = j + " canzoni aggiunte per l'artista " + artista + "\nCanzoni attualmente nella playlist: " + cont;
        System.out.println(messaggio);
        setMessaggio(messaggio);
        return j;
    }
    
    public int ripristinoPlaylist() throws FileNotFoundException, IOException, Exception{
        int j = 0;
            BufferedReader br = new BufferedReader(new FileReader("playlistprecedente.csv"));
            String line;
            ArrayList <Traccia> t2 = new ArrayList <>();
            
            while((line = br.readLine()) != null) {
                
                String[] info = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                Traccia t1 = new Traccia(info[0], info[1], info[2], info[3]);
                p.aggiungiTraccia(t1);
                j++;
            }
            System.out.println("Canzoni attualmente nella playlist: " + j);
        return j;
    }
    
    
    
    public void menu() throws Exception{
        
        System.out.println("Selezionare come aggiungere le tracce");
        System.out.println("0) Uscita");
        System.out.println("1) Ripristinare playlist precedente");
        System.out.println("2) Per Artista");
        System.out.println("3) Per Genere");
        System.out.println("4) Normale");
        System.out.println("5) Alt. visualizza canzoni attuali");
        System.out.println("Scelta: ");
        
        scelta = scan.nextLine();  // Read user input
        System.out.println("Risposta: " + scelta); 
        
        switch(scelta){
            case "0":
                break;
            case "1":
                ripristinoPlaylist();
                break;
            case "2": 
                menuArtista();
                break;
            case "3":
                menuGenere();
                break;
            case "4":
                selectAll();
                break;
            case "5":
                visuaCanzoni();
                break;
        }
    }
    
    public void menuGenere(){
        System.out.println("Selezionare un genere: ");
        System.out.println("0) Annulla");
        System.out.println("1) Rock");
        System.out.println("2) Jazz");
        System.out.println("3) POP");
        System.out.println("4) Country");
        System.out.println("5) Raggae");
        System.out.println("Scelta: ");
        
        sceltaGenere = scan.nextLine();  // Read user input
        System.out.println("Risposta: " + sceltaGenere); 
        
        switch(sceltaGenere){
            case "0":
                break;
            case "1": 
                sceltaGenere = "Rock";
                selectByGenere(sceltaGenere);
                break;
            case "2":
                sceltaGenere = "Jazz";
                selectByGenere(sceltaGenere);
                break;
            case "3":
                sceltaGenere = "POP";
                selectByGenere(sceltaGenere);
                break;
            case "4":
                sceltaGenere = "Country";
                selectByGenere(sceltaGenere);
                break;
            case "5":
                sceltaGenere = "Raggae";
                selectByGenere(sceltaGenere);
                break;
                
            default: throw new IllegalArgumentException("Genere selezionato Erroneamente!");
        }
    }
    
    public void menuArtista(){
        System.out.println("Selezionare un artista: ");
        System.out.println("0) Annulla");
        System.out.println("1) Lenny Kravitz");
        System.out.println("2) Jimi Hendrix");
        System.out.println("3) RATT");
        System.out.println("4) James Brown");
        System.out.println("5) The Dave Brubeck Quartet");
        System.out.println("6) Glenn Miller");
        System.out.println("7) Steve Lacy");
        System.out.println("8) Playboi Carti");
        System.out.println("9) Manu Chao");
        System.out.println("10) Whitey Shafer");
        System.out.println("11) Hank Williams");
        System.out.println("12) Patsy Cline");
        System.out.println("13) Bob Marley");
        System.out.println("14) Inner Circle");
        System.out.println("Scelta: ");
        
        sceltaArtista = scan.nextLine();  // Read user input
        System.out.println("Risposta: " + sceltaArtista); 
        
        switch(sceltaArtista){
            case "0":
                break;
            case "1": 
                sceltaArtista = "Lenny Kravitz";
                selectByArtista(sceltaArtista);
                break;
            case "2":
                sceltaArtista = "Jimi Hendrix";
                selectByArtista(sceltaArtista);
                break;
            case "3":
                sceltaArtista = "Ratt";
                selectByArtista(sceltaArtista);
                break;
            case "4":
                sceltaArtista = "James Brown";
                selectByArtista(sceltaArtista);
                break;
            case "5":
                sceltaArtista = "The Dave Brubeck Quartet";
                selectByArtista(sceltaArtista);
                break;
            case "6": 
                sceltaArtista = "Glenn Miller";
                selectByArtista(sceltaArtista);
                break;
            case "7": 
                sceltaArtista = "Steve Lacy";
                selectByArtista(sceltaArtista);
                break;
            case "8": 
                sceltaArtista = "Playboi Carti";
                selectByArtista(sceltaArtista);
                break;
            case "9": 
                sceltaArtista = "Manu Chao";
                selectByArtista(sceltaArtista);
                break;
            case "10": 
                sceltaArtista = "Whitey Shafer";
                selectByArtista(sceltaArtista);
                break;
            case "11": 
                sceltaArtista = "Hank Williams";
                selectByArtista(sceltaArtista);
                break;
            case "12": 
                sceltaArtista = "Patsy Cline";
                selectByArtista(sceltaArtista);
                break;
            case "13": 
                sceltaArtista = "Bob Marley";
                selectByArtista(sceltaArtista);
                break;
            case "14": 
                sceltaArtista = "Inner Circle";
                selectByArtista(sceltaArtista);
                break;
            default: throw new IllegalArgumentException("Artista selezionato Erroneamente!");
        }
    }
    
    
    public void writeToFile(Playlist p) {
        ArrayList<Traccia> data = p.getPlaylist();

        String filePath = "playlistprecedente.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Traccia t : data) {
                writer.write(t.getCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ArrayList written to file successfully.");
    }
}