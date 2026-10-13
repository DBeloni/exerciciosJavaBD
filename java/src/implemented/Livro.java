package implemented;

import abstracts.ItemBiblioteca;

public class Livro extends ItemBiblioteca {
    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazo() {
        return 14;
    }

    @Override
    public double getMultaDia() {
        return 0.50;
    }
}
