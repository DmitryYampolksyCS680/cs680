package edu.umb.cs680.hw10.APFS;

import edu.umb.cs680.hw10.FSFoundation.FSVisitor;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApfsFileSearchVisitorTest {


    @Test
    public static void main(String[] args) {


        ApfsDirectory root = new ApfsDirectory(null, "root",0, LocalDateTime.now());
        ApfsDirectory home1 = new ApfsDirectory(root, "home1",0, LocalDateTime.now());
        ApfsDirectory home2 = new ApfsDirectory(root, "home2",0, LocalDateTime.now());
        ApfsDirectory home3 = new ApfsDirectory(home1, "home3",0, LocalDateTime.now());

        ApfsFile afile_root_1 = new ApfsFile(root,"afile_root_1",100,LocalDateTime.now());
        ApfsFile afile_root_2 = new ApfsFile(root,"afile_root_2",200,LocalDateTime.now());
        ApfsFile afile_home1_1 = new ApfsFile(home1,"afile_home1_1",300,LocalDateTime.now());

        int mysize = root.getTotalSize();
        assertEquals(mysize,600);


        ApfsCountingVisitor aCountingVisitor = new ApfsCountingVisitor();
        root.accept(aCountingVisitor);

        int[] actualCountingVisitor = {aCountingVisitor.getDirNum(), aCountingVisitor.getFileNum(), aCountingVisitor.getLinkNum()};
        int[] expectedCountingVisitor = {4,3,0};
        assertArrayEquals(expectedCountingVisitor,actualCountingVisitor,"assertEquals ApfsCountingVisitor");

        ApfsFileCrawlingVisitor aFileCrawlingVisitor = new ApfsFileCrawlingVisitor();
        root.accept(aFileCrawlingVisitor);



String fileName = "afile_root_1";
        ApfsFileSearchVisitor aFileSearchVisitor = new ApfsFileSearchVisitor(fileName);
        root.accept(aFileSearchVisitor);


        assertEquals(aFileSearchVisitor.getFoundFiles().size(),1,"assertEquals FileSearchVisitor");


    }

}