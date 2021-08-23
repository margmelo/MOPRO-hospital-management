/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import java.io.Serializable;

/**
 * Esta entidade possui como atributos o recurso e a quantidade em stock
 * respetiva.
 *
 * @author MOPRO_Grupo4
 */
public class RecursoStock implements Serializable {

    /**
     * O recurso
     */
    private Recurso recurso;

    /**
     * A quantidade em stock do recurso
     */
    private int qtStock;

    /**
     * Variável inteira por omissão
     */
    private static final int INT_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de RecursoStoxk sem parâmetros
     */
    public RecursoStock() {
        setRecurso(new Recurso());
        setQtStock(INT_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de RecursoStock com os valores passados por
     * parâmetro
     *
     * @param recurso
     * @param qtStock
     */
    public RecursoStock(Recurso recurso, int qtStock) {
        setRecurso(new Recurso(recurso));
        setQtStock(qtStock);
    }

    /**
     * Constroi uma instância de RecursoStock por cópia do passado por parâmetro
     *
     * @param rs
     */
    public RecursoStock(RecursoStock rs) {
        setRecurso(new Recurso(rs.recurso));
        setQtStock(rs.qtStock);
    }

    /**
     * Devolve o recurso
     *
     * @return O recurso
     */
    public Recurso getRecurso() {
        return new Recurso(recurso);
    }

    /**
     * Define o recurso
     *
     * @param r O recurso
     */
    public void setRecurso(Recurso r) {
        this.recurso = new Recurso(r);
    }

    /**
     * Devolve a quantidade em stock
     *
     * @return A quantidade em stock
     */
    public int getQtStock() {
        return qtStock;
    }

    /**
     * Define a quantidade em stock
     *
     * @param qtStock A quantidade do recurso em stock
     */
    public void setQtStock(int qtStock) {
        this.qtStock = qtStock;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RecursoStock other = (RecursoStock) obj;
        return this.recurso.equals(other.recurso);
    }

    /**
     * Devolve a descrição textual do Stock do recurso
     *
     * @retun Características do stock do recurso
     *
     */
    @Override
    public String toString() {
        return recurso + ", " + qtStock + " unidades";
    }

    /**
     * Adiciona uma determinada quantidade de recurso ao stock
     *
     * @param qt A quantidade a adicionar
     */
    public void adicionarQtRecurso(int qt) {
        qtStock = qt;
    }

    /**
     * Diminui a quantidade em stock do recurso em uma unidade
     */
    public void decrementarQtRecurso() {
        qtStock--;
    }

}
