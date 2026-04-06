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
    // `final` praticamente significa "constante" para variáveis
    // (Google) Também pode ser usado para métodos que não podem ser sobrescritos e classes que não podem ser herdadas
    
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



        int x;
        { // (Dá pra definir escopos só usando {} mas parece bem estranho kk)
            x = 10; // Essa variável é acessível aqui
            int g; // Variável definida dentro desse escopo, e será destruída no final dele ...
        }
        // ... A variável `g` já não é mais acessível aqui
        System.out.println(x);



        int a = 10;
        int b = a; // Definindo o valor de `b` para o valor que está em `a`, 10
        b = 99;
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 99
        // Alterar `b` não alterou o valor de `a`



        Carro c1 = new Carro("Fiat", "Uno", 2020);
        Carro c2 = c1; // Definindo o valor de `c2` para o endereço de `c1`
        c2.setModelo("Palio");
        System.out.println(c1.getModelo()); // Palio
        System.out.println(c2.getModelo()); // Palio
        // `Carro` não é um objeto primitivo como `int`, ele é alocado no Heap
        // A variável `c2` passa a apontar para o mesmo endereço Heap que `c1`
        // Sendo assim, ambos `c1` e `c2` compartilham do mesmo objeto, referenciando à mesma coisa
        // (Objetos primitivos são alocados no Stack ao invés do Heap)



        Carro meuCarro = new Carro("VW", "Gol", 2015);
        trocarModelo(meuCarro); // Aqui nós estamos passando uma referência para `meuCarro`
        System.out.println(meuCarro.getModelo()); // Fusca
    }

    public static void trocarModelo(Carro c) {
        c.setModelo("Fusca");
        // `c` aponta para uma referência do objeto passado, e não à uma cópia dele
    }
}
