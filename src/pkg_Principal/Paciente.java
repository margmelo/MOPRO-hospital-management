/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import pkg_Exceptions.ExcepCaractEspeciais;
import pkg_Exceptions.ExcepNumPositivos;
import pkg_Exceptions.ExcepNomeEsp;
import pkg_Exceptions.ExcepData;
import java.io.Serializable;
import java.util.ArrayList;
import pkg_Utilitários.Data;

/**
 * Para cada paciente é necessário conhecer o seu código de utente, nome, data
 * de nascimento, data de internamento, data de alta, subsistema de saúde,
 * doença, recursos materiais usados e finalmente um campo para observações
 *
 * @author MOPRO_Grupo4
 */
public class Paciente implements Serializable {

    /**
     * O código do paciente. Vai ser gerado automaticamente
     */
    private int codPaciente;

    /**
     * O nome do paciente
     */
    private String nomePaciente;

    /**
     * A data de nascimento do paciente
     */
    private Data dataNasc;

    /**
     * A data de internamento
     */
    private Data dataInt;

    /**
     * A data de alta
     */
    private Data dataAlta;

    /**
     * O subsistema de saúde do paciente
     */
    private String subsistema;

    /**
     * A doença diagnosticada ao paciente
     */
    private String doenca;
    /**
     * A lista de recursos usados pelo paciente
     */
    private ArrayList<Recurso> listaRecursos;

    /**
     * Observações adicionadas à ficha do paciente
     */
    private String obs;

    /**
     * Valor string por omissão
     */
    private static final String STRING_POR_OMISSAO = "N.D.";

    /**
     * O número de pacientes existentes. Utilizado para criar automáticamente o
     * código do paciente
     */
    private static int totalPacientes = 0;

    /**
     * Constroi uma instância de paciente com valores N.D. e listas vazias.
     */
    public Paciente() throws ExcepNomeEsp, ExcepNumPositivos, ExcepData, ExcepCaractEspeciais {
        setCodPaciente(codPaciente);
        setNomePaciente(STRING_POR_OMISSAO);
        setDataNasc(new Data());
        setDataInt(new Data());
        setDataAlta(new Data());
        setSubsistema(STRING_POR_OMISSAO);
        setDoenca(STRING_POR_OMISSAO);
        setObs(STRING_POR_OMISSAO);
        setListaRecursos(new ArrayList());
    }

    /**
     * Constroi uma instância de paciente com os valores passados por parâmetro.
     * O código é gerado automaticamente
     *
     * @param nomePaciente O nome do paciente
     * @param dataNasc A data de nascimento do paciente
     * @param dataInt A data de internamento do paciente
     * @param dataAlta A data de alta do paciente
     * @param subsistema O subsistema de saúde do paciente
     * @param doenca A doença diagnosticada ao paciente
     * @param listaRecursos A lista de recursos associados ao paciente
     * @param obs As observações associadas à ficha do paciente
     */
    public Paciente(int codPaciente, String nomePaciente, Data dataNasc, Data dataInt, Data dataAlta, String subsistema, String doenca, String obs)
            throws ExcepNomeEsp, ExcepNumPositivos, ExcepData, ExcepCaractEspeciais {
        setCodPaciente(codPaciente);
        setNomePaciente(nomePaciente);
        setDataNasc(new Data(dataNasc));
        setDataInt(new Data(dataInt));
        setDataAlta(new Data(dataAlta));
        setSubsistema(subsistema);
        setDoenca(doenca);
        setObs(obs);
        setListaRecursos(new ArrayList());
    }

    /**
     * Constrói uma instância de paciente por cópia do paciente passado por
     * parâmetro
     *
     * @param p O paciente a copiar
     */
    public Paciente(Paciente p) throws ExcepNomeEsp, ExcepNumPositivos, ExcepData, ExcepCaractEspeciais {
        setCodPaciente(p.codPaciente);
        setNomePaciente(p.nomePaciente);
        setDataNasc(new Data(p.dataNasc));
        setDataInt(new Data(p.dataInt));
        setDataAlta(new Data(p.dataAlta));
        setSubsistema(p.subsistema);
        setDoenca(p.doenca);
        setObs(p.obs);
        setListaRecursos(new ArrayList(p.listaRecursos));
    }

    /**
     * Devolve o código do paciente
     *
     * @return O código do paciente
     */
    public int getCodPaciente() {
        return codPaciente;
    }

    /**
     * Devolve o nome do Paciente
     *
     * @return O nome do paciente
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * Devolve data de nascimento do paciente
     *
     * @return A data de nascimento do Paciente
     */
    public Data getDataNasc() {
        return new Data(dataNasc);
    }

    /**
     * Devolve data de internamento do paciente
     *
     * @return A data de internamento do paciente
     */
    public Data getDataInt() {
        return new Data(dataInt);
    }

    /**
     * Devolve data de alta do paciente
     *
     * @return A data de akta do paciente
     */
    public Data getDataAlta() {
        return new Data(dataAlta);
    }

    /**
     * Devolve o subsistema de saúde do paciente
     *
     * @return O subsistema de saúde do paciente
     */
    public String getSubsistema() {
        return subsistema;
    }

    /**
     * Devolve doenca diagnosticada ao paciente
     *
     * @return A doença diagnosticada ao paciente
     */
    public String getDoenca() {
        return doenca;
    }

