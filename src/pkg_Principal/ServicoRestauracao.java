/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import pkg_Interfaces.IServicoFimDeSemana;
import pkg_Exceptions.ExcepNumPositivos;
import java.io.Serializable;
import pkg_Utilitários.Data;

/**
 *
 * @author MOPRO_Grupo4
 */
public class ServicoRestauracao extends Servico implements IServicoFimDeSemana, Serializable {

    /**
     * Quantidade de refeições servidas diariamente
     */
    private int qtRefeicoes;

    /**
     * Preço de cada refeição
     */
    private static float precoRefeicao = 3;

    /**
     * Possibilidade de serviço ao fim de semana
     */
    private boolean servicoFds;

    /**
     * Constrói um serviço de restauração com o código do serviço passado por
     * parâmetro, e restantes valores default
     *
     * @param codServico O código do serviço
     */
    public ServicoRestauracao(int codServico) throws ExcepNumPositivos {
        super(codServico);
        setQtRefeicoes(INT_POR_OMISSAO);
        setServicoFds(SERVICO_POR_OMISSAO);
    }

    /**
     * Constrói um serviço de restauração com valores passados por parâmetro
     *
     * @param codServico O código do serviço
     * @param dataInicio A data de início da prestação do serviço
     * @param dataFim A data de fim de prestação do serviço
     * @param descricao A descrição do serviço
     * @param nif_empresa O nif da empresa que presta o serviço
     * @param qtRefeicoes A quantidade de refeições servidas diariamente
     * @param servicoFds A possibilidade de fazer serviço ao fim de semana
     */
    public ServicoRestauracao(int codServico, Data dataInicio, Data dataFim, String descricao, int nif_empresa, int qtRefeicoes, boolean servicoFds)
            throws ExcepNumPositivos {
        super(codServico, dataInicio, dataFim, descricao, nif_empresa);
        setQtRefeicoes(qtRefeicoes);
        setServicoFds(servicoFds);
    }

    /**
     * Constrói um serviço de restauração por cópia de outro serviço
     *
     * @param sr O serviço a copiar
     */
    public ServicoRestauracao(ServicoRestauracao s) throws ExcepNumPositivos {
        super(s);
        setQtRefeicoes(s.qtRefeicoes);
        setServicoFds(s.servicoFds);
    }

    /**
     * Devolve a quantidade de refeições diárias
     *
     * @return A quantidade de refeições diárias
     */
    public int getQtRefeicoes() {
        return qtRefeicoes;
    }

    /**
     * Altera a quantidade de refeições servidas diariamente
     *
     * @param qtRefeicoes A nova quantidade de refeições diárias
     */
    public void setQtRefeicoes(int qtRefeicoes) {
        this.qtRefeicoes = qtRefeicoes;
    }

    /**
     *
     * @param servicoFds
     */
    public void setServicoFds(boolean servicoFds) {
        this.servicoFds = servicoFds;
    }

    /**
     * Devolve a descrição textual do Servico de restauração
     *
     * @retun Características do serviço de restauração
     *
     */
    @Override
    public String toString() {
        return "\n> #" + super.getCodServico() + " - " + super.getDescricao() + ""
                + "\n   Início do contrato: " + super.getDataInicio() + ""
                + "\n   Término do contrato: " + super.getDataFim() + ""
                + "\n   NIF da empresa: " + super.getNif_empresa() + ""
                + "\n   Refeições servidas: " + qtRefeicoes + "; Preço por refeição: " + precoRefeicao + "€; "
                + "\n   custo diário do serviço: " + obterCustoServico(1);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (super.equals(outroObjeto) == false) {
            return false;
        }
        ServicoRestauracao obj = (ServicoRestauracao) outroObjeto;
        return this.qtRefeicoes == obj.qtRefeicoes;
    }

    /**
     * Calcula o custo do serviço de restauração
     *
     * @param qtDias A quantidade de dias para que se pretende fazer o cálculo
     *
     * @return O custo do serviço de restauração
     */
    @Override
    public float obterCustoServico(int qtDias) {
        float custoRefeicoes = qtRefeicoes * precoRefeicao * qtDias;
        return custoRefeicoes;
    }

    /**
     * Verifica se o serviço serve refeições ao fim de semana
     *
     * @return true se o serviço servir refeições ao fim de semana, e false se
     * não o fizer
     */
    @Override
    public boolean validarServicoFimDeSemana() {
        return servicoFds;
    }
}
