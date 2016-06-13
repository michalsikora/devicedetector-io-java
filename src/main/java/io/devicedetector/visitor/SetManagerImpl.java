package io.devicedetector.visitor;

import io.devicedetector.token.Token;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SetManagerImpl implements Manager {
    public final Set<Visitor> visitors;

    public SetManagerImpl(Set<Visitor> visitors) {
        this.visitors = visitors;
    }

    public SetManagerImpl() {
        this(new TreeSet<>());
    }

    @Override
    public void visit(Set<Token> tokenPool, Map<String, Object> collator) {
        for (Visitor visitor : visitors) {
            for (Token token : tokenPool) {
                if (visitor.accept(token, collator)) {
                    if (Result.BREAK.equals(visitor.visit(token, collator))) {
                        break;
                    }
                }
            }
        }
    }
}
