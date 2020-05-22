package edu.umb.cs680.hw09.APFS;

import edu.umb.cs680.hw09.FSFoundation.Directory;
import edu.umb.cs680.hw09.FSFoundation.FSElement;
import edu.umb.cs680.hw09.FSFoundation.FileSystem;
import edu.umb.cs680.hw09.FSFoundation.Link;
import edu.umb.cs680.hw09.FSFoundation.File;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class ApfsElement extends FSElement {

    ApfsElement() {
        super(null, "root", 0, LocalDateTime.now());
    }

    protected ApfsDirectory parent;

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(parent,name,size,creationTime);

    }


    public void setParent(ApfsDirectory parent)
    {
        this.parent = parent;
    }


    class ApfsDirectory extends Directory {


        public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
            super(parent, name, size, creationTime);



        }

        public boolean isDirectory() {
            return true;
        }


        private LinkedList<FSElement> children;

        private FileSystem fileSystem;

        private int nchildren = 0;


        public LinkedList<FSElement> getChildren() {
            return this.children;

        }

        public void appendChild(ApfsElement child) {
            this.children.add(child);
            child.setParent(this);
            this.nchildren++;
        }

        public int countChildren() {
            return nchildren;
        }

//        public LinkedList<ApfsDirectory> getSubDirectories() {
//
//            LinkedList<ApfsDirectory> subDirectories = new LinkedList<>();
//
//            for (FSElement fsElement : this.getChildren()) {
//                if (fsElement.isDirectory())
//                    subDirectories.add((ApfsDirectory) fsElement);
//
//            }
//
//            return subDirectories;
//
//
//        }

        public LinkedList<FSElement> getFiles() {
            LinkedList<FSElement> Files = new LinkedList<>();

            for (FSElement fsElement : this.getChildren()) {
                if (!fsElement.isDirectory())
                    Files.add(fsElement);

            }

            return Files;

        }

        public int getTotalSize() {
            int totalSize = 0;

            for (FSElement fsElement : this.getFiles()) {
                totalSize = totalSize + fsElement.getSize();
            }

            for (Directory aDirectory : this.getSubDirectories()) {
                totalSize = totalSize + aDirectory.getTotalSize();
            }

            return totalSize;

        }


        class ApfsFile extends File {
            public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
                super(parent, name, size, creationTime);
            }

            public boolean isDirectory() {
                return false;
            }

        }


        class ApfsLink extends Link {

            public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, FSElement target)
            {
                super(parent, name,0,creationTime,target);

            }

            private ApfsElement target = null;

            public ApfsElement getTarget()
            {return target;}


            @Override
            public boolean isDirectory() {
                return false;
            }
        }


//    @Override
//    public boolean isDirectory() {
//        return false;
//    }
    }
    public abstract boolean isDirectory();
}
