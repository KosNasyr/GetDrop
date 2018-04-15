package su.aion.gd;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetDrop {

    public ArrayList<String> getInfo(String filePath) throws Exception {
        ArrayList<String> drop = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.ISO_8859_1);
        for (String line : lines) {
            byte[] b = line.getBytes("ISO-8859-1");
            String[] newLine = new String(b, "windows-1251")
                                                .toLowerCase()
                                                .split(" ");
            for (String word : newLine) {
                if (!word.isEmpty()) {
                    drop.add(word);
                }
            }
        }
        return drop;
    }

    public long getKinara (ArrayList<String> drop) {
        long sum = 0;
        for (int i = 0; i < drop.size(); i++) {
            if (drop.get(i).equals("кинаров:")) {
                String kins = drop.get(i + 1).replace(".", "")
                        .replaceAll("[\\s|\\u00A0]+", "");
                sum = sum + Long.parseLong(kins);
            }
        }
        return sum;
    }

    public String getMatesDrop(ArrayList<String> drop){
        String mDrop ="";
        for (int i = 0; i < drop.size(); i++) {
            if (drop.get(i).equals("получает:")) {
                mDrop= mDrop + drop.get(i-1) +" "+ drop.get(i) +" " + drop.get(i+1) +"\n";
            }
        }
        return mDrop;
    }

    public String getMyDrop(ArrayList<String> drop){
        String mDrop ="";
        for (int i = 0; i < drop.size(); i++) {
            if (drop.get(i).equals("получено:") || drop.get(i).equals("приобретено:")) {
                mDrop = mDrop + drop.get(i) + " " + drop.get(i+1) + "\n";
            }
        }
        return mDrop;
    }
}
