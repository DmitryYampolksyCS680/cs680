package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectoryTest {


    protected static String[] dirToStringArray(Directory d){


        String[] dirInfo = {
                String.valueOf(d.isFile()),d.getName(), String.valueOf(d.getSize()), String.valueOf(d.getCreationTime()),
                d.getParent().getName(),
                String.valueOf(d.countChildren())};

                return dirInfo;
        }


    @Test
    public void verifyDirectoryEqualityRoot(){

        LocalDateTime expectedCreationTime = LocalDateTime.now();

        String[] expected = {"false", "root","0",String.valueOf(expectedCreationTime),"root","0" };
        Directory actual = new Directory(null, "root",0, expectedCreationTime);

        assertArrayEquals(expected, dirToStringArray(actual) );

    }

//
//                @Test
//    public void verifyDirectoryEqualityHome (){ ... }






    @Test
    void isDirectory() {
    }

    @Test
    void getChildren() {
    }

    @Test
    void appendChild() {
    }

    @Test
    void countChildren() {
    }

    @Test
    void getSubDirectories() {
    }

    @Test
    void getFiles() {
    }

    @Test
    void getTotalSize() {
    }

    public  void mainTest() {


        Directory root = new Directory(null, "root",0, LocalDateTime.now());
        Directory home1 = new Directory(root, "home",0, LocalDateTime.now());
        Directory home2 = new Directory(root, "home",0, LocalDateTime.now());
        Directory home3 = new Directory(home1, "home",0, LocalDateTime.now());
        Directory home4 = new Directory(home3, "home",0, LocalDateTime.now());
        Directory home5 = new Directory(home4, "home",0, LocalDateTime.now());
        File afile_root_1 = new File(root,"afile_root_1",100,LocalDateTime.now());
        File afile_root_2 = new File(root,"afile_root_2",200,LocalDateTime.now());
        File afile_home1_1 = new File(home1,"afile_home1_1",300,LocalDateTime.now());
        File afile_home4 = new File(home4,"afile_home4",400,LocalDateTime.now());

String[] info = dirToStringArray(root);

        int mysize = root.getTotalSize();

        assertEquals(mysize,1000);

    }
}