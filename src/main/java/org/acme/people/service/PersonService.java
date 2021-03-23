

package org.acme.people.service;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.acme.people.model.EyeColor;
import org.acme.people.model.Person;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class PersonService {


    /*
     	By default, the code consuming the event must be non-blocking, as it’s called on the Vert.x event loop. Since our method will block to wait for the transaction, we use blocking = true to force this consumer to be run in a worker thread.
	    A new Person entity is created and persisted
        The return value of a method annotated with @ConsumeEvent is used as response to the incoming message.
    */

    @ConsumeEvent(value = "add-person", blocking = true) 
    @Transactional
    public Person addPerson(String name) {
        LocalDate birth = LocalDate.now().plusWeeks(Math.round(Math.floor(Math.random() * 20 * 52 * -1)));
        EyeColor color = EyeColor.values()[(int)(Math.floor(Math.random() * EyeColor.values().length))];
        Person p = new Person();
        p.birth = birth;
        p.eyes = color;
        p.name = name;
        Person.persist(p); 
        return p; 
    }

}

