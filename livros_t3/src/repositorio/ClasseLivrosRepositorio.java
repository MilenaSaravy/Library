package repositorio;

import dominio.ClasseLivros;
import fakedb.ClasseLivrosFakeDB;

public class ClasseLivrosRepositorio extends BaseLivrosRepositorio<ClasseLivros> {

    private final ClasseLivrosFakeDB db;

    public ClasseLivrosRepositorio() {
        this.db = new ClasseLivrosFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public ClasseLivros Read(int chave) {
        for (ClasseLivros cp : this.dados) {
            if (cp.getCodigo() == chave) {
                return cp;
            }
        }
        return null;
    }

    @Override
    public ClasseLivros Edit(ClasseLivros instancia) {
        ClasseLivros cp = this.Read(instancia.getCodigo());
        if (cp != null) {
            cp.setTitulo(instancia.getTitulo());
            cp.setAutor(instancia.getAutor());
            cp.setISBN(instancia.getISBN());
            cp.setAnoPublicacao(instancia.getAnoPublicacao());
            return cp;
        }
        return null;
    }

    @Override
    public ClasseLivros Add(ClasseLivros instancia) {
        int pos = this.dados.size() - 1;
        ClasseLivros cp = this.dados.get(pos);
        int proxChave = cp.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public ClasseLivros Delete(int chave) {
        ClasseLivros cp = this.Read(chave);
        if (cp != null) {
            this.dados.remove(cp);
            return cp;
        }
        return null;
    }

    public ClasseLivros[] Listar() {
        return this.dados.toArray(new ClasseLivros[0]);
    }
}
