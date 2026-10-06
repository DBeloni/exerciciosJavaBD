package implemented;

import abstracts.ItemBiblioteca;

public class Livro extends ItemBiblioteca {

    public Livro ( String codigo, String titulo, boolean disponivel ) {
        super(codigo, titulo, disponivel);
    }

    @Override
    public int getPrazo() {
        return 14;
    }

    @Override
    public double getMultaDia() {
        return 0.5;
    }
}