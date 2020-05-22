package edu.umb.cs680.hw03;


public class Student {


    private float tuition;
    private String name;
    private int l20num=0;
    private String usAddr="";
    private int yrsInState=0;
    private String foreignAddr="";

    private enum StudentStatus {
        INSTATE,
        OUTSTATE,
        INTL
    }

    private StudentStatus status;

    private Student( String name,
             String usAddr,
             int l20num,
             int yrsInState,
             String foreignAddr,
                     StudentStatus status       ) {

        this.status=status;
        this.name=name;
        this.usAddr=usAddr;
    }

//no "Factory class"
    public static Student createInStateStudent(String name,String usAddr)
    {
        return new Student(name,usAddr,0,0,"",StudentStatus.INSTATE);
    }

    public static Student createOutStateStudent(String name,String usAddr,int yrsInState)
    {
        return new Student(name,usAddr,0,yrsInState,"",StudentStatus.OUTSTATE);
    }

    public static Student createIntlStudent(String name,String usAddr,int i20Num,String foregnAddr)
    {
        return new Student(name,usAddr,i20Num,0,foregnAddr,StudentStatus.INTL);
    }



    void setTuition(float tuition){
        this.tuition=tuition;
    }
    float getTuituion()
    { return this.tuition;}

    String getName()
    {return this.name;}

    StudentStatus getStatus()
    {return this.status;}





}
