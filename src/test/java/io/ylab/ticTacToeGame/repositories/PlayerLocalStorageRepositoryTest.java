package io.ylab.ticTacToeGame.repositories;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayerLocalStorageRepositoryTest {

    private PlayerLocalStorageRepository storage = new PlayerLocalStorageRepository();

    @Test
    void get() {

    }

    @Test
    void saveAll() {
    }

    @Test
    void sorted() {
        Map<String, String> map = new HashMap<>();
        map.put("Kar", "1");
        map.put("Hrak", "10");
        map.put("Rak", "1");
        map.put("H", "6");
        map.put("G", "0");

        Map<String, String> res = new LinkedHashMap<>();
        res.put("Hrak", "10");
        res.put("H", "6");
        res.put("Kar", "1");
        res.put("Rak", "1");
        res.put("G", "0");

        assertEquals(res.toString(), storage.getSorted(map).toString());
    }
}