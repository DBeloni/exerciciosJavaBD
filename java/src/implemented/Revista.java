package implemented;

import abstracts.ItemBiblioteca;

public class Revista extends ItemBiblioteca {

    public Revista ( String codigo, String titulo, boolean disponivel ) {
        super(codigo, titulo, disponivel);
    }

    @Override
    public int getPrazo() {
        return 7;
    }

    @Override
    public double getMultaDia() {
        return 1.0;
    }
}