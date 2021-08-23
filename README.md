# MOPRO-hospital-management
Group work held in the second semester of the degree in systems engineering of ISEP, within the scope of the curricular unit of Modelling and Programming. ``` Final grade: 19 ```

This project was developed in three iterations and the utterance was as follows.

---
FIRST ITERATION
---
### Problem description
The European organization LifeComesFirst (LCF) intends to support a network of European hospitals in the management of material resources under the COVID-19 pandemic. Monitoring and updating information from the various participating hospitals can help to improve the use and distribution of resources.
In a first phase of implementation (IT1), it is possible to identify the key entities for the problem below.
* **Hospital:** It is necessary to know the code of each hospital, which must be unique, name, address, country, doctors, hospitalized patients, types of material resources and stock of resources;
* **Doctor:** It is necessary to know the professional order code, name and main specialty;
* **Patient:** For each patient it is necessary to know their user code, name, date of birth, date of admission, date of discharge, healthcare system, illness, material resources used and finally a field for observations;
* **Type of resource:** This concept needs to have only one designation, for example, “masks”;
* **Resource:** This entity is characterized by a unique code, the type of resource to which it refers and a description, which serves to describe a resource in more detail, for example, “surgical masks”;
* **Stock of resource:** This entity has as attributes the resource and the respective stock quantity.

Regarding the features to be implemented, a hospital must meet the following requirements:
* Add/remove doctor;
* Add/remove patient;
* Add type of resource;
* Add resource to a patient;
* Change a patient's healthcare system;
* Obtain a patient given the user code provided by the user.

Create a class to test the implemented classes, satisfying the following requirements:
1. Create an hospital;
2. Create two doctors and add them to the hospital;
3. Create two patients and add them to the hospital;
4. Create two types of resource and add them to the hospital;
5. Add a resource to a patient;
6. List types of resource, doctors and patients of the hospital;
7. Show data of a patient given the user code provided by the user;
8. Show on the screen the quantity in stock of a resource whose code was provided by the user.

#### Testing class example:
```java
public class Main {
  public static void main(String[] args) {
    Hospital h1 = new Hospital();
    Medico m1 = new Medico(11111, "Fernando Pereira");
    h1.adicionarMedico(m1);
    Paciente p1 = new Paciente();
    h1.adicionarPaciente(p1);
    h1.alterarSubsistemaSaude(p1,"ADSE");
    TipoRecurso tr1 = new TipoRecurso("mascara");
    h1.adicionarTipoRecurso(tr1);
    Recurso r1 = new Recurso(tr1,"mascara cirúrgica");
    h1.adicionarRecursoPaciente(p1,r1);
    listarMedicosHospital(h1);
  }
  public static void listarMedicosHospital(Hospital h) {
    //....
  } 
}
 ```
 ---
 SECOND ITERATION
 ---
 ### Problem Description
 Based on the work of IT1, this iteration will aim to evolve into a mini-management system for several hospitals, with the information being centralized in the European organization _LifeComesFirst (LCF)_. In this sense, it will be necessary to complete the application developed previously, as described below:
 * **Organization:** It is the organization responsible for storing hospital information. It must also have an attribute to store its name;
 * **Hospital:** In addition to the attributes already known, this class must know the total number of wards and the list of contracted services;
* **Services** can be of two types: **Cleaning** Services and **Catering** Services;
* Any **service** is characterized by a code, a start date, an end date of the contract, a description and the TIN of the company providing the service;
* For **cleaning services**, it is also necessary to characterize the category of products to be used for cleaning (consider categories "A", "B" and "C"), the number of wards that were contracted for cleaning, the price per cleaning per ward and the amount of daily cleanings per ward;
* In the case of **catering services**, in addition to the common attributes associated with any service, it is necessary to add the amount of daily meals contracted. The price per meal does not vary by catering company, and may even be changed by the hospital;
* Hospitals have the right to assess the services provided to them. Thus, any service must implement the **IPayable** interface (see code at the end of this statement).
* Each type of service also has a specific formula to calculate its price. Thus, any service must implement the **IRating** interface (see code at the end of this statement and formulas for calculating service prices).
* The catering service is required to decide whether or not to have meals on the weekend. In this sense, any catering service must implement the **IWeekendService** interface (see code at the end of this statement).

