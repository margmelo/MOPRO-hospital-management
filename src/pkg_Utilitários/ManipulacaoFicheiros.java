/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Utilitários;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import pkg_Principal.Organizacao;

/**
 *
 * @author MOPRO_Grupo4
 */
public class ManipulacaoFicheiros {

    private static Organizacao org = null;

    private static boolean gravarFicheiro(String nomeFicheiro, Organizacao org) {
        try {
            FileOutputStream fout = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            try {
                out.writeObject(org);
                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            //throw new RuntimeException("IO Exception in CommandLine Application",ex);
            return false;
        }
    }

    private static boolean lerFicheiro(String nomeFicheiro) {
        try {
            FileInputStream fin = new FileInputStream(nomeFicheiro);
            ObjectInputStream in = new ObjectInputStream(fin);
            try {
                org = (Organizacao) in.readObject();
                System.out.println("Leu Organizaçao");
                return true;
            } finally {
                in.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Não conseguiu encontrar o ficheiro");
            return false;
        } catch (IOException ex) {
            System.out.println("Erro na leitura do ficheiro");
            //throw new RuntimeException("IO Exception in CommandLine Application",ex);
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no carregamento da clase!!");
            return false;
        }
    }

    public static boolean gravarInformacaoOrganizacao(String nomeFicheiro, Organizacao org) {
        return gravarFicheiro(nomeFicheiro, org);
    }

    public static Organizacao lerInformacaoOrganizaco(String nomeFicheiro) {
        if (lerFicheiro(nomeFicheiro)) {
            return org;
        } else {
            return null;
        }
    }
}
