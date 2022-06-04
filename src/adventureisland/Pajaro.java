//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Caracol.java
//  @ Date : 02/05/2021
//  @ Author : 
//
//


package adventureisland;

import java.awt.Graphics2D;

public class Pajaro extends Enemigo {

    private static final String DIRECCIONES[] = {"recursos\\Enemigos\\Pajaro.GIF",
                                                 "recursos\\Enemigos\\PajaroMuerto.png"};
    private int contadorMultiple;
    private boolean enMovimiento = false;
    
    public Pajaro() {
        super(DIRECCIONES, 2, 0);
        this.visible = false;
        contadorMultiple = 0;
        this.puntos = 500;
    }
    
    @Override
    public void movimiento(){
        if(enMovimiento){
            if(contadorMultiple < 30){
                contadorMultiple+=1;
                posX -= 2;
                posY += 4;
            } else if(contadorMultiple < 60){
                contadorMultiple+=1;
                posX -= 2;
                posY -= 4;
            } else {
                contadorMultiple = 0;
            }
        }
    }
    
    @Override
    public void display(Graphics2D g){
        if(this.visible){
            if(!(fueChocado)){
                movimiento();
            } else {
                if(this.contadorMultiple < 5){
                    posY-=3;
                } else {
                    if(posY < 495){
                        posY+=4;
                    } else {
                        this.visible = false;
                    }
                }
                if(contadorMultiple < 200){
                    contadorMultiple+=1;
                } else {
                    this.visible = false;
                }
            }
            g.drawImage(imagen, (int) posX, (int) posY, sizeImg[0][0], sizeImg[0][1], null);
        }
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }
    
    @Override
    public void setFueChocado(boolean fueChocado){
        this.fueChocado = fueChocado;
        this.contadorMultiple = 0;
        cambiarImagen(1);
    }
}
