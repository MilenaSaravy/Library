package servicio;

import java.util.ArrayList;

import dominio.ClasseLivros;
import repositorio.ClasseLivrosRepositorio;

public class ClasseLivroServicio extends BaseServicoLivros<ClasseLivros> {

    private final ClasseLivrosRepositorio repositorio;

    public ClasseLivroServicio() {
        this.repositorio = new ClasseLivrosRepositorio();
    }

    @Override
    public ArrayList<ClasseLivros> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public ClasseLivros Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public ClasseLivros Editar(ClasseLivros obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public ClasseLivros Adicionar(ClasseLivros obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public ClasseLivros Remover(int chave) {
        return this.repositorio.Delete(chave);
    }
}
