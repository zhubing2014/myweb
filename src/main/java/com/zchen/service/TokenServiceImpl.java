package com.zchen.service;

import com.zchen.dao.TokenDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @author Zhouce Chen
 * @version Nov 20, 2013
 */
@Service
public class TokenServiceImpl implements TokenService {
    private static final Logger logger = Logger.getLogger(TokenServiceImpl.class);

    @Resource
    TokenDao tokenDao;

    @Override
    public void refreshTokens() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 5);
        tokenDao.deleteBeforeTime(calendar.getTime());
    }
}
