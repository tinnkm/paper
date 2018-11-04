package com.tinnkm.wechat.fileupload.jwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author tinnkm
 * @version 1.0
 * @classname JwtUtils
 * @description jwt工具类
 * @date 2018/11/4 10:11
 **/
public class JwtUtils {

    /**
     * 解析token
     *
     * @param token    token值
     * @param security 私钥值
     * @return
     */
    public static Claims parse(String token, String security) {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(security)).parseClaimsJws(token).getBody();
    }

    /**
     * 生成token
     * @param name
     * @param userId
     * @param role
     * @param audientce
     * @param issuer
     * @param expires
     * @param security
     * @return
     */
    public static String createToken(String name, String userId, String role, String audientce, String issuer, Integer expires, String security) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] secretBytes = DatatypeConverter.parseBase64Binary(security);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("typ", "JWT").claim("role", role).claim("unique_name", name).claim("userId", userId)
                .setIssuer(issuer)
                .setAudience(audientce)
                .signWith(signatureAlgorithm, secretKeySpec);
        if (expires >= 0) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime localDateTime = now.plusSeconds(expires);
            jwtBuilder.setExpiration(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())).setNotBefore(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));
        }

        return jwtBuilder.compact();
    }
}
