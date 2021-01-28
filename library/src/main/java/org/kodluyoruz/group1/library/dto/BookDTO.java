package org.kodluyoruz.group1.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.enums.LanguagesEnum;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends BaseDTO {

    @NotEmpty(message = "Kitap ismi boş bırakılamaz.")
    private String bookName;

    private Long pageNumber;

    @NotEmpty(message = "Yayınevi bilgisi boş bırakılamaz.")
    private String publisherName;

    private Integer editionNumber;

    private Long isbn;

    private LanguagesEnum languagesEnum;

    @NotEmpty(message = "Kitap türü boş bırakılamaz.")
    private String category;

    private StatusEnum status;

    private List<String> authors = new ArrayList<>();

    private Member member;

}
