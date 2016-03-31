package playlist;

import java.io.*;
import java.util.*;

public class pretreatment {
	
	public int[][] playlist = new int[5504][];
	public int[] playlist_popularity = new int[5504];
	
	public static void main(String[] args){
		pretreatment pre = new pretreatment();
		try{
			pre.readInFile("/Users/muyunyan/Documents/eeclipse/Playlist/PlaylistApp-Datasets/all_playlists.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void readInFile(String file) throws Exception{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String[] wordsArray;
		String c;
		for (int i = 0; (c = br.readLine()) != null;i++){
			 wordsArray = c.split("\t");
			 String[] song = wordsArray[0].split("\\s+");
			 playlist[i] = new int[song.length];
			 for(int j = 0;j < song.length ;j++){
				 
				 playlist[i][j] = Integer.parseInt(song[j]);
			 }
			 playlist_popularity[i] = Integer.parseInt(wordsArray[1]);
		}
		br.close();
		fr.close();
	}

}
