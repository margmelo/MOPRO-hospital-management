/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import pkg_Exceptions.ExcepNumPositivos;
import pkg_Exceptions.ExcepNomeEsp;
import java.io.Serializable;

/**
 * É necessário conhecer o código de ordem profissional, nome e especialidade
 * principal;
 *
 * @author MOPRO_Grupo4
 */
public class Medico implements Serializable {

    /**
     * O código da ordem profissional do médico
     */
    private int codMedico;

    /**
     * O nome do médico
     */
    private String nomeMedico;

    /**
     * A especialidade médica do médico
     */
    private String especialidade;

    /**
     * A variável String por omissão
     */
    private static final String STRING_POR_OMISSAO = "Não Especializado";

    /**
     * variável inteira por omissão
     */
    private static final int INT_POR_OMISSAO = 0;

    /**
     * Constroi uma instância de médico com valores N.D. no nome e especialidade
     * e 0 no código
     */
    public Medico() throws ExcepNumPositivos, ExcepNomeEsp {
        setCodMedico(INT_POR_OMISSAO);
        setNomeMedico(STRING_POR_OMISSAO);
        setEspecialidade(STRING_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de médico com os valores passados por parâmetro
     *
     * @param codMedico O código de ordem profissional do médico
     * @param nomeMedico O nome do médico
     * @param especialidade A especialidade do médico
     */
    public Medico(int codMedico, String nomeMedico, String especialidade) throws ExcepNumPositivos, ExcepNomeEsp {
        setCodMedico(codMedico);
        setNomeMedico(nomeMedico);
        setEspecialidade(especialidade);
    }

    /**
     * Constroi uma instância de médico com os valores passados por parâmetro e
     * N.D. na especialidade
     *
     * @param codMedico O código de ordem profissional do médico
     * @param nomeMedico O nome do médico
     */
    public Medico(int codMedico, String nomeMedico) throws ExcepNumPositivos, ExcepNomeEsp {
        setCodMedico(codMedico);
        setNomeMedico(nomeMedico);
        setEspecialidade(STRING_POR_OMISSAO);
    }

    /**
     * Constroi uma instância de médico por cópia do médico passado por
     * parâmetro
     *
     * @param m O médico a copiar
     */
    public Medico(Medico m) throws ExcepNumPositivos, ExcepNomeEsp{
        setCodMedico(m.codMedico);
        setNomeMedico(m.nomeMedico);
        setEspecialidade(m.especialidade);
    }

    /**
     * Devolve o código de ordem profissional do médico
     *
     * @return O código de ordem profissonal do médico
     */
    public int getCodigo() {
        return codMedico;
    }

    /**
     * Devolve o nome do médico
     *
     * @return O nome do médico
     */
    public String getNome() {
        return nomeMedico;
    }

    /**
     * Devolve especialidade do médico
     *
     * @return A especialidade do médico
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Define o código do médico
     *
     * @param codMedico
     */
    public void setCodMedico(int codMedico) throws ExcepNumPositivos {
        if (codMedico < 9999) {
            throw new ExcepNumPositivos("O código " + codMedico + " é inválido.\nDeve ser positivo e ter pelo menos 5 dígitos.");
        }
        this.codMedico = codMedico;
    }

    /**
     * Define nome do médico
     *
     * @param nomeMedico O nome do médico
     */
    public void setNomeMedico(String nomeMedico) throws ExcepNomeEsp {
        char c;
        for (int i = 0; i < nomeMedico.length(); i++) {
            c = nomeMedico.charAt(i);
            if (Character.isLetter(c) == false && Character.isSpaceChar(c) == false) {
                throw new ExcepNomeEsp("O Médico " + nomeMedico + " tem caracteres que não são letras nem contêm espaços");
            }
        }
        this.nomeMedico = nomeMedico;
    }

    /**
     * Define a especialidade do médico
     *
     * @param especialidade A especialidade do médico
     */
    public void setEspecialidade(String especialidade) throws ExcepNomeEsp {
        char c;
        for (int i = 0; i < especialidade.length(); i++) {
            c = especialidade.charAt(i);
            if (Character.isLetter(c) == false && Character.isSpaceChar(c) == false) {
                throw new ExcepNomeEsp("A especialidade " + especialidade + " tem caracteres que não são letras nem contêm espaços");
            }
        }
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        return this.codMedico == other.codMedico
                && this.especialidade.compareToIgnoreCase(other.especialidade) == 0
                && this.nomeMedico.compareToIgnoreCase(other.nomeMedico) == 0;
    }

    /**
     * Devolve a descrição textual do médico
     *
     * @retun Características do médico
     *
     */
    @Override
    public String toString() {
        return "> #" + codMedico + " Dr. " + nomeMedico + " - " + especialidade + "\n";
    }

}
