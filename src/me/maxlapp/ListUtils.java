package me.maxlapp;

import java.util.*;

public class ListUtils {

    public static <T extends Number> List<T> removeRepeated(int repetitionsNumber, boolean bySequence, List<T> list) {
        final ArrayList<Integer> indexes4remove = new ArrayList<Integer>();
        final HashMap<T, List<Integer>> counterMap = new HashMap<T, List<Integer>>();

        for (int position = 0; position < list.size(); position++) {
            final T el = list.get(position);

            if (!counterMap.containsKey(el)) {
                counterMap.put(el, new ArrayList<Integer>());
            }
            counterMap.get(el).add(position);
        }

        for (T key : counterMap.keySet()) {
            final List<Integer> positions = counterMap.get(key);

            if (positions.size() >= repetitionsNumber) {
                if (bySequence) {
                    for (List<Integer> sequence : extractSequences(repetitionsNumber, positions)) {
                        indexes4remove.addAll(sequence);
                    }
                } else {
                    indexes4remove.addAll(positions);
                }
            }
        }

        final ArrayList<T> result = new ArrayList<T>();
        for (int i = 0; i < list.size(); i++) {
            if (!indexes4remove.contains(i)) {
                 result.add(list.get(i));
            }
        }

        return result;
    }

    public static List<List<Integer>> extractSequences(int sequenceLength, List<Integer> list) {
        final List<List<Integer>> sequences = new ArrayList<List<Integer>>();
        int beginSequence   = -1;
        int endSequence     = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            boolean nextExactlyFollowing = list.get(i + 1) - list.get(i) == 1;

            if (nextExactlyFollowing) {
                endSequence = i + 1;
                if (beginSequence == -1) {
                    beginSequence = i;
                }
            }

            boolean sequenceDetected = (endSequence - beginSequence >= sequenceLength - 1);
            boolean oneToLast = (i == list.size() - 2);

            if (sequenceDetected && (!nextExactlyFollowing || oneToLast)) {
                if (sequenceDetected) {
                    sequences.add(list.subList(beginSequence, endSequence + 1));
                    beginSequence   = -1;
                    endSequence     = -1;
                }
            }
        }
        return sequences;

    }

}
