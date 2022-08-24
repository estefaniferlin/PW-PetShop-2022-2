/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20202PF.CC0011
 */
public class TestePersistirRaca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-Estefani-ModelPU"); 
        EntityManager em = emf.createEntityManager();
        
        Raca r = new Raca();
        r.setNome("Golden retriever");
        
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
     
    }
   
}
