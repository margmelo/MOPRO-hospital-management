/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import pkg_Interfaces.IServicoFimDeSemana;
import pkg_Exceptions.ExcepEndereco;
import pkg_Exceptions.ExcepNumPositivos;
import pkg_Exceptions.ExcepNomeEsp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * De cada hospital é necessário conhecer o código, o qual deve ser único, nome,
 * endereço, país, médicos, pacientes internados, tipos de recursos materiais e
 * stock de recursos; As funcionalidades pedidas são implementadas aqui.
 *
 * @author MOPRO_Grupo4
 */
public final class Hospital implements Serializable {

    /**
     * O código do hospital. Vai ser gerado automaticamente
     */
    private int codHospital;

    /**
     * O nome do hospital
     */
    private String nomeHospital;

    /**
     * O endereço do hospital
     */
    private String endHospital;

    /**
     * O país em que se encontra o hospital
     */
    private String paisHospital;

    /**
     * A quantidade de enfermarias existentes no hospital
     */
    private int qtEnfermarias;

    /**
     * A lista de médicos do hospital
     */
    private ArrayList<Medico> listaMedicos;

    /**
     * A lista de pacientes internados no hospital
     */
    private ArrayList<Paciente> listaPacientes;

    /**
     * A lista de tipos de recursos existentes no hospital
     */
    private ArrayList<TipoRecurso> listaTipoRecurso;

    /**
     * A lista de stock de recursos existentes no hospital
     */
    private ArrayList<RecursoStock> listaStock;

    /**
     * A lista de serviços contratados pelo hospital
     */
    private List<Servico> listaServicos;

    /**
     * Velor do endereço por omissão
     */
    private static final String END_POR_OMISSAO = "Rua do Hospital";

    /**
     * Valor String por omissão
     */
    private static final String STRING_POR_OMISSAO = "Não especificado";

    /**
     * Valor inteiro por omissão
     */
    private static final int INT_POR_OMISSAO = 1;

    /**
     * Constrói uma instância de hospital com valores N.D. no nome, endereço,
     * país e listas vazias nos restantes atributos.
     */
    public Hospital(int codHospital) throws ExcepNomeEsp, ExcepNumPositivos, ExcepEndereco {
        setCodHospital(codHospital);
        setNomeHospital(STRING_POR_OMISSAO);
        setEndHospital(END_POR_OMISSAO);
        setPaisHospital(STRING_POR_OMISSAO);
        setQtEnfermarias(INT_POR_OMISSAO);
        setListaMedicos(new ArrayList());
        setListaPacientes(new ArrayList());
        setListaTipoRecurso(new ArrayList());
        setListaStock(new ArrayList());
        setListaServicos(new ArrayList());
    }

    /**
     * Constrói uma instância de hospital com valores passados como parâmetro
     * para o código, nome, endereço e país e listas vazias nos restantes
     * atributos. O código do hospital é gerado automaticamente
     *
     * @param nomeHospital O nome do hospital
     * @param endHospital O endereço do hospital
     * @param paisHospital = país do hospital
     * @param qtEnfermarias
     */
    public Hospital(int codHospital, String nomeHospital, String endHospital, String paisHospital, int qtEnfermarias) throws ExcepNomeEsp, ExcepNumPositivos, ExcepEndereco {
        setCodHospital(codHospital);
        setNomeHospital(nomeHospital);
        setEndHospital(endHospital);
        setPaisHospital(paisHospital);
        setQtEnfermarias(qtEnfermarias);
        setListaMedicos(new ArrayList());
        setListaPacientes(new ArrayList());
        setListaTipoRecurso(new ArrayList());
        setListaStock(new ArrayList());
        setListaServicos(new ArrayList());
    }

    /**
     * Constrói um hospital por cópia do hospital passado como parâmetro
     *
     * @param h O hospital a copiar
     */
    public Hospital(Hospital h) throws ExcepNomeEsp, ExcepNumPositivos, ExcepEndereco {
        setCodHospital(h.codHospital);
        setNomeHospital(h.nomeHospital);
        setEndHospital(h.endHospital);
        setPaisHospital(h.paisHospital);
        setQtEnfermarias(h.qtEnfermarias);
        setListaMedicos(new ArrayList(h.listaMedicos));
        setListaPacientes(new ArrayList(h.listaPacientes));
        setListaTipoRecurso(new ArrayList(h.listaTipoRecurso));
        setListaStock(new ArrayList(h.listaStock));
        setListaServicos(new ArrayList(h.listaServicos));
    }

