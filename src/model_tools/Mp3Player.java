/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
/**
 *
 * @author montipog
 */
public class Mp3Player {
   
    private String filename;
    private Player player;
    private int currentPosition;


    public Mp3Player(String filename) {
        this.filename = filename;
    }


    public void play() {
        this.play(0);
    }
    public void play(int position) {
        try {   
            BufferedInputStream buffer = new BufferedInputStream(
            new FileInputStream(filename));
            player = new Player(buffer);
            player.play(position);
            currentPosition = 0;
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void pause() {
        try {   
            BufferedInputStream buffer = new BufferedInputStream(
            new FileInputStream(filename));
            this.currentPosition = player.getPosition();
            player.close();
//            player.();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void resume() {
        this.play(this.currentPosition);
    }

    public static void main(String[] args) {
        Mp3Player mp3 = new Mp3Player("song.mp3");
        mp3.play();

    }

}

