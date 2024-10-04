import java.io.*;

public class Main {
    public static void main(String[] args) {

        File dirGames = new File("C://Games");
        StringBuilder text = new StringBuilder();

        if (dirGames.mkdir()) {
            text.append("Папка Games создана\n");
        } else {
            text.append("Папка Games не создана\n");
        }

        File dirSrc = new File(dirGames, "src");
        File dirRes = new File(dirGames, "res");
        File dirSavegames = new File(dirGames, "savegames");
        File dirTemp = new File(dirGames, "temp");

        if (dirSrc.mkdir() && dirRes.mkdir() && dirSavegames.mkdir() && dirTemp.mkdir()) {
            text.append("В папке Games создана папка(и)\n");
        } else {
            text.append("В папке Games создана папка(и)\n ");
        }


        File dirMain = new File(dirSrc, "main");
        File dirTest = new File(dirSrc, "test");
        if (dirMain.mkdir() && dirTest.mkdir()) {
            text.append("В папке src созданы папка(и)\n");
        } else {
            text.append("В папке src созданы папка(и)\n");
        }


        File fileMain = new File(dirMain, "Main.java");
        File fileUtils = new File(dirMain, "Utils.java");
        try {
            if (fileMain.createNewFile() && fileUtils.createNewFile()) {
                text.append("Созданы один или два файла\n");
            } else {
                text.append("Один или два файла не созданы\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File dirDrawables = new File(dirRes, "drawables");
        File dirIcons = new File(dirRes, "icons");
        File dirVectors = new File(dirRes, "vectors");
        if (dirDrawables.mkdir() && dirIcons.mkdir() && dirVectors.mkdir()) {
            text.append("В папке res созданы папка(и)\n");
        } else {
            text.append("В папке res не созданы папка(и)\n");
        }

        File fileTemp = new File(dirTemp, "temp.txt");
        try {
            if (fileTemp.createNewFile()) {
                text.append("Файл temp создан\n");
            } else {
                text.append("Файл temp  не создан\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp, true))) {
            text.append("Сообщения в файл записаны.\n");
            bw.write(text.toString());
            bw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
