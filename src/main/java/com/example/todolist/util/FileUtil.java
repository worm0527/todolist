package com.example.todolist.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtil {

    private FileUtil() {
        throw new UnsupportedOperationException();
    }

    public static void copyFile(String source, String target) throws IOException {
        try (FileInputStream fi = new FileInputStream(source)) {
            try (FileOutputStream fo = new FileOutputStream(target)) {
                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = fi.read(buffer)) != -1) {
                    fo.write(buffer);
                }
            }
        }
    }

    public static void copyFileNIO(String source, String target) throws IOException {
        try (FileInputStream fi = new FileInputStream(source)) {
            try (FileOutputStream fo = new FileOutputStream(target)) {
                FileChannel inChannel = fi.getChannel();
                FileChannel outChannel = fo.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

    public static void showDirection(String path) {
        File file = new File(path);
        showDir(file, 0);
    }

    private static void showDir(File file, int level) {
        if (file.isDirectory()) {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            level++;
            System.out.println(file.getName());
            for (File f : file.listFiles()) {
                showDir(f, level);
            }
        } else {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(file.getName());
        }
    }

    public static void showDirectionNIO(String path) throws IOException {
        Path initPath = Paths.get(path);
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });

    }

    public static void main(String[] args) throws IOException {
//        copyFile("C:\\Users\\xsy\\Desktop\\226.pdf", "C:\\Users\\xsy\\Desktop\\226_test.pdf");
//        showDirection("C:\\Users\\xsy\\Desktop");
        showDirectionNIO("C:\\Users\\xsy\\Desktop");
    }

}
