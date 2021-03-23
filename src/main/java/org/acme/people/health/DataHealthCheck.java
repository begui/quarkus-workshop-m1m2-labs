

package org.acme.people.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

/*

MicroProfile also provides a way for the applications to supply arbitrary data in the form of key/value pairs sent in the health check response. 
This can be done by using the withData(key, value)` method of the health check response builder API. This is useful to provide additional info about 
passing or failing health checks, to give some indication of the problem when failures are investigated.

*/

@ApplicationScoped
@Liveness
public class DataHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Health check with data")
        .up()
        .withData("foo", "fooValue")
        .withData("bar", "barValue")
        .build();

    }
}

