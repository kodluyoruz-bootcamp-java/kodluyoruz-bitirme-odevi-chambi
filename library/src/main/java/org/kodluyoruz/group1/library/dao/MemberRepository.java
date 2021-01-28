package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserName(String userName);

    boolean existsByUserNameAndDeleted(String userName, boolean deleted);

    boolean existsByEmailAndDeleted(String email , boolean deleted);
}
