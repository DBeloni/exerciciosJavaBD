package implemented;

import abstracts.ItemBiblioteca;

public class Dvd extends ItemBiblioteca {
    public Dvd(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazo() {
        return 3;
    }

    @Override
    public double getMultaDia() {
        return 1.50;
    }
}
