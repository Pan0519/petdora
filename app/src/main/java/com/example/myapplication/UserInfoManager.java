package com.example.myapplication;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserInfoManager {
    static UserInfoManager infoManager;

    List<userInfo> userInfos = new ArrayList<>();

    public static UserInfoManager getInstance() {
        if (null == infoManager) {
            infoManager = new UserInfoManager();
        }

        return infoManager;
    }

    public void SetUserInfos(QuerySnapshot snapshots) {
        for (QueryDocumentSnapshot document : snapshots) {
            userInfos.add(new userInfo(document));
        }
    }

    public List<userInfo> GetUserInfos() {
        return userInfos;
    }

    public userInfo GetUserInfoByUid(long uid) {
        Iterator<userInfo> infoIterator = userInfos.iterator();

        while (infoIterator.hasNext()) {
            userInfo info  = infoIterator.next();
            if(info.getUid()==uid)
            {
                return info;
            }
        }

        return null;
    }
}

class userInfo {
    String mail;
    String name;
    String pwd;
    Long uid;

    public userInfo(QueryDocumentSnapshot info) {
        uid = info.getLong("uid");
        mail = info.getString("email");
        pwd = info.getString("pwd");
        name = info.getString("name");
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public Long getUid() {
        return uid;
    }
}


