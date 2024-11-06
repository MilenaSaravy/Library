package dominio;

public abstract class BaseLivros {
    protected int codigo;
    protected String titulo;
    protected String autor;
    protected String ISBN;
    protected int AnoPublicacao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnoPublicacao() {
        return AnoPublicacao;
    }

    public void setAnoPublicacao(int AnoPublicacao) {
        this.AnoPublicacao = AnoPublicacao;
    }

    public BaseLivros() {
    }

    public BaseLivros(int codigo, String titulo, String autor, String ISBN, int AnoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.AnoPublicacao = AnoPublicacao;
    }
}
