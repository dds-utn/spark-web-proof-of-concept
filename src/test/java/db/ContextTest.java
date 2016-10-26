package db;

import java.math.BigDecimal;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import model.Proyecto;

public class ContextTest extends AbstractPersistenceTest implements
WithGlobalEntityManager {

@Test
	public void contextUp() {
	Proyecto proyecto = new Proyecto("PGM", BigDecimal.valueOf(30_0000));
	
	persist(proyecto);
	}

}