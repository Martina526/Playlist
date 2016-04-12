package project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Excute {
	
	ArrayList<Song> Songs = new ArrayList<Song>();
	ArrayList<Playlist> Playlists = new ArrayList<Playlist>();
	HashMap<Integer, Song> num2song = new HashMap<Integer, Song>(); 
	HashMap<Integer, Playlist> num2playlist = new HashMap<Integer, Playlist>();

	public static void main(String[] args) {
		try {
			Excute go = new Excute();
			go.pretreatSong("/Users/muyunyan/Documents/eeclipse/Playlist/PlaylistApp-Datasets/all_songs.txt");
			go.pretreatPlaylist("/Users/muyunyan/Documents/eeclipse/Playlist/PlaylistApp-Datasets/all_playlists.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void pretreatSong(String file) throws Exception{	
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String[] member;
		String c;	
		for (int i = 0; (c = br.readLine()) != null;i++){
			 member = c.split("\t");
			 Song s = new Song(member[1],member[2]);//initial a new song with "singer" & "name"
			 num2song.put(Integer.parseInt(member[0]), s);// key = song number, value = song object		 
		}
		br.close();
		fr.close();
	}
	

	public ArrayList<Playlist> loadSingle(String single){
		String[] member = single.split("\t");
		int pop = Integer.parseInt(member[member.length-1]);
		if(pop < Playlists.get(1024).pop){
			
		}
		else{
			Playlist pp = new Playlist(pop);
			for(int i = 0; i < member.length - 1; i++){
				Song s = num2song.get(Integer.parseInt(member[i]));
				s.updatesongPopularity(pop);
				s.updataPlaylist();
				pp.insongs.add(s);
			}
			Playlists.add(pp);		
			return Playlists;
			}
	}
	
	public ArrayList<Playlist> loadFile(String file){
		FileReader fr = new FileReader(file);
//		BufferedReader br = new BufferedReader(fr);
//		String[] member;
//		String c;
//		for (int i = 0; (c = br.readLine()) != null;i++){			
//			member = c.split("\t");
//			int pop = Integer.parseInt(member[1]);
//			String[] sss = member[0].split("\\s+");
//			Playlist p = new Playlist(Integer.parseInt(member[1]));
//			
//			for(int j = 0;j < sss.length ;j++){	
//				 int numsong =  Integer.parseInt(sss[j]);
//				 String songName = num2song.get(numsong);
//				 Songs.get(numsong).updatePop(pop);
//				//this.//改了equal就相当于改了get就可以找到了
//				 
//			}
//			num2playlist.put(i, p);
//		}
//		br.close();
//		fr.close();
		return Playlists;}

	//get these playlist's insong.get(i).name to show up the string name of songs
	public ArrayList<Playlist> topEight(){
		ArrayList<Playlist> p = new ArrayList<Playlist>();
		for(int i = 0; i < 8; i++){
			p.add(Playlists.get(i));
		}
		return p;
		
	}
	
	
//	public void pretreatPlaylist(String file) throws Exception{	
//		FileReader fr = new FileReader(file);
//		BufferedReader br = new BufferedReader(fr);
//		String[] member;
//		String c;
//		for (int i = 0; (c = br.readLine()) != null;i++){			
//			member = c.split("\t");
//			int pop = Integer.parseInt(member[1]);
//			String[] sss = member[0].split("\\s+");
//			Playlist p = new Playlist(Integer.parseInt(member[1]));
//			
//			for(int j = 0;j < sss.length ;j++){	
//				 int numsong =  Integer.parseInt(sss[j]);
//				 String songName = num2song.get(numsong);
//				 Songs.get(numsong).updatePop(pop);
//				//this.//改了equal就相当于改了get就可以找到了
//				 
//			}
//			num2playlist.put(i, p);
//		}
//		br.close();
//		fr.close();
//	}
	
	// 调整playlist的时候需要调整：内部song,在更新playlists里边的饿playlist对象的时候
	// 是否hashmap里边的对应的playlist的对象信息也改变了？
		
	}
}
