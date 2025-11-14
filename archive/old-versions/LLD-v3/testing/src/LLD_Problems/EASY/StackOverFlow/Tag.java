package LLD_Problems.EASY.StackOverFlow;

import java.util.UUID;

public class Tag {
    private final String name;
    private final int id;

    public Tag(String name) {
        this.name = name;
        id = UUID.randomUUID().hashCode();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
