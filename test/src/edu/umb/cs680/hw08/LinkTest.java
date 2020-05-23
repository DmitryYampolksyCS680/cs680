package edu.umb.cs680.hw08;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    @Test
    void isDirectory() {

        Directory root = new Directory(null, "root",0, LocalDateTime.now());

        File aFile = new File(root,"aFile",100,LocalDateTime.now());
        Link aLinkDirectory = new Link(root,"aLinkDirectory",0,LocalDateTime.now(),root);
        Link aLinkFile = new Link(root,"aLinkFile",0,LocalDateTime.now(),aFile);

        assertTrue(root.isDirectory());
        assertTrue(aFile.isDirectory());
        assertTrue(aLinkDirectory.isDirectory());
        assertTrue(aLinkFile.isDirectory());


    }


@Test
public static void main(String[] args) {




    Directory root = new Directory(null, "root",0, LocalDateTime.now());
    Directory applications = new Directory(root, "applications",0, LocalDateTime.now());
    Directory home = new Directory(root, "home",0, LocalDateTime.now());
    Directory code = new Directory(home, "code",0, LocalDateTime.now());

    File a = new File(applications,"a",100,LocalDateTime.now());
    File b = new File(applications,"b",200,LocalDateTime.now());

    Link x = new Link(home,"x",0,LocalDateTime.now(),applications);
    File c = new File(home,"c",300,LocalDateTime.now());
    File d = new File(home,"d",400,LocalDateTime.now());

    Link y = new Link(code,"y",0,LocalDateTime.now(),b);
    File e = new File(code,"e",500,LocalDateTime.now());
    File f = new File(code,"f",600,LocalDateTime.now());

    int mySize = root.getTotalSize();
    int actualSize = 100+200+300+400+500+600;
    assertEquals(mySize,actualSize);



    Link testLink = new Link((Directory) x.getTarget(),"testLink",0,LocalDateTime.now(),x.getTarget());
    String actualName = "applications";
    assertEquals(testLink.getTarget().getName(),actualName);


}
    
}