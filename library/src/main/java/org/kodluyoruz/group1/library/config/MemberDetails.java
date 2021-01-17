package org.kodluyoruz.group1.library.config;

import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class MemberDetails implements UserDetails {


    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Long phoneNumber;
    private String adress;
    private Date birthDate;
    private Date createDate;
    private Date updateDate;
    private StatusEnum memberStatus;
    private List<GrantedAuthority> authorities;


    public MemberDetails(Member member) {
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.userName = member.getUserName();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.phoneNumber = member.getPhoneNumber();
        this.adress = member.getAdress();
        this.birthDate = member.getBirthOfDate();
        this.createDate = member.getCreateDate();
        this.updateDate = member.getUpdateDate();
        this.memberStatus = member.getMemberStatus();
        this.authorities = Arrays.stream(member.getMemberRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (memberStatus == StatusEnum.ACTIVE){
            return true;
        }else {
            return false;
        }
    }
}
