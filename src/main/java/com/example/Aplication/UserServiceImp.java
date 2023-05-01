package com.example.Aplication;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users saveUser(Users user){
        return userRepository.save(user);
    }

    @Override
    public List<Users> fetchUserList(){
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public Users updateUser(Users user, Long userId) {
        Users depDB = userRepository.findById(userId.intValue()).get();

        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
            depDB.setName(user.getName());
        }

        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
            depDB.setEmail(user.getEmail());
        }

        if (Objects.nonNull(user.getCif()) && !"".equalsIgnoreCase(user.getCif())) {
            depDB.setCif(user.getCif());
        }

        return userRepository.save(depDB);
    }

    @Override
    public Users findUser(Long id){
        return userRepository.findById(id.intValue()).get();
    }

    @Override
    public void deleteUserById(Long userId){
        userRepository.deleteById(userId.intValue());
    }

    @Override
    public Users findEmail(String email, String password){
        List<Users> users = (List<Users>) userRepository.findAll();
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail() == email && users.get(i).getPassword() == password){
                return users.get(i);
            }
        }
        return null;
    }
}
