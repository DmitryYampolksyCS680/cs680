package edu.umb.cs680.hw10.APFS;

import java.util.LinkedList;

class ApfsFileSearchVisitor implements ApfsVisitor{



    public String fileName;
    private LinkedList<ApfsFile> foundFiles;


public ApfsFileSearchVisitor(String name_in){

    fileName = name_in;
    foundFiles = new LinkedList<ApfsFile>();
}



    @Override
    public void visit(ApfsLink link) {

    }

    @Override
    public void visit(ApfsDirectory dir) {

    }

    @Override
    public void visit(ApfsFile file) {

        if(file.getName().equals(fileName)){
            foundFiles.add(file);
        }
    }


    LinkedList<ApfsFile> getFoundFiles(){
        return foundFiles;
    }
}
