package org.swissre;

public class TrackOfBonous {

    private int beverageCounter = 0;

    public boolean isBeverageFree() {
        beverageCounter++;
        return beverageCounter % 5 == 0;
    }

}
