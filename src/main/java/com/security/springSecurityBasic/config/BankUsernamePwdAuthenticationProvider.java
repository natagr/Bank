package com.security.springSecurityBasic.config;

import com.security.springSecurityBasic.model.Customer;
import com.security.springSecurityBasic.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    final CustomerRepository customerRepository;

    final PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd=authentication.getCredentials().toString();
        List<Customer> customer=customerRepository.findByEmail(username);
        if(customer.size()>0){
            if(passwordEncoder.matches(pwd, customer.get(0).getPwd())){
                List<GrantedAuthority> authorities=new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            }else{
                throw new BadCredentialsException("invalid password");
            }
        }else{
            throw new BadCredentialsException("no user registered with this details");
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
