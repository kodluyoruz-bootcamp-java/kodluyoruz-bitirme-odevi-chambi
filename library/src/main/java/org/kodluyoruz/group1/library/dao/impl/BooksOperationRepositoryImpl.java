package org.kodluyoruz.group1.library.dao.impl;


import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.kodluyoruz.group1.library.dao.BooksOperationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BooksOperationRepositoryImpl implements BooksOperationRepository {

    private final EntityManager entityManager;


    protected Session getSession(){
        return entityManager.unwrap(Session.class);
    }

    @Override
    public boolean hasExistSameBookIsbn(Long bookIsbn) {
        Long result = getSession()
                .createQuery("SELECT COUNT (*) FROM Books WHERE isbn=:givenIsbn", Long.class)
                .setParameter("givenIsbn", bookIsbn)
                .uniqueResult();
        return result >0;
    }


    //aynı barkod numarası var mı onun kontrolünü yapıyoruz


}


