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
public interface IAvaliavel {

    /**
     * Valor de avaliacao FRACO
     */
    public static final int FRACO = 1;
    
    /**
     * Valor de avaliacao RAZOAVEL
     */
    public static final int RAZOAVEL = 2;
    
    /**
     * Valor de avaliacao BOM
     */
    public static final int BOM = 3;
    
    /**
     * Valor de avaliacao MUITO BOM
     */
    public static final int MUITO_BOM = 4;
    
    /**
     * Valor de avaliacao EXCELENTE
     */
    public static final int EXCELENTE = 5;

    /**
     * Devolve a media das avaliacoes
     *
     * @return media das avaliacoes
     */
    public float obterAvaliacao();

    /**
     * Atualiza as avaliacoes da empresa
     *
     * @param val valor a inserir
     */
    public void atualizarAvaliacao(int val);
}
