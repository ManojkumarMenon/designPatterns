package com.manoj.practice.design.patterns;

public class StatePattern {

    public static void main(String[] args) {
        System.out.println("---");
        State newState = new NewState();
        State runnableState = new RunnableState();
        State runningState = new RunningState();
        State sleepingState = new SleepingState();
        State terminatedState = new TerminatedState();

        newState.setNextState(runnableState);
        runnableState.setPreviousState(newState);
        runnableState.setNextState(runningState);
        runningState.setPreviousState(runnableState);
        runningState.setNextState(sleepingState);
        sleepingState.setPreviousState(runningState);
        sleepingState.setNextState(terminatedState);
        terminatedState.setPreviousState(sleepingState);

        State startState = newState;
        while (startState != null) {
            if (startState.getPreviousState() != null) {
                startState.getPreviousState().printCurrentState();
            }
            startState.printCurrentState();
            if (startState.getNextState() != null) {
                startState.getNextState().printCurrentState();
            }

            startState = startState.getNextState();

            System.out.println("---");
        }

    }

}

class context {
    public State state = new NewState();

    public void setPreviousState(State state) {
        this.state.setPreviousState(state);
    }
}

interface State {
    public void setPreviousState(State state);

    public void printCurrentState();

    public void setNextState(State state);

    public State getPreviousState();

    public State getNextState();
}

class NewState implements State {

    private State previousState;
    private State nextState;

    public State getPreviousState() {
        return previousState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setPreviousState(State state) {
        this.previousState = state;

    }

    public void printCurrentState() {
        System.out.println("In NewState State ...");
    }

    public void setNextState(State state) {
        this.nextState = state;
    }

}

class RunnableState implements State {
    private State previousState;
    private State nextState;

    public State getPreviousState() {
        return previousState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setPreviousState(State state) {
        this.previousState = state;

    }

    public void printCurrentState() {
        System.out.println("In RunnableState State ...");
    }

    public void setNextState(State state) {
        this.nextState = state;
    }

}

class RunningState implements State {
    private State previousState;
    private State nextState;

    public State getPreviousState() {
        return previousState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setPreviousState(State state) {
        this.previousState = state;

    }

    public void printCurrentState() {
        System.out.println("In Running State ...");
    }

    public void setNextState(State state) {
        this.nextState = state;
    }
}

class SleepingState implements State {
    private State previousState;
    private State nextState;

    public State getPreviousState() {
        return previousState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setPreviousState(State state) {
        this.previousState = state;

    }

    public void printCurrentState() {
        System.out.println("In Sleeping State ...");
    }

    public void setNextState(State state) {
        this.nextState = state;
    }
}

class TerminatedState implements State {
    private State previousState;
    private State nextState;

    public State getPreviousState() {
        return previousState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setPreviousState(State state) {
        this.previousState = state;

    }

    public void printCurrentState() {
        System.out.println("In Terminated State ...");
    }

    public void setNextState(State state) {
        this.nextState = state;
    }
}