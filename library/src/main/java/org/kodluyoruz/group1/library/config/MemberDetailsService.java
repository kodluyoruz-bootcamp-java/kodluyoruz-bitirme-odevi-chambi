package org.kodluyoruz.group1.library.config;

import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberDetailsService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByUserName(userName);

        member.orElseThrow(() -> new UsernameNotFoundException("Not Found:" + userName));

        return member.map(MemberDetails:: new).get();


    }
}
