/*
 * Lista de Exercícios - POO
 * Prof: Diego Alves
 * Aluno: Denilson
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Carro {
    String marca;
    String modelo;
    int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibir() {
        System.out.println("CARRO:");
        System.out.println("  Marca:  " + this.marca);
        System.out.println("  Modelo: " + this.modelo);
        System.out.println("  Ano:    " + this.ano + " (Idade: " + this.idadeDoCarro() + ")");
    }

    public int idadeDoCarro() {
        return (2026 - this.ano);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Carro> carros = new ArrayList<Carro>();

        carros.add(new Carro("Wolfsagen", "AT09", 2010));
        carros.add(new Carro("Tóiot", "Horizon", 2017));
        carros.add(new Carro("Ronday", "Koloral", 1830));

        carros.forEach(carro -> carro.exibir());
        // Esse `forEach` é bem parecido com isso:
        // https://github.com/Denilseven/breakout-cppcon2014/blob/9e3c0501ea61c9fc66f6c6a5618a0dd92c3874cc/main.cxx#L363
    }
}
