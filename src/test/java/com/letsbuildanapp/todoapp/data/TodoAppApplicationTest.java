package com.letsbuildanapp.todoapp.data;

import java.io.File;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link com.letsbuildanapp.todoapp.TodoAppApplication}.
 */
@RunWith(SpringRunner.class)
@TestExecutionListeners(mergeMode = MergeMode.MERGE_WITH_DEFAULTS, listeners = {
        OrderedCassandraTestExecutionListener.class })
@SpringBootTest
@CassandraDataSet(keyspace = "todoapp", value = "setup.cql")
@EmbeddedCassandra(timeout = 60000)
public class TodoAppApplicationTest {

    @ClassRule
    public static OutputCapture outputCapture = new OutputCapture();

    @ClassRule
    public static SkipOnWindows skipOnWindows = new SkipOnWindows();

    @Test
    public void testDefaultSettings() throws Exception {
        String output = TodoAppApplicationTest.outputCapture.toString();
        assertThat(output).contains("firstName='Alice', lastName='Smith'");
    }

    static class SkipOnWindows implements TestRule {

        @Override
        public Statement apply(final Statement base, Description description) {
            return new Statement() {

                @Override
                public void evaluate() throws Throwable {
                    if (!runningOnWindows()) {
                        base.evaluate();
                    }
                }

                private boolean runningOnWindows() {
                    return File.separatorChar == '\\';
                }

            };
        }

    }

}
