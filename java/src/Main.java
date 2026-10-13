import abstracts.ItemBiblioteca;
import implemented.Aluno;
import implemented.Dvd;
import implemented.Livro;
import implemented.Professor;
import implemented.Revista;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(10);

        Livro livro1 = new Livro("L01", "Noites Brancas");
        Livro livro2 = new Livro("L02", "As Vantagens de Ser Invisível");
        Revista revista1 = new Revista("R01", "Pessoas Normais");
        Revista revista2 = new Revista("R02", "Norwegian Wood");
        ItemBiblioteca dvd1 = new Dvd("D01", "Documentário de exemplo");

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(livro2);
        biblioteca.adicionarItem(revista1);
        biblioteca.adicionarItem(revista2);
        biblioteca.adicionarItem(dvd1);

        Aluno aluno = new Aluno("Davi");
        Professor professora = new Professor("Ana");

        biblioteca.listarAcervo();

        System.out.println("\n--- Empréstimos do aluno (limite: 3 itens) ---");
        biblioteca.emprestar(aluno, livro1);
        biblioteca.emprestar(aluno, livro2);
        biblioteca.emprestar(aluno, revista1);

        System.out.println("\n--- Quarta tentativa: deve ser recusada pelo limite ---");
        try {
            biblioteca.emprestar(aluno, revista2);
        } catch (IllegalArgumentException e) {
            System.out.println("Empréstimo recusado como esperado: " + e.getMessage());
        }

        System.out.println("\n--- Tentativa de devolução por outro usuário: deve ser recusada ---");
        try {
            biblioteca.devolver(professora, livro1);
        } catch (IllegalArgumentException e) {
            System.out.println("Devolução recusada como esperado: " + e.getMessage());
        }

        System.out.println("\n--- Devolução pelo aluno correto ---");
        biblioteca.devolver(aluno, livro1);

        System.out.println("\n--- Lista final ---");
        biblioteca.listarAcervo();
    }
}
