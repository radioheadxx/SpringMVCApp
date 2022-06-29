package mvc.service;

import mvc.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long id);

    public User findById(Long id);
}
