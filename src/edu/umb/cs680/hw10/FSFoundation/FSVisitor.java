package edu.umb.cs680.hw10.FSFoundation;

public interface FSVisitor {


    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);

}



