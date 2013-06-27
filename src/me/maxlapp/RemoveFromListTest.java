package me.maxlapp;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.*;

public class RemoveFromListTest {

    @Test
    public void removeSequenceFromList() {

        List<Integer> list = Arrays.asList(new Integer[]{1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 1, 6, 7, 8, 9, 1});

        List<Integer> result = ListUtils.removeRepeated(3, true, list);
        assertThat(Arrays.asList(new Integer[]{2, 3, 4, 1, 6, 7, 8, 9, 1}), is(result));
    }

    @Test
    public void removeRepeatedNumbersFromList() {

        List<Integer> list = Arrays.asList(new Integer[]{1, 1, 1, 1, 2, 3, 4, 5, 5, 1, 5, 6, 7, 8, 9, 1});

        List<Integer> result = ListUtils.removeRepeated(3, false, list);
        assertThat(Arrays.asList(new Integer[]{2, 3, 4, 6, 7, 8, 9}), is(result));
    }

}
