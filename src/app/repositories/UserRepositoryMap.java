package app.repositories;

import app.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryMap implements UserRepository{

    private Map<Integer, User> users = new HashMap<>();
    private int currentId;

    @Override
    public void save(User entity) {
        entity.setId(++currentId);
        users.put(currentId, entity);
    }

    @Override
    public User findById(int id) {
//        TODO homework
        return this.users.get(id) ;
    }

    @Override
    public List<User> findAll() {
//        TODO homework
        return new ArrayList<User>(this.users.values());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public User findByEmail(String email) {

        for ( Map.Entry<Integer, User> entry: this.users.entrySet() ) {
            if (entry.getValue().getEmail().equals(email) ) {
                return entry.getValue();
            }
        }
        
        return null;
    }
}
