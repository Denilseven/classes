public class Atendimento {
    Pet pet;
    int dia;
    int mes;
    int ano;

    public Atendimento(int dia, int mes, int ano) {
        this.pet = new Pet();
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Atendimento() {
        this.pet = new Pet();
        this.dia = 0;
        this.mes = 0;
        this.ano = 0;
    }
}
