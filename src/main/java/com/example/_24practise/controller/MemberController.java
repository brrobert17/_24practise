package com.example._24practise.controller;

import com.example._24practise.entity.Member;
import com.example._24practise.service.MemberService;
import com.example._24practise.service.exception.MemberNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {

    final MemberService memberService;

    @GetMapping
    public List<Member> getAll (){
        return memberService.getAll();
    }

    @GetMapping("{id}")
    public Member getById(@PathVariable Integer id) throws MemberNotFoundException {
        return memberService.getById(id);
    }

    @PostMapping
    public Member create(@RequestBody Member member) {
        return memberService.create(member);
    }

    @PutMapping("{id}")
    public Member update(@PathVariable Integer id, @RequestBody Member member) throws MemberNotFoundException {
        return memberService.update(id, member);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable Integer id) throws MemberNotFoundException {
        memberService.del(id);
    }

}
