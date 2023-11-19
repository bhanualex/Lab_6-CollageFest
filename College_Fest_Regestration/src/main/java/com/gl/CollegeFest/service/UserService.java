package com.gl.CollegeFest.service;

import com.gl.CollegeFest.dto.UserRegistrationDto;
import com.gl.CollegeFest.entity.User;

public interface UserService {
	public User save(UserRegistrationDto registrationDto);


}
