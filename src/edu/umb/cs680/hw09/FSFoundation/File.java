package edu.umb.cs680.hw09.FSFoundation;

import java.time.LocalDateTime;

public abstract class File extends FSElement
{
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }


}
