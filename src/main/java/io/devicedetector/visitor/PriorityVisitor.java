package io.devicedetector.visitor;

abstract public class PriorityVisitor implements Visitor, Comparable<PriorityVisitor>{
    protected final int priority;

    public PriorityVisitor(int priority) {
        this.priority = priority;
    }

    public PriorityVisitor() {
        this(0);
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PriorityVisitor v) {
        int compare = v.getPriority() - this.priority;

        if(compare == 0) {
            compare = 1;
        }

        return compare;
    }
}
