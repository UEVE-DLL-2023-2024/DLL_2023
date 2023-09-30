import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de sauvegarder et de récupérer les données d'un joueur
 * Le fichier se trouve sous le nom "[Nom du joueur]_data.txt" dans le dossier : ./save
 * Le fichier de sauvegarde se comporte de la façon suivante :
 * - Première ligne : dernier score du joueur
 * - Seconde ligne : dernier score du bot
 * - Troisième ligne : meilleure win streak du joueur
 */
public class LocalStorage {
    private static String getFileName(String playerName) {
        return "./save/"+playerName + "_data.txt";
    }

    // Méthode pour sauvegarder le score et la win streak
    public static void saveData(String playerName, int score,int scoreBot, int winStreak) {
        String fileName = getFileName(playerName);
        if(!new File("./save").exists()){
            if(!new File("./save").mkdir()){
                System.out.println("Erreur lors de la création du dossier save");
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(score);
            writer.println(scoreBot);

            writer.println(winStreak);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Méthode pour récupérer la dernière winstreak
    public static int getScore(String playerName) {
        String fileName = getFileName(playerName);
        if(new File(fileName).exists()){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return 0;
        }
    }
        return 0;
    }

    // Méthode pour récupérer la meilleure win streak
    public static int getBestWinStreak(String playerName) {
        String fileName = getFileName(playerName);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // On lit la première ligne (score) sans l'utiliser
            reader.readLine(); // On lit la seconde ligne (score) sans l'utiliser
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return 0; // Si le fichier n'existe pas ou s'il y a une erreur, on renvoie 0
        }
    }
    public static int getBotScore(String playerName){
        String fileName = getFileName(playerName);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // On lit la première ligne (score) sans l'utiliser
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return 0; // Si le fichier n'existe pas ou s'il y a une erreur, on renvoie 0
        }
    }
    public static void resetScores(String playerName) {
        String fileName = getFileName(playerName);
        List<String> lines = new ArrayList<>();

        //  Lire le contenu du fichier pour garder en tête la plus grosse winstreak
        if(new File(fileName).exists()){
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // reset les 2 premieres lignes
            if (lines.size() >= 2) {
                lines.set(0, "0");
                lines.set(1, "0");
            }

            // Écrire à nouveau les nouvelles infos dans le fichier
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                for (String line : lines) {
                    writer.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<List<String>> getAllScoreboard() {
        File folder = new File("./save");
        File[] listOfFiles = folder.listFiles();
        List<List<String>> playerScoreboard = new ArrayList<>();

        if (listOfFiles != null) {  // Ajout d'une vérification null pour éviter une NullPointerException
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    List<String> playerInfo = new ArrayList<>();
                    String fileName = file.getName();
                    String playerName = fileName.substring(0, fileName.length() - 9);
                    playerInfo.add(playerName + " " + getScore(playerName) + " - " + getBotScore(playerName) + " Bot, " + "Meilleure serie de victoire : " + getBestWinStreak(playerName));
                    playerScoreboard.add(playerInfo);  // Ajoute la liste playerInfo à playerScoreboard
                }
            }
        }
        return playerScoreboard;
    }


}