    /**
     * Devolve o código do hospital
     *
     * @return O código do hospital
     */
    public int getCodHospital() {
        return codHospital;
    }

    /**
     * Devolve o nome do hospital
     *
     * @return O nome do hospital
     */
    public String getNomeHospital() {
        return nomeHospital;
    }

    /**
     * Devolve o endereço do hospital
     *
     * @return O endereço do hospital
     */
    public String getEndHospital() {
        return endHospital;
    }

    /**
     * Devolve o país do Hospital
     *
     * @return O país do Hospital
     */
    public String getPaisHospital() {
        return paisHospital;
    }

    /**
     * Devolve a quantidade de enfermarias do Hospital
     *
     * @return A quantidade de enfermarias do Hospital
     */
    public int getQtEnfermarias() {
        return qtEnfermarias;
    }

    /**
     * Devolve a lista de pacientes internados no hospital
     *
     * @return A lista de pacientes internados no hospital
     */
    public ArrayList<Paciente> getListaPacientes() {
        return new ArrayList(listaPacientes);
    }

    /**
     * Devolve a lista de médicos do hospital
     *
     * @return A lista de médicos do hospital
     */
    public ArrayList<Medico> getListaMedicos() {
        return new ArrayList(listaMedicos);
    }

    /**
     * Devolve a lista de tipos de recursos do hospital
     *
     * @return A lista de tipos de recursos do hospital
     */
    public ArrayList<TipoRecurso> getListaTiposRecurso() {
        return new ArrayList(listaTipoRecurso);
    }

    /**
     * Devolve a lista de recursos em stock no hospital
     *
     * @return A lista de recursos em stock do hospital
     */
    public ArrayList<RecursoStock> getListaStock() {
        return new ArrayList(listaStock);
    }

    /**
     * Devolve a lista de serviços contratados pelo hospital
     *
     * @return A lista de serviços contratados pelo hospital
     */
    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    /**
     * Atribui um código automático ao hospital
     *
     * @param totalHospitais O codigo do hospital
     */
    public void setCodHospital(int codHospital) throws ExcepNumPositivos {
        if (codHospital < 0) {
            throw new ExcepNumPositivos("O código " + codHospital + " é inválido.\nDeve ser um número inteiro positivo");
        }
        this.codHospital = codHospital;
    }

    /**
     * Modifica o nome do hospital
     *
     * @param nomeHospital O novo nome do hospital
     */
    public void setNomeHospital(String nomeHospital) throws ExcepNomeEsp {
        char c;
        for (int i = 0; i < nomeHospital.length(); i++) {
            c = nomeHospital.charAt(i);
            if (Character.isLetter(c) == false && Character.isSpaceChar(c) == false) {
                throw new ExcepNomeEsp("O Hospital " + nomeHospital + " tem caracteres inválidos.");
            }
        }
        this.nomeHospital = nomeHospital;
    }

    /**
     * Modifica o endereço do hospital
     *
     * @param endHospital O novo endereço do hospital
     *
     * @throws ExcepEndereco
     * @throws ExcepNomeEsp
     */
    public void setEndHospital(String endHospital) throws ExcepEndereco, ExcepNomeEsp, ExcepNumPositivos, NumberFormatException {
        char c;
        if ((endHospital.contains("\\.") == false)
                && (endHospital.startsWith("Av. ")
                && endHospital.startsWith("Rua ")
                && endHospital.startsWith("Trav. ")
                && endHospital.startsWith("Lugar ")) == true) {
            throw new ExcepEndereco("O " + endHospital + " é inválido."
                    + "\n-O endereço deve começar por <Av.>, <Lugar>, <Trav.>, ou <Rua>");
        }
        for (int i = 0; i < endHospital.length(); i++) {
            c = endHospital.charAt(i);
            if (Character.isLetterOrDigit(c) == false && Character.isSpaceChar(c) == false && Character.toString(c).equals(".") == false) {
                throw new ExcepNomeEsp("O " + endHospital + " é inválido."
                        //+ "\n-O endereço deve começar por <Av.>, <Lugar>, <Trav.>, ou <Rua>"
                        + "\n-O endereço só aceita letras, números, espaços e pontos.");
            }
        }
        this.endHospital = endHospital;
    }

