package biz.user.impl;

import biz.user.UserDTO;
import biz.user.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDTO getUser(UserDTO dto) {
        return userDAO.getUser(dto);
    }
}
