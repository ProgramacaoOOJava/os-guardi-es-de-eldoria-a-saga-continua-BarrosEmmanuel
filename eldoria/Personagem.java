package eldoria;

import java.util.Objects;

/**
 * Classe base para representar personagens do reino de Eldoria.
 * Aplica conceitos de encapsulamento, herança e polimorfismo.
 */
public abstract class Personagem {
    // Atributos privados (encapsulamento)
    private String nome;
    private String classe;
    private int nivel;
    private int pontosDeVida;
    private double poderBase;

    // * Construtor que inicializa todos os atributos do personagem.
    public Personagem(String nome, String classe, int nivel, int pontosDeVida, double poderBase) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
        this.poderBase = poderBase;
    }

    // Getters
    public String getNome() { return nome; }
    public String getClasse() { return classe; }
    public int getNivel() { return nivel; }
    public int getPontosDeVida() { return pontosDeVida; }
    public double getPoderBase() { return poderBase; }

    // Setters com validações
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }

    public void setClasse(String classe) {
        if (classe != null && !classe.trim().isEmpty()) {
            this.classe = classe;
        }
    }

    public void setNivel(int nivel) {
        if (nivel > 0) {
            this.nivel = nivel;
        }
    }

    // * Criar métodos que define os pontos de vida do personagem.
    public void setPontosDeVida(int pontosDeVida) {
        if (pontosDeVida >= 0) {
            this.pontosDeVida = pontosDeVida;
        }
    }

    public void setPoderBase(double poderBase) {
        if (poderBase >= 0) {
            this.poderBase = poderBase;
        }
    }

    /**
     * Criar método que define a habilidade do personagem.
     * Deve ser sobrescrito pelas subclasses para implementar comportamentos específicos.
     */
    public abstract void usarHabilidade();

    /**
     * Sobrescrita do método toString() para exibir informações do personagem.
     * @return String formatada com todos os atributos do personagem
     */
    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
               "Classe: " + classe + "\n" +
               "Nível: " + nivel + "\n" +
               "Pontos de Vida: " + pontosDeVida + "\n" +
               "Poder Base: " + poderBase;
    }

    /**
     * Sobrescrita do método equals() para comparar personagens.
     * Dois personagens são considerados iguais se tiverem o mesmo nome e classe.
     * @param obj Objeto a ser comparado
     * @return true se os personagens forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Personagem other = (Personagem) obj;
        return Objects.equals(nome, other.nome) && 
               Objects.equals(classe, other.classe);
    }

    /**
     * Sobrescrita do método hashCode() para ser consistente com equals().
     * @return Código hash baseado no nome e classe
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, classe);
    }
}
