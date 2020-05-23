package edu.umb.cs680.hw09.APFS;

import edu.umb.cs680.hw09.FSFoundation.FSElement;
import edu.umb.cs680.hw09.FSFoundation.FileSystem;


import java.time.LocalDateTime;
import java.util.LinkedList;

public  class ApfsElement extends FSElement {

    ApfsElement() {
        super(null, "root", 0, LocalDateTime.now());
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    protected ApfsDirectory parent;

    public  ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime)
    {


        if(parent!=null)
            if(!parent.isDirectory())
                throw new IllegalArgumentException("FSElement parent should be a Directory.\n");


        this.parent=parent;
        this.creationTime=creationTime;
        this.name=name;
        this.size=size;

        if (parent != null)
            parent.appendChild(this);

    }




    public void setParent(ApfsDirectory parent)
    {
        this.parent = parent;
    }



}

class ApfsDirectory extends ApfsElement {




    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime)
    {
        super(parent,name,size,creationTime);

        children = new LinkedList<ApfsElement>();


    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public void appendChild(ApfsElement child)
    {
        if(this.children ==null)
            this.children = new LinkedList<ApfsElement>();

        this.children.add(child);
        child.setParent(this);
        this.nchildren++;
    }


    private LinkedList<ApfsElement>  children;

    private static FileSystem fileSystem;

    private int nchildren = 0;


    public LinkedList<ApfsElement> getChildren()
    {
        return this.children;

    }


    public int countChildren()
    {
        return nchildren;
    }

    public LinkedList<ApfsDirectory> getSubDirectories()
    {

        LinkedList<ApfsDirectory> subDirectories = new LinkedList<>();

        for (ApfsElement fsElement: this.getChildren()) {
            if(fsElement.isDirectory())
                subDirectories.add((ApfsDirectory) fsElement);

        }

        return subDirectories;


    }

    public LinkedList<ApfsFile> getFiles()
    {
        LinkedList<ApfsFile> Files = new LinkedList<ApfsFile>();

        for (ApfsElement fsElement: this.getChildren()) {
            if(!fsElement.isDirectory())
                Files.add((ApfsFile) fsElement);

        }

        return Files;

    }

    public int getTotalSize()
    {
        int totalSize=0;

        for( ApfsElement fsElement: this.getFiles() )
        {
            totalSize= totalSize+fsElement.getSize();
        }

        for( ApfsDirectory aDirectory: this.getSubDirectories() )
        {
            totalSize= totalSize+aDirectory.getTotalSize();
        }

        return totalSize;

    }



}



class ApfsLink extends ApfsElement {

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target)
    {
        super(parent, name,0,creationTime);
        this.target = target;
    }

    private ApfsElement target = null;

    public ApfsElement getTarget()
    {return target;}


    @Override
    public boolean isDirectory() {
        return false;
    }
}



class ApfsFile extends ApfsElement {
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    public boolean isDirectory() {
        return false;
    }

}