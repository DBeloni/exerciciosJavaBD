import implemented.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca minhaBiblioteca = new Biblioteca(10);

        Livro livro1 = new Livro("L01", "Noites Brancas", true);
        Livro livro2 = new Livro("L02", "As Vantagens de Ser Invisível", true);
        Revista revista1 = new Revista("R01", "Pessoas Normais", true);
        Revista revista2 = new Revista("R02", "Norwegian Wood", true);

        minhaBiblioteca.adicionarItem(livro1);
        minhaBiblioteca.adicionarItem(livro2);
        minhaBiblioteca.adicionarItem(revista1);
        minhaBiblioteca.adicionarItem(revista2);

        Aluno aluno1 = new Aluno("Davi", 0);

        minhaBiblioteca.ListarAcervo();

        try {
            System.out.println("\n1º Livro");
            minhaBiblioteca.Emprestar(aluno1, livro1);

            System.out.println("\n2º Livro");
            minhaBiblioteca.Emprestar(aluno1, livro2);

            System.out.println("\n1ª Revista");
            minhaBiblioteca.Emprestar(aluno1, revista1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            System.out.println("\n2ª Revista");
            minhaBiblioteca.Emprestar(aluno1, revista2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n\nLista Final");
        minhaBiblioteca.ListarAcervo();
    }
}