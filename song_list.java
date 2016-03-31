package project_text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Song_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] SongNumber = new int[8162];
        String[] SongName = new String[8162];
        String[] Author = new String[8162];
		readFileByLines("/Users/Sony/Desktop/PlayListApp 2/PlaylistApp-Datasets/song_list.txt", SongNumber, SongName, Author);
		HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
		for (int i = 0; i < 3168; i++) {
			mp.put(i, 0);
		}
		
		System.out.println(SongNumber[3167]);
		System.out.println(SongName[3167]);
		System.out.println(Author[3167]);
		System.out.println(mp.get(10));
		
	}
	public static void readFileByLines(String fileName, int[] SongNumber, String[] SongName, String[] Author) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int i = 0;
            while ((tempString = reader.readLine()) != null) {
                int j = 0;
                while(tempString.charAt(j) != '\t') {
                	j++;
                }
                String num = tempString.substring(0, j);
                SongNumber[i] = Integer.parseInt(num);
                j++;
                int n = j;
                while(tempString.charAt(n) != '\t') {
                	n++;
                }
                SongName[i] = tempString.substring(j, n);
                n++;
                int m = n;
                Author[i] = tempString.substring(m);
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        
    }
}