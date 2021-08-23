/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import java.io.Serializable;

/**
 * Esta entidade caracteriza-se por um código único, o tipo de recurso a que se
 * refere e uma descrição, a qual serve para descrever mais detalhadamente um
 * recurso, por exemplo, “máscaras cirúrgicas”;
 *
 * @author MOPRO_Grupo4
 */
public class Recurso implements Serializable {

    /**
     * código do recurso gerado automaticamente
     */
    private int codRecurso;
    /**
     * designação do recurso
     */
    private TipoRecurso tipoRecurso;
    /**
     * descrição do recurso
     */
    private String descricao;
    /**
     * código automático atribuido ao recursp
     */
    private static int totalRecursos = 0;
    /**
     * variável String por omissão
     */
    private static final String STRING_POR_OMISSAO = "N.D.";

    /**
     * Constrói uma instância do recurso com valores N.D.
     */
    public Recurso() {
        setCodRecurso(codRecurso);
        setTipoRecurso(new TipoRecurso());
        setDescricao(STRING_POR_OMISSAO);
    }

    /**
     * COnstrói ima instância de recurso com os valores passados por parâmetro.
     * O código de recurso é gerado automáticamente
     *
     * @param tipoRecurso O tipo de recurso
     * @param descricao A descrição do recurso
     */
    public Recurso(TipoRecurso tipoRecurso, String descricao) {
        setCodRecurso(codRecurso);
        setTipoRecurso(new TipoRecurso(tipoRecurso));
        setDescricao(descricao);
    }

    /**
     * Constroi uma instância de recurso por cópia do recurso passado por
     * parâmetro
     *
     * @param r O recurso a copiar
     */
    public Recurso(Recurso r) {
        setCodRecurso(r.codRecurso);
        setTipoRecurso(new TipoRecurso(r.tipoRecurso));
        setDescricao(r.descricao);
    }

    /**
     * Devolve o código do recurso
     *
     * @return O código do recurso
     */
    public int getCodRecurso() {
        return codRecurso;
    }

    /**
     * Devolve o tipo de recurso
     *
     * @return O tipo de recurso
     */
    public TipoRecurso getTipoRecurso() {
        return new TipoRecurso(tipoRecurso);
    }
    
    public void setCodRecurso(int totalRecursos) {
        this.codRecurso = ++totalRecursos;
    }

    /**
     * Define o tipo de recurso
     *
     * @param tipoRecurso O tipo de recurso
     */
    public void setTipoRecurso(TipoRecurso tipoRecurso) {
        this.tipoRecurso = new TipoRecurso(tipoRecurso);
    }

    /**
     * Devolve a descrição do recurso
     *
     * @return A descrição do recurso
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do recurso
     *
     * @param descricao A descrição do recurso
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Recurso other = (Recurso) obj;
        return this.codRecurso == other.codRecurso
                && this.descricao.equals(other.descricao)
                && this.tipoRecurso.equals(other.tipoRecurso);
    }

    /**
     * Devolve a descrição textual do recurso
     *
     * @retun Características do recurso
     *
     */
    @Override
    public String toString() {
        return tipoRecurso + "#" + codRecurso + " " + descricao;
    }


}
