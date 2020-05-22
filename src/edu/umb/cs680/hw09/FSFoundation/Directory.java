package edu.umb.cs680.hw09.FSFoundation;

import java.time.LocalDateTime;
import java.util.LinkedList;

public  class Directory extends FSElement
{




    public Directory(Directory parent, String name, int size, LocalDateTime creationTime)
    {
        super(parent,name,size,creationTime);

        children = new LinkedList<FSElement>();


    }

    @Override
    public boolean isDirectory() {
        return true;
    }



    private LinkedList<FSElement>  children;

    private static FileSystem fileSystem;

    private int nchildren = 0;


    public LinkedList<FSElement> getChildren()
    {
        return this.children;

    }

    public void appendChild(FSElement child)
    {
        this.children.add(child);
        child.setParent(this);
        this.nchildren++;
    }

    public int countChildren()
    {
        return nchildren;
    }

    public LinkedList<Directory> getSubDirectories()
    {

        LinkedList<Directory> subDirectories = new LinkedList<>();

        for (FSElement fsElement: this.getChildren()) {
            if(fsElement.isDirectory())
                subDirectories.add((Directory) fsElement);

        }

        return subDirectories;


    }

    public LinkedList<FSElement> getFiles()
    {
        LinkedList<FSElement> Files = new LinkedList<>();

        for (FSElement fsElement: this.getChildren()) {
            if(!fsElement.isDirectory())
                Files.add(fsElement);

        }

        return Files;

    }

    public int getTotalSize()
    {
        int totalSize=0;

        for( FSElement fsElement: this.getFiles() )
        {
            totalSize= totalSize+fsElement.getSize();
        }

        for( Directory aDirectory: this.getSubDirectories() )
        {
            totalSize= totalSize+aDirectory.getTotalSize();
        }

        return totalSize;

    }



}
