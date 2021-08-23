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
public interface IPagavel {

    /**
     * Devolve o custo do serviço dada uma quantidade de dias (qtDias)
     *
     * @param qtdDias quantidade de dias para cálculo do custo do serviço
     *
     * @return custo do serviço para uma dada quantidade de dias
     */
    public float obterCustoServico(int qtDias);
}
