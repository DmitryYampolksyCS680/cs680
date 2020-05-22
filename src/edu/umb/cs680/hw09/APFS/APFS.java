package edu.umb.cs680.hw09.APFS;

import edu.umb.cs680.hw09.FSFoundation.Directory;
import edu.umb.cs680.hw09.FSFoundation.FSElement;
import edu.umb.cs680.hw09.FSFoundation.FileSystem;

import java.time.LocalDateTime;

public abstract class APFS extends FSElement {


  private String ownersName="";


  LocalDateTime lastModified = null;//to be set in modify action

  public APFS(ApfsElement.ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
    super(parent,name,size,creationTime);

    this.lastModified = creationTime;
  }




//
//public ApfsDirectory getRootDirectory()
//    {
//
//    }






}
