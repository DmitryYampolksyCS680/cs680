package edu.umb.cs680.hw12.FSFoundation;



import java.time.LocalDateTime;
import java.util.Objects;

public abstract class FSElement {


    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;



    public FSElement( String name, int size, LocalDateTime creationTime)
    {

        this.creationTime=creationTime;
        this.name=name;
        this.size=size;


    }


    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime)
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

    //public abstract void accept(FSVisitor v);


    public boolean isFile(){
        return !isDirectory();
    }


    public void setParent(Directory parent)
    {
        this.parent = parent;
    }


}


