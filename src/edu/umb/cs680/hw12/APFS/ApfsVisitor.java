package edu.umb.cs680.hw12.APFS;

interface ApfsVisitor{


    void visit(ApfsLink link);
    void visit(ApfsDirectory dir);
    void visit(ApfsFile file);



}


