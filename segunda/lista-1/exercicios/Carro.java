public class Carro {
    private static int totalCarros = 0;

    private String marca;
    private String modelo;
    private int ano;

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public int getAno() { return ano; }
    public void setAno(int ano) { if (anoValido(ano)) this.ano = ano; }

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

    public static int imprimirTotal() {
        System.out.println("Total de carros: " + Carro.totalCarros); // Acessando um valor (estático) da classe em si
        return Carro.totalCarros;
        // Uma função `static` não pode acessar atributos de uma instância
        // Suponho que seja pq não há referência à nenhuma instância (`this`) no caso
    }

    public static final int ANO_MUITO_ANTIGO = 1886;
    public static final int ANO_MUITO_RECENTE = 2026;
    // `final` praticamente significa "constante" para variáveis
    // (Google) Também pode ser usado para métodos que não podem ser sobrescritos e classes que não podem ser herdadas

    public static boolean anoValido(int ano) {
        return !(ano < ANO_MUITO_ANTIGO || ano > ANO_MUITO_RECENTE);
        // System.out.println("Erro: ano inválido, deve ser entre " + Carro.ANO_MUITO_ANTIGO + " e " + Carro.ANO_MUITO_RECENTE);
    }
}
