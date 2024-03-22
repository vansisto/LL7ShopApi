package com.vansisto.ll7shopapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestcontainersTest extends AbstractTestcontainers{

    @Test
    void testDbStarted() {
        assertThat(MY_SQL_CONTAINER.isCreated());
        assertThat(MY_SQL_CONTAINER.isRunning());
    }
}
