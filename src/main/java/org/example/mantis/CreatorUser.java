package org.example.mantis;

import org.example.mantis.entities.MantisUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

public class CreatorUser {
    public MantisUser getUser(Integer level) throws NoSuchAlgorithmException {
        MantisUser mantisUser = new MantisUser();
        mantisUser.setId(new Random().nextInt(999999));
        mantisUser.setUsername(UUID.randomUUID().toString().substring(0,10));
        mantisUser.setRealname("John Doe");
        mantisUser.setEmail(UUID.randomUUID().toString().substring(0,10) + "@lee.com");
        StringBuilder sb = new StringBuilder();
        String password = UUID.randomUUID().toString().substring(0,10);
        for(byte b : MessageDigest.getInstance("MD5").digest(password.getBytes())){
            sb.append(String.format("%02x", b));
        }
        mantisUser.setPassword(sb.toString());
        mantisUser.setEnabled(1);
        mantisUser.setIsProtected(0);
        mantisUser.setAccessLevel(level);
        mantisUser.setLoginCount(0);
        mantisUser.setLostPasswordRequestCount(0);
        mantisUser.setFailedLoginCount(0);
        mantisUser.setCookieString(UUID.randomUUID().toString().substring(0,10));
        mantisUser.setLastVisit(3123124);
        mantisUser.setDateCreated(12521512);
        return mantisUser;
    }
}
