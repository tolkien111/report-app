package com.myworkspace.reportapp.entity.customer;

import com.myworkspace.reportapp.entity.EntityTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest extends EntityTest {

    @Test
    void shouldSaveManager(){
        //GIVEN
        final var manager = new Manager("yahoo@wp.pl",
                "669876222",
                "Alan",
                "James",
                "bbb");

        //WHEN
        persistObject(manager);

        //THEN
        final var readManager = em.find(Manager.class, manager.getId());
        assertEquals(manager, readManager);
    }

}