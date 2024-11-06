package servicio;

import java.util.ArrayList;

public abstract class BaseServicoLivros<TDominio> {
    
    public abstract ArrayList<TDominio> Navegar();

    public abstract TDominio Ler(int chave);

    public abstract TDominio Editar(TDominio obj);

    public abstract TDominio Adicionar(TDominio obj);

    public abstract TDominio Remover(int chave);
}
