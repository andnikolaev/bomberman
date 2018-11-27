package ru.rsreu.nikolaev0211.model.level;

import java.io.*;

public class LevelReader {


    public LevelReader() {

    }

    public Level readLevel(String filePath) {
        String levelFileHeader = readHeader(filePath);
        int rows = getRows(levelFileHeader);
        int columns = getColumns(levelFileHeader);
        int levelNumber = getLevelNumber(levelFileHeader);
        char[][] levelArray = new char[rows][columns];
        try {
            BufferedReader bufferedInputStream = new BufferedReader(new FileReader(filePath));
            bufferedInputStream.readLine();
            String currentLevelString = "";
            for (int i = 0; i < rows; i++) {
                currentLevelString = bufferedInputStream.readLine();
                if (!currentLevelString.equals("")) {
                    levelArray[i] = processLevelString(currentLevelString, columns);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Level level = new Level(levelNumber, levelArray);
        return level;

    }

    private char[] processLevelString(String currentLevelString, int columns) {

        char[] result = new char[columns];
        for (int i = 0; i < columns; i++) {
            result[i] = currentLevelString.charAt(i);
        }

        return result;
    }

    private int getLevelNumber(String levelFileHeader) {
        return Integer.valueOf(levelFileHeader.split(" ")[0]);
    }

    private int getRows(String levelFileHeader) {
        return Integer.valueOf(levelFileHeader.split(" ")[1]);
    }

    private int getColumns(String levelFileHeader) {
        return Integer.valueOf(levelFileHeader.split(" ")[2]);
    }


    private String readHeader(String filePath) {
        String result = "";

        try {
            BufferedReader bufferedInputStream = new BufferedReader(new FileReader(filePath));
            result = bufferedInputStream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
