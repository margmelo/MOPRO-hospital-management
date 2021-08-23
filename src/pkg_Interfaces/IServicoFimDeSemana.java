/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Interfaces;

/**
 *
 * @author MOPRO_Grupo4
 */
public interface IServicoFimDeSemana {

    /**
     * Valor do servico de transfer por omissao
     */
    public static final boolean SERVICO_POR_OMISSAO = false;

    /**
     * Verifica se a empresa de restauração tem servico ao fim de semana
     *
     * @return true se sim, false se nao
     */
    public abstract boolean validarServicoFimDeSemana();
}
