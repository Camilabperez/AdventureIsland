
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Dinosaurio.java
//  @ Date : 02/05/2021
//  @ Author : 
//
//


package adventureisland;

import java.awt.Image;
import java.awt.Rectangle;

public class Dinosaurio extends BonusHabilidad {

    protected Heroe heroe;
    protected boolean muerto = false;
    protected int nImagen;
    protected int posXDisparo;
    protected int posYDisparo;
    protected int limitePosX1;
    protected boolean proyectil = false;
    public static final int DEFAULT_DELAY_DISPARO = 20;
    protected int delayDisparo = DEFAULT_DELAY_DISPARO;
    protected int direccionDisparo;
    
    public Dinosaurio(String direccion) {
        super(direccion);
    }
    public Dinosaurio(String direcciones[], int cantidadImagenes, int numeroImagen) {
        super(direcciones, cantidadImagenes, numeroImagen);
    }
    
    private void morir(){
        this.visible = false;
        this.muerto = true;
    }
    
    public Image getImage(int numeroImagen){
        Image rImage = null;
        this.nImagen = -1;
        switch(heroe.getEstadoActual()){
            case Heroe.ESTADO_TROPEZANDO:
            case Heroe.ESTADO_MURIENDO:
            case Heroe.ESTADO_QUEMADO:
                morir();
                break;
            default:
                this.nImagen = numeroImagen;
                rImage = imagenes[numeroImagen];
        }
        return rImage;
    }
    
    @Override
    public int getWidth(){
        if(nImagen != -1){
            return sizeImg[nImagen][0];
        }
        return 0;
    }
    
    @Override
    public int getHeight(){
        if(nImagen != -1){
            return sizeImg[nImagen][1];
        }
        return 0;
    }

    public void setHeroe(Heroe heroe) {
        this.heroe = heroe;
    }

    public boolean estaMuerto() {
        return muerto;
    }
    
    public boolean disparar(int posXDisparo, int posYDisparo, int direccionDisparo){
        if(proyectil == false){
            this.posXDisparo = posXDisparo;
            this.posYDisparo = posYDisparo;
            this.direccionDisparo = direccionDisparo;
            delayDisparo = DEFAULT_DELAY_DISPARO;
            proyectil = true;
            return true;
        }
        return false;
    }
    
    public Rectangle getProyectil(){
        return (proyectil) ? new Rectangle(posXDisparo, posYDisparo, sizeImg[14][0], sizeImg[14][1]) : null;
    }
}