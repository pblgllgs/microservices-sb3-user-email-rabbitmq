package com.pblgllgs.user.service;

import com.pblgllgs.user.entity.UserModel;
import com.pblgllgs.user.dto.UserRecordDto;
import com.pblgllgs.user.producer.UserProducer;
import com.pblgllgs.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    @Transactional
    public UserModel save(UserRecordDto userRecordDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        userModel = userRepository.save(userModel);
        userProducer.publisherMessageEmail(userModel);
        return userModel;
    }
}
