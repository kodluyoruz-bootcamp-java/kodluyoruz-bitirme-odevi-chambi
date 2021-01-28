//package org.kodluyoruz.group1.library.converter;
//
//import org.kodluyoruz.group1.library.dto.MemberDTO;
//import org.kodluyoruz.group1.library.model.entities.Member;
//import org.kodluyoruz.group1.library.model.entities.Role;
//
//import java.util.List;
//
//public class MemberDTOToMemberConverter  {
//
//
//
//    public Member convert(MemberDTO memberDTO, List<Role> roles) {
//
//        Member member = new Member();
//        member.setFirstName(memberDTO.getFirstName());
//        member.setLastName(memberDTO.getLastName());
//        member.setAdress(memberDTO.getAddress());
//        member.setBirthDate(memberDTO.getBirthDate());
//        member.setEmail(memberDTO.getEmail());
//        member.setPassword(memberDTO.getPassword());
//        member.setMemberStatus(memberDTO.getMemberStatus());
//        member.setPhoneNumber(memberDTO.getPhoneNumber());
//        member.setUserName(memberDTO.getUserName());
//        member.setRoles(roles);
//
//
//        return member;
//    }
//}
