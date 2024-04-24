package com.aluracursos.screenmatch.excepcion;

public class ErrorConvertirDuracionException extends RuntimeException {
    private String mensaje;

    public ErrorConvertirDuracionException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
