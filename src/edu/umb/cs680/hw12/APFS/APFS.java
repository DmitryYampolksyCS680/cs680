package edu.umb.cs680.hw12.APFS;

import edu.umb.cs680.hw12.FSFoundation.Directory;
import edu.umb.cs680.hw12.FSFoundation.FileSystem;

import java.time.LocalDateTime;

public abstract class APFS extends FileSystem {


  private String ownersName="";


  LocalDateTime lastModified = null;//to be set in modify action

  public APFS(Directory parent, String name, int size, LocalDateTime creationTime) {
    super();

    this.lastModified = creationTime;
  }




//
//public ApfsDirectory getRootDirectory()
//    {
//
//    }






}
