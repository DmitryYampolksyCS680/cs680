package edu.umb.cs680.hw10.APFS;

import edu.umb.cs680.hw10.FSFoundation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class ApfsElement extends FSElement {

    ApfsElement() {
        super(null, "root", 0, LocalDateTime.now());
    }

    protected ApfsDirectory parent;

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {

        super(name,size,creationTime);

        this.parent=parent;

        if(parent!=null)
            if(!parent.isDirectory())
                throw new IllegalArgumentException("FSElement parent should be a Directory.\n");



        if (parent != null)
            parent.appendChild(this);

    }


    public void setParent(ApfsDirectory parent)
    {
        this.parent = parent;
    }
    public abstract void accept(ApfsVisitor v);


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

    @Override
    public void accept(ApfsVisitor v) {
        v.visit(this);

    }
}


class ApfsFile extends ApfsElement {
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }


    public void accept(ApfsVisitor v)
    {
        v.visit(this);
    }


    public boolean isDirectory() {
        return false;
    }

}

class ApfsDirectory extends ApfsElement {


    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);



    }

    public boolean isDirectory() {
        return true;
    }


    public void accept(ApfsVisitor v)
    {
        v.visit(this);

        for(ApfsElement e: children) {
            e.accept(v);
        }

        }

    private LinkedList<ApfsElement> children =new LinkedList<ApfsElement>();

    private FileSystem fileSystem;

    private int nchildren = 0;


    public LinkedList<ApfsElement> getChildren() {
        return this.children;

    }

    public void appendChild(ApfsElement child)
    {
        if(this.children ==null)
            this.children = new LinkedList<ApfsElement>();

        this.children.add(child);
        child.setParent(this);
        this.nchildren++;
    }


    public int countChildren() {
        return nchildren;
    }



    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<>();

        for (ApfsElement fsElement : this.getChildren()) {
            if (!fsElement.isDirectory())
                files.add((ApfsFile) fsElement);

        }

        return files;

    }

    public int getTotalSize() {
        int totalSize = 0;

        for (ApfsElement fsElement : this.getFiles()) {
            totalSize = totalSize + fsElement.getSize();
        }

        for (ApfsDirectory aDirectory : this.getSubDirectories()) {
            totalSize = totalSize + aDirectory.getTotalSize();
        }

        return totalSize;

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


//    @Override
//    public boolean isDirectory() {
//        return false;
//    }
}