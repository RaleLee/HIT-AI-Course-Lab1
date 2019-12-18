import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class Monkey {

    public static ArrayList<State> statelist = new ArrayList<State>();

    public static State monkeyDownBox(State state) {
        if (state.getMonkeyOn() && !state.monkeyAtBanana()) {
            State newState = new State(
                    state.getPosMonkey(),
                    state.getPosBox(),
                    state.getPosBanana(),
                    false,
                    state.getMonkeyGet()
            );
            return newState;
        }
        return state;
    }

    public static State monkeyToBox(State state) {
        if (!state.monkeyGetBox()) {
            State newState = new State(
                    state.getPosBox(),
                    state.getPosBox(),
                    state.getPosBanana(),
                    state.getMonkeyOn(),
                    state.getMonkeyGet()
            );
            return newState;
        }
        return state;
    }

    public static State monkeyPushBox(State state) {
        if (!state.monkeyGetBox()) {
            return state;
        }
        State newState = new State(
                state.getPosBanana(),
                state.getPosBanana(),
                state.getPosBanana(),
                state.getMonkeyOn(),
                state.getMonkeyGet()
        );
        return newState;
    }

    public static State monkeyUpBox(State state) {
        if (!state.monkeyGetBox()) {
            return state;
        }
        State newState = new State(
                state.getPosMonkey(),
                state.getPosBox(),
                state.getPosBanana(),
                true,
                state.getMonkeyGet()
        );
        return newState;
    }

    public static State monkeyGetBanana(State state){
        if(!isRightState(state)){
            return state;
        }

        System.out.println("Begin");
        State atLand = monkeyDownBox(state);
        System.out.println(atLand);
        State getBox = monkeyToBox(atLand);
        System.out.println(getBox);
        State push = monkeyPushBox(getBox);
        System.out.println(push);
        State up = monkeyUpBox(push);
        System.out.println(up);
        State finalState = new State(
                up.getPosMonkey(),
                up.getPosBox(),
                up.getPosBanana(),
                up.getMonkeyOn(),
                true
        );
        return finalState;
    }

    public static boolean isRightState(State state){
        if(!state.monkeyGetBox() && state.getMonkeyOn()){
            System.out.println("Wrong!");
            return false;
        }
        if(state.getMonkeyGet()){
            System.out.println("Wrong!");
            return false;
        }
        return true;
    }

    public static void simulate(State state){
        System.out.println(state);
        State out1 = monkeyGetBanana(state);
        System.out.println(out1);
        System.out.println("End\n");
    }

    public static void main(String[] args) {

        // state 1
        //
        State state1 = new State(
                'A', 'C', 'B',
                false, false
        );
        statelist.add(state1);
        // state 2
        State state2 = new State(
                'C', 'C', 'B',
                true, false
        );
        statelist.add(state2);
        // state 3, a wrong state
        State state3 = new State(
                'A', 'C', 'B',
                false, true
        );
        statelist.add(state3);
        // state 4, another wrong state
        State state4 = new State(
                'C', 'A', 'B',
                true, false
        );
        statelist.add(state4);

        for(int i = 0; i < statelist.size(); i++){
            simulate(statelist.get(i));
        }
    }
}
