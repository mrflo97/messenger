package com.fwindhagauer.messenger.services;

import com.fwindhagauer.messenger.entitiy.PrivateMessage;
import com.fwindhagauer.messenger.repository.PrivateMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class PrivateMessageService extends BaseService<PrivateMessage, PrivateMessageRepository> {
}
