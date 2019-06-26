package com.ganesh.learn.more.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UseFileWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        System.out.println("Is file exists? "+ file.exists());
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            System.out.println("Is file created ? "+ newFile);
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("Something");
        fileWriter.close();
    }
}
