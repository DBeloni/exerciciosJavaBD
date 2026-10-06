package implemented;

import abstracts.Usuario;

public class Aluno extends Usuario {
    private final int itensPermitidos = 3;

    public Aluno( String nome, int quantidadeEmprestada ) {
        super(nome, quantidadeEmprestada);
    }

    @Override
    public int getItensPermitidos() {
        return this.itensPermitidos;
    }
}