package dao.generic.jdbc.dao;

import main.java.com.Cliente;
import main.java.com.Produto;

import java.util.List;

public interface IProdutoDAO {
    public Integer cadastrar(Produto produto) throws Exception;
    public Integer atualizar(Produto produto) throws Exception;
    public Produto buscar(Produto codigo) throws Exception;
    public List<Produto> buscarTodos() throws Exception;
    public Integer excluir(Produto produto) throws Exception;
}
