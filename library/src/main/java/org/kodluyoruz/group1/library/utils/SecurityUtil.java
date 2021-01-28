package org.kodluyoruz.group1.library.utils;

import lombok.Data;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.service.IMemberService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Data
public final class SecurityUtil {

    private static IMemberService memberService;

    public SecurityUtil(IMemberService memberService) {
        this.memberService = memberService;
    }

    public static String getCurrentUsername() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication == null || authentication.getPrincipal() == null) {
            return null;
        } else {
            return ((Member) authentication.getPrincipal()).getUserName();
        }
    }

    public static Member getCurrentUser() {

        String currentUsername = getCurrentUsername();

        if (currentUsername == null) {
            return null;
        } else {

            return memberService.findByUserName(currentUsername);
        }
    }
}

