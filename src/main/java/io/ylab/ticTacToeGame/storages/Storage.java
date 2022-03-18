package io.ylab.ticTacToeGame.storages;

import java.io.File;
import java.io.IOException;

public interface Storage<T> {

    T read(File file) throws IOException;

    void write(T t, File file) throws IOException;
}