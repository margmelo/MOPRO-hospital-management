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
import javax.swing.JOptionPane;
import pkg_Principal.ServicoLimpezas.Produto;
import pkg_Utilitários.Data;
import pkg_Utilitários.ManipulacaoFicheiros;

/**
 *
 * @author mruna
 */
public class Teste_IT3 {

    // Leitura e validação do nome da organização- Exemplo
    public static Organizacao lerNomeOrganizacao() {
        Organizacao org = null;
        boolean correto = false;
        String s;
        do {
            try {
                s = JOptionPane.showInputDialog(null, "Qual o nome da organizacao <permitido letras e espaços> ? ");
                org = new Organizacao(s);
                correto = true;
            } catch (ExcepNomeEsp e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (correto == false);
        return org;
    }

    //Leitura e validação dos dados de um hospital
    public static Hospital lerDadosHospital() {
        Hospital h = null;
        boolean correto = false;
        String s;
        do {
            try {
                s = JOptionPane.showInputDialog(null, "Qual o código do hospital <permitido números inteiros positivos> ?");
                int codH = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "Qual o nome do hospital <permitido letras e espaços> ?");
                String nome = s;
                s = JOptionPane.showInputDialog(null, "Qual o endereço do hospital <permitido letras e espaços, deve começar por Av., Rua, Lugar ou Trav.> ?");
                String endHospital = s;
                h = new Hospital(codH, nome, endHospital, "Portugal", 100);
                correto = true;
            } catch (ExcepNumPositivos | ExcepNomeEsp | NumberFormatException | ExcepEndereco e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (correto == false);
        return h;
    }

    //Leitura e validação dos dados de um médico
    public static Medico lerDadosMedico() {
        Medico m = null;
        boolean correto = false;
        String s;
        do {
            try {
                s = JOptionPane.showInputDialog(null, "Qual o código de cédula profissional do médico? <permitido números inteiros positivos com pelo menos 5 algarismos> ?");
                int cod = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "Qual o nome do médico <permitido letras e espaços> ?");
                String nomeM = s;
                s = JOptionPane.showInputDialog(null, "Qual a especialidade do médico <permitido letras e espaços> ?");
                String esp = s;
                m = new Medico(cod, nomeM, esp);
                correto = true;
            } catch (ExcepNumPositivos | ExcepNomeEsp | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (correto == false);
        return m;
    }

    //Leitura e validação dos dados de um paciente
    public static Paciente lerDadosPaciente() {
        Paciente p = null;
        boolean correto = false;
        String s;
        do {
            try {
                s = JOptionPane.showInputDialog(null, "Qual o código do paciente <permitido números inteiros positivo com pelo menos 2 dígitos> ?");
                int cod = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "Qual o nome do paciente <permitido letras e espaços> ?");
                String nomeP = s;
                s = JOptionPane.showInputDialog(null, "DATA DE NASCIMENTO: Insira o dia <1-31>");
                int a = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "DATA DE NASCIMENTO: Insira o mês <1-12>");
                int b = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "DATA DE NASCIMENTO: Insira o ano.");
                int c = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "DATA DE INTERNAMENTO: Insira o dia <1-31>");
                int d = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "DATA DE INTERNAMENTO: Insira o mês <1-12>");
                int e = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "DATA DE INTERNAMENTO: Insira o ano.");
                int f = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "DATA DE ALTA: Insira o dia <1-31>");
                int g = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "DATA DE ALTA: Insira o mês <1-12>");
                int h = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "DATA DE ALTA: Insira o ano.");
                int i = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "Qual o diagnóstico?");
                String doenca = s;
