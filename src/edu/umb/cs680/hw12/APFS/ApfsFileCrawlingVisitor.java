package edu.umb.cs680.hw12.APFS;

import java.util.LinkedList;

class ApfsFileCrawlingVisitor implements ApfsVisitor{


    private LinkedList<ApfsFile> files;


public ApfsFileCrawlingVisitor(){
    files=new LinkedList<ApfsFile>();
}



    @Override
    public void visit(ApfsLink link) {
    }

    @Override
    public void visit(ApfsDirectory dir) {
    }

    @Override
    public void visit(ApfsFile file) {
files.add(file);
    }

    public LinkedList<ApfsFile> getFiles(){
        return files;
    }
}
