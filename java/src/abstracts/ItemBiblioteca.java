package abstracts;

public abstract class ItemBiblioteca {
    private final String codigo;
    private final String titulo;
    private boolean disponivel;

    protected ItemBiblioteca(String codigo, String titulo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O código do item não pode ser vazio.");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título do item não pode ser vazio.");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public abstract int getPrazo();

    public abstract double getMultaDia();

    public final String getCodigo() {
        return codigo;
    }

    public final String getTitulo() {
        return titulo;
    }

    public final boolean isDisponivel() {
        return disponivel;
    }

    public final void emprestar() {
        if (!disponivel) {
            throw new IllegalStateException("Este item já está emprestado.");
        }
        disponivel = false;
    }

    public final void devolver() {
        if (disponivel) {
            throw new IllegalStateException("Este item não está emprestado.");
        }
        disponivel = true;
    }

    @Override
    public String toString() {
        String status = disponivel ? "Disponível" : "Emprestado";
        String tipo = getClass().getSimpleName();
        return "[" + tipo + "] Código: " + codigo + " | Título: " + titulo + " | Status: " + status;
    }
}
