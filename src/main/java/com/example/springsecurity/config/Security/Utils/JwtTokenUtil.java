package com.example.springsecurity.config.Security.Utils;

import com.example.springsecurity.config.ConnectionFactory;
import lombok.Data;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtTokenUtil {


  @Autowired
  private ConnectionFactory connectionFactory;

    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_ROLE = "role";
    static final String CLAIM_KEY_CREATED = "created";



  private String gerarToken(Map<String, Object> claims) {
    return Jwts.builder().setClaims(claims).setExpiration(gerarDataExpiracao())
            .signWith(SignatureAlgorithm.HS512, connectionFactory.getSecret()).compact();
  }

  public String obterToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
    userDetails.getAuthorities().forEach(
            authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
    claims.put(CLAIM_KEY_CREATED, new Date());
    return gerarToken(claims);
  }

  public Date getExpirationDateFromToken(String token) {
    Date expiration;
    try {
      Claims claims = getClaimsFromToken(token);
      expiration = claims.getExpiration();
    } catch (Exception e) {
      expiration = null;
    }
    return expiration;
  }

  public String refreshToken(String token) {
    String refreshedToken;
    try {
      Claims claims = getClaimsFromToken(token);
      claims.put(CLAIM_KEY_CREATED, new Date());
      refreshedToken = gerarToken(claims);
    } catch (Exception e) {
      refreshedToken = null;
    }
    return refreshedToken;
  }
  public boolean tokenValido(String token) {
    return !tokenExpirado(token);
  }

  private boolean tokenExpirado(String token) {
    Date dataExpiracao = this.getExpirationDateFromToken(token);
    if (dataExpiracao == null) {
      return false;
    }
    return dataExpiracao.before(new Date());
  }

    private Claims getClaimsFromToken(String token) {

    Claims claims;
    try {
      claims = Jwts.parser().setSigningKey(connectionFactory.getSecret())
              .parseClaimsJws(token).getBody();
    } catch (Exception e) {
      claims = null;
    }
    return claims;
  }

  public String getUsernameFromToken(String token) {
    String username;
    try {
      Claims claims = getClaimsFromToken(token);
      username = claims.getSubject();
    } catch (Exception e) {
      username = null;
    }
    return username;
  }
  public Date gerarDataExpiracao(){
    Long currentDate = System.currentTimeMillis();
    return new Date(System.currentTimeMillis() + connectionFactory.getExpiration() * 1000);
  }

}
