package abstracts;

public abstract class Usuario {
    private final String nome;
    private int quantidadeEmprestada;

    protected Usuario(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do usuário não pode ser vazio.");
        }
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public final String getNome() {
        return nome;
    }

    public final int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public abstract int getItensPermitidos();

    public final void registrarEmprestimo() {
        if (quantidadeEmprestada >= getItensPermitidos()) {
            throw new IllegalStateException("O usuário já atingiu o limite de itens emprestados.");
        }
        quantidadeEmprestada++;
    }

    public final void registrarDevolucao() {
        if (quantidadeEmprestada <= 0) {
            throw new IllegalStateException("O usuário não possui empréstimos para devolver.");
        }
        quantidadeEmprestada--;
    }
}
