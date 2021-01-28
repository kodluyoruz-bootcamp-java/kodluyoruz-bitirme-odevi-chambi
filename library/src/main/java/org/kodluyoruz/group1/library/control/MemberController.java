package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.service.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final IMemberService memberService;

    @GetMapping("/member")
    public List<Member> getAll() {
        return memberService.getAll();
    }

    @PostMapping("/new-record")
    public Member create(@RequestBody @Valid MemberDTO memberDTO) {
        return memberService.create(memberDTO);
    }

    @PutMapping
    public Member update(Long id, @RequestBody @Valid MemberDTO memberDTO) {
        return memberService.update(id, memberDTO);
    }

    @PutMapping("/new-password/{id}")
    ResponseEntity<Member> password(@RequestBody @Valid MemberDTO memberDTO, @PathVariable Long id) {
        Member m = memberService.updatePassword(id, memberDTO);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id)  {
        return memberService.getById(id);
    }

    @PutMapping("/delete/{id}")
    public Member delete(@PathVariable Long id)  {
        return memberService.delete(id);
    }

    @PutMapping("/member-status/{id}")
    public Member updateMemberStatus(@PathVariable Long id, @RequestBody @Valid MemberDTO memberDTO)  {
        return memberService.updateMemberStatus(id, memberDTO);
    }

    @PutMapping("/take-book/{id}")
    public Member takeBook(@PathVariable Long id)  {
        return memberService.takeBook(id);
    }

}
