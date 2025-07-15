package dao.generic.jdbc.dao;

import dao.generic.jdbc.dao.ConnectionFactory;
import dao.generic.jdbc.dao.IProdutoDAO;
import main.java.com.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm, produto);
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, produto);
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Produto buscar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produtoEncontrado = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm, produto);
            rs = stm.executeQuery();
            if (rs.next()) {
                produtoEncontrado = new Produto();
                Long id = rs.getLong("PK_ID_PRODUTOS");
                String nome = rs.getString("NOME");
                String codigo = rs.getString("CODIGO");
                Double preco = rs.getDouble("PRECO");
                String descricao = rs.getString("DESCRICAO");

                produtoEncontrado.setId(id);
                produtoEncontrado.setNome(nome);
                produtoEncontrado.setCodigo(codigo);
                produtoEncontrado.setPreco(preco);
                produtoEncontrado.setDescricao(descricao);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return produtoEncontrado;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> list = new ArrayList<>();
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("PK_ID_PRODUTOS");
                String nome = rs.getString("NOME");
                String codigo = rs.getString("CODIGO");
                Double preco = rs.getDouble("PRECO");
                String descricao = rs.getString("DESCRICAO");

                produto.setId(id);
                produto.setNome(nome);
                produto.setCodigo(codigo);
                produto.setPreco(preco);
                produto.setDescricao(descricao);
                list.add(produto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return list;
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, produto);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    // Métodos SQL
    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_PRODUTOS(PK_ID_PRODUTOS, CODIGO, NOME, PRECO, DESCRICAO) ");
        sb.append("VALUES(DEFAULT, ?, ?, ?, ?)");
        return sb.toString();
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_PRODUTOS ");
        sb.append("SET NOME = ?, PRECO = ?, DESCRICAO = ? ");
        sb.append("WHERE PK_ID_PRODUTOS = ?");
        return sb.toString();
    }

    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_PRODUTOS ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }

    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_PRODUTOS");
        return sb.toString();
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM TB_PRODUTOS ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }

    // Métodos para adicionar parâmetros
    private void adicionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
        stm.setString(2, produto.getNome());
        stm.setDouble(3, produto.getPreco());
        stm.setString(4, produto.getDescricao());
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
        stm.setDouble(2, produto.getPreco());
        stm.setString(3, produto.getDescricao());
        stm.setLong(4, produto.getId());
    }

    private void adicionarParametrosSelect(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
