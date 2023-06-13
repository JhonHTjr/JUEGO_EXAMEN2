package mvc3nraya;

import vista.interfaz;
import controlador.controlador;
import modelo.juego;

/**
 * @web www.jc-mouse.net/
 * @author Mouse
 */
public class Main {

    public static void main(String[] args) {

        juego modelo = new juego();
        interfaz vista = new interfaz();
        controlador controlador = new controlador(vista, modelo);
        controlador.iniciar_vista();
        vista.setVisible(true);
    }

}
