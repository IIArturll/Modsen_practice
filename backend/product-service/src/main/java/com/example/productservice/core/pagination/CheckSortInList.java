package com.example.productservice.core.pagination;

import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class CheckSortInList {
    public static <T> Sort isSorted(List<T> list, Comparator<T> comparator){
        boolean ascending = IntStream.range(0, list.size()-1).allMatch(i -> comparator.compare(list.get(i), (list.get(i+1))) <=0);
        boolean descending = IntStream.range(0, list.size()-1).allMatch(i -> comparator.compare(list.get(i), (list.get(i+1))) >=0);

        if(ascending){
            return Sort.by(Sort.Direction.ASC, "name");
        } else if (descending) {
            return Sort.by(Sort.Direction.DESC, "name");
        }
        return Sort.unsorted();
    }
}