Regarding the features that the LCF organization needs to implement, they are presented below:
* Add/remove a hospital;
* Add/delete doctor/patient/resource type/resource stock to a given hospital;
* Add resource to an existing patient in a given hospital;
* Change an existing patient's health subsystem in a given hospital;
* Obtain a patient, provided hospital code and patient user code;
* Update the evaluation of a service receiving as parameters the service code, the evaluation and the hospital code;
* Calculate the total cost of the cleaning service for a given hospital (cf. item 9.);
* Calculate the total cost of the restoration service for a given hospital (cf. item 10.);
* Calculate the cost of all services for a given hospital (cf. item 11.).

Create a class to test the implemented classes, satisfying the following requirements:
1. Create the LCF organization;
2. Create two hospitals;
3. Add hospitals to LCF;
4. Create doctors, patients, resource types, resources, stocks, services and add them to one of the hospitals;
5. Repeat point 4. but now adding objects to the other hospital;
6. Add resource to a patient, provided the hospital code by the user;
7. Update the assessment of a service for a given hospital. The user must provide the service code, assessment and hospital code;
8. List all hospital information given the hospital code provided by the user;
9. Show the total cost of cleaning service for a given hospital. The user must provide the number of days for the cost calculation and the hospital code;
10. Show the total cost of the restoration service for a given hospital. The user must provide the number of days for the cost calculation and the hospital code;
11. Show the cost of all services for a given hospital. The user must provide the number of days for the cost calculation and the hospital code;
12. Show the number of catering companies that work on the weekend in a given hospital. The user must provide the hospital code;
13. Show a list of companies (only TINs) that provide services in a hospital, sorted in ascending order of the TIN of each one. The hospital code must be given by the user.

#### Testing class example:
```java
public class Main {
  public static void main(String[] args) {
    LCF lcf = new LCF(“LifeComesFirst”);
    Hospital h1 = new Hospital();
    lcf.adicionarHospital(h1);
    Medico m1 = new Medico(11111, "Fernando Pereira");
    lcf.adicionarMedicoHospital(m1,1); // the 2nd parameter is the hospital's code
    Paciente p1 = new Paciente(234);
    lcf.adicionarPacienteHospital(p1,234); // the 2nd parameter is the patient's user code
 ......
 }
 ```
 #### Interface files provided
 ```java
 public interface IWeekendService {
   
   /**
   * Valor do servico de transfer por omissao
   */
   public static final boolean SERVICO_POR_OMISSAO = false;
   
   /**
   * Verifica se a empresa de restauração tem servico ao fim de semana
   *
   * @return true se sim, false se nao
   */
   public abstract boolean validarServicoFimDeSemana();
}
```
```java
public interface IRating {
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
```
```java
public interface IPayable {
  /**
   * Devolve o custo do serviço dada uma quantidade de dias (qtDias)
   * @param qtdDias quantidade de dias para cálculo do custo do serviço
   * @return custo do serviço para uma dada quantidade de dias
   */
   public float obterCustoServico(int qtdDias);
}
```
#### Services Costing Formulas
* **Cleaning service for each hospital:**
  * number of wards contracted x price per cleaning per ward x number of daily cleanings contracted per infirmary x number of days
* **Catering service for each hospital:**
  * number of daily meals contracted x price per meal x number of days

