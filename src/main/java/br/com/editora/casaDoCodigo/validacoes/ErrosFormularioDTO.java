package br.com.editora.casaDoCodigo.validacoes;

public class ErrosFormularioDTO {
    private String campo;
    private String erro;

    public ErrosFormularioDTO(String campo, String erro) {

        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {

        return campo;
    }

    public String getErro() {

        return erro;
    }
}
