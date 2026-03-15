public class Pet {
    String name;
    float peso;

    public Pet(String name, float peso) {
        this.name = name;
        this.peso = peso;
    }

    public Pet(String name) {
        this.name = name;
        this.peso = -1;
    }

    public Pet() {
        this.name = "Novo Pet";
        this.peso = -1;
    }
}
