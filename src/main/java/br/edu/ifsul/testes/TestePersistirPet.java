/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estef
 */
public class TestePersistirPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-Estefani-ModelPU");
        EntityManager em = emf.createEntityManager();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Raca r = em.find(Raca.class, 1);
        Pet p = new Pet();
        
        p.setNome("Homer");
        p.setPeso(28.00);
        p.setEspecie(r);
        calendar.setTime(sdf.parse("29/11/2010"));
        p.setNascimento(calendar);

        em.getTransaction().begin();
        em.persist(p);  // persiste a cidade criada
        em.getTransaction().commit();
        em.close();
        emf.close();
 
    }
    
}
