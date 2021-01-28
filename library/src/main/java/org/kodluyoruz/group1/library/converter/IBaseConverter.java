package org.kodluyoruz.group1.library.converter;

public interface IBaseConverter<E, D> {

    D convertToDto(E book);

    E convertToEntity(D dto);
}
