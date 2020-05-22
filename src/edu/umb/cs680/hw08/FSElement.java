package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Objects;

public abstract class FSElement {


    private String name;
    private int size;
    private LocalDateTime creationTime;

    protected Directory parent;

    void setParent(Directory parent)
    {
        this.parent = parent;
    }


    FSElement(Directory parent, String name, int size, LocalDateTime creationTime)
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

    public Directory getParent()
    {

        return Objects.requireNonNullElseGet(this.parent, () -> (Directory) this);

    }

    public int getSize()
    {
        return this.size;
    }

    public String getName()
    {
        return this.name;
    }

    public LocalDateTime getCreationTime()
    {
        return this.creationTime;
    }

    public abstract boolean isDirectory();


    public boolean isFile(){
        return !isDirectory();
    }

    static class Directory extends FSElement
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

    static class FileSystem
    {
        private FileSystem(){}

        private static FileSystem system=null;
        static FileSystem getFileSystem()
        {
            if(system==null) {
                system = new FileSystem();
            }
            return system;
        }

        LinkedList<Directory>  getRootDirs()
        {
            return rootDirs;
        }

        void addRootDir(Directory root_in)
        {
            if(rootDirs!=null)//or in the constructor
            rootDirs = new LinkedList<Directory>();

            rootDirs.add(root_in);
        }

        LinkedList<Directory> rootDirs=null;
    }
}


