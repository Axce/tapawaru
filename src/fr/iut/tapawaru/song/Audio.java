package fr.iut.tapawaru.song;

import java.util.Random;

import maryb.player.Player;

public class Audio
{

	   private static final int NUMBER_OF_SONG_AVAILABLE = 3;
	   
	   public static final int BACKGROUND_MUSIQUE = 1;
	   public static final int ANIMATION_MUSIQUE = 2;
	
	   private Player p;

	   private int audioType;

	   
	    
	   public Audio(int audioType)
	   {
		  this.p = new Player();
	      this.p.setCurrentVolume( 0.2f );    

	      this.audioType = audioType;
	   }

	   public Audio(int audioType, int song)
	   {
		  this.p = new Player();
	      this.p.setCurrentVolume( 0.7f );    

	      this.audioType = audioType;
	      this.p.setSourceLocation( "song/animation"+song+".wav" );
	   }
	   
	   public void run(){
		   if(this.audioType == BACKGROUND_MUSIQUE)
		   {
			   Random r = new Random();
			   int valeur = r.nextInt(NUMBER_OF_SONG_AVAILABLE)+1;
			   this.p.setSourceLocation( "song/"+valeur+".mp3" );
		   }


		   this.p.setSourceLocation( "song/animation1.wav" );
		 this.p.play();
		   
	   }
	   public Player getP()
	{
		return this.p;
	}
}
