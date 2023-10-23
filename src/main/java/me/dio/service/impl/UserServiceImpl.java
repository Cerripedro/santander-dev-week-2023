package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User created(User userToCreated) {
        if (userRepository.existsByAccountNumber(userToCreated.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreated);
    }

    @Override
    public User deleteById(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return user;
        }).orElseThrow(NoSuchElementException::new);
    }

}
