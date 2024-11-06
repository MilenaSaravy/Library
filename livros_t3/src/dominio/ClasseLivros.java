package dominio;

public class ClasseLivros extends BaseLivros {

    public ClasseLivros(int codigo, String titulo, String autor, String ISBN, int AnoPublicacao) {
        super(codigo, titulo, autor, ISBN, AnoPublicacao);
    }

    public ClasseLivros() {
        super();
    }

    @Override
    public String toString() {
        return "ClasseLivros{" +
               "codigo=" + codigo +
               ", titulo='" + titulo + '\'' +
               ", autor='" + autor + '\'' +
               ", ISBN='" + ISBN + '\'' +
               ", AnoPublicacao=" + AnoPublicacao +
               '}';
    }
}
