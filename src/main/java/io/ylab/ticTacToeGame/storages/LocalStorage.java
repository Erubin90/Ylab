package io.ylab.ticTacToeGame.storages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LocalStorage {

    public String read(File file) throws IOException {
        var inputStream = new FileInputStream(file);
        var bytes = inputStream.readAllBytes();
        inputStream.close();
        return new String(bytes);
    }

    public void write(String value ,File file) throws IOException {
        var outputString = new FileOutputStream(file);
        outputString.write(value.getBytes());
        outputString.close();
    }
}
