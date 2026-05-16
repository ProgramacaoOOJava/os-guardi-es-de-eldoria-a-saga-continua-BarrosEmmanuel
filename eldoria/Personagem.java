package eldoria;

import java.util.Objects;

/**
 * Classe base para representar personagens do reino de Eldoria.
 * Nível Aventureiro: Adicionado tratamento de exceções robusto nos métodos modificadores.
 */
public abstract class Personagem {
    private String nome;
    private String classe;
    private int nivel;
    private int pontosDeVida;
    private double poderBase;

    // O construtor agora utiliza os setters para garantir que as validações rodem na criação
    public Personagem(String nome, String classe, int nivel, int pontosDeVida, double poderBase) {
        setNome(nome);
        setClasse(classe);
        setNivel(nivel);
        setPontosDeVida(pontosDeVida);
        setPoderBase(poderBase);
    }

    public String getNome() { return nome; }
    public String getClasse() { return classe; }
    public int getNivel() { return nivel; }
    public int getPontosDeVida() { return pontosDeVida; }
    public double getPoderBase() { return poderBase; }

    // Setters com validações automáticas e tratamento de exceções
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro de Validação: O nome do personagem não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setClasse(String classe) {
        if (classe == null || classe.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro de Validação: A classe do personagem não pode ser vazia.");
        }
        this.classe = classe;
    }

    public void setNivel(int nivel) {
        if (nivel <= 0) {
            throw new IllegalArgumentException("Erro de Validação: O nível deve ser maior que zero.");
        }
        this.nivel = nivel;
    }

    public void setPontosDeVida(int pontosDeVida) {
        if (pontosDeVida < 0) {
            throw new IllegalArgumentException("Erro de Validação: Os pontos de vida não podem ser negativos.");
        }
        this.pontosDeVida = pontosDeVida;
    }

    public void setPoderBase(double poderBase) {
        if (poderBase < 0) {
            throw new IllegalArgumentException("Erro de Validação: O poder base não pode ser negativo.");
        }
        this.poderBase = poderBase;
    }

    public abstract void usarHabilidade();

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
               "Classe: " + classe + "\n" +
               "Nível: " + nivel + "\n" +
               "Pontos de Vida: " + pontosDeVida + "\n" +
               "Poder Base: " + poderBase;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Personagem other = (Personagem) obj;
        return Objects.equals(nome, other.nome) && 
               Objects.equals(classe, other.classe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, classe);
    }
}
