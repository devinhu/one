package com.sd.one.utils.db.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.sd.one.utils.db.entity.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig demosDaoConfig;

    private final UserDao userDao;
    private final DemosDao demosDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        demosDaoConfig = daoConfigMap.get(DemosDao.class).clone();
        demosDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        demosDao = new DemosDao(demosDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Demos.class, demosDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        demosDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DemosDao getDemosDao() {
        return demosDao;
    }

}
