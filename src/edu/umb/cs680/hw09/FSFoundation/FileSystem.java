package edu.umb.cs680.hw09.FSFoundation;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem
{
    public FileSystem(){}

    protected String name;
    protected int capacity;
    protected int id;

    LinkedList <FSElement> rootDirs;



    public FSElement initFileSystem(String name,int capacity)
    {

        this.name = name;
        this.capacity = capacity;

        FSElement root = createDefaultRoot();

        if(root.isDirectory() &&
                capacity >= root.getSize()){
        setRoot(root);
        this.id = root.hashCode();
        return root;
    }else{
        return null;

    }

    }


    private void setRoot(FSElement root)
    {
        rootDirs.add(root);
    }

    protected FSElement createDefaultRoot()
    {
        return new Directory(null,"root",0, LocalDateTime.now());
    }


    private static FileSystem system=null;

    static FileSystem getFileSystem()
    {
        if(system==null) {
            system = new FileSystem();
        }
        return system;
    }

//    LinkedList<FSElement> getRootDirs()
//    {
//        return rootDirs;
//    }

//    void addRootDir(Directory root_in)
//    {
//        if(rootDirs!=null)//or in the constructor
//            rootDirs = new LinkedList<Directory>();
//
//        rootDirs.add(root_in);
//    }


    public int getCapacity() {
        return capacity;
    }


    public int getUsed()
    {
        return 1;
    }

    public String getName() {
        return name;
    }
}