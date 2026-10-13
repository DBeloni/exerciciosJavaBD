package implemented;

import abstracts.Usuario;

public class Aluno extends Usuario {
    private static final int ITENS_PERMITIDOS = 3;

    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public int getItensPermitidos() {
        return ITENS_PERMITIDOS;
    }
}
