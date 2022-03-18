package io.ylab.ticTacToeGame.repositories;

import java.util.List;

public interface Repository<T> {

    T get(String name);

    void save(T t);

    void saveAll(List<T> t);
}
