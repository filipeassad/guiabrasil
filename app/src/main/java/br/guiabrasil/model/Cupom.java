package br.guiabrasil.model;

/**
 * Created by 0118431 on 27/09/2016.
 */
public class Cupom {

    private Integer id;
    private String titulo;
    private String descricao;
    private String porcentagem;

    public Cupom() {
    }

    public Cupom(Integer id, String titulo, String descricao, String porcentagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.porcentagem = porcentagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem = porcentagem;
    }
}
