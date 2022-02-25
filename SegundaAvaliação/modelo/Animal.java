/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.animais.ifrs.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import br.animais.ifrs.utils.Conexao;

/**
 *
 * @author juliana
 */
public class Animal {
    private String especie, classe;
    private float peso;
    private int idade;

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the classe
     */
    public String getClasse() {
        return classe;
    }

    /**
     * @param classe the classe to set
     */
    public void setClasse(String classe) {
        this.classe = classe;
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) throws Exception {
        if (peso < 1 || peso > 102) {
            throw new Exception ("O peso deve ser entre 1kg e 102 kg. <br>");
        }        
         this.peso = peso;
    }    
    
    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void inserir () throws Exception{
        Connection con = null;            
        PreparedStatement pstmt = null;
        
        try {         
            con = Conexao.pegarConexao();

            pstmt = con.prepareStatement("insert into animais (especie, classe, peso, idade) values (?, ?, ?, ?)");
            pstmt.setString(1, this.getEspecie());
            pstmt.setString(2, this.getClasse());            
            pstmt.setFloat(3,this.getPeso());
            pstmt.setInt(4, this.getIdade());

            pstmt.execute();               

        } catch (Exception e) {
            throw new Exception("Falha ao inserir um clube no banco de dados!!! <!-- "+e.getMessage()+"-->");
        } finally {
            pstmt.close();
            con.close();
        }        
    }
    
    public List<Animal> consultar() throws Exception{
                        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        List<Animal> animais = new ArrayList();
        
        try {           
            con = Conexao.pegarConexao();
            
            pstmt = con.prepareStatement("select * from animais");        
            /* Executar a setença SQL */
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Animal c = new Animal();
                c.setEspecie(rs.getString("especie"));
                c.setClasse(rs.getString("classe"));
                c.setPeso(rs.getFloat("peso"));
                c.setIdade(rs.getInt("idade"));                
                animais.add(c);
            }      

        } catch (Exception e) {
            throw new Exception("Falha ao consultar clubes no banco de dados!!! <!-- "+e.getMessage()+"-->");
        } finally {
            rs.close();
            pstmt.close();
            con.close();
        }                 
        return animais;
    }
}
