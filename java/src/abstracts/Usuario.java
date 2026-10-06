package abstracts;

public abstract class Usuario {
    protected String nome;
    protected int quantidadeEmprestada;

    protected Usuario ( String nome, int quantidadeEmprestada ) {
        this.nome = nome;
        this.quantidadeEmprestada = quantidadeEmprestada;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public void setQuantidadeEmprestada(int quantidadeEmprestada) {
        this.quantidadeEmprestada = quantidadeEmprestada;
    }

    public abstract int getItensPermitidos();
}