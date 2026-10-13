import abstracts.ItemBiblioteca;
import abstracts.Usuario;

public class Biblioteca {
    private final ItemBiblioteca[] acervo;
    private final Usuario[] responsaveisPorItem;
    private int quantidadeItens;

    public Biblioteca(int capacidadeMaxima) {
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("A capacidade máxima deve ser maior que zero.");
        }
        this.acervo = new ItemBiblioteca[capacidadeMaxima];
        this.responsaveisPorItem = new Usuario[capacidadeMaxima];
        this.quantidadeItens = 0;
    }

    public void adicionarItem(ItemBiblioteca item) {
        if (item == null) {
            throw new IllegalArgumentException("Não é possível adicionar um item nulo.");
        }
        if (quantidadeItens >= acervo.length) {
            throw new IllegalArgumentException("Biblioteca cheia! Não é possível adicionar mais itens.");
        }
        if (buscarIndiceItem(item) >= 0) {
            throw new IllegalArgumentException("Este item já está cadastrado no acervo.");
        }
        for (int i = 0; i < quantidadeItens; i++) {
            if (acervo[i].getCodigo().equals(item.getCodigo())) {
                throw new IllegalArgumentException("Já existe um item com o código " + item.getCodigo() + ".");
            }
        }

        acervo[quantidadeItens] = item;
        quantidadeItens++;
    }

    public void emprestar(Usuario usuario, ItemBiblioteca item) {
        if (usuario == null || item == null) {
            throw new IllegalArgumentException("Usuário e item devem ser informados.");
        }

        int indice = buscarIndiceItem(item);
        if (indice < 0) {
            throw new IllegalArgumentException("O item não pertence ao acervo desta biblioteca.");
        }
        if (usuario.getQuantidadeEmprestada() >= usuario.getItensPermitidos()) {
            throw new IllegalArgumentException("Não é possível emprestar: limite de itens atingido.");
        }
        if (!item.isDisponivel()) {
            throw new IllegalArgumentException("Este item já está emprestado.");
        }

        usuario.registrarEmprestimo();
        item.emprestar();
        responsaveisPorItem[indice] = usuario;
        System.out.println("Empréstimo realizado com sucesso: " + item.getTitulo() + " -> " + usuario.getNome());
    }

    public void devolver(Usuario usuario, ItemBiblioteca item) {
        if (usuario == null || item == null) {
            throw new IllegalArgumentException("Usuário e item devem ser informados.");
        }

        int indice = buscarIndiceItem(item);
        if (indice < 0) {
            throw new IllegalArgumentException("O item não pertence ao acervo desta biblioteca.");
        }
        if (item.isDisponivel() || responsaveisPorItem[indice] == null) {
            throw new IllegalArgumentException("Este item não possui empréstimo em aberto.");
        }
        if (responsaveisPorItem[indice] != usuario) {
            throw new IllegalArgumentException("A devolução deve ser feita pelo usuário que pegou o item.");
        }
        if (usuario.getQuantidadeEmprestada() <= 0) {
            throw new IllegalStateException("O contador de empréstimos do usuário está inconsistente.");
        }

        item.devolver();
        usuario.registrarDevolucao();
        responsaveisPorItem[indice] = null;
        System.out.println("Devolução realizada com sucesso: " + item.getTitulo() + " <- " + usuario.getNome());
    }

    public void listarAcervo() {
        if (quantidadeItens == 0) {
            System.out.println("O acervo está vazio.");
            return;
        }

        System.out.println("\nAcervo:");
        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println(acervo[i]);
        }
    }

    private int buscarIndiceItem(ItemBiblioteca item) {
        for (int i = 0; i < quantidadeItens; i++) {
            if (acervo[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
