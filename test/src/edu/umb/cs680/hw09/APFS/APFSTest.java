package edu.umb.cs680.hw09.APFS;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class APFSTest {

    @Test
    void setOwnersName() {
        

        ApfsDirectory root = new ApfsDirectory(null, "root", 0, LocalDateTime.now());

        String apfsName = "apfs";
        int apfsSize = 1234;

        try {
            APFS a = new APFS(root, apfsName, apfsSize, root.getCreationTime());
            a.setOwnersName("Dmitry Yamplsky");
            fail("APFSTest fail.");
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }

    }


}