package com.example.orderservice.core.pagination;

import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class CheckSortInList {
    public static <T> Sort isSorted(List<T> list){
        boolean ascending = IntStream.range(0, list.size()-1).allMatch(i -> getComparator().compare(list.get(i), (list.get(i+1))) <=0);
        boolean descending = IntStream.range(0, list.size()-1).allMatch(i -> getComparator().compare(list.get(i), (list.get(i+1))) >=0);

        if(ascending){
            return Sort.by(Sort.Direction.ASC, "name");
        } else if (descending) {
            return Sort.by(Sort.Direction.DESC, "name");
        }
        return Sort.unsorted();
    }

    @SuppressWarnings("unchecked")
    private static <T> Comparator<T> getComparator() {
        return (obj1, obj2) -> {
            try {
                Field idField = obj1.getClass().getDeclaredField("id");
                idField.setAccessible(true);
                Comparable<Integer> id1 = (Comparable<Integer>) idField.get(obj1);
                Comparable<Integer> id2 = (Comparable<Integer>) idField.get(obj2);
                return id1.compareTo((Integer) id2);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Failed to compare objects using the 'id' field.", e);
            }
        };
    }

}
