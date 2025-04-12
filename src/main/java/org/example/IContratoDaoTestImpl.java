package org.example;


public class IContratoDaoTestImpl implements IcontratoDao {
    @Override
    public String salvar(Contrato contrato) {
        return "sucesso";
    }

    @Override
    public String buscar(Long id) {
        return "sucesso";
    }

    @Override
    public String excluir(Long id) {
        return "sucesso";
    }

    @Override
    public String atualizar(Contrato contrato) {
        return "sucesso";
    }
}
