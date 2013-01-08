package org.sibyg.hibernate.tutorial.dao;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sibyg.hibernate.tutorial.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.sibyg.hibernate.tutorial.builder.AddressBuilder.addressBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AddressDaoIntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;

    private DefaultAddressDao addressDao;

    @Before
    public void setUp() {
        addressDao = new DefaultAddressDao(sessionFactory);
    }

    @Test
    public void shouldCreateAddress() {
        // Given
        Random random = new Random();
        int flatNumber = random.nextInt();
        int houseNumber = random.nextInt();
        Address address = addressBuilder().flatNumber(flatNumber).houseNumber(houseNumber).build();

        // When
        addressDao.create(address);

        // Then
        assertThat(address.getId(), is(notNullValue()));
    }
}
