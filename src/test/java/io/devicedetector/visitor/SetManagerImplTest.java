package io.devicedetector.visitor;

import io.devicedetector.token.Token;
import io.devicedetector.token.UserAgentTokenImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SetManagerImplTest {

    @Test
    public void testVisit() {
        HashSet<Visitor> visitors = new HashSet<>();

        SetManagerImpl manager = new SetManagerImpl();
        manager.visitors.add(new PriorityVisitor() {
            @Override
            public boolean accept(Token token, Map<String, Object> collator) {
                return true;
            }

            @Override
            public Result visit(Token token, Map<String, Object> collator) {
                collator.put("browser", "Chrome");
                return Result.CONTINUE;
            }
        });

        HashMap<String, Object> collator = new HashMap<>();
        HashSet tokenPool = new HashSet<Token>();
        tokenPool.add(new UserAgentTokenImpl("Mozilla/4.78 [en] (Win98; U)"));

        manager.visit(tokenPool, collator);

        assertEquals("Chrome", collator.get("browser"));
    }
}