

package org.acme.people;

import javax.enterprise.context.ApplicationScoped;
import org.acme.people.service.GreetingService;
import io.quarkus.test.Mock;

/*

Quarkus supports the use of mock objects using the CDI @Alternative mechanism. To use this simply override the bean you wish to mock with a class in the src/test/java directory, and put the @Alternative and @Priority(1) annotations on the bean. Alternatively, a convenient io.quarkus.test.Mock stereotype annotation could be used. This built-in stereotype declares @Alternative, @Priority(1) and @Dependent.

Let’s mock our existing GreetingService. Although our existing service is pretty simple, in the real world the service might have too many dependencies on external systems to be feasible to call directly.

Create a new class file in src/test/java in the org.acme.people package called MockGreetingService.java with the following code:

*/

@Mock
@ApplicationScoped
public class MockGreetingService extends GreetingService {

    @Override
    public String greeting(String name) {
        return "hello " + name + " <<<<<<<<<< from mock greeting >>>>>>>>>>";
    }
}