//                s = JOptionPane.showInputDialog(null, "Observações:");
//                String obs = s;
                p = new Paciente(cod, nomeP, new Data(c, b, a), new Data(f, e, d), new Data(i, h, g), "ADSE", doenca, "sem observações");
                correto = true;
            } catch (ExcepNumPositivos | ExcepNomeEsp | ExcepData | ExcepCaractEspeciais | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (correto == false);
        return p;
    }

    // Leitura e validação dos dados de um serviço de limpeza
    public static ServicoLimpezas lerDadosServicoLimpeza() {
        ServicoLimpezas sl = null;
        boolean correto = false;
        String s;
        do {
            try {
                s = JOptionPane.showInputDialog(null, "Qual o código do serviço de limpeza <permitido números inteiros positivos> ? ");
                int cod = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "Qual o preço por limpeza de enfermaria <permitido números reais positivos> ?");
                float preco = Float.parseFloat(s);
                s = JOptionPane.showInputDialog(null, "Qual a quantidade de limpezas diárias por enfermaria <permitido números inteiros positivo>?");
                int qt1 = Integer.parseInt(s);
                s = JOptionPane.showInputDialog(null, "Qual a quantidade de enfermarias <permitido números inteiros positivos>?");
                int qt2 = Integer.parseInt(s);
                sl = new ServicoLimpezas(cod, new Data(2020, 05, 29), new Data(2021, 05, 29), "limpeza", 123456789, Produto.A, qt2, qt1, preco);
                correto = true;
            } catch (ExcepNumPositivos | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (correto == false);
        return sl;
    }

    // Leitura e validação dos dados de um serviço de restauração
    public static ServicoRestauracao lerDadosServicoRestauracao() {
        ServicoRestauracao sr = null;
        boolean correto = false;
        String s;
        do {
            try {
                s = JOptionPane.showInputDialog(null, "Qual o código do serviço de restauração <permitido números inteiros positivos>?");
                int cod = Integer.parseInt(s);
                sr = new ServicoRestauracao(cod, new Data(8, 2, 2020), new Data(8, 2, 2021), "refeições", 987654321, 19, true);
                correto = true;
            } catch (ExcepNumPositivos | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (correto == false);
        return sr;
    }

    public static Organizacao carregarDadosManual() throws ExcepNomeEsp, ExcepNumPositivos, ExcepEndereco, ExcepData, ExcepCaractEspeciais {

        /*a*/ //criar organização
        Organizacao lcf = lerNomeOrganizacao();

        /*b*/ //hospitais
        Hospital h1 = new Hospital(1, "St Maria", "Av. Egas Moniz", "Portugal", 5);
        Hospital h2 = new Hospital(2, "St António", "Trav. Abel Salazar", "Portugal", 3);
        Hospital h3 = lerDadosHospital();
        lcf.adicionarHospital(h1);
        lcf.adicionarHospital(h2);
        lcf.adicionarHospital(h3);

        /*d*/ //médicos
        Medico m1 = new Medico(11111, "Fernando Pereira");
        Medico m2 = new Medico(22222, "Maria Gomes");
        Medico m3 = new Medico(33333, "Abel Abrantes");
        Medico m4 = new Medico(44444, "Beatriz Bastos");
        Medico m5 = lerDadosMedico();
        lcf.adicionarMedico(h1, m1);
        lcf.adicionarMedico(h1, m2);
        lcf.adicionarMedico(h2, m3);
        lcf.adicionarMedico(h2, m4);
        lcf.adicionarMedico(h3, m5);


        /*d*/ //pacientes
        Paciente p1 = new Paciente(111, "Manuela Tavares",
                new Data(1975, 06, 02),
                new Data(2020, 04, 20),
                new Data(2020, 04, 26),
                "Multicare", "AVC",
                "Ficar atento a eventuais sequelas do AVC. \n                Tem de ser acordado de 3h em 3h durante a noite.");
        Paciente p2 = new Paciente(222, "Matilde Martins",
                new Data(2002, 01, 30),
                new Data(2016, 06, 01),
                new Data(2017, 10, 06),
                "ADSE", "Crise asmática",
                "Paciente com muitos problemas respiratórios.\n                Paciente suspeito de covid19");
        Paciente p3 = new Paciente(333, "Ana Carolina",
                new Data(1991, 03, 07),
                new Data(2020, 11, 24),
                new Data(2020, 12, 15),
                "Allianz", "PCR",
                "PCR pós queda. \n                possível traumatismo craniano.");
        Paciente p4 = new Paciente(444, "João Baptista",
                new Data(1996, 06, 29),
                new Data(2016, 07, 1),
                new Data(2017, 07, 17),
                "Fidelidade", "Multiplas fraturas",
                "Paciente com possiveis fraturas pós acidente de carro .\n                Repouso total");
        Paciente p5 = lerDadosPaciente();
        lcf.adicionarPaciente(h1, p1);
        lcf.adicionarPaciente(h1, p2);
        lcf.adicionarPaciente(h2, p3);
        lcf.adicionarPaciente(h2, p4);
        lcf.adicionarPaciente(h3, p5);


        /*d*/ //tipos de recurso
        TipoRecurso tr1 = new TipoRecurso("máscara");
        TipoRecurso tr2 = new TipoRecurso("ventilador");
        TipoRecurso tr3 = new TipoRecurso("gaze");
        TipoRecurso tr4 = new TipoRecurso("colar cervical");
        lcf.adicionarTipoRecurso(h1, tr1);
        lcf.adicionarTipoRecurso(h1, tr2);
        lcf.adicionarTipoRecurso(h2, tr3);
        lcf.adicionarTipoRecurso(h2, tr4);

        /*d*/ //recursos
        Recurso r1 = new Recurso(tr1, "máscara cirurgica");
        Recurso r2 = new Recurso(tr1, "máscara descartável");
        Recurso r3 = new Recurso(tr2, "ventilador invasivo");
        Recurso r4 = new Recurso(tr2, "ventilador não invasivo");
        Recurso r5 = new Recurso(tr3, "gaze estéril");
        Recurso r6 = new Recurso(tr3, "gaze não estéril");
        Recurso r7 = new Recurso(tr4, "colar cervical macio");
        Recurso r8 = new Recurso(tr4, "colar cervical rígido");
        lcf.adicionarStock(h1, r1, 100);
        lcf.adicionarStock(h1, r2, 150);
        lcf.adicionarStock(h1, r3, 10);
        lcf.adicionarStock(h1, r4, 25);
        lcf.adicionarStock(h2, r5, 60);
        lcf.adicionarStock(h2, r6, 40);
        lcf.adicionarStock(h2, r7, 5);
        lcf.adicionarStock(h2, r8, 15);

        /*d*/ //serviços
        ServicoLimpezas sl1 = new ServicoLimpezas(1, new Data(4, 6, 2019), new Data(9, 6, 2019), "limpezas", 123321123, Produto.A, 6, 2, 5);
        ServicoRestauracao sr1 = new ServicoRestauracao(2, new Data(1, 5, 2019), new Data(5, 6, 2019), "refeições", 198765432, 100, false);
        ServicoLimpezas sl3 = lerDadosServicoLimpeza();
        ServicoRestauracao sr3 = lerDadosServicoRestauracao();
        lcf.adicionarServico(h1, sl1);
        lcf.adicionarServico(h1, sr1);
        lcf.adicionarServico(h3, sr3);
        lcf.adicionarServico(h3, sl3);
        return lcf;
    }

    public static Organizacao carregarDadosFicheiro() {
//        String nomeFic;
//        nomeFic = JOptionPane.showInputDialog(null, "Qual o nome do ficheiro? ");
        Organizacao org = ManipulacaoFicheiros.lerInformacaoOrganizaco("lcf.dat");
        return org;
    }

    public static void gravarDadosFicheiro(Organizacao org) {
//        String nomeFic;
//        nomeFic = JOptionPane.showInputDialog(null, "Qual o nome quer dar ao ficheiro? ");
        boolean resp = ManipulacaoFicheiros.gravarInformacaoOrganizacao("lcf.dat", org);
        return;
    }

    public static void main(String[] args) throws ExcepNomeEsp, ExcepNumPositivos, ExcepEndereco, ExcepData, ExcepCaractEspeciais, NumberFormatException {
        //Scanner sc = new Scanner(System.in);
        Organizacao org = null;
        String resp = JOptionPane.showInputDialog(null, "Pretende que a informação seja lida de um ficheiro? <s/n>");
        if (resp.equals("s")) {
            org = carregarDadosFicheiro();
        } else {
            org = carregarDadosManual();
        }
        //System.out.println("valor de LifeComesFirst: " + lcf);
        if (org == null) {
            org = carregarDadosManual();
        }
        System.out.println(org.toString());

        resp = JOptionPane.showInputDialog(null, "Pretende que a informação seja guardada num ficheiro? <s/n>");
        if (resp.equals("s")) {
            gravarDadosFicheiro(org);
        }
    }
}
