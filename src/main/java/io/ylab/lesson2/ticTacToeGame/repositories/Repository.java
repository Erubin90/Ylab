package io.ylab.lesson2.ticTacToeGame.repositories;

import java.util.List;

public interface Repository<T> {

    T get(String name);

    void saveAll(List<T> t);
}
