/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estef
 */
public class TesteListarPets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-Estefani-ModelPU"); // recebe o nome da unidade de persistencia que vem do arquivo persistence.xml  (o persistence-unit)
        EntityManager em = emf.createEntityManager();
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Pet> pets = em.createQuery("from Pet order by nome").getResultList();
        
        for(Pet p : pets){
            System.out.println("\nID: " + p.getId() + "\nNome: " + p.getNome() + "\nData de nascimento: " + sdf.format(p.getNascimento().getTime()) + "\nPeso: " + p.getPeso() + "\nEspécie: " + p.getEspecie().getNome() + "\n");
        }
        
        em.close();
        emf.close();
        
    }
    
}
