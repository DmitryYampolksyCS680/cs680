package edu.umb.cs680.hw09.FSFoundation;

import java.time.LocalDateTime;

 public abstract class Link extends FSElement {

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target)
    {
        super(parent, name,0,creationTime);
        this.target = target;

    }

    private FSElement target = null;

public FSElement getTarget()
{return target;}




    @Override
    public boolean isDirectory() {
        return false;
    }
}
