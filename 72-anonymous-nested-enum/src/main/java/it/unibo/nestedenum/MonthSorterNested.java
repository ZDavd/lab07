package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    enum Month{
        GENNAIO (31),
        FEBBRAIO (28),
        MARZO (31),
        APRILE (30),
        MAGGIO (31),
        GIUGNO (30),
        LUGLIO (31),
        AGOSTO (31),
        SETTEMBRE (30),
        OTTOBRE (31),
        NOVEMBRE (30),
        DICEMBRE(31);

        private final int numDays;

        Month(int numDays){
            this.numDays = numDays;
        }

        public int getNumDays(){
            return numDays;
        }
                
        /**
         * Converts a string representation of a month to its corresponding Month enum constant.
         * The method performs a case-insensitive partial match against the enum constant names.
         * 
         * @param month the string representation of the month to search for
         * @return the Month enum constant that matches the given string
         * @throws IllegalArgumentException if no match is found or if the string matches multiple months (ambiguous)
         */
        public static Month fromString(String month){
            int occurrences = 0;
            Month possibleResult = null;
            for (Month monthElem : Month.values()) {
                if(monthElem.name().toUpperCase().startsWith(month.toUpperCase())){
                    occurrences++;
                    possibleResult = monthElem;
                }
            }
            if (occurrences == 1) {
                return possibleResult;
            }
            throw new IllegalArgumentException(month + (occurrences > 1 ? " is an ambiguous name" : " not found as a valid constant"));
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return Month.fromString(o1).getNumDays() - Month.fromString(o2).getNumDays();
            }
            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return Month.fromString(o1).ordinal() - Month.fromString(o2).ordinal();
            }
            
        };
    }
}
