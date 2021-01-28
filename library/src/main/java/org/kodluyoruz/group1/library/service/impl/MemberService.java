package org.kodluyoruz.group1.library.service.impl;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.converter.BookConverter;
import org.kodluyoruz.group1.library.converter.MemberConverter;
import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.dao.RoleRepository;
import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.exceptions.AlreadyExistException;
import org.kodluyoruz.group1.library.exceptions.MemberNotFoundException;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.entities.Role;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;
import org.kodluyoruz.group1.library.service.IMemberService;
import org.kodluyoruz.group1.library.utils.SecurityUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements IMemberService {

    private final MemberRepository memberRepository;
    private final MemberConverter memberConverter;
    private final BookService bookService;
    private final BookConverter bookConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member create(MemberDTO memberDTO)   {
        String encodedPassword = bCryptPasswordEncoder.encode(memberDTO.getPassword());
        memberDTO.setPassword(encodedPassword);

        if (memberRepository.existsByUserNameAndDeleted(memberDTO.getUserName(), false)) {
            throw new AlreadyExistException("Bu username kullanılmakta!");
        }
        if (memberRepository.existsByEmailAndDeleted(memberDTO.getEmail(), false)) {
            throw new AlreadyExistException("Bu email kullanılmakta, Lütfen başka bir email ile kayıt olunuz!!");
        }

        List<Role> roles = new ArrayList<>();
        for (String role : memberDTO.getRoles()) {
            roles.add(roleRepository.findByRoleName(role));
        }
        Member member= memberConverter.convert(memberDTO, roles);
        return memberRepository.save(member);
    }

    @Override
    public Member updatePassword(Long id, MemberDTO memberDTO) {
        Member prevMember = memberRepository.findById(id).orElseThrow(null);
        if (prevMember == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(memberDTO.getPassword());
        prevMember.setPassword(encodedPassword);

        return memberRepository.save(prevMember);
    }

    @Override
    public Member updateMemberStatus(Long id, MemberDTO memberDTO) {
        Member prevMember = memberRepository.findById(id).orElse(null);
        if (prevMember == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!!");
        }
        prevMember.setMemberStatus(StatusEnum.PASSIVE);
        memberRepository.save(prevMember);
        return prevMember;
    }

    public Member update(Long id, MemberDTO memberDTO) {

        Member prevMember = memberRepository.findById(id).orElse(null);
        if (prevMember == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!!");
        }
        if (memberRepository.existsByUserNameAndDeleted(memberDTO.getUserName(), false)
                && !id.equals(prevMember.getId())) {
            throw new AlreadyExistException("Bu userName kullanılmakta Lütfen başka bir userName giriniz");
        }
        if (memberRepository.existsByEmailAndDeleted(memberDTO.getEmail(),false) && !id.equals(prevMember.getId())) {
            throw new AlreadyExistException("Bu email zaten var!");
        }

        prevMember.setEmail(memberDTO.getEmail());
        prevMember.setUserName(memberDTO.getUserName());
        prevMember.setPassword(memberDTO.getPassword());
        prevMember.setPhoneNumber(memberDTO.getPhoneNumber());
        prevMember.setBirthDate(memberDTO.getBirthDate());
        prevMember.setMemberStatus(memberDTO.getMemberStatus());
        prevMember.setAdress(memberDTO.getAddress());
        prevMember.setFirstName(memberDTO.getFirstName());
        prevMember.setLastName(memberDTO.getLastName());
        prevMember.setDeleted(memberDTO.isDeleted());

        return memberRepository.save(prevMember);
    }

    @Override
    public Member getById(Long id) {

        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }
        return member;
    }

    @Override
    public Member delete(Long id)  {

        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }
        member.setDeleted(true);
        return member;
    }

    @Override
    public Member takeBook(Long bookId) {
        Member currentUser = SecurityUtil.getCurrentUser();
        if (currentUser == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }
        Book book = bookConverter.convertToEntity(bookService.getBookById(bookId));
        currentUser.setBooks(Collections.singletonList(book));
        return currentUser;
    }


    @Override
    public Member findByUserName(String userName) {
        return memberRepository.findByUserName(userName).orElseThrow(MemberNotFoundException::new);
    }
}
