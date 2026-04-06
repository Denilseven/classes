/*
 * Lista de Exercícios - POO
 * Prof: Diego Alves
 * Aluno: Denilson
 */

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
        Carro carro1 = new Carro("Wolfsagen", "AT09", 2010);
        Carro carro2 = new Carro("Tóiot", "Horizon", 2017);

        carro1.exibir();
        carro2.exibir();
    }
}
