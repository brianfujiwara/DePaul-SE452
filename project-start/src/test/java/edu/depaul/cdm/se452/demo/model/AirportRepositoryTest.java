package edu.depaul.cdm.se452.demo.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class AirportRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AirportRepository repository;

//    @Test
    public void findByAiportCode() {
        final String ORD = "ORD";
        final String CHICAGO = "Chicago";
        Airport ord = repository.findByCode(ORD);
        Assert.assertEquals(CHICAGO, ord.getCity());
        Assert.assertEquals(3, ord.getOriginationFlights().size());
    }
}
