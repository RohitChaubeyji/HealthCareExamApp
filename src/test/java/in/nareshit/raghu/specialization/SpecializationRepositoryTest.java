package in.nareshit.raghu.specialization;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import in.nareshit.raghu.entity.Specialization;
import in.nareshit.raghu.repository.SpecializationRepository;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SpecializationRepositoryTest {
	
	@Autowired
	private SpecializationRepository repo;
	
	/**
	 * 1. Test save operation
	 */
	@Test
	@Order(1)
	public void testSpecCreated() {
		
		Specialization spec=new Specialization(null,"CRDLS","Cardiologists","They're expert are heart and blood vessals. ");
		spec = repo.save(spec);
		assertNotNull("spec is not created", spec);	
	}
	
	@Test
	@Order(2)
	public void testSpecFetchAll() {
		
		List<Specialization> list = repo.findAll();
		assertNotNull(list);
		assertThat(list.size()>0);
	}

}
