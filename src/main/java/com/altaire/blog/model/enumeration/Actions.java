package com.altaire.blog.model.enumeration;

/**
 * Created by cue on 3/16/2017.
 */
public enum Actions {
    C(0,"CREATED"),U(1,"UPDATED"), D(2,"DELETED"), V(3,"VIEWED");
    private int actions;
    private String label;

    Actions(int actions, String label) {
        this.actions = actions;
        this.label = label;
    }

    public int getActions() {
        return actions;
    }

    public String getLabel() {
        return label;
    }
}
