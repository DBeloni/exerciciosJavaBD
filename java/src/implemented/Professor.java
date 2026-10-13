package implemented;

import abstracts.Usuario;

public class Professor extends Usuario {
    private static final int ITENS_PERMITIDOS = 5;

    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int getItensPermitidos() {
        return ITENS_PERMITIDOS;
    }
}
