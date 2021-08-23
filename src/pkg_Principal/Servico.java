/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import pkg_Interfaces.IAvaliavel;
import pkg_Interfaces.IPagavel;
import pkg_Exceptions.ExcepNumPositivos;
import java.io.Serializable;
import pkg_Utilitários.Data;

/**
 *
 * @author mruna
 */
public abstract class Servico implements IAvaliavel, IPagavel, Comparable<Servico>, Serializable {

    /**
     * O código do serviço
     */
    private int codServico;

    /**
     * A data de início do serviço
     */
    private Data dataInicio;

    /**
     * A data de fim do serviço
     */
    private Data dataFim;

    /**
     * A descriçao do serviço
     */
    private String descricao;

    /**
     * A NIF da empresa que fornece o serviço
     */
    private int nif_empresa;

    /**
     * A avaliacao do servico
     */
    private int avaliacao;

    /**
     * valor default para varáveis string
     */
    private static final String STR_POR_OMISSAO = "N.D.";

    /**
     * valor default para variáveis inteiras
     */
    static final int INT_POR_OMISSAO = 1;

    /**
     * valor default para variáveis double
     */
    static final float FLT_POR_OMISSAO = 1;

    /**
     * Constrói um serviço com valores default
     */
    public Servico(int codServico) throws ExcepNumPositivos{
        setCodServico(codServico);
        setDataInicio(new Data());
        setDataFim(new Data());
        setDescricao(STR_POR_OMISSAO);
        setNif_empresa(INT_POR_OMISSAO);
        setAvaliacao(INT_POR_OMISSAO);
    }

    /**
     * Constrói um serviço a partir dos valores passados por parâmetro
     *
     * @param codServico O código do serviço
     * @param dataInicio A data de início de prestação do serviço
     * @param dataFim A data de fim de prestação do serviço
     * @param descricao A descrição do serviço
     * @param nif_empresa O NIF da empresa que presta o serviço
     */
    public Servico(int codServico, Data dataInicio, Data dataFim, String descricao, int nif_empresa) throws ExcepNumPositivos{
        setCodServico(codServico);
        setDataInicio(new Data(dataInicio));
        setDataFim(new Data(dataFim));
        setDescricao(descricao);
        setNif_empresa(nif_empresa);
        setAvaliacao(avaliacao);
    }

    /**
     * Constrói um serviço por cópia de outro serviço
     *
     * @param s o serviço a copiar
     */
    public Servico(Servico s) throws ExcepNumPositivos{
        setCodServico(s.codServico);
        setDataInicio(new Data(s.dataInicio));
        setDataFim(new Data(s.dataFim));
        setDescricao(s.descricao);
        setNif_empresa(s.nif_empresa);
        setAvaliacao(s.avaliacao);
    }

    /**
     * Devolve o código do serviço
     *
     * @return o código do serviço
     */
    public int getCodServico() {
        return codServico;
    }

    /**
     * Devolve o NIF da empresa prestadora do serviço
     *
     * @return o NIF da empresa prestadora do serviço
     */
    public int getNif_empresa() {
        return nif_empresa;
    }

    /**
     * Devolve a descricao do serviço prestado
     *
     * @return a descricao do serviço prestado
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Devolve a data de início do contrato
     *
     * @return A data de início do contrato
     */
    public Data getDataInicio() {
        return dataInicio;
    }

    /**
     * Devolve a data de término do contrato
     *
     * @return A data de término do contrato
     */
    public Data getDataFim() {
        return dataFim;
    }
    
    /**
     * 
     */
    public final void setCodServico(int codServico) throws ExcepNumPositivos {
        if(codServico<0 ){
            throw new ExcepNumPositivos ("O código " + codServico + " é inválido.\nDeve ser um valor inteiro positivo");
        }
        this.codServico = codServico;
    }

    /**
     *
     * @param dataInicio
     */
    public final void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     *
     * @param dataFim
     */
    public final void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    /**
     *
     * @param descricao
     */
    public final void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @param nif_empresa
     */
    public final void setNif_empresa(int nif_empresa) {
        this.nif_empresa = nif_empresa;
    }

    /**
     *
     * @param avaliacao
     */
    public final void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     * Devolve a avaliação da empresa prestadora do serviço
     *
     * @return a avaliação
     */
    public float obterAvaliacao() {
        return avaliacao;
    }

    /**
     * Atualiza a avaliação da empresa prestadora do serviço
     *
     * @param val valor a inserir
     */
    public void atualizarAvaliacao(int val) {
        this.avaliacao = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        return this.codServico == other.codServico
                && this.dataInicio.equals(other.dataInicio)
                && this.dataFim.equals(other.dataFim)
                && this.descricao.equalsIgnoreCase(descricao)
                && this.nif_empresa == other.nif_empresa;
    }

    /**
     * Devolve a descrição textual do Servico
     *
     * @retun Características do servico
     *
     */
    @Override
    public String toString() {
        return "\n> #" + codServico + " - " + descricao + ""
                + "\n   Início do contrato: " + dataInicio + ""
                + "\n   Término do contrato: " + dataFim + ""
                + "\n   NIF da empresa: " + nif_empresa + "";

    }

    @Override
    public int compareTo(Servico s) {
        if (nif_empresa == s.nif_empresa) {
            return 0;
        } else if (nif_empresa < s.nif_empresa) {
            return -1;
        } else {
            return 1;
        }
    }
}
