package io.ylab.ticTacToeGame.tools;

import io.ylab.ticTacToeGame.objects.enums.Directory;
import io.ylab.ticTacToeGame.objects.enums.FileFormat;
import io.ylab.ticTacToeGame.objects.players.Player;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Creator {

    public static File createFile(List<Player> players, FileFormat fileFormat, Directory directory) throws IOException {
        String fullName = players.get(0).getName() + "vs" + players.get(1).getName() + "_";
        FileFilter filter = (pathname) -> pathname.getName().matches(fullName + "\\d*\\." + fileFormat);
        var files = new File(directory.getPath()).listFiles(filter);
        File newFile;
        if (files != null && files.length > 0) {
            Comparator<File> comparator = (x, y) -> {
                int numFile1 = Integer.parseInt(x.getName().replace(fullName, "").replace("." + fileFormat, ""));
                int numFile2 = Integer.parseInt(y.getName().replace(fullName, "").replace("." + fileFormat, ""));
                return Integer.compare(numFile2, numFile1);
            };
            Arrays.sort(files, comparator);
            String maxNumLastGame = files[0].getName().replace(fullName, "").replace("." + fileFormat, "");
            int num = Integer.parseInt(maxNumLastGame) + 1;
            newFile = new File(directory.getPath() + fullName + num + "." + fileFormat);
        }
        else {
            newFile = new File(directory.getPath() + fullName + "1." + fileFormat);
        }
        newFile.createNewFile();
        return newFile;
    }
}
