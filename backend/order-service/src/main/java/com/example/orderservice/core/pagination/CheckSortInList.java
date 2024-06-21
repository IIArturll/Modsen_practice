package com.example.orderservice.core.pagination;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.IntStream;

public class CheckSortInList {
    public static <T extends Comparable<? super T>> Sort isSorted(List<T> list){
        boolean ascending = IntStream.range(0, list.size()-1).allMatch(i -> list.get(i).compareTo(list.get(i+1)) <=0);
        boolean descending = IntStream.range(0, list.size()-1).allMatch(i -> list.get(i).compareTo(list.get(i+1)) >=0);

        if(ascending){
            return Sort.by(Sort.Direction.ASC, "name");
        } else if (descending) {
            return Sort.by(Sort.Direction.DESC, "name");
        }
        return Sort.unsorted();
    }

}
