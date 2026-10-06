import abstracts.Usuario;
import abstracts.ItemBiblioteca;

public class Biblioteca {
    private ItemBiblioteca[] acervo;
    private int quantidadeItens;

    public Biblioteca(int capacidadeMaxima) {
        this.acervo = new ItemBiblioteca[capacidadeMaxima];
        this.quantidadeItens = 0;
    }

    public void adicionarItem(ItemBiblioteca item) {
        if (quantidadeItens >= acervo.length) {
            throw new IllegalArgumentException("Biblioteca cheia! Não é possível adicionar mais itens.");
        }

        acervo[quantidadeItens] = item;
        quantidadeItens++;
    }

    public void Emprestar(Usuario usuario, ItemBiblioteca item) {
        if (usuario.getQuantidadeEmprestada() >= usuario.getItensPermitidos()) {
            throw new IllegalArgumentException("Não é possível emprestar! Limite atingido.");
        }

        if (!(item.isDisponivel())) {
            throw new IllegalArgumentException("Este item já está emprestado!");
        }

        System.out.println("Empréstimo realizado com sucesso!");
        usuario.setQuantidadeEmprestada(usuario.getQuantidadeEmprestada() + 1);
        item.setDisponivel(false);
    }

    public void Devolver(Usuario usuario, ItemBiblioteca item) {
        if (usuario.getQuantidadeEmprestada() <= 0) {
            throw new IllegalArgumentException("Não é possível devolver! Não foram feitos empréstimos.");
        }

        System.out.println("Devolução realizada com sucesso!");
        usuario.setQuantidadeEmprestada(usuario.getQuantidadeEmprestada() - 1);
        item.setDisponivel(true);
    }

    public void ListarAcervo() {
        if (quantidadeItens == 0) {
            System.out.println("O acervo está vazio.");
            return;
        }

        System.out.println("\nAcervo:");
        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println(acervo[i].toString());
        }
    }
}