/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import pkg_Exceptions.ExcepNumPositivos;
import java.io.Serializable;
import pkg_Utilitários.Data;

/**
 *
 * @author MOPRO_Grupo4
 */
public class ServicoLimpezas extends Servico implements Serializable {

    /**
     * O produto de limpeza utilizado
     */
    private Produto produto;

    /**
     * A quantidade de enfermarias para limpeza diária
     */
    private int qtEnfermariasParaLimpeza;

    /**
     * A quantidade de limpezas diárias para cada enfermaria
     */
    private int qtLimpezasDiariasPorEnfermaria;

    /**
     * Preço de cada limpeza
     */
    private float precoLimpezaPorEnfermaria;

    /**
     * Enumerado das opções de produto de limpeza
     */
    public static enum Produto {
        A, B, C
    }

    /**
     * Produto de limpeza usado por omissão
     */
    private static final Produto PRODUTO_POR_OMISSAO = Produto.A;

    /**
     * Constrói um serviço de limpeza com o código passado por parâmetro e
     * restantes valores default
     *
     * @param codServico O código do serviço
     */
    public ServicoLimpezas(int codServico) throws ExcepNumPositivos {
        super(codServico);
        setProduto(PRODUTO_POR_OMISSAO);
        setQtEnfermariasParaLimpeza(INT_POR_OMISSAO);
        setQtLimpezasDiariasPorEnfermaria(INT_POR_OMISSAO);
        setPrecoLimpezaPorEnfermaria(FLT_POR_OMISSAO);
    }

    /**
     * Constrói um serviço de limpeza apartir dos valores passados por parâmetro
     *
     * @param codServico O código do serviço
     * @param dataInicio A data de início da prestação do serviço
     * @param dataFim A data de fim da prestação do serviço
     * @param descricao A descrição do serviço
     * @param nif_empresa O nif da empresa que presta o serviço
     * @param produto O produto utilizado na limpeza
     * @param qtEnfermariasParaLimpeza A quantidade de enfermarias a limpar
     * diariamente
     * @param qtLimpezasPorEnfermaria
     * @param precoLimpezaPorEnfermaria
     */
    public ServicoLimpezas(int codServico, Data dataInicio, Data dataFim,
            String descricao, int nif_empresa, Produto produto,
            int qtEnfermariasParaLimpeza, int qtLimpezasDiariasPorEnfermaria, float precoLimpezaPorEnfermaria) throws ExcepNumPositivos {
        super(codServico, dataInicio, dataFim, descricao, nif_empresa);
        setProduto(produto);
        setQtEnfermariasParaLimpeza(qtEnfermariasParaLimpeza);
        setQtLimpezasDiariasPorEnfermaria(qtLimpezasDiariasPorEnfermaria);
        setPrecoLimpezaPorEnfermaria(precoLimpezaPorEnfermaria);
    }

    /**
     * Constrói um serviço de limpeza por cópia de outro serviço de limpeza
     *
     * @param s O serviço de limpeza a copiar
     */
    public ServicoLimpezas(ServicoLimpezas s) throws ExcepNumPositivos {
        super(s);
        setProduto(s.produto);
        setQtEnfermariasParaLimpeza(s.qtEnfermariasParaLimpeza);
        setQtLimpezasDiariasPorEnfermaria(s.qtLimpezasDiariasPorEnfermaria);
        setPrecoLimpezaPorEnfermaria(s.precoLimpezaPorEnfermaria);
    }

    /**
     * Devolve o produto utlizado
     *
     * @return O produto utlizado
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Devolve a quantidade de enfermarias a limpar diariamente
     *
     * @return A quantidade de enfermarias a limpar diariamente
     */
    public int getQtEnfermariasParaLimpeza() {
        return qtEnfermariasParaLimpeza;
    }

    /**
     * Devolve a quantidade de limpezas feitas diariamente a cada enfermaria
     *
     * @return A quantidade de limpezas feitas diariamente a cada enfermaria
     */
    public int getQtLimpezasDiariasPorEnfermaria() {
        return qtLimpezasDiariasPorEnfermaria;
    }

    /**
     * Devolve o preço de cada limpeza
     *
     * @return O preço de cada limpeza
     */
    public double getPrecoLimpezaPorEnfermaria() {
        return precoLimpezaPorEnfermaria;
    }

    /**
     * Modifica o produto de limpeza utilizado
     *
     * @param produto O novo produto de limpeza
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Modifica a quantidade de enfermarias a limpar diariamente
     *
     * @param qtEnfermariasParaLimpeza A nova quantidade de enfermarias a limpar
     * diariamente
     */
    public void setQtEnfermariasParaLimpeza(int qtEnfermariasParaLimpeza) throws ExcepNumPositivos {
        if (qtLimpezasDiariasPorEnfermaria < 0) {
            throw new ExcepNumPositivos("A quantidade " + qtLimpezasDiariasPorEnfermaria + " é inválida.\nDeve ser um valor inteiro positivo.");
        }
        this.qtEnfermariasParaLimpeza = qtEnfermariasParaLimpeza;
    }

    /**
     * Modifica a quanridade de limpezas a fazer diariamente em cada enfermaria
     *
     * @param qtLimpezasDiariasPorEnfermaria A nova quantidade de limpezas a
     * fazer diariamente em cada enfermaria
     */
    public void setQtLimpezasDiariasPorEnfermaria(int qtLimpezasDiariasPorEnfermaria) throws ExcepNumPositivos {
        if (qtLimpezasDiariasPorEnfermaria < 0) {
            throw new ExcepNumPositivos("A quantidade " + qtLimpezasDiariasPorEnfermaria + " é inválida.\nDeve ser um valor inteiro positivo.");
        }
        this.qtLimpezasDiariasPorEnfermaria = qtLimpezasDiariasPorEnfermaria;
    }

    /**
     * Modifica o preço de cada limpeza
     *
     * @param precoLimpezaPorEnfermaria O novo preço de cada limpeza
     */
    public final void setPrecoLimpezaPorEnfermaria(float precoLimpezaPorEnfermaria) throws ExcepNumPositivos {
        if (precoLimpezaPorEnfermaria < 0) {
            throw new ExcepNumPositivos("O preço " + precoLimpezaPorEnfermaria + "€ é inválido.\nDeve ser um valor real positivo.");
        }
        this.precoLimpezaPorEnfermaria = precoLimpezaPorEnfermaria;
    }

    /**
     * Devolve a descrição textual do Servico de limpeza
     *
     * @retun Características do servico de limpeza
     */
    @Override
    public String toString() {
        return "\n> #" + super.getCodServico() + " - " + super.getDescricao() + ""
                + "\n   Início do contrato: " + super.getDataInicio() + ""
                + "\n   Término do contrato: " + super.getDataFim() + ""
                + "\n   NIF da empresa: " + super.getNif_empresa() + ""
                + "\n   Produtos usados: Categoria " + produto
                + "\n   Qt Enfermarias: " + qtEnfermariasParaLimpeza + "; Qt limpezas diárias: " + qtLimpezasDiariasPorEnfermaria + "; Preço de cada limpeza: " + precoLimpezaPorEnfermaria +"€; "
                + "\n   Custo diário do serviço: " + obterCustoServico(1) + "€";
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) == false) {
            return false;
        }
        ServicoLimpezas other = (ServicoLimpezas) obj;
        return this.produto.equals(other.produto)
                && this.qtEnfermariasParaLimpeza == other.qtEnfermariasParaLimpeza
                && this.qtLimpezasDiariasPorEnfermaria == other.qtLimpezasDiariasPorEnfermaria
                && this.precoLimpezaPorEnfermaria == other.precoLimpezaPorEnfermaria;
    }

    /**
     * Calcula o custo do serviço de limpeza
     *
     * @param qtDias A quantidade de dias para que se pretende fazer o cálculo
     *
     * @return O custo do serviço de limpeza
     */
    @Override
    public float obterCustoServico(int qtDias) {
//        System.out.println("qtEnfermarias="+qtEnfermariasParaLimpeza);
//        System.out.println("qtLimpezas="+qtLimpezasDiariasPorEnfermaria);
//        System.out.println("preço="+precoLimpezaPorEnfermaria);
//        System.out.println("qtDias="+qtDias);
        float custoLimpezas = qtEnfermariasParaLimpeza * qtLimpezasDiariasPorEnfermaria * precoLimpezaPorEnfermaria * qtDias;
        return custoLimpezas;
    }

}
