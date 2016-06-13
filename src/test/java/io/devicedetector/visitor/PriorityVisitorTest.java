package io.devicedetector.visitor;

import io.devicedetector.token.Token;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class PriorityVisitorTest {

    @Test
    public void prioritizedVisitorShouldBeOrdered() throws Exception {
        PriorityVisitor visitor1 = createVisitor(-255);
        PriorityVisitor visitor2 = createVisitor(255);
        PriorityVisitor visitor3 = createVisitor(0);
        PriorityVisitor visitor4 = createVisitor(0);

        TreeSet<PriorityVisitor> visitors = new TreeSet<>();
        visitors.add(visitor1);
        visitors.add(visitor3);
        visitors.add(visitor2);
        visitors.add(visitor4);

        Iterator<PriorityVisitor> iterator = visitors.iterator();
        assertEquals(visitor2, iterator.next());
        assertEquals(visitor3, iterator.next());
        assertEquals(visitor4, iterator.next());
        assertEquals(visitor1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    private PriorityVisitor createVisitor(int priority) {
        PriorityVisitor visitor = new PriorityVisitor(priority) {
            @Override
            public boolean accept(Token token, Map<String, Object> collator) {
                return true;
            }

            @Override
            public Result visit(Token token, Map<String, Object> collator) {
                collator.put(Integer.toString(priority), priority);

                return Result.CONTINUE;
            }
        };

        return visitor;
    }
}