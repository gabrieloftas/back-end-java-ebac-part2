package org.example;

public interface IcontratoDao {
    String salvar(Contrato contrato);

    String buscar(Long id);

    String excluir(Long id);

    String atualizar(Contrato contrato);
}


