package edu.umb.cs680.hw12.FSFoundation;


import java.time.LocalDateTime;

public class Link extends FSElement {

   public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target)
   {
       super(parent, name,0,creationTime);
       this.target = target;

   }

   private FSElement target = null;

public FSElement getTarget()
{return target;}


    //public void accept(FSVisitor v){v.visit(this);}

   @Override
   public boolean isDirectory() {
       return false;
   }
}
