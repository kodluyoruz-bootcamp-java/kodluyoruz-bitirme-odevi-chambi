package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.entities.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberConverter implements IBaseConverter<Member, MemberDTO> {

    private final ModelMapper modelMapper;

    @Override
    public MemberDTO convertToDto(Member entity) {
        return modelMapper.map(entity, MemberDTO.class);
    }

    @Override
    public Member convertToEntity(MemberDTO dto) {
        return modelMapper.map(dto, Member.class);
    }

    public Member convert(MemberDTO memberDTO, List<Role> roles) {

        Member member = new Member();
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setAdress(memberDTO.getAddress());
        member.setBirthDate(memberDTO.getBirthDate());
        member.setEmail(memberDTO.getEmail());
        member.setPassword(memberDTO.getPassword());
        member.setMemberStatus(memberDTO.getMemberStatus());
        member.setPhoneNumber(memberDTO.getPhoneNumber());
        member.setUserName(memberDTO.getUserName());
        member.setRoles(roles);


        return member;
    }
}