    /**
     * Modifica o país do hospital
     *
     * @param paísHospital O novo país do hospital
     */
    public void setPaisHospital(String paísHospital) {
        this.paisHospital = paísHospital;
    }

    /**
     * Modifica a quantidade de enfermarias do hospital
     *
     * @param qtEnfermarias A nova quantidade de enfermarias do hospital
     * @throws ExcepNumPositivos
     */
    public void setQtEnfermarias(int qtEnfermarias) throws ExcepNumPositivos {
        if (qtEnfermarias < 0) {
            throw new ExcepNumPositivos("A quantidade " + qtEnfermarias + " é inválida.\nDeve ser um número inteiro positivo.");
        }
        this.qtEnfermarias = qtEnfermarias;
    }

    /**
     * Modifica a lista de médicos do hospital
     *
     * @param listaMedicos A nova lista de médicos do hospital
     */
    public void setListaMedicos(ArrayList<Medico> listaMedicos) {
        this.listaMedicos = new ArrayList(listaMedicos);
    }

    /**
     * Modifica a lista de pacientes do hospital
     *
     * @param listaPacientes A nova lista de pacientes internados
     */
    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = new ArrayList(listaPacientes);
    }

    /**
     * Modifica a lista de recursos do hospital
     *
     * @param listaTipoRecurso A nova lista de Tipos de recursos do hospital
     */
    public void setListaTipoRecurso(ArrayList<TipoRecurso> listaTipoRecurso) {
        this.listaTipoRecurso = new ArrayList(listaTipoRecurso);
    }

    /**
     * Modifica a lista de recursos em stock no hospital
     *
     * @param listaStock A nova lista de recursos em stock no hospital
     */
    public void setListaStock(ArrayList<RecursoStock> listaStock) {
        this.listaStock = new ArrayList(listaStock);
    }

    /**
     * Modifica a lista de servicos contratados pelo hospital
     *
     * @param listaServicos A nova lista de servicos contratados pelo hospital
     */
    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = new ArrayList(listaServicos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Hospital other = (Hospital) obj;
        return this.codHospital == other.codHospital
                && this.nomeHospital.equals(other.nomeHospital)
                && this.endHospital.equals(other.endHospital)
                && this.paisHospital.equals(other.paisHospital)
                && this.qtEnfermarias == other.qtEnfermarias
                && this.listaMedicos.equals(other.listaMedicos)
                && this.listaPacientes.equals(other.listaPacientes)
                && this.listaStock.equals(other.listaStock)
                && this.listaServicos.equals(other.listaServicos);
    }

    /**
     * Devolve a descrição textual do hospital
     *
     * @retun Características do hospital
     *
     */
