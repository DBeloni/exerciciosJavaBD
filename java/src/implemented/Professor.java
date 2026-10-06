package implemented;

import abstracts.Usuario;

public class Professor extends Usuario {
    private final int itensPermitidos = 5;

    public Professor ( String nome, int quantidadeEmprestada ) {
        super(nome, quantidadeEmprestada);
    }

    @Override
    public int getItensPermitidos() {
        return this.itensPermitidos;
    }
}