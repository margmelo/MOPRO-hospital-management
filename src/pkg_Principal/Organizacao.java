/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Principal;

import pkg_Exceptions.ExcepEndereco;
import pkg_Exceptions.ExcepCaractEspeciais;
import pkg_Exceptions.ExcepNumPositivos;
import pkg_Exceptions.ExcepNomeEsp;
import pkg_Exceptions.ExcepData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma organização
 *
 * @author MOPRO_Grupo4
 */
public final class Organizacao implements Serializable {

    /**
     * nome da organização
     */
    private String nomeOrg;

    /**
     * nome da organização por omissão
     */
    private static final String NOME_POR_OMISSAO = "sem nome";

    /**
     * lista de hospitais da organização
     */
    private List<Hospital> listaHospitais;

    /**
     * Constrói uma organizaçao apartir do seu nome
     *
     * @throws pkg_Principal.ExcepNomeEsp
     */
    public Organizacao() throws ExcepNomeEsp {
        setNomeOrg(NOME_POR_OMISSAO);
        setListaHospitais(new ArrayList());
    }

    /**
     * Constrói uma organização por cópia de outra
     *
     * @param lcf Organização a copiar
     */
    public Organizacao(String nome) throws ExcepNomeEsp {
        setNomeOrg(nome);
        setListaHospitais(new ArrayList());
    }

    /**
     * Devolve o nome da organização
     *
     * @return o nome da organização
     */
    public String getNomeOrg() {
        return nomeOrg;
    }

    /**
     * Devolve a lista de hospitais da organização
     *
     * @return a lista de hospitais da organização
     */
    public List<Hospital> getListaHospitais() {
        return new ArrayList<Hospital>(listaHospitais);
    }

    /**
     * Modifica o nome da organização
     *
     * @param nomeOrg O novo nome da organização
     */
    public void setNomeOrg(String nomeOrg) throws ExcepNomeEsp {
        char c;
        for (int i = 0; i < nomeOrg.length(); i++) {
            c = nomeOrg.charAt(i);
            if (Character.isLetter(c) == false && Character.isSpaceChar(c) == false) {
                throw new ExcepNomeEsp("A organização " + nomeOrg + " tem caracteres que não são letras nem contêm espaços");
            }
        }
        this.nomeOrg = nomeOrg;
    }

    /**
     * Modifica a lista de hospitais da organização
     *
     * @param listaHospitais A lista atualizada de hospitais da organização
     */
    public void setListaHospitais(List listaHospitais) {
        this.listaHospitais = new ArrayList(listaHospitais);
    }

    @Override
    public String toString() {
        return "Organização: " + nomeOrg + ""
                + "\n" + listaHospitais + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Organizacao other = (Organizacao) obj;
        return this.nomeOrg.equals(other.nomeOrg)
                && this.listaHospitais.equals(other.listaHospitais);
    }

    /**
     * Adiciona um hospital à lista de hospitais da organização
     *
     * @param h O hospital a adicionar
     */
    public void adicionarHospital(Hospital h) throws ExcepNomeEsp, ExcepNumPositivos, ExcepEndereco, ExcepCaractEspeciais {
        listaHospitais.add(new Hospital(h));
    }

    /**
     * Remove um hospital à lista de hospitais da organização
     *
     * @param h O hospital a remover
     */
    public void removerHospital(Hospital h) throws ExcepNomeEsp, ExcepNumPositivos, ExcepEndereco, ExcepCaractEspeciais {
        listaHospitais.remove(new Hospital(h));
    }

    /**
     * Adiciona um médico a um hospital
     *
     * @param m O médico a adicionar
     * @param h O hospital a que o médico deve ser adicionado
     */
    public void adicionarMedico(Hospital h, Medico m) throws ExcepNumPositivos, ExcepNomeEsp {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.adicionarMedico(new Medico(m));
        }
    }

    /**
     * Remove um médico a um hospital
     *
     * @param m O médico a remover
     * @param h O hospital a que o médico deve ser removido
     */
    public void eliminarMedico(Hospital h, Medico m) {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.eliminarMedico(m);
        }
    }

    /**
     * Adiciona um paciente a um hospital
     *
     * @param p O paciente a adicionar
     * @param h O hospital a que o paciente deve ser adicionado
     */
    public void adicionarPaciente(Hospital h, Paciente p) throws ExcepNomeEsp, ExcepNumPositivos, ExcepData, ExcepCaractEspeciais {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.adicionarPaciente(new Paciente(p));
        }
    }

    /**
     * Remove um paciente a um hospital
     *
     * @param p O paciente a remover
     * @param h O hospital a que o paciente deve ser removido
     */
    public void eliminarPaciente(Hospital h, Paciente p) {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.eliminarPaciente(p);
        }
    }

    /**
     * Adiciona um tipo de recurso a um hospital
     *
     * @param tr O tipo de recurso a adicionar
     * @param h O hospital a que o tipo de recurso deve ser adicionado
     */
    public void adicionarTipoRecurso(Hospital h, TipoRecurso tr) {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.adicionarTipoRecurso(new TipoRecurso(tr));
        }
    }

    /**
     * Remove um tipo de recurso a um hospital
     *
     * @param tr O tipo de recurso a remover
     * @param h O hospital a que o tipo de recurso deve ser removido
     */
    public void eliminarTipoRecurso(Hospital h, TipoRecurso tr) {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.eliminarTipoRecurso(tr);
        }
    }

    /**
     * Adiciona um tipo de recurso a um hospital
     *
     * @param r O recurso a adicionar
     * @param q A quantidade de stock a adicionar
     * @param h O hospital a que o tipo de recurso deve ser adicionado
     */
    public void adicionarStock(Hospital h, Recurso r, int q) {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.adicionarStock(new Recurso(r), q);
        }
    }

    /**
     * Elimina stock de um recurso a um dado hospital
     *
     * @param r o recurso a eliminar
     * @param q a quantidade de stock a eliminar
     * @param h o hospital a editar
     */
    public void eliminarStock(Hospital h, Recurso r, int q) {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.eliminarStock(new Recurso(r), q);
        }
    }

    /**
     * Adiciona um recurso a um paciente num dado hospital
     *
     * @param r O recurso a adicionar
     * @param codH
     * @param p O paciente a que deve ser adicionado
     */
    public void adicionarRecursoPaciente(int codH, Recurso r, Paciente p) {
        Hospital h1 = procurarHospital(codH);
        if (h1 != null) {
            h1.adicionarRecursoPaciente(p, r);
//            System.out.println(">>> " + r.getDescricao() + " adicionado ao paciente " + p.getNomePaciente());
        }
    }

    /**
     * Adiciona um serviço a um hospital
     *
     * @param h O hospital a que o serviço vai ser prestado
     * @param s O serviço a ser prestado
     */
    public void adicionarServico(Hospital h, Servico s) {
        Hospital aux = procurarHospital(h.getCodHospital());
        if (aux != null) {
            aux.adicionarServico(s);
        }
    }

    /**
     * Altera o subsistema de saúde de um paciente num dado hospital
     *
     * @param novoSubsistema O novo subsistema do paciente
     * @param p O paciente a que o subsistema deve ser alterado
     * @param h O hospital em que o paciente está operado
     */
    public void alterarSubsistema(Hospital h, String novoSubsistema, Paciente p) {
        Hospital h1 = procurarHospital(h.getCodHospital());
        if (h1 != null) {
            h1.alterarSubsistema(p, novoSubsistema);
        }
    }

    /**
     * Pesquisa um hospital na lista de hospitais da organização pelo código do
     * hospital.
     *
     * @param codH O codigo do hospital a pesquisar
     *
     * @return hospital O hospital encontrado. null caso não exista
     */
    public Hospital procurarHospital(int codH) {
        int aux = -1;
        for (int i = 0; i < listaHospitais.size() && aux == -1; i++) {
            if (((Hospital) listaHospitais.get(i)).getCodHospital() == codH) {
                aux = i;
            }
        }
        if (aux != -1) {
            return (Hospital) listaHospitais.get(aux);
        }
//        System.out.println(">>>O HOSPITAL QUE PESQUISOU NÃO EXISTE<<<");
        return null;
    }

    /**
     * Calcula o custo de serviços de restauração prestados a um determinado
     * hospital cujo código é fornecido
     *
     * @param nDias o número de dias para que se pretende fazer o cálculo
     * @param codHospital o código do hospital a que o serviço foi prestado
     *
     * @return O custo total dos serviços de restauração prestados àquele
     * hospital
     */
    public float obterCustoServicoRestauracao(int codHospital, int nDias) {
        float totalRestauracao = 0;
        Hospital aux = procurarHospital(codHospital);
        if (aux != null) {
            totalRestauracao = aux.obterCustoServicoRestauracao(nDias);
        }
        return totalRestauracao;
    }

    /**
     * Calcula o custo de serviços de limpeza prestados a um determinado
     * hospital cujo código é fornecido
     *
     * @param nDias o número de dias para que se pretende fazer o cálculo
     * @param codHospital o código do hospital a que o serviço foi prestado
     *
     * @return O custo total dos serviços de limpeza prestados àquele hospital
     */
    public float obterCustoServicoLimpeza(int codHospital, int nDias) {
        float totalLimpezas = 0;
        Hospital aux = procurarHospital(codHospital);
        if (aux != null) {
            List<Servico> listaServicos = aux.getListaServicos();
            //System.out.println("ESTOU EM CALCULAR LIMPEZA: " +listaServicos.size());
            for (Servico sl : listaServicos) {
                //System.out.println("ESTOU EM CALCULAR LIMPEZA for");
                if (sl instanceof ServicoLimpezas) {
                    //System.out.println("ESTOU EM CALCULAR LIMPEZA if");
                    totalLimpezas = totalLimpezas + ((ServicoLimpezas) sl).obterCustoServico(nDias);
                }
            }
        }
        return totalLimpezas;
    }

    /**
     * Calcula o custo de serviços (de restauração e de limpeza) prestados a um
     * determinado hospital cujo código é fornecido
     *
     * @param nDias o número de dias para que se pretende fazer o cálculo
     * @param codHospital o código do hospital a que os serviços foram prestados
     *
     * @return O custo total dos serviços prestados àquele hospital
     */
    double calcularCustoTotalServicos(int codHospital, int nDias) {
        Hospital aux = procurarHospital(codHospital);
        if (aux == null) {
            return 0;
        }
        double valor = aux.calcularTotalServicos(nDias);
        return valor;
    }

    /**
     * Ordena a lista de serviços prestados a um determinado hospital cujo
     * código é fornecido, por ordem crescente do NIF da empresa que presta o
     * serviço
     *
     * @param codHospital
     *
     * @return a lista ordenada de serviços prestados a determinado hospital
     */
    public List<Servico> servicosOrdenados(int codHospital) {
        Hospital aux = procurarHospital(codHospital);
        if (aux == null) {
            return null;
        } else {
            return aux.servicosOrdenados();
        }
    }

    /**
     * Contabiliza quantas empresas prestam serviços de restauração ao fim de
     * semana num determinado hospital, cujo código é fornecido.
     *
     * @param codHospital O código do hospital onde se quer pesquisar
     *
     * @return quantidade de empresas que prestam serviços de restauração ao fim
     * de semana
     */
    public int qtRestauracaoFds(int codHospital) {
        Hospital aux = procurarHospital(codHospital);
        if (aux == null) {
            return 0;
        } else {
            return aux.qtRestauracaoFds();
        }
    }

    /**
     * Atualiza a avaliação de um serviço fornecido a um hospital, pertencente a
     * uma organização, através do código do hospital e do serviço, fornecidos
     * pelo utilizador
     *
     * @param codServico código do serviço
     * @param av avaliação dada pelo utilizador
     * @param codHospital2 código do hospital a que o serviço foi prestado
     */
    void atualizarAvaliacao(int codHospital, int av, int codServico) {
        Hospital aux = procurarHospital(codHospital);
        if (aux != null) {
            aux.atualizarAvaliacao(codServico, av);
        } else {
//            System.out.println(">>>OS DADOS QUE INSERIU NÃO SÃO VÁLIDOS<<<");
        }

    }

    /**
     * Lista os médicos do hospital
     *
     * @param h O hospital cujos médicos se pretende listar
     */
    public void listarMedicos(Hospital h) {
        Hospital aux = procurarHospital(h.getCodHospital());
        if (aux != null) {
            ArrayList<Medico> listaMedicos = h.getListaMedicos();
            System.out.println("\nLista de médicos do hospital " + h.getNomeHospital() + ":");
            for (Medico m : listaMedicos) {
                System.out.println(m);
            }
        }
    }

    /**
     * Mostra a lista de pacientes. Para que fosse mais acessível a leitura
     * decidimos apresentar apenas o código e nome de cada paciente
     *
     * @param h
     */
    public void listarPacientes(Hospital h) {
        Hospital aux = procurarHospital(h.getCodHospital());
        if (aux != null) {
            ArrayList<Paciente> listaPacientes = h.getListaPacientes();
            System.out.println("\nLista de pacientes do hospital " + h.getNomeHospital() + ":");
            for (Paciente p : listaPacientes) {
                System.out.println(p);
            }
        }
    }

    /**
     * Lista os tipos de recursos do hospital
     *
     * @param h O hospital cujos recursos se pretende listar
     */
    public void listarTiposRecurso(Hospital h) {
        Hospital aux = procurarHospital(h.getCodHospital());
        if (aux != null) {
            ArrayList<TipoRecurso> listaTipoRecurso = h.getListaTiposRecurso();
            System.out.println("\nLista de tipos de recursos do hospital " + h.getNomeHospital() + ":");
            for (TipoRecurso tr : listaTipoRecurso) {
                System.out.println(tr);
            }
        }
    }

    /**
     * Mostra a lista do Stock de recursos do hospital
     *
     * @param h O hospital cujo stock de recursos vai ser listado
     */
    public void listarStock(Hospital h) {
        Hospital aux = procurarHospital(h.getCodHospital());
        if (aux != null) {
            ArrayList<RecursoStock> listaStock = h.getListaStock();
            System.out.println("\nLista de recursos em stock do hospital " + h.getNomeHospital() + ":");
            for (RecursoStock rs : listaStock) {
                System.out.println(rs);
            }
        }
    }

    /**
     * Mostrar os paciente do hospital com um determinado código
     *
     * @param h O hospital no qual se pretende fazer a pesquisa
     * @param codPaciente O código do paciente a pesquisar
     */
    public void mostrarPaciente(Hospital h, int codPaciente) {
        Hospital aux = procurarHospital(h.getCodHospital());
        if (aux != null) {
            Paciente p = h.procurarPaciente(codPaciente);
            if (p != null) {
                System.out.println("Paciente " + codPaciente + ": " + p);
            } else {
                System.out.println("Não existe nenhum paciente com o código " + codPaciente);
            }
        }
    }

    /**
     * Mostrar o stock de um determinado recurso no hospital
     *
     * @param h O hospital no qual se pretende fazer a pesquisa
     * @param codRecurso O código do recurso a pesquisar
     */
    public void mostrarStock(Hospital h, int codRecurso) {
        Hospital aux = procurarHospital(h.getCodHospital());
        if (aux != null) {
            int cod = h.verStock(codRecurso);
            if (cod != -1) {
                System.out.println("Recurso " + codRecurso + ": " + cod);
            } else {
                System.out.println("Não existe nenhum recurso com o código " + codRecurso);
            }
        }
    }

    /**
     * Mostra a lista do serviços contratados pelo hospital
     *
     * @param h O hospital cujos serviços contratados vão ser listados
     */
    public void listarServicos(Hospital h) {
        Hospital aux = procurarHospital(h.getCodHospital());
        if (aux != null) {
            List<Servico> listaServicos = h.getListaServicos();
            System.out.println("\nLista de serviços contratados pelo hospital " + h.getNomeHospital() + ":");
            for (Servico s : listaServicos) {
                System.out.println(s);
            }
        }
    }
}
