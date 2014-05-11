package Webapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Monteur {
    private String naam;
    
    public Monteur(String nm){
        naam = nm;
    }
    public void setNaam(String nm){
        naam = nm;
    }
    public String getNaam(){
        return naam;
    }
    public String toString(){
        return naam;
    }
}
