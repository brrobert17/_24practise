package com.example._24practise.repo;

import com.example._24practise.entity.Member;
import com.example._24practise.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {
}
