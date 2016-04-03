package playlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Playlist {
	public int[][] playlist = new int[128][];
	public ArrayList<Integer> playlist_pp = new ArrayList<Integer>();
	
	
	public void main(String[] args){
		
		
	}
	
	public void loadSingle(){}
	public void loadFile(String file)throws Exception{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String[] wordsArray;
		String c;
		int index = 0;
		for (int i = 0; (c = br.readLine()) != null;i++){
			 wordsArray = c.split("\t");
			 String[] song = wordsArray[0].split("\\s+");
			 playlist[index] = new int[song.length];
			 for(int j = 0;j < song.length ;j++){			 
				 playlist[i][j] = Integer.parseInt(song[j]);
			 }
			 playlist_pp.add(Integer.parseInt(wordsArray[1]));
			 
			 if((i+1)%128 == 0){
				 index = 0;
				 int minimal = playlist_popularity.minimal();
				 for(Iterator<E> it = playlist_pp.iterator(); it.hasNext();){
					 if(it > minimal){
						 playlist_popularity.insert(playlist, 128 + index);
					 }
				 }
			 }

		}
		br.close();
		fr.close();
		
	}

}
