package controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import db.RepositorioProyectos;
import model.Proyecto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ProyectosControllerTest extends AbstractPersistenceTest implements WithGlobalEntityManager{
	private ProyectosController controlador;
	private Request request;
	private Response response;
	
	@Before
	public void setUp(){
		controlador = new ProyectosController();
		request = mock(Request.class);
		response = mock(Response.class);
	}
	
	@Test
	public void indexSinParametrosDevuelveTodosLosProyectos(){
		RepositorioProyectos.instancia.agregar(new Proyecto("Proyecto 1", new BigDecimal(1000)));
		RepositorioProyectos.instancia.agregar(new Proyecto("Proyecto 2", new BigDecimal(2000)));
		
		ModelAndView modelAndView = controlador.index(request, response);
		Map<String, ArrayList<Proyecto>> viewModel = (Map<String, ArrayList<Proyecto>>) modelAndView.getModel();
		assertEquals(2, viewModel.get("proyectos").size());
	}
	
}