---
THIRD ITERATION
---
Based on the work of IT2, this iteration aims to evolve into an application that allows the LCF organization's data to be read and saved to a file and to carry out a set of validations of input data entered by the user. In this sense, make the necessary changes to the application of IT2, as described below:
1. The constructors must invoke the respective ```setter()``` methods existing in their classes, being these responsible for validating the values passed by parameter. User-entered data must be read outside the domain classes.
2. The methods to read and write from/to file (serialization/deserialization) the organization's information, must be implemented in a proper class (ex.: Handling Files), which must belong to the same project, however, inserted in a new package (eg “pck_HandlingFiles”).
3. It is not mandatory to validate all object attribute values, some validations are required, as described below. The validation process must allow the user to repeat data entry while they are not valid. Required validations are:
  * In the Organization, the name must only consist of letters or Space character;
  * At the hospital:
    * The hospital name must only accept letters or space characters;
    * The address must only accept letters, numbers, space or period (‘.’). In addition, the address must start with one of the following character sequences “Av.”, “Street”, “Trav.” and “Place”.
  * In the Cleaning Service:
    * The service code should only accept a positive integer type value;
    * The price for cleaning must be a positive real type value;
    * The daily cleaning amount must be a positive integer type value;
    * The number of wards must be a positive integer type value.
  * On the Patient:
    * The patient code must be a positive integer type value, at least 2 digits long;
    * The patient's name must only accept letters or space characters;
    * The date of birth must be before the date of admission.
    * The description of the disease must only accept letters, numbers, space or a symbol between the following: “+-@_”;

#### Test Class
The loading of the Organization's data can be done in two different ways, and the user must make the decision. In this sense, when the application starts, it should ask the user if he wants to read the information from a file. If so, the file name must be requested, otherwise, the data is created in the same way as what was done in previous iterations (not forgetting the required validations).
Regarding the other functionalities of the Test class, they must be kept from IT2 to IT3. Before the application ends, the user should be asked if he wants the organization's information to be saved to a file. If so, the file name must be requested, and then the information saved on disk.

#### Description of project development stages
* Step 1: Start by improving and finish (if applicable) practical work 2 (i.e., IT2). Also pay attention to point 1 of this statement.
* Step 2: Analyze the code provided for the Test class.
* Step 3: Read and write from/to file all LCF organization information. Also note point 2 of this statement.
* Step 4: Ask the user for some of the object attribute values and validate them as indicated in point 3 of this statement.

