package eldoria;

import java.util.ArrayList;

/**
 * Classe principal - Nível Mestre.
 * Implementa polimorfismo dinâmico, verificação de tipos com instanceof e comparações.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== BEM-VINDOS AO REINO DE ELDORIA ===");
        
        ArrayList<Personagem> listaPersonagens = new ArrayList<>();
        
        // Cadastro de múltiplos personagens (2 Magos e 2 Guerreiros) protegidos por try-catch
        try {
            listaPersonagens.add(new Mago("Eldoran", 7, 60, 18.0));
            listaPersonagens.add(new Mago("Arthemis", 8, 75, 60.0));
            listaPersonagens.add(new Guerreiro("Thorin", 6, 150, 35.0));
            listaPersonagens.add(new Guerreiro("Ragnar", 7, 180, 40.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao inicializar heróis: " + e.getMessage());
        }
        
        int contadorHeroi = 1;
        
        // Iteração sobre a lista demonstrando polimorfismo dinâmico e instanceof
        for (Personagem p : listaPersonagens) {
            System.out.println("--- Herói " + contadorHeroi + " ---");
            System.out.println(p); // Polimorfismo no toString()
            
            // Vinculação dinâmica do método usarHabilidade()
            System.out.print("Habilidade: ");
            p.usarHabilidade();
            
            // Verificação de tipos com instanceof e mensagens personalizadas específicas
            if (p instanceof Mago) {
                System.out.println("O personagem " + p.getNome() + " é um Mago de nível " + p.getNivel() + ".");
            } else if (p instanceof Guerreiro) {
                System.out.println("O personagem " + p.getNome() + " é um Guerreiro de nível " + p.getNivel() + ".");
            }
            
            System.out.println();
            contadorHeroi++;
        }

        // Demonstração de comparações completas usando equals()
        System.out.println("Comparação: ");
        Personagem eldoran = listaPersonagens.get(0);
        Personagem arthemis = listaPersonagens.get(1);
        
        if (eldoran.equals(arthemis)) {
            System.out.println(eldoran.getNome() + " e " + arthemis.getNome() + " são iguais.");
        } else {
            System.out.println(eldoran.getNome() + " e " + arthemis.getNome() + " são diferentes.");
        }
        System.out.println();

        // TESTE ADICIONAL DE VALIDAÇÃO AUTOMÁTICA (Herança do Nível Aventureiro)
        try {
            new Guerreiro("Guerreiro Corrompido", 4, -5, 50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("[Validação Ativa]: Impendida criação inválida -> " + e.getMessage());
        }
    }
}
