package eldoria;

import java.util.ArrayList;

/**
 * Classe principal que demonstra os conceitos de POO aplicados no sistema de personagens de Eldoria.
 * Demonstra: herança, polimorfismo, encapsulamento, instanceof, equals() e hashCode().
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== BEM-VINDOS AO REINO DE ELDORIA ===");
        System.out.println("Os Guardiões se preparam para a batalha!\n");
        
        // Criando uma lista polimórfica de personagens
        ArrayList<Personagem> listaPersonagens = new ArrayList<>();
        
        // Adicionando Magos à lista
        listaPersonagens.add(new Mago("Valerius", 5, 80, 45.5));
        listaPersonagens.add(new Mago("Morgana", 8, 75, 60.0));
        
        // Adicionando Guerreiros à lista
        listaPersonagens.add(new Guerreiro("Thorin", 6, 150, 35.0));
        listaPersonagens.add(new Guerreiro("Ragnar", 7, 180, 40.0));
        
        // Percorrendo a lista e demonstrando polimorfismo
        for (Personagem p : listaPersonagens) {
            System.out.println("--- DADOS DO PERSONAGEM ---");
            System.out.println(p); // Polimorfismo no toString() de cada subclasse
            p.usarHabilidade();   // Polimorfismo no método abstrato usarHabilidade()
            System.out.println();
        }

        // Demonstrando o uso de instanceof (Identificação do tipo de subclasse)
        System.out.println("=== ANÁLISE DE CLASSES (instanceof) ===");
        int qtdMagos = 0;
        int qtdGuerreiros = 0;
        
        for (Personagem p : listaPersonagens) {
            if (p instanceof Mago) {
                qtdMagos++;
            } else if (p instanceof Guerreiro) {
                qtdGuerreiros++;
            }
        }
        System.out.println("Total de Magos na lista: " + qtdMagos);
        System.out.println("Total de Guerreiros na lista: " + qtdGuerreiros);
        System.out.println();

        // Demonstrando equals() e hashCode() (Comparação baseada em Nome e Classe)
        System.out.println("=== TESTE DE IGUALDADE (equals e hashCode) ===");
        Personagem magoClone = new Mago("Valerius", 1, 50, 10.0); // Mesmo nome/classe de Valerius, atributos diferentes
        Personagem magoPrincipal = listaPersonagens.get(0); // Pega o primeiro mago (Valerius)
        
        boolean saoIguais = magoPrincipal.equals(magoClone);
        System.out.println("O mago original e o clone são o mesmo personagem? " + saoIguais);
        System.out.println("Hash do Mago Original: " + magoPrincipal.hashCode());
        System.out.println("Hash do Mago Clone:    " + magoClone.hashCode());
    }
}
