package game;

public class Poker {


	
	
	public Poker() {
	
	}
	
	public void sortBySuit(Hand h) {
		
		int i, j, min_j;
		
		for( i= 0; i<h.getSize(); i++) {
			min_j = i;
			for( j = i+1; j<h.getSize(); j++) {
				if(h.getCard(j).getSuit()< h.getCard(min_j).getSuit()) {
					min_j = j;
				}
			}
			
		Card help = h.getCard(i);
		h.setCard(h.getCard(min_j), i);
		h.setCard(help, min_j);
		}
		
	}
	
	public void sortByRank(Hand h) {
		int i, j, min_j;	
		
		for ( i = 0 ; i < h.getSize() ; i ++ )
	      {
	         min_j = i;  
	         for ( j = i+1 ; j < h.getSize() ; j++ )
	         {
	            if ( h.getCard(j).getRank() > h.getCard(min_j).getRank() )
	            {
	               min_j = j; 
	            }
	         }
	         
	         Card help = h.getCard(i);
	 		h.setCard(h.getCard(min_j), i);
			h.setCard(help, min_j);
			}
	}
	
	public boolean royalFlush(Hand h) {
		
		if(h.getCard(0).getRank() == 14 && h.getCard(1).getRank()== 13 && h.getCard(2).getRank()==12
				&& h.getCard(3).getRank() ==11 && h.getCard(4).getRank()==10) {
			for(int i =0; i < h.getSize(); i++) {
				if(h.getCard(i).getSuit() == h.getCard(i+1).getSuit()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean StraightFlush(Hand h) {
		
		for(int i = 1; i<h.getSize(); i++) {
			if(h.getCard(0).getSuit() != h.getCard(i).getSuit()) {
				return false;
			}
		}
		for(int j = 1; j<h.getSize(); j++) {
			if((h.getCard(j-1).getRank()-1) != (h.getCard(j).getRank())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean fourOfAKind(Hand h) {
		
		int counter = 0;
		for(int i = 0; i< h.getSize(); i++) {
			counter = 0;
			for(int j = 0; j<h.getSize(); j++) {
				if(h.getCard(j).getRank() == h.getCard(i).getRank()) {
					counter++;
				}
			}
			if(counter >= 4) {
				return true;
			}
		}
		return false;
	}
	

}