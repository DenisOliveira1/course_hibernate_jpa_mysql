package br.edu.denis.testes;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.denis.entidade.Empregado;

public class EmpregadosTeste {

	// variaveis
	private EntityManager em;
	private EntityManagerFactory emf;

	// main
	public static void main(String[] args) {
		new EmpregadosTeste();
	}

	// construtor
	public EmpregadosTeste() {
		// associa com o xml de persistencia
		emf = Persistence.createEntityManagerFactory("denisPersistencia");
		
		adicionarEmpregado(new Empregado("Denis", "Pepito", new GregorianCalendar(1994, 7, 15).getTime()));
		adicionarEmpregado(new Empregado("Yu", "Chen", new GregorianCalendar(1996, 1, 15).getTime()));
		listarEmpregados();
		//removerEmpregado(10);
		listarEmpregados();
		
	}

	// metodos
	public void listarEmpregados() {
		System.out.println();
		em = emf.createEntityManager();
		List<Empregado> empregados = (List<Empregado>) em.createQuery("FROM Empregado").getResultList();// Empregados é																								// o nome da																								// sensitive
		System.out.println("- Em esta base de dados existema " + empregados.size() + " empregados");
		
		for(Empregado emp:empregados) {
			System.out.println("* "+emp.toString());
		}
		em.close();
	}

	public void adicionarEmpregado(Empregado e) {
		em = emf.createEntityManager();
		em.getTransaction().begin();//inicio
		em.persist(e);
		em.getTransaction().commit();//fim
		em.close();
	}
	
	public void removerEmpregado(int id){
		em = emf.createEntityManager();
		em.getTransaction().begin();//inicio
		em.remove(em.find(Empregado.class, id));	
		em.getTransaction().commit();//fim	
		em.close();
	}
}


