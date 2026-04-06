/*
 * Lista de Exercícios - POO
 * Prof: Diego Alves
 * Aluno: Denilson
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Carro {
    static int totalCarros = 0;

    private String marca;
    private String modelo;
    private int ano;

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public static final int ANO_MUITO_ANTIGO = 1886;
    public static final int ANO_MUITO_RECENTE = 2026;
    
    public int getAno() { return ano; }
    public boolean setAno(int ano) {
        if (ANO_MUITO_ANTIGO < 1886 || ano > ANO_MUITO_RECENTE) {
            System.out.println("Erro: ano inválido, deve ser entre " + ANO_MUITO_ANTIGO + " e " + ANO_MUITO_RECENTE);
            return false;
        }
        else {
            this.ano = ano;
            return true;
        }
    }

    public int idadeDoCarro() {
        return (2026 - this.ano);
    }

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        Carro.totalCarros++;
    }

    public Carro() {
        this.marca = "Desconhecido";
        this.modelo = "Desconhecido";
        this.ano = 0;
        Carro.totalCarros++;
    }

    public void exibir() {
        System.out.println("CARRO:");
        System.out.println("  Marca:  " + this.marca);
        System.out.println("  Modelo: " + this.modelo);
        System.out.println("  Ano:    " + this.ano + " (Idade: " + this.idadeDoCarro() + ")");
    }

    static int imprimirTotal() {
        System.out.println("Total de carros: " + Carro.totalCarros); // Acessando um valor (estático) da classe em si
        return Carro.totalCarros;
        // Uma função `static` não pode acessar atributos de uma instância
        // Suponho que seja pq não há referência à nenhuma instância (`this`) no caso
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Carro> carros = new ArrayList<Carro>();

        carros.add(new Carro("Wolfsagen", "AT09", 2010));
        carros.add(new Carro("Tóiot", "Horizon", 2017));
        carros.add(new Carro("Ronday", "Koloral", 1930));
        carros.add(new Carro("Wamaha", "Miku", 2007));
        carros.add(new Carro("Wario's", "Bowser", 1985));

        carros.forEach(carro -> carro.exibir());
        // Esse `forEach` é bem parecido com isso:
        // https://github.com/Denilseven/breakout-cppcon2014/blob/9e3c0501ea61c9fc66f6c6a5618a0dd92c3874cc/main.cxx#L363

        Carro.imprimirTotal();
    }
}
