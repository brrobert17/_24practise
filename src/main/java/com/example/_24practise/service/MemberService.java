package com.example._24practise.service;

import com.example._24practise.entity.Member;
import com.example._24practise.repo.MemberRepo;
import com.example._24practise.service.exception.MemberNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    final MemberRepo memberRepo;


    public Member create(Member member) {
        return memberRepo.save(member);
    }

    public Member getById(Integer id) throws MemberNotFoundException {
        return memberRepo.findById(id).orElseThrow(() -> new MemberNotFoundException("member not found by id: " + id));
    }

    public List<Member> getAll() {
        return memberRepo.findAll();
    }

    public Member update(Integer id, Member member) throws MemberNotFoundException {
        memberRepo.findById(id).orElseThrow(() -> new MemberNotFoundException("member not found by id: " + id));
        return memberRepo.save(member);
    }

    public void del(Integer id) throws MemberNotFoundException {
        memberRepo.findById(id).orElseThrow(() -> new MemberNotFoundException("member not found by id: " + id));
        memberRepo.deleteById(id);
    }
}
