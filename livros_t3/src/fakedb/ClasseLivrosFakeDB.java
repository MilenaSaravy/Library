package fakedb;

import java.util.ArrayList;

import dominio.ClasseLivros;

public class ClasseLivrosFakeDB extends BaseFakeDB<ClasseLivros> {

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<>();
        this.tabela.add(new ClasseLivros(1, "Coraline", "Neil Gaiman", "978-85-510-0675-7", 2002));
        this.tabela.add(new ClasseLivros(2, "Jujutsu Kaisen", "Gege Akutami", "978-65-5512-207-7", 2018));
        this.tabela.add(new ClasseLivros(3, "Harry Potter", "J.K. Rowling", "978-85-325-2995-4", 1997));
        this.tabela.add(new ClasseLivros(4, "O Pequeno Principe", "Antoine de Saint-Exupery", "978-85-220-3144-3", 1943));
        this.tabela.add(new ClasseLivros(5, "Medo Classico", "Edgar Allan Poe", "978-85-945-4024-9", 1846));
        this.tabela.add(new ClasseLivros(6, "Solo Leveling", "Chu-Gong", "978-65-86799-19-4", 2018));
    }

    public ClasseLivrosFakeDB() {
        super();
    }
}
