package eldoria;

/**
 * Representa a especialização de Guerreiro no reino de Eldoria.
 */
public class Guerreiro extends Personagem {

    // Construtor que define automaticamente a classe como "Guerreiro"
    public Guerreiro(String nome, int nivel, int pontosDeVida, double poderBase) {
        super(nome, "Guerreiro", nivel, pontosDeVida, poderBase);
    }

    /**
     * Sobrescrita obrigatória do método abstrato da classe mãe.
     */
    @Override
    public void usarHabilidade() {
        System.out.println(getNome() + " executou um Golpe Demolidor com sua espada!");
    }
}
