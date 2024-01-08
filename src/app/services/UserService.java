package app.services;

import app.domain.User;
import app.repositories.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser (String email, String password) {

        // TODO check parameters isNull & isEmpty
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email should contain @");
        }

//        TODO check if email Exists in BD
        if (repository.findByEmail(email).getId() != 0 ) {
            throw  new IllegalArgumentException("User exists");
        }

        repository.save(new User(email, password));
    }

//    TODO get One and All Users

    public User getUserById ( int id ) {
        User user = repository.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Id doesn't exists");
        }
        return user ;
    }

    public List<User> getAllUsers () {
        return repository.findAll();
    }
}
