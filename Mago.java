package eldoria;

/**
 * Representa a especialização de Mago no reino de Eldoria.
 */
public class Mago extends Personagem {

    // Construtor que repassa os parâmetros para a superclasse abstrata
    public Mago(String nome, int nivel, int pontosDeVida, double poderBase) {
        super(nome, "Mago", nivel, pontosDeVida, poderBase);
    }

    /**
     * Sobrescrita obrigatória do método abstrato da classe mãe.
     */
    @Override
    public void usarHabilidade() {
        System.out.println(getNome() + " conjurou uma Bola de Fogo arcana!");
    }
}
