package test.java.com;

import dao.generic.jdbc.dao.IProdutoDAO;
import dao.generic.jdbc.dao.ProdutoDAO;
import main.java.com.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Notebook Dell");
        produto.setPreco(2500.00);
        produto.setDescricao("Notebook Dell Inspiron 15");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBusca = new Produto();
        produtoBusca.setCodigo("10");
        Produto produtoBD = produtoDAO.buscar(produtoBusca);

        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Mouse Logitech");
        produto.setPreco(85.50);
        produto.setDescricao("Mouse sem fio Logitech");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBusca = new Produto();
        produtoBusca.setCodigo("10");
        Produto produtoBD = produtoDAO.buscar(produtoBusca);

        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Teclado Mecânico");
        produto.setPreco(350.00);
        produto.setDescricao("Teclado mecânico RGB");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBusca = new Produto();
        produtoBusca.setCodigo("10");
        Produto produtoBD = produtoDAO.buscar(produtoBusca);

        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigo("10");
        produto1.setNome("Monitor Samsung");
        produto1.setPreco(800.00);
        produto1.setDescricao("Monitor 24 polegadas");

        Integer countCad = produtoDAO.cadastrar(produto1);
        assertTrue(countCad == 1);

        Produto produto2 = new Produto();
        produto2.setCodigo("20");
        produto2.setNome("Webcam Logitech");
        produto2.setPreco(250.00);
        produto2.setDescricao("Webcam Full HD");

        Integer countCad2 = produtoDAO.cadastrar(produto2);
        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = produtoDAO.buscarTodos();
        assertEquals(list.size(), 0);
    }

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Smartphone Samsung");
        produto.setPreco(1200.00);
        produto.setDescricao("Galaxy S23");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBusca = new Produto();
        produtoBusca.setCodigo("10");
        Produto produtoBD = produtoDAO.buscar(produtoBusca);

        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());
        assertEquals(produto.getDescricao(), produtoBD.getDescricao());

        produtoBD.setCodigo("20");
        produtoBD.setNome("iPhone 15");
        produtoBD.setPreco(5500.00);
        produtoBD.setDescricao("iPhone 15 Pro Max");

        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoBusca1 = new Produto();
        produtoBusca1.setCodigo("10");
        Produto produtoBD1 = produtoDAO.buscar(produtoBusca1);
        assertNull(produtoBD1);

        Produto produtoBusca2 = new Produto();
        produtoBusca2.setCodigo("20");
        Produto produtoBD2 = produtoDAO.buscar(produtoBusca2);

        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());
        assertEquals(produtoBD.getPreco(), produtoBD2.getPreco());
        assertEquals(produtoBD.getDescricao(), produtoBD2.getDescricao());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
        }
    }
}
