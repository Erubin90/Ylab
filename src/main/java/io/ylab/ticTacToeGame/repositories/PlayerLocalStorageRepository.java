package io.ylab.ticTacToeGame.repositories;

import io.ylab.ticTacToeGame.objects.players.Person;
import io.ylab.ticTacToeGame.objects.players.Player;
import io.ylab.ticTacToeGame.storages.LocalStorage;
import io.ylab.ticTacToeGame.tools.Convert;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PlayerLocalStorageRepository implements Repository<Player> {

    private final File file;

    private final Convert convert;

    private final LocalStorage localStorage;

    public PlayerLocalStorageRepository() {
        this.file = new File("src/main/java/io/ylab/ticTacToeGame/Players.txt");
        this.convert = new Convert(" : ", "\n");
        this.localStorage = new LocalStorage();
    }

    @Override
    public Player get(String name) {
        Player player = null;
        try {
            String stringFile = localStorage.read(file);
            var map = convert.stringToMap(stringFile);
            String point = map.get(name);
            if (point != null && point.matches("\\d+")) {
                player = new Person(name, Integer.parseInt(point));
            }
            else {
                player = new Person(name);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public void save(Player player) {
        try {
            String stringFile = localStorage.read(file);
            var map = convert.stringToMap(stringFile);
            map = sorted(map);
            String value = convert.mapToString(map);
            localStorage.write(value, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveAll(List<Player> players) {
        try {
            String stringFile = localStorage.read(file);
            var map = convert.stringToMap(stringFile);
            for (var player: players)
                map.put(player.getName(), String.valueOf(player.getPoint()));
            map = sorted(map);
            String value = convert.mapToString(map);
            localStorage.write(value, file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> sorted(Map<String, String> map) {
        Comparator<String> comparator = (x, y) -> {
            Integer ix = Integer.parseInt(map.get(x));
            Integer iy = Integer.parseInt(map.get(y));
            int compare = iy.compareTo(ix);
            if (compare == 0) {
                compare = x.compareTo(y);
            }
            return compare;
        };
        Map<String, String> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    //Метод добавлен для тестирования
    public Map<String, String> getSorted(Map<String, String> map) {
        return sorted(map);
    }
}
