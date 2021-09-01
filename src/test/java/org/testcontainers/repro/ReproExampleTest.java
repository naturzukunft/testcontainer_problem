package org.testcontainers.repro;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

public class ReproExampleTest {

    private static final Logger LOG = LoggerFactory.getLogger(ReproExampleTest.class);

    /**
     * Placeholder for a piece of code that demonstrates the bug. You can use this as a starting point, or replace
     * entirely.
     * <p>
     * Ideally this would be a failing test. If it's excessively difficult to form as a test (e.g. relates to log
     * output, teardown or other side effects) then it would be sufficient to explain the behaviour in the issue
     * description.
     */
    @Test
    public void demonstration() {
        try (
            // customize the creation of a container as required
            GenericContainer<?> container = new GenericContainer(DockerImageName.parse("registry.gitlab.com/linkedopenactors/loa-suite:feature-testcontainer"))
            .withExposedPorts(8080)
            .withEnv("SPRING_PROFILES_ACTIVE", "test")
            .withFileSystemBind("/tmp/dockerVolumes/", "/mnt/spring/", BindMode.READ_WRITE)
            .withLogConsumer(new Slf4jLogConsumer(LOG))
            .waitingFor(Wait.forHttp("/swagger-ui.html"));

        ) {
            container.start();

            // ...
        }
    }
}
