/*
BlackJack OOD 
Logic class Lecture 21 and/or 05_06 video
Simulator patter
*/ 

public enum Suit{
    Club, 
    Diamond, 
    Heart, 
    Spade
}
    
public class Card{
    private int faceValue; 
    private Suits suit; 
    
    public Card(int c, Suits s){
        faceValue = c; 
        suit = s;
    }
    
    public int value(){
        return faceValue; 
    }
    
    public Suit(){
        return suit; 
    }
    
}

public class Deck{
    private static final Random random = new Random();
    
    private final List<Card> cards = new ArrayList<>(); 
    private int dealtIndex = 0; 
    
    public Deck(){
        for(int i = 1; i <= 13; i++){
            for (Suit suit: Suit.values()){
                cards.add(new Card(i, suit))
            }
        }
    }
    
    public void shuffle(){
        for(int i = 0; i < cards.size - 1; i++){
            int j = random.nextInt(cards.size() - i) +i;
            Card card1 = cards.get(i); 
            Card card2 = cards.get(j); 
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }
    
    private int remainingCards(){
        return cards.size()- dealtIndex;
    }
    
    public Card[] dealHand(int number){
        if (remainingCards() < number){
            return null;
        }
    
        Card[] cards = new Card[number];
        for(int i = 0; i < number; i ++){
            cards[i] = dealCard(); 
        }
        return cards; 
    }
        
    public Card dealCard(){
        return remainingCards() = 0 ? null : cards.get(dealIndex ++);
    }
    
    
}

public class Hand{
    protected final List<Card> cards = new ArrayList<>();
    
    public int score(){
        int score = 0; 
        for (Card card: cards){
            score += card.value();
        }
        return score; 
    }
    
    public void addCards(Card[] c){
        Collections.addAll(cards, c);
    }
    
    public int size(){
        return cards.size();
    }
}

public class BlackJackHand extends Hand{
    @Override 
    public int score(){
        List<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE; //max score <=21
        int minOver = Integer.MAX_VALUE; //min score > 21
        
        for(int score : scores){
            if (score > 21 && score < minOver){
                minOver = score;
            } else if (score <= 21 && score > maxUnder){
                maxUnder = score; 
            }
        }
        return maxUnder == Integer.Max_VALUE? minOver:maxUnder; 
    }
    
    private List<Integer> possibleScore(){
        List<Integer> scores = new ArrayList<>();
        for (Card card : cards){
            updateScore(card, scores);
        }
        return scores; 
    }

    private void updateScore(Card card, List<Integer> scores){
        final int[] toAdd = getScores(card); 
        if(score.isEmpty()) {
            for(int score: toAdd){
                scores.add(score);
            }
        }else{
        
            final int length = scores.size();
            for (int i = 0; i < length; i ++){
                int oldScore = scores.get(i); 
                scores.set(i, oldScore + toAdd[0]);
                for (int j = 1; j < toAdd.length; j++){
                    scores.add(oldScore + toAdd[j]);
                }
            }  
        }
    }
    
    private int[] getScores(Card card){
        if (card.value() > 1) {
            return new int[] { Math.min(card.value(), 10);
        }else{ //ACE
            return new int[]{1, 11};           
        }
    }
    
    public boolean busted(){
        return score() > 21;
    }
    
    public boolean isBlackJack(){
        if (cards.size() != 2){
            return false;
        }
        card first = cards.get(0);
        card second = cards.get(1);
        return (isAce(first) && isFaceCard(second)) || (isAce(second) && isFaceValue(First));
    }
    
    private static boolean isAce(Card c){
        return c.value() ==1; 
    }
    
    private static boolean isFaceCard(Card c){
        return c.value() >= 11 && c.value()<=13;
    }
    
}

public class BlackJackGameAutomator(){
    private Deck deck; 
    private BlackJackHand[] hands; 
    private static final int HIT_UNTIL = 16; 
    
    public BlackJackGameAutomator(int numPlayers){
        hands = new BlackJackHand[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            hands[i] = new BlackJackHand();
        }
    }
    
    void initializeDeck{
        deck = new Deck();
        deck.shuffle(); 
    }
    
    boolean dealInitlal(){
        for(BlackJackHand hand: hands){
            Card[] cards = deck.dealHand(2);
            if (cards == null){
                return false; 
            }
            hand.addCards(cards);
        }
        return true; 
    }
    
    List<Integer> GetBlackJacks(){
        List<Integer> winners = new ArrayList<>(); 
        for(int i = 0; i < hands.length; i ++){
            if(hands[i].isBlackJack()){
                winners.add(i);
            }
        }
        return winners; 
    }
    
    boolean playHand(BlackJackHand hand){
        while(hand.score() < HIT_UNTIL){
            Card card = deck.dealCard(); 
            if (card == null){
                return false;
            }
            hand.addCards(new Card[] {card}); 
        }
        return true; 
    }
    
    boolean playAllHand(){
        for(BlackJackHand hand: hands){
            if(!playHand(hand)){
                return false; 
            }
        }
        return true; 
    }
    
    List<Integer> getWinner(){
        List<Integer> winners = new ArrayList<>(); 
        int winnerScore = 0; 
        for (int i = 0; i <. hands.length; i ++){
            BlackJackHand hand = hand[i];
        
            if(!hand.busted()){
                if(hand.score() > winningScore){
                    winningScore = hand.score();
                    winners.clears();
                    winners.add(i);
                }else if(hand.score() == winningScore){
                    winners.add(i);
                }
            }
        }
        return winners;
    }
    
    void printHandsAndScore(){
        for(int i = 0; i < hands.length; i ++){
            System.out.print("Hand" + i + "(" + hands[i].score()+ "):");
            hands[i].print();
            System.out.print();
        }
    }
    
    public void simulate(){
        initalizedDeck();
        
        boolean success = dealInital();
        if(!success){
            System.out.println("Error. Out of cards");
        }else {
            System.out.println("--inital--");
            printHandsAndScore(); 
            List<Integer> blackJacks = getBlackJacks(); 
            if(blackJacks.size() > 0){
                System.out.print("BlackJack at");
                for(int i : blackJacks){
                    System.out.print(i + "");
                }
                System.out.println("done");
            }else {
                success = playAllHands();
                if(!success){
                    System.out.println("Error.Out of cards");
                }else {
                    System.out.println("\n --Complete Game --");
                    printHandsAndScore();
                    List<Integer> winners = getWinners();
                    if (winner.size() >0){
                        System.out.print("Winners");
                        for(int i : winners){
                            System.out.print(i + "");
                        }
                        System.out.print();
                    }else{
                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }
    
   
}





