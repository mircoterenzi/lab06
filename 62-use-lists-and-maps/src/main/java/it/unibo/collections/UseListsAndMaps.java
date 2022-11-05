package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int NUMBER_TO_ADD = 100_000;
    private static final int NUMBER_TO_READ = 1000;
    
    private static final long AFRICA = 1_110_635_000;
    private static final long AMERICAS = 972_005_000;
    private static final long ANTARCTICA = 0;
    private static final long ASIA = 4_298_723_000l;
    private static final long EUROPE = 742_452_000;
    private static final long OCEANIA = 38_304_000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {

        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> numArray = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            numArray.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> numList = new LinkedList<>();
        numList.addAll(numArray);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int firstNumValue = numArray.get(0);
        final int lastNumIndex = numArray.size() - 1;
        numArray.set(0, numArray.get(lastNumIndex));
        numArray.set(lastNumIndex, firstNumValue);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
         
        for (Integer curr : numArray) {
            System.out.println(curr);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        AddElements(numArray);
        AddElements(numList);

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        ReadElements(numArray);
        ReadElements(numList);

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
        */
        
        
        Map<String,Long> world = new HashMap<>();
        world.put("Africa", AFRICA);
        world.put("Americas", AMERICAS);
        world.put("Antarctica", ANTARCTICA);
        world.put("Asia", ASIA);
        world.put("Europe", EUROPE);
        world.put("Oceania", OCEANIA);

        /*
         * 8) Compute the population of the world
         */
        long totPopulation = 0;
        for (Long currPopulation : world.values()) {
            totPopulation += currPopulation;
        }

        System.out.println("The world population is: " + totPopulation);
    }

    private static void AddElements (List <Integer> list) {
        long time = System.nanoTime();  //Set the initial time

        for (int i = 0; i < NUMBER_TO_ADD; i++) {
            list.add(0,0);
        }

        time = System.nanoTime() - time; //Calculate the time requiered
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println(
            "Time requiered to add 100.000 elements: "
            + time + "ns (" + millis + "ms)"
        );
    }

    private static void ReadElements (List <Integer> list) {
        long time = System.nanoTime();

        for (int i = 0; i < NUMBER_TO_READ; i++) {
            list.get(list.size() / 2);
        }

        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println(
            "Time requiered to add 100.000 elements: "
            + time + "ns (" + millis + "ms)"
        );
    }
}
