
import org.example.Contrato;
import org.example.IContratoDaoTestImpl;
import org.example.IcontratoDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContratoDAOTest {

    @Test
    void testSalvarComSucesso() {
        IcontratoDao contratoDAO = new IContratoDaoTestImpl();
        Contrato novoContrato = new Contrato(1L, "Cliente Teste", "Serviço Teste", 100.00);
        String resultado = contratoDAO.salvar(novoContrato);
        assertEquals("sucesso", resultado);
    }

    @Test
    void testBuscarComSucesso() {
        IcontratoDao contratoDAO = new IContratoDaoTestImpl();
        String resultado = contratoDAO.buscar(1L);
        assertEquals("sucesso", resultado);
    }

    @Test
    void testExcluirComSucesso() {
        IcontratoDao contratoDAO = new IContratoDaoTestImpl();
        String resultado = contratoDAO.excluir(1L);
        assertEquals("sucesso", resultado);
    }

    @Test
    void testAtualizarComSucesso() {
        IcontratoDao contratoDAO = new IContratoDaoTestImpl();
        Contrato contratoAtualizado = new Contrato(1L, "Cliente Atualizado", "Serviço Atualizado", 200.00);
        String resultado = contratoDAO.atualizar(contratoAtualizado);
        assertEquals("sucesso", resultado);
    }
}