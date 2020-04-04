package com.ahmethkaya.issuemanagement.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TPage<T> {

    private int number; //kaçıncı sayfa görünüyor

    private int size; //kayıtları kaçarlı gösteriyor

    private Sort sort; //kolona tıklayıp sıralamak için

    private int totalPages; //toplam sayfa sayısı

    private Long totalElements; //toplam element sayısı

    private List<T> content;

    public void setStat(Page page, List<T> list) {

        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;
    }

}
