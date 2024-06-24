package com.example.productservice.core.pagination;

import com.example.productservice.entities.ProductEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductCustomPage implements Page<ProductEntity>{
    private List<ProductEntity> items;
    private int pageNumber;
    private int pageSize;
    private int totalElements;


    @Override
    public int getTotalPages() {
        return pageSize == 0 ? 1 : (int) Math.ceil((double) totalElements / (double) pageSize);
    }

    @Override
    public long getTotalElements() {
        return totalElements;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <U> Page<U> map(Function<? super ProductEntity, ? extends U> converter) {

        List<U> mappedItems = items.stream()
                .map(converter)
                .collect(Collectors.toList());

        ProductCustomPage mappedPage = new ProductCustomPage();
        mappedPage.setItems((List<ProductEntity>) mappedItems);
        mappedPage.setPageNumber(getNumber());
        mappedPage.setPageSize(getSize());
        mappedPage.setTotalElements(getNumberOfElements());

        return (Page<U>) mappedPage;
    }

    @Override
    public int getNumber() {
        return pageNumber;
    }

    @Override
    public int getSize() {
        return pageSize;
    }

    @Override
    public int getNumberOfElements() {
        return totalElements / getTotalPages();
    }

    @Override
    public List<ProductEntity> getContent() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public boolean hasContent() {
        return !items.isEmpty();
    }

    @Override
    public Sort getSort() {
        Comparator<ProductEntity> sortProducts = Comparator.comparing(ProductEntity::getName);
        return CheckSortInList.isSorted(items, sortProducts);
    }

    @Override
    public boolean isFirst() {
        return pageNumber > 0;
    }

    @Override
    public boolean isLast() {
        return this.getNumber() + 1 < this.getTotalPages();
    }

    @Override
    public boolean hasNext() {
        return this.getNumber() + 1 < this.getTotalPages();
    }

    @Override
    public boolean hasPrevious() {
        return this.getNumber() > 0;
    }

    @Override
    public Pageable nextPageable() {
        Pageable currentPageable = PageRequest.of(pageNumber, pageSize, getSort());
        int nextPageNumber = currentPageable.getPageNumber() + 1;
        return PageRequest.of(nextPageNumber, pageSize, currentPageable.getSort());
    }

    @Override
    public Pageable previousPageable() {
        Pageable currentPageable = PageRequest.of(pageNumber, pageSize, getSort());
        if (--pageNumber <= 0) {
            return currentPageable;
        }
        int previousPageNumber = currentPageable.getPageNumber() - 1;
        return PageRequest.of(previousPageNumber, pageSize, currentPageable.getSort());
    }

    @NotNull
    @Override
    public Iterator<ProductEntity> iterator() {
        return items.iterator();
    }

    public String toString() {
        String contentType = "UNKNOWN";
        List<ProductEntity> content = this.getContent();
        if (!content.isEmpty() && content.get(0) != null) {
            contentType = content.get(0).getClass().getName();
        }

        return String.format("Page %s of %d containing %s instances", this.getNumber() + 1, this.getTotalPages(), contentType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof ProductCustomPage)) {
            return false;
        } else {
            ProductCustomPage that = (ProductCustomPage) (obj);
            return this.getTotalPages() == that.getTotalPages() && super.equals(obj);
        }
    }
}
