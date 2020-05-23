package edu.umb.cs680.hw10.APFS;

import edu.umb.cs680.hw10.APFS.ApfsElement.*;

interface ApfsVisitor{


    void visit(ApfsLink link);
    void visit(ApfsDirectory dir);
    void visit(ApfsFile file);



}


