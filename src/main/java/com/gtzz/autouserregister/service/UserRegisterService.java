package com.gtzz.autouserregister.service;

import com.gtzz.autouserregister.config.DataConfig;
import com.gtzz.autouserregister.dao.GrantRepository;
import com.gtzz.autouserregister.dao.UserAccountRepository;
import com.gtzz.autouserregister.dao.UserRepository;
import com.gtzz.autouserregister.model.Grant;
import com.gtzz.autouserregister.model.User;
import com.gtzz.autouserregister.model.UserAccount;
import com.gtzz.autouserregister.service.iservice.IUserRegisterService;
import com.gtzz.autouserregister.utils.AuthStringUtil;
import com.gtzz.autouserregister.utils.EncryptUtil;
import com.gtzz.autouserregister.utils.SnowflakeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UserRegisterService implements IUserRegisterService {

    @Autowired
    private GrantRepository grantRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SnowflakeFactory snowflakeFactory;
    @Autowired
    private DataConfig dataConfig;

    @Override
    public void userRegister(String phoneNumber) {
        User user = new User();
        UserAccount userAccount = new UserAccount();
        Grant grant = new Grant();
        Long userId = getId();
        Date now = new Date();

        user.setUserId(userId);
        user.setSex(1);
        user.setAvatar("defaultAvatar");
        user.setName(AuthStringUtil.getStringRandom("8"));
        user.setCreateTime(now);
        user.setUpdateTime(now);

        userAccount.setUserAccountId(getId());
        userAccount.setUserId(userId);
        userAccount.setAccountType("phone");
        userAccount.setLoginType(3);
        userAccount.setIdentifier(phoneNumber);
        userAccount.setCredential(EncryptUtil.MD5(phoneNumber));
        userAccount.setCreateTime(now);
        userAccount.setUpdateTime(now);

        grant.setGrantId(getId());
        grant.setDutiesId(dataConfig.getDutiesId());
        grant.setTenantId(dataConfig.getTenantId());
        grant.setGrantAdmin(0);
        grant.setUserId(userId);
        grant.setState(1);
        grant.setDefaul(1);
        grant.setCreateTime(now);
        grant.setUpdateTime(now);

        userRepository.save(user);
        userAccountRepository.save(userAccount);
        grantRepository.save(grant);
    }

    private List<Long> generateIds(Integer count) {
        List<Long> ids = new ArrayList();
        count = count == null ? 1 : count;
        for (int i = 0; i < count; i++) {
            long id = snowflakeFactory.nextId();
            ids.add(id);
        }
        return ids;
    }

    private Long getId() {
        return generateIds(1).get(0);
    }
}
