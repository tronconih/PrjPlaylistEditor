/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author studente
 */
public final class Playlist {
    
    private ArrayList<Traccia> vet = new ArrayList<>();

    public void aggiungiTraccia(Traccia t){
        vet.add(t);
    }
    public ArrayList<Traccia> getPlaylist(){
        return vet;
    }
    
}
