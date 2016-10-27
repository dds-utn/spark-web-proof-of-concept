package db;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import model.Proyecto;

public class RepositorioProyectos implements WithGlobalEntityManager{

	public static RepositorioProyectos instancia = new RepositorioProyectos();

	public void agregar(Proyecto proyecto) {
		entityManager().persist(proyecto);
	}

	public List<Proyecto> listar() {
		return entityManager().createQuery("from Proyecto", Proyecto.class)
		.getResultList();
	}
	
	public Proyecto buscar(long id){
		return entityManager().find(Proyecto.class, id);
	}
}
