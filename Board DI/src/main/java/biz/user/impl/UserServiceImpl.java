package biz.user.impl;

import biz.user.UserDTO;
import biz.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    // @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) { // userDAO 객체 Autowired
        this.userDAO = userDAO;
    }

    public UserDTO getUser(UserDTO dto) {
        return userDAO.getUser(dto);
    }
}
