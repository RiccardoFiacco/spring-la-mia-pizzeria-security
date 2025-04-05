package org.exercise.spring_la_mia_pizzeria_crud.configuration;

import java.util.Optional;

import org.exercise.spring_la_mia_pizzeria_crud.model.User;
import org.exercise.spring_la_mia_pizzeria_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            // Se l'utente non viene trovato, lancia un'eccezione
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new DatabaseUserDetails(user.get());// Restituisce un oggetto UserDetails che rappresenta l'utente
                                                   // trovato
    }
}
