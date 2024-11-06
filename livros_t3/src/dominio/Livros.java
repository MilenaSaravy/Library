package dominio;

public class Livros extends BaseLivros {
    private int codigoGenero;
    private Double valor;

    public int getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(int codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public Livros() {
        super();
    }

    public Livros(int codigo, String titulo, String autor, String ISBN, int AnoPublicacao, int codigoGenero) {
        super(codigo, titulo, autor, ISBN, AnoPublicacao);
        this.codigoGenero = codigoGenero;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "GeneroLivro{" +
               "codigo=" + codigo +
               ", titulo='" + titulo + '\'' +
               ", autor='" + autor + '\'' +
               ", ISBN='" + ISBN + '\'' +
               ", AnoPublicacao=" + AnoPublicacao +
               ", codigoGenero=" + codigoGenero +
               '}';
    }
}
