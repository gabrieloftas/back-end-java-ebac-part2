package org.example;

public class Contrato {
    private final long l;
    private final String clienteAtualizado;
    private final String servicoAtualizado;
    private final double v;

    public Contrato(long l, String clienteAtualizado, String servicoAtualizado, double v) {
        this.l = l;
        this.clienteAtualizado = clienteAtualizado;
        this.servicoAtualizado = servicoAtualizado;
        this.v = v;
    }
}
