package edu.umb.cs680.hw12.APFS;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ApfsDirectoryTest {

@Test
    public static void main(String[] args) {



        String[] elementNames = {"Ahome1", "Chome2", "Ehome3", "Bafile_root_1", "Dafile_root_2", "Aafile_root_2", "Eafile_home1_1"};
    ArrayList<String> elementNamesArray = new ArrayList<String>();
    ArrayList<String> rootChildrenNamesArray = new ArrayList<String>();


    rootChildrenNamesArray.add(elementNames[0]);
    rootChildrenNamesArray.add(elementNames[1]);
    rootChildrenNamesArray.add(elementNames[3]);
    rootChildrenNamesArray.add(elementNames[4]);
    rootChildrenNamesArray.add(elementNames[5]);


        Collections.addAll(elementNamesArray, elementNames);


        Iterator<String> nameIterator = elementNamesArray.iterator();



        ApfsDirectory root = new ApfsDirectory(null, "root",0, LocalDateTime.now());
        ApfsDirectory Ahome1 = new ApfsDirectory(root, nameIterator.next(),0, LocalDateTime.now());
        ApfsDirectory Chome2 = new ApfsDirectory(root, nameIterator.next(),0, LocalDateTime.now());
        ApfsDirectory Fhome3 = new ApfsDirectory(Chome2, nameIterator.next(),0, LocalDateTime.now());

        ApfsFile Bafile_root_1 = new ApfsFile(root,nameIterator.next(),100,LocalDateTime.now());
        ApfsFile Dafile_root_2 = new ApfsFile(root,nameIterator.next(),200,LocalDateTime.now());
        ApfsFile Aafile_root_2 = new ApfsFile(root,nameIterator.next(),200,LocalDateTime.now());
        ApfsFile Eafile_home1_1 = new ApfsFile(Chome2,nameIterator.next(),300,LocalDateTime.now());

        ArrayList<String>expectedRootChildrenNameOrder=new ArrayList<String>(rootChildrenNamesArray);

        Collections.sort(expectedRootChildrenNameOrder);



        testAppendChild_defaultComparator(root,expectedRootChildrenNameOrder);


        LinkedList<Comparator> comparators = new LinkedList<Comparator>();
        comparators.add(new TimestampComparator());
        comparators.add(new AlphabeticComparator());
        comparators.add(new ReverseAlphabeticComparator());

        LinkedList<ApfsFile> files = root.getFiles(new TimestampComparator());

        LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(new ReverseAlphabeticComparator());







    }




    @Test
    static void testAppendChild_defaultComparator(ApfsDirectory root, ArrayList<String> expectedElementNameOrder_in) {


        ArrayList<String>actualElementNameOrder= new ArrayList<>();
        ArrayList<String>expectedElementNameOrder=new ArrayList<String>(expectedElementNameOrder_in);

        for(ApfsElement e:root.getChildren())
            actualElementNameOrder.add(e.getName());


        assertEquals(expectedElementNameOrder,actualElementNameOrder);


    }






}