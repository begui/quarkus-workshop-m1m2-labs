

package org.acme.people.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

/*



As you can see health check procedures are defined as implementations of the HealthCheck interface which are defined as CDI beans with the either the @Readiness or @Liveness annotation. HealthCheck is a functional interface whose single method call returns a HealthCheckResponse object which can be easily constructed by the fluent builder API shown above. This simple example will serve as our Readiness probe.
	

There are two types of probes in Quarkus apps (and Kubernetes):

    Liveness Probe - Many applications running for long periods of time eventually transition to broken states, and cannot recover except by being restarted. Kubernetes provides liveness probes to detect and remedy such situations. Restarting a container in such a state can help to make the application more available despite bugs.

    Readiness Probe - Sometimes, applications are temporarily unable to serve traffic. For example, an application might need to load large data or configuration files during startup, or depend on external services after startup. In such cases, you don’t want to kill the application, but you don’t want to send it requests either. Kubernetes provides readiness probes to detect and mitigate these situations. A pod with containers reporting that they are not ready does not receive traffic through Kubernetes Services.

Readiness and liveness probes can be used in parallel for the same container. Using both can ensure that traffic does not reach a container that is not ready for it, and that containers are restarted when they fail. There are various Configuration Paramters you can set, such as the timeout period, frequency, and other parameters that can be tuned to expected application behavior.

*/

@ApplicationScoped
@Readiness
public class SimpleHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Simple health check").up().build();
    }
}