//    public String toString() {
//        return "> #" + codHospital + " - Hospital " + nomeHospital + ", " + endHospital + ", " + paisHospital
//                + "\n     nr enfermarias: " + qtEnfermarias;
//    }
    @Override
    public String toString() {
        return "> #" + codHospital + " - Hospital " + nomeHospital + ", " + endHospital + ", " + paisHospital + ","
                + "\n  " + qtEnfermarias + " enfermarias"
                + "\n "
                + "\n Médicos do hospital " + nomeHospital + ":"
                + "\n " + listaMedicos + ""
                + "\n "
                + "\n Pacientes do hospital " + nomeHospital + ":"
                + "\n " + listaPacientes + ""
                + "\n "
                + "\n Tipos de recurso do hospital " + nomeHospital + ":"
                + "\n " + listaTipoRecurso + ""
                + "\n "
                + "\n Stock de recursos do hospital " + nomeHospital + ":"
                + "\n " + listaStock + ""
                + "\n "
                + "\n Serviços contratados pelo hospital " + nomeHospital + ":"
                + "\n " + listaServicos
                + "\n "
                + "\n-------------------//--------------------\n";
    }

    /**
     * Adiciona um médico à lista de médicos do hospital
     *
     * @param m O médico a adicionar
     */
    public void adicionarMedico(Medico m) {
        listaMedicos.add(m);
    }

    /**
     * Remove um médico da lista de médicos do hospital
     *
     * @param m O médico a remover
     *
     */
    public void eliminarMedico(Medico m) {
        listaMedicos.remove(m);
    }

    /**
     * Adiciona um paciente à lista de pacientes do hospital
     *
     * @param p O paciente a adicionar
     */
    public void adicionarPaciente(Paciente p) {
        listaPacientes.add(p);
    }

    /**
     * Remove um paciente da lista de pacientes do hospital
     *
     * @param p O paciente a remover
     */
    public void eliminarPaciente(Paciente p) {
        listaPacientes.remove(p);
    }

    /**
     * Adiciona um tipo de recurso à lista de tipos de recursos do hospital
     *
     * @param tr O tipo de recurso a adicionar
     */
    public void adicionarTipoRecurso(TipoRecurso tr) {
        listaTipoRecurso.add(tr);
    }

    /**
     * Remove um tipo de recurso à lista de tipos de recursos do hospital
     *
     * @param tr O tipo de recurso a remover
     */
    public void eliminarTipoRecurso(TipoRecurso tr) {
        listaTipoRecurso.remove(tr);
    }

    /**
     * Adiciona um recurso a um paciente
     *
     * @param p O paciente ao qual se pretende adicionar o recurso
     * @param r O recurso a adicionar
     */
    public void adicionarRecursoPaciente(Paciente p, Recurso r) {
        Paciente aux = this.procurarPaciente(p.getCodPaciente());
        if (aux != null) {
            int posicao = procurarRecursoStock(r);
            if (posicao != -1) {
                // Adicionar recurso ao paciente
                aux.adicionarRecurso(r);
                //Decrementar no stock do hospital
                RecursoStock rs = listaStock.get(posicao);
                rs.decrementarQtRecurso();
                listaStock.set(posicao, rs);
            }
        }
    }

    /**
     * Procura o stock de um recurso
     *
     * @param r O recurso a encontrar
     * @return A posição no vetor onde se encontra o recurso r. -1 caso o
     * recurso não exista
     */
    public int procurarRecursoStock(Recurso r) {
        for (int i = 0; i < listaStock.size(); i++) {
            if (listaStock.get(i).getRecurso().equals(r)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Altera o subsistema de saúde de um paciente
     *
     * @param p O paciente
     * @param novoSubsistema O novo subsistema de saúde do paciente
     */
    public void alterarSubsistema(Paciente p, String novoSubsistema) {
        p.setSubsistema(novoSubsistema);
    }

    /**
     * Pesquisa um paciente na lista de pacientes internados no hospital pelo
     * seu código de paciente.
     *
     * @param codPaciente O código do paciente a pesquisar
     * @return paciente O paciente encontrado. null caso não exista.
     */
    public Paciente procurarPaciente(int codPaciente) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getCodPaciente() == codPaciente) {
                return paciente;
            }
        }
        return null;
    }

    /**
     * Adiciona um recurso ao stock do hospital. Caso o recurso não exista,
     * cria. Caso exista, adiciona à quantidade.
     *
     * @param r O recurso a adicionar
     * @param quantidade A quantidade a adicionar
     */
    public void adicionarStock(Recurso r, int quantidade) {
        int posicao = procurarRecursoStock(r);
        if (posicao == -1) {
            listaStock.add(new RecursoStock(r, quantidade));
        } else {
            RecursoStock rs = listaStock.get(posicao);
            int antigaQt = rs.getQtStock();
            rs.setQtStock(antigaQt + quantidade);
            listaStock.set(posicao, rs);
        }
    }

    /**
     * Elimina um recurso ao stock do hospital. Caso o recurso não exista, cria.
     * Caso exista, subtrai à quantidade.
     *
     * @param r O recurso a remover
     * @param quantidade A quantidade a remover
     */
    public void eliminarStock(Recurso r, int quantidade) {
        int posicao = procurarRecursoStock(r);
        if (posicao == -1) {
            listaStock.remove(new RecursoStock(r, quantidade));
        } else {
            RecursoStock rs = listaStock.get(posicao);
            int antigaQt = rs.getQtStock();
            rs.setQtStock(antigaQt - quantidade);
            listaStock.set(posicao, rs);
        }
    }

    /**
     * Pesquisa o stock de um recurso pelo código do recurso.
     *
     * @param codRecurso O codigo do recurso a pesquisar
     * @return A quantidade em stock do recurso. -1 caso o recurso não exista
     */
    public int verStock(int codRecurso) {
        for (RecursoStock rs : listaStock) {
            if (rs.getRecurso().getCodRecurso() == codRecurso) {
                return rs.getQtStock();
            }
        }
        return -1;
    }

    /**
     * Adiciona um serviço à lista de serviços contratados pelo hospital
     *
     * @param s O serviço a adicionar
     */
    public void adicionarServico(Servico s) {
        listaServicos.add(s);
    }

    /**
     * Remove um serviço à lista de serviços contratados pelo hospital
     *
     * @param s O serviço a remover
     */
    public void eliminarServico(Servico s) {
        listaServicos.remove(s);
    }

    /**
     * Contabiliza a quantidade de refeiçoes contratadas pelo hospital ao fim de
     * semana
     *
     * @return a quantidade de refeiçoes contratadas pelo hospital ao fim de
     * semana
     */
    public int qtRestauracaoFds() {
        int qt = 0;
        for (Servico s : listaServicos) {
            if (s instanceof IServicoFimDeSemana) {
                if (((IServicoFimDeSemana) s).validarServicoFimDeSemana() == true) {
                    qt++;
                }
            }
        }
        return qt;
    }

    /**
     * Ordena os serviços por ordem crescente do NIF da empresa prestadora do
     * serviço
     *
     * @return a lista de serviços ordenada
     */
    public List<Servico> servicosOrdenados() {
        List<Servico> lst = new ArrayList<Servico>(listaServicos);
        Collections.sort(lst);
        return lst;
    }

    /**
     * Calcula o custo da prestação de serviços de limpeza durante um
     * determinado número de dias
     *
     * @param qtDias quantidade de dias de prestação dos serviços
     * @return O custo total dos serviços de limpeza prestados
     */
    public float obterCustoServicoLimpeza(int qtDias) {
        float totalLimpezas = 0;
        ServicoLimpezas sl = null;
        //System.out.println("Tam Lista: " +this.listaServicos.size());
        for (Servico s : listaServicos) {
            if (s instanceof ServicoLimpezas) {
                totalLimpezas += ((ServicoLimpezas) s).obterCustoServico(qtDias);
            }
        }
        return totalLimpezas;
    }

    /**
     * Calcula o custo da prestação de serviços de restauração durante um
     * determinado número de dias
     *
     * @param qtDias quantidade de dias de prestação dos serviços
     * @return O custo total dos serviços de restauração prestados
     */
    public float obterCustoServicoRestauracao(int qtDias) {
        float totalRestauracao = 0;
        ServicoRestauracao sr = null;
        for (Servico s : listaServicos) {
            if (s instanceof ServicoRestauracao) {
                totalRestauracao += ((ServicoRestauracao) s).obterCustoServico(qtDias);
            }
        }
        return totalRestauracao;
    }

    /**
     * Calcula o custo da prestação de serviços (de restauração e de limpeza)
     * durante um determinado número de dias
     *
     * @param qtDias quantidade de dias de prestação dos serviços
     * @return O custo total dos serviços prestados
     */
    double calcularTotalServicos(int qtDias) {
        double custoTotal = 0;
        for (Servico s : listaServicos) {
            custoTotal = custoTotal + s.obterCustoServico(qtDias);
        }
        return custoTotal;
    }

    /**
     * Atualiza a avaliação do serviço prestado ao hospital, através do código
     * do serviço fornecido pelo utilizador
     *
     * @param codServico código do serviço
     * @param val avaliação atribuida
     */
    public void atualizarAvaliacao(int codServico, int val) {
        Servico aux = procurarServico(codServico);
        if (aux != null) {
            aux.atualizarAvaliacao(val);
            //System.out.println(">>> Avaliação do serviço " + codServico + " atualizada para " + val);
        }
    }

    /**
     * Pesquisa um Serviço na lista de serviços contratados por um hospital,
     * pelo código do serviço fornecido
     *
     * @param codServico código do serviço
     *
     * @return servico O servico encontrado. null caso não exista
     */
    public Servico procurarServico(int codServico) {
        for (Servico servico : listaServicos) {
            if (servico.getCodServico() == codServico) {
                return servico;
            }
        }
        return null;
    }
}
