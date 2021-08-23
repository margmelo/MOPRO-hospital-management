/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import java.io.Serializable;

/**
 * : Este conceito necessita de ter unicamente uma designação, por exemplo,
 * “máscaras”
 *
 * @author MOPRO_Grupo4
 */
public class TipoRecurso implements Serializable {

    /**
     * O nome do recurso
     */
    private String designacao;
    /**
     * A variável String por omissao
     */
    private static final String STRING_POR_OMISSAO = "N.D.";

    /**
     * Constroi uma instância de TipoRecurso com valores N.D.
     */
    public TipoRecurso() {
        setDesignacao(STRING_POR_OMISSAO);
    }

    /**
     * Constroi uma instancia de TipoRecurso com a designação passada por
     * parametro
     *
     * @param designacao A designação do tipo de recurso
     */
    public TipoRecurso(String designacao) {
        setDesignacao(designacao);
    }

    /**
     * Constroi uma instancia de TipoRecurso por cópia do passado por parâmetro
     *
     * * @param tr O tipo de recurso a copiar
     */
    public TipoRecurso(TipoRecurso tr) {
        setDesignacao(tr.designacao);
    }

    /**
     * Devolve a designação do recurso
     *
     * @return A designação do recurso
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Define a designação do recurso
     *
     * @param designacao A designação do recurso
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final TipoRecurso other = (TipoRecurso) obj;
        return this.designacao.compareToIgnoreCase(other.designacao) == 0;
    }

    @Override
    public String toString() {
        return "\n> " + designacao + " ";
    }
}
