package com.example.apf.service;

import com.example.apf.Entity.Member;
import com.example.apf.Entity.Role;
import com.example.apf.Repository.MemberRepository;
import com.example.apf.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roleRepository.findAll()) {
            if (role.getUserId().equals(userId)) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
            }
        }
        return new User(member.getUserId(), member.getPassword(), grantedAuthorities);
    }
}
