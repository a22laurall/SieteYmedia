package sieteymedia;

import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {
    Baraja baraja;
    Carta[] cartasJugador;
    Carta[] cartasBanca;

    public void setCartasJugador(Carta[] cartasJugador) {
        this.cartasJugador = cartasJugador;
    }

    public void setCartasBanca(Carta[] cartasBanca) {
        this.cartasBanca = cartasBanca;
    }

    public void setBaraja(Baraja baraja){
        this.baraja = baraja;
    }

    void turnoJugador() {
        char opc = 'C';
        
        if (valorCartas(cartasJugador) < 7.5 && opc == 'C') {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasJugador, c);
            opc ='O';
        }

    }

    void turnoBanca() {
        while (valorCartas(cartasBanca) < valorCartas(cartasJugador)) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
    }

    double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int val;
        int i = 0;
        while (cartas[i] != null) {
            val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val;
            i++;
        }

        return total;
    }

    void insertarCartaEnArray(Carta[] cartas, Carta c) {
        // inserta al final detectando el primer null
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;

    }

    String mostrarCartas(Carta[] cartas) {
        int i = 0;
        String cartasMostrar = "";
        while (cartas[i] != null) {
            cartasMostrar += cartas[i];
            i++;
        }
        return cartasMostrar;
    }
}
