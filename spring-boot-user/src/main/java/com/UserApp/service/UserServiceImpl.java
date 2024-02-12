package com.UserApp.service;

import com.UserApp.common.EmailAlreadyExistsException;
import com.UserApp.common.ResourceNotFoundException;
import com.UserApp.dto.UserDto;
import com.UserApp.model.User;
import com.UserApp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);
        Optional<User> userEmail=repo.findByEmail(user.getEmail());
        if(userEmail.isPresent()){
            throw new EmailAlreadyExistsException("Email Id Already Exist for user");
        }
        User savedUser= repo.save(user);
        UserDto createdUserDto=modelMapper.map(savedUser,UserDto.class);
        return createdUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user=repo.findById(id).orElseThrow(() ->  new ResourceNotFoundException("User","id",id));
        UserDto fetchedUser=modelMapper.map(user, UserDto.class);
        return fetchedUser;
    }

    @Override
    public List<UserDto> getUserData() {
        List<User> users=repo.findAll();

        return users.stream().map((user)-> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser=repo.findById(id).orElseThrow(
                ()->  new ResourceNotFoundException("user","Id",id)
        );

        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        User user=repo.save(existingUser);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User deletedUser= repo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","Id",id)
        );
        repo.deleteById(id);
    }
}
