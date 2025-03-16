/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instituto;

/**
 *
 * @author ProfDiurno
 */
public class Nif {

    private int numero;
    private char letra;

    //CONSTANTE: no accesible - compartido por todo - no modificable
    private static final char[] LETRAS
            = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
                'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
                'C', 'K', 'E'};
    //saca la letra con el modulo de 23
    private static char calcularLetra(int numero) {
        return LETRAS[numero % 23];
    }
    //inicia el nif sin valores
    protected Nif() {
        this.numero = 0;
        this.letra = ' ';
    }
    //calcula la letra
    protected Nif(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }
    //saca el nif en formato letra+numero
    @Override
    public String toString() {
        return numero + "-" + letra;
    }

    protected void setNif(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }
    //compara si los 2 nif son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        //mira si es nulo
        if (obj == null) {
            return false;
        }
        //si esta en la misma clase
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nif other = (Nif) obj;
        //compara numero y letra
        if (this.numero != other.numero) {
            return false;
        }
        return this.letra == other.letra;
    }
}

}
