package playlist;

import java.util.*;

public class playlist_popularity extends BST{
	ArrayList<Integer> number = new ArrayList<Integer>(); 
	ArrayList<Integer> popularity = new ArrayList<Integer>(); 
	//static BST<Integer> pl_popularity = new BST<Integer>();
	
	public static void main(String[] args) {
		pretreatment pre = new pretreatment();
		try{
			pre.readInFile("/Users/muyunyan/Documents/eeclipse/Playlist/PlaylistApp-Datasets/all_playlists.txt");			
			playlist_popularity pp = new playlist_popularity(pre.playlist_pp);
			ArrayList top_8_number = pp.sortAsDecrease(8);
			System.out.println(top_8_number);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	playlist_popularity( ArrayList<Integer> popularity){

		this.popularity = popularity;	
		for(int i = 0 ; i < this.popularity.size();){
			this.number.add(i+1);
			insert(popularity.get(i),number.get(i));
		}
	}
	
	public void adjust(){}
	public int minimal(){
		int k = findmini();
		return k;
	}
}
