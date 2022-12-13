
package com.mycompany.dia_5;

public class Generala {
    String dado; //variable que contiene el dado
    int cont = 0; //contador para saber que tipo es
   
    String jugada (String dados) {
        int [] array_aux = new int [dados.length()]; //array auxiliar donde se cargan los numeros del dado
        int cont1 = 0; //contado auxiliar para la escalera
        
        for (int i=0; i<dados.length(); i++) { //ciclo donde se convierte el string a int y se guarda en cada posicion del array
            array_aux [i] = dados.charAt(i) - '0';
        }
        int esca = array_aux [0]; //se guarda el primer elemento en una variable auxiliar para la escalera
        
        for (int i=0; i<dados.length(); i++) { //aca se calculan todos los casos posibles
            for (int j=0; j<dados.length(); j++) {
                if (array_aux [i] == array_aux[j]) { //cuenta la cantidad de apariciones de elementos iguales para saber que tipo es
                    cont++;
                }
                if (array_aux [j] == esca) { //casos especiales para la escalera
                    if (esca == 6 && j == 0) {
                        cont1++;
                    }
                    if (esca == 6) {
                        esca = 0;
                    }
                    cont1++;
                    esca++;
                    if (esca == 2 && j == 4) {
                        return "ESCALERA";
                    }
                    
                    if (esca == 2 && j > 1) {
                        return "NADA";
                    }
                }
            }
        }
        //los casos correspondientes
        if (cont == 25) {
            return "GENERALA";
        }
        if (cont == 17) {
            return "POKER";
        }
        if (cont == 13) {
            return "FULL";
        }
        if (cont1 == 5) {
            return "ESCALERA";
        }
        return "NADA";
    }
    public static void main (String [] args) {
        Generala g = new Generala();
        String dado;
        double x = (int)(Math.random()*((99999-10000)+1))+10000; //generacion del numero random de 5 digitos
        dado = x + "";
        System.out.println(dado);
        System.out.println(g.jugada(dado)); 
    }
}
