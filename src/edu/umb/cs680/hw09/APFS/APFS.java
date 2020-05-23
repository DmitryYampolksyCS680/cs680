package edu.umb.cs680.hw09.APFS;

import edu.umb.cs680.hw09.FSFoundation.FileSystem;

import java.time.LocalDateTime;

public class APFS extends FileSystem {


  private String ownersName="";


  LocalDateTime lastModified = null;//to be set in modify action

  public APFS(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {

//    super(parent,name,size,creationTime);
    super();

    this.lastModified = creationTime;
  }



  void setOwnersName(String name_in)
  {
    ownersName=name_in;
  }

//
//public ApfsDirectory getRootDirectory()
//    {
//
//    }






}
