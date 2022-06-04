//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Fruta.java
//  @ Date : 02/05/2021
//  @ Author : 
//
//

 package adventureisland;

import java.awt.*;
import java.awt.geom.AffineTransform;


public class Fruta extends ObjetoGrafico {
    private int puntos;
    private int contadorTexto = 50;
    private int segundosExtra;
    private boolean pausa=false;
    
    private static final String TIPOS[] = {"recursos\\Calabaza.png", // 0
                                            "recursos\\Anana.png",  // 1
                                            "recursos\\Naranja.png", // 2
                                            "recursos\\Banana.png", // 3
                                            "recursos\\Sandia.png", // 4
                                            "recursos\\Zanahoria.png", // 5
                                            "recursos\\Morron.png", // 6
                                            "recursos\\ManzanaAzul.png", // 7
                                            "recursos\\ManzanaRoja.png", // 8
                                            "recursos\\ManzanaRosa.png", // 9
                                            "recursos\\ManzanaCeleste.png", // 10
                                            "recursos\\UvaVioletaBR.png", //11
                                            "recursos\\UvaRosaBB.png", // 12
                                            "recursos\\UvaBlancaBA.png", // 13
                                            "recursos\\UvaVioletaBB.png"}; // 14

    public Fruta(int tipo) {
        super(TIPOS, 15, tipo);
        this.tipo = tipo;
        if(tipo >= 0 && tipo < 11){
            this.puntos = 50;
            this.segundosExtra = 3;
        } else {
            this.puntos = 100;
            this.segundosExtra = 5;
        }
        this.desaparicion = 500;
        this.visible = false;
    }
    
    @Override
    public void display(Graphics2D g2) {
        AffineTransform transform = new AffineTransform();
        AffineTransform old = g2.getTransform();
        Font f = new Font("Arial Black",16,16);
        g2.setFont(f);
        if(desaparicion == 0){
            this.visible = false;
            this.fueChocado = true;
            this.contadorTexto = 0;
        }
        if(fueChocado && contadorTexto != 0){
            g2.setColor(Color.BLACK);
            g2.drawString(Integer.toString(puntos),(int) posX - 1, (int) posY - 1);
            g2.drawString(Integer.toString(puntos),(int) posX - 1, (int) posY + 1);
            g2.drawString(Integer.toString(puntos),(int) posX + 1, (int) posY - 1);
            g2.drawString(Integer.toString(puntos),(int) posX + 1, (int) posY + 1);
            g2.setColor(Color.WHITE);
            g2.drawString(Integer.toString(puntos),(int) posX, (int) posY);
            this.contadorTexto--;
            this.visible = false;
            this.posY-=0.5;
        }
        if(this.visible && this.contadorTexto == 50){
            if(!pausa){this.desaparicion--;} //Imitando temporizador para que desaparezca la fruta
            if((this.desaparicion%5 != 0 && this.desaparicion > 0 && this.desaparicion <50) || (this.desaparicion>50 && this.visible)){
                g2.drawImage(this.imagen, (int) this.posX, (int) this.posY, this.width, this.height, null);
            }
        } 
        g2.setTransform(old);
    }
    
    public int getPuntos(){
   	return this.puntos;
    }

    public int modificarTiempo(){
   	return this.puntos;
    }
    
    public void setDurabilidad(int durabilidad){
        this.desaparicion = durabilidad;
    }

    public int getSegundosExtra() {
        return segundosExtra;
    }
    
    public void setPausa(boolean b){
        this.pausa = b;
    }
    
    
}

    /*public static Fruta[] generarVectorFruta(int cantFrutas, int parteMundo, int ratioGeneracion){
        Fruta frutas[] = new Fruta[cantFrutas];
        
        for(int i = 0; i < cantFrutas; i++){
            int v =(int) Math.random()*16+8; //Variacion de altura
            int h=(int) (410 - (Math.random()*12+1)*v); //Altura
            int f = (int) Math.random()*100;
            if(f < ratioGeneracion){//Probabilidad
                frutas[i] = new Fruta((int) (Math.random()*12));
            } else {
                frutas[i] = new Fruta(11 + ((int) (Math.random()*4+1)));
            }
            frutas[i].setPosition((Escenario.ANCHO_MUNDO/(parteMundo+2))*(i+2), h);
        }
        return frutas;
    }*/