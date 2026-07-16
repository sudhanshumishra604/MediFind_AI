package com.sudhanshu.medifind.auth.service;

import com.sudhanshu.medifind.auth.dto.LoginRequest;
import com.sudhanshu.medifind.auth.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);
}