#### Example: Test class structure
```java
public class Teste {
 
 // Leitura e validação do nome da organização- Exemplo
   public static Organizacao lerNomeOrganizacao() {
     Organizacao org=null;
     boolean correto = false;
     String s;
     do {
         try {
             s=JOptionPane.showInputDialog(null, "Qual o nome da organizacao <permitido letras e espaço>? ");
             org = new Organizacao(s);
             correto=true;
             } catch (ExcecaoAlfabetoEspaco e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
             }
         } while(correto==false);
         return org;
     }

     // Leitura e validação dos dados de um serviço de limpeza
     public static ServicoLimpeza lerDadosServicoLimpeza(){
        // Completar
     }
     
     public static ServicoRestauracao lerDadosServicoRestauracao(){
        // Completar
     }
     
     public static Organizacao carregarDadosManual(){
         Organizacao lcf = lerNomeOrganizacao();
         Hospital h1 = new Hospital("Hospital 1", "Rua do Hospital", "Portugal", 5);
         Hospital h2 = new Hospital("Hospital 2", "Rua do Centro de Saude", "Portugal", 3);
         lcf.adicionarHospital(h1);
         lcf.adicionarHospital(h2);
         Medico m1 = new Medico(11111, "Fernando Pereira");
         Medico m2 = new Medico(22222, "Maria Gomes");
         lcf.adicionarMedico(m1, h1);
         lcf.adicionarMedico(m2, h1);
         Paciente p1 = new Paciente(1111, "Antonio", new Data(2000, 1, 1), new Data(2010, 1, 1), new Data(2010, 1, 5), "SNS", new ArrayList<Recurso>(), "apendicite", "dores de barriga");
         Paciente p2 = new Paciente(2222, "Manuela", new Data(2003, 1, 1), new Data(2020, 5, 1), new Data(2020, 5, 5), "SNS", new ArrayList<Recurso>(), "apendicite", "dores de barriga");
         lcf.adicionarPaciente(p1, h1);
         lcf.adicionarPaciente(p2, h1);
         TipoRecurso tr1 = new TipoRecurso("mascara");
         TipoRecurso tr2 = new TipoRecurso("bata");
         lcf.adicionarTipoRecurso(tr1, h1);
         lcf.adicionarTipoRecurso(tr2, h1);
         Recurso r1 = new Recurso(tr1, "mascara cirúrgica");
         Recurso r2 = new Recurso(tr1, "mascara sem ser cirúrgica");
         lcf.adicionarStock(r1, 150, h1);
         lcf.adicionarStock(r2, 370, h1);
         Medico m3 = new Medico(33333, "Abel Abrantes");
         Medico m4 = new Medico(44444, "Beatriz Bastos");
         lcf.adicionarMedico(m3, h2);
         lcf.adicionarMedico(m4, h2);
         Paciente p3 = new Paciente(3333, "Carla", new Data(2007, 1, 1), new Data(2019, 1, 1), new Data(2019, 1, 5), "ADSE", new ArrayList<Recurso>(), "covid-19", "tosse");
         Paciente p4 = new Paciente(4444, "Diogo", new Data(2001, 1, 1), new Data(2017, 5, 1), new Data(2017, 5, 5), "SNS", new ArrayList<Recurso>(), "gripe", "tosse");
         lcf.adicionarPaciente(p3, h2);
         lcf.adicionarPaciente(p4, h2);
         TipoRecurso tr3 = new TipoRecurso("ligadura");
         TipoRecurso tr4 = new TipoRecurso("sutura");
         lcf.adicionarTipoRecurso(tr3, h2);
         lcf.adicionarTipoRecurso(tr4, h2);
         Recurso r3 = new Recurso(tr3, "ligadura grande");
         Recurso r4 = new Recurso(tr4, "sutura externa");
         lcf.adicionarStock(r3, 120, h2);
         lcf.adicionarStock(r4, 250, h2);
         // adição de serviços
         ServicoRestauracao sr1 = lerDadosServicoRestauracao();
         ServicoLimpeza sl1 = lerDadosServicoLimpeza();
         ServicoRestauracao sr2 = lerDadosServicoRestauracao();
         ServicoLimpeza sl2 = lerDadosServicoLimpeza();
         lcf.adicionarServicoHospital(sr1, h1);
         lcf.adicionarServicoHospital(sl1, h1);
         lcf.adicionarServicoHospital(sr2, h1);
         lcf.adicionarServicoHospital(sl2, h2);
         return lcf;
     }
     
     public static Organizacao carregarDadosFicheiro() {
         String nomeFic;
         nomeFic = JOptionPane.showInputDialog(null, "Qual o nome do ficheiro? ");
         Organizacao lcf = ManipulacaoFicheiro.lerInformacaoOrganizacao(nomeFic);
         return lcf;
     }
     
     public static void gravarDadosFicheiro(Organizacao org) {
         String nomeFic;
         nomeFic = JOptionPane.showInputDialog(null, "Qual o nome do ficheiro? ");
         boolean resp = ManipulacaoFicheiro.gravarInformacaoOrganizacao(nomeFic,org);
         return ;
     }
    
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         Organizacao lcf=null; 
         String resp = JOptionPane.showInputDialog(null, "Pretende que a informação seja lida de um ficheiro? <s/n>");
         if (resp.equals("s")) {
            lcf = carregarDadosFicheiro();
         } else {
            lcf = carregarDadosManual();
         } if (lcf==null) {
            lcf = carregarDadosManual();
         }
         
         System.out.println(lcf.toString());
        // Nesta área criar e adicionar mais alguns objetos à organização (ex:hospital, medico, paciente)
           // Completar
        // Gravar depois a informação para ficheiro
        resp = JOptionPane.showInputDialog(null, "Pretende que a informação seja guardada num ficheiro? <s/n>");
        if (resp.equals("s")) {
        // Completar
         }
    }    
}