    /**
     * Devolve recursos atribuídos ao paciente
     *
     * @return Os recursos atribuidos ao paciente
     */
    public ArrayList<Recurso> getListaRecursos() {
        return new ArrayList(listaRecursos);
    }

    /**
     * Devolve observações feitas na ficha do paciente
     *
     * @return As observações feitas na ficha do paciente
     */
    public String getObs() {
        return obs;
    }

    /**
     * Devolve código do paciente (gerado automaticamente)
     *
     * @return O código do paciente
     */
    public static int getTotalPacientes() {
        return totalPacientes;
    }

    /**
     * Atribui um código automaticamente ao paciente
     *
     * @param codPaciente O código do paciente
     */
    public void setCodPaciente(int codPaciente) throws ExcepNumPositivos {
        if (codPaciente < 9) {
            throw new ExcepNumPositivos("O código " + codPaciente + " é inválido.\nDeve ser positivo e ter pelo menos 2 dígitos.");
        }
        this.codPaciente = codPaciente;
    }

    /**
     * Define o nome do paciente
     *
     * @param nomePaciente O nome do paciente
     */
    public void setNomePaciente(String nomePaciente) throws ExcepNomeEsp {
        char c;
        for (int i = 0; i < nomePaciente.length(); i++) {
            c = nomePaciente.charAt(i);
            if (Character.isLetter(c) == false && Character.isSpaceChar(c) == false) {
                throw new ExcepNomeEsp("O paciente " + nomePaciente + " tem caracteres que não são letras nem contêm espaços");
            }
        }
        this.nomePaciente = nomePaciente;
    }

    /**
     * Define a data de nascimento do paciente
     *
     * @param dataNasc A data de nascimensto do paciente
     */
    public void setDataNasc(Data dataNasc) {
        this.dataNasc = new Data(dataNasc);
    }

    /**
     * Define a data de internamento do paciente
     *
     * @param dataInt A data de internamento do paciente
     */
    public void setDataInt(Data dataInt) throws ExcepData {
        if (dataInt.isMaior(dataNasc) == false) {
            throw new ExcepData("A data de internamento é anterior à data de nascimento.");
        }
        this.dataInt = new Data(dataInt);
    }

    /**
     * Define a data de alta do paciente
     *
     * @param dataAlta A data de alta do paciente
     */
    public void setDataAlta(Data dataAlta) throws ExcepData {
        if (dataAlta.isMaior(dataInt) == false) {
            throw new ExcepData("A data de alta é anterior à data de internamento.");
        }
        this.dataAlta = new Data(dataAlta);
    }

    /**
     * Define o subsistema de saúde do paciente
     *
     * @param subsistema O subsistema de saude do paciente
     */
    public void setSubsistema(String subsistema) {
        this.subsistema = subsistema;
    }

    /**
     * Define doenca diagnosticada ao paciente
     *
     * @param doenca O subsistema de saúde do paciente
     */
    public void setDoenca(String doenca) throws ExcepCaractEspeciais {
        char c;
        for (int i = 0; i < doenca.length(); i++) {
            c = doenca.charAt(i);
            if (Character.isLetterOrDigit(c) == false
                    && Character.isSpaceChar(c) == false
                    && Character.toString(c).equals(".") == false
                    && Character.toString(c).equals("+") == false
                    && Character.toString(c).equals("-") == false
                    && Character.toString(c).equals("_") == false
                    && Character.toString(c).equals("@") == false) {
                throw new ExcepCaractEspeciais("A doença " + doenca + " tem caractéres inválidos."
                        + "\nSão permitidos: letras, números, espaços e os seguintes símbolos: + . - _ @");
            }
        }
        this.doenca = doenca;
    }

    /**
     * Define as observações feitas
     *
     * @param obs As observações associadas à ficha do paciente
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * Define recursos atribuidos ao paciente
     *
     * @param listaRecursos A lista de recursos atribuídos ao paciente
     */
    public void setListaRecursos(ArrayList<Recurso> listaRecursos) {
        this.listaRecursos = new ArrayList(listaRecursos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        return this.codPaciente == other.codPaciente
                && this.nomePaciente.equals(other.nomePaciente)
                && this.subsistema.equals(other.subsistema)
                && this.doenca.equals(other.doenca)
                && this.obs.equals(other.obs)
                && this.dataNasc.equals(other.dataNasc)
                && this.dataInt.equals(other.dataInt)
                && this.dataAlta.equals(other.dataAlta)
                && this.listaRecursos.equals(other.listaRecursos);
    }

    /**
     * Devolve a descrição textual do paciente
     *
     * @retun Características do paciente
     *
     */
    @Override
    public String toString() {
        return "> #" + codPaciente + " - " + nomePaciente + " "
                + "\n   Nascido a: " + dataNasc
                + "\n   Internado a: " + dataInt
                + "\n   Alta a: " + dataAlta
                + "\n   Subsistema de saúde: " + subsistema
                + "\n   Diagnóstico: " + doenca
                + "\n   Recursos atribuídos: " + listaRecursos
                + "\n   Observações: " + obs
                + "\n ";
    }

    /**
     * Adiciona um recurso à lista de recursos do paciente
     *
     * @param r O recurso a adicionar
     */
    public void adicionarRecurso(Recurso r) {
        listaRecursos.add(r);
    }

}
