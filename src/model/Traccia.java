/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tronconih
 */
public final class Traccia {
    private String titolo;
    private String artista;
    private String genere;
    private String percorso;
   
    public Traccia(String title, String artist, String genre, String perc) throws Exception{
        setTitolo(title);
        setArtista(artist);
        setGenere(genre);
        setPercorso(perc);
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getTitolo() {
        return titolo;
    }

    private void setTitolo(String titolo) throws Exception {
        if(titolo.equals("")) throw new Exception("Titolo nullo");
        this.titolo = titolo;
    }

    public String getArtista() {
        return artista;
    }

    private void setArtista(String artista) throws Exception {
        if(artista.equals("")) throw new Exception("Artista nullo");
        this.artista = artista;
    }

    public String getPercorso() {
        return percorso;
    }

    private void setPercorso(String percorso) throws Exception {
        if(percorso.equals("")) throw new Exception("Percorso nullo");
        this.percorso = percorso;
    }
    
    public String getCSV() {
        return this.titolo + "," + this.artista + "," + this.genere + "," + this.percorso;
    }
}