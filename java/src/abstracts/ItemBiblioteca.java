package abstracts;

public abstract class ItemBiblioteca {
    protected String codigo;
    protected String titulo;
    protected boolean disponivel;

    protected ItemBiblioteca ( String codigo, String titulo, boolean disponivel ) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = disponivel;
    }

    public abstract int getPrazo();
    public abstract double getMultaDia();

    public boolean isDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        String status = disponivel ? "Disponível" : "Emprestado";
        String tipo = this.getClass().getSimpleName();
        return "[" + tipo + "] Código: " + codigo + " | Título: " + titulo + " | Status: " + status;
    }
}