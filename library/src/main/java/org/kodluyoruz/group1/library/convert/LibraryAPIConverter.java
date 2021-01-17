package org.kodluyoruz.group1.library.convert;

public interface LibraryAPIConverter<T,R> {

    R convert (T input);

}
