/**
 * An Immutable class to represent the state of monkey, box and banana.
 *
 */
public class State {
    private char posMonkey; // position of Monkey
    private char posBox;    // position of Box
    private char posBanana; // position of banana
    private boolean monkeyGet;  // the state of monkey get the banana
    private boolean monkeyOn;   // the state of monkey on the box

    public State(char posMonkey, char posBox, char posBanana, boolean monkeyOn, boolean monkeyGet){
        this.posMonkey = posMonkey;
        this.posBox = posBox;
        this.posBanana = posBanana;
        this.monkeyOn = monkeyOn;
        this.monkeyGet = monkeyGet;
    }

    public char getPosMonkey() {
        return posMonkey;
    }

    public char getPosBox() {
        return posBox;
    }

    public char getPosBanana() {
        return posBanana;
    }

    /**
     * To check if monkey is under the banana
     * @return
     */
    public boolean getMonkeyOn() {
        return monkeyOn;
    }

    public boolean getMonkeyGet() {
        return monkeyGet;
    }

    /**
     * To check if the monkey is under the banana.
     * @return
     */
    public boolean monkeyAtBanana(){
        return this.posMonkey == this.posBanana;
    }

    /**
     * To get the state of whether monkey get box.
     *
     * @return boolean the monkey get the box
     */
    public boolean monkeyGetBox(){
        return this.posMonkey == this.posBox;
    }
    @Override
    public String toString() {
        return "Monkey at: " + posMonkey + ", " +
                "Box at: " + posBox + ", " +
                "Banana at: " + posBanana + ", " +
                "Monkey is on box: " + monkeyOn + ", " +
                "Monkey get the banana: "  + monkeyGet;
    }
}
