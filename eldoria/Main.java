package eldoria;

import java.util.ArrayList;

/**
 * Classe principal - Nível Aventureiro.
 * Demonstra tratamento de exceções além de herança, polimorfismo, equals e hashCode.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== BEM-VINDOS AO REINO DE ELDORIA (NÍVEL AVENTUREIRO) ===");
        System.out.println("Os Guardiões se preparam para a batalha!\n");
        
        ArrayList<Personagem> listaPersonagens = new ArrayList<>();
        
        // Criando personagens com dados válidos dentro de um bloco protegido
        try {
            listaPersonagens.add(new Mago("Valerius", 5, 80, 45.5));
            listaPersonagens.add(new Mago("Morgana", 8, 75, 60.0));
            listaPersonagens.add(new Guerreiro("Thorin", 6, 150, 35.0));
            listaPersonagens.add(new Guerreiro("Ragnar", 7, 180, 40.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao inicializar guilda: " + e.getMessage());
        }
        
        // Percorrendo a lista e demonstrando polimorfismo e formatação do toString()
        for (Personagem p : listaPersonagens) {
            System.out.println("--- DADOS DO PERSONAGEM ---");
            System.out.println(p); 
            p.usarHabilidade();   
            System.out.println();
        }

        // Demonstrando equals() e hashCode()
        System.out.println("=== TESTE DE IGUALDADE (equals e hashCode) ===");
        Personagem magoClone = new Mago("Valerius", 1, 50, 10.0);
        Personagem magoPrincipal = listaPersonagens.get(0);
        
        System.out.println("O mago original e o clone são o mesmo personagem? " + magoPrincipal.equals(magoClone));
        System.out.println("Hash do Mago Original: " + magoPrincipal.hashCode());
        System.out.println("Hash do Mago Clone:    " + magoClone.hashCode());
        System.out.println();

        // DEMONSTRAÇÃO DO NÍVEL AVENTUREIRO: Tratamento de erro em tempo de execução
        System.out.println("=== TESTE DE VALIDAÇÃO AUTOMÁTICA (Tratamento de Erros) ===");
        try {
            System.out.println("Tentando criar um guerreiro com pontos de vida negativos...");
            // Instanciação direta sem variável não utilizada para evitar o aviso do compilador
            new Guerreiro("Assis", 4, -10, 50.0);
        } catch (IllegalArgumentException e) {
            // O sistema captura o erro lançado pelo setter impedindo a criação do objeto
            System.out.println("Capturado com sucesso! " + e.getMessage());
        }
    }
}
