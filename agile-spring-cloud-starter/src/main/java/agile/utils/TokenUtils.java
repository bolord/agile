package agile.utils;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.github.jhipster.config.JHipsterProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class TokenUtils {

    private final Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    private static final String AUTH_HEADER = "Authorization";

    private static final String AUTH_BEARER = "Bearer";

    public static final String COOKIE_NAME = "token";

    private String secretKey;

    private long tokenValidityInMilliseconds;

    private long tokenValidityInMillisecondsForRememberMe;

    private final JHipsterProperties jHipsterProperties;

    public TokenUtils(JHipsterProperties jHipsterProperties) {
        this.jHipsterProperties = jHipsterProperties;
    }

    @PostConstruct
    public void init() {
        this.secretKey =
            jHipsterProperties.getSecurity().getAuthentication().getJwt().getSecret();

        this.tokenValidityInMilliseconds =
            1000 * jHipsterProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSeconds();
        this.tokenValidityInMillisecondsForRememberMe =
            1000 * jHipsterProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSecondsForRememberMe();
    }

    /**
     * 构建 Token
     * @param uid	userId
     * @param rememberMe		是否延长有效时间
     * @return
     */
    public String createToken(long uid, boolean rememberMe) {
        long now = System.currentTimeMillis();
        Date validity;
        if (rememberMe) {
            validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
        } else {
            validity = new Date(now + this.tokenValidityInMilliseconds);
        }

        String token = Jwts.builder()
        		.claim("uid", uid)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setExpiration(validity)
                .compact();

        return token;
    }

    /**
     * 构建 Token
     * @param uid	userId
     * @param data	附加数据
     * @param rememberMe		是否延长有效时间
     * @return
     */
    public String createToken(long uid, Map<String, Object> data, boolean rememberMe) {
        long now = System.currentTimeMillis();
        Date validity;
        if (rememberMe) {
            validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
        } else {
            validity = new Date(now + this.tokenValidityInMilliseconds);
        }

        String token = Jwts.builder()
        		.claim("uid", uid)
                .addClaims(data)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setExpiration(validity)
                .compact();

        return token;
    }

    /**
     * 从 request 请求中获取 token
     * @param request
     * @return
     */
    public String getToken(HttpServletRequest request) {
        String header = request.getHeader(AUTH_HEADER);

        if (StringUtils.isBlank(header)) {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (StringUtils.equals(COOKIE_NAME, cookie.getName())) {
                        return cookie.getValue();
                    }
                }
            }

            return null;
        }

        return StringUtils.substring(header, AUTH_BEARER.length() + 1);
    }

    /**
     * 解析 Token
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        if (validateToken(token)) {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } else {
            return null;
        }
    }

    /**
     * 解析 Token
     * @param request HttpServletRequest
     * @throws ExpiredJwtException 过期
     * @throws UnsupportedJwtException 不支持
     * @throws MalformedJwtException 无效
     * @throws SignatureException 签名错误
     * @throws IllegalArgumentException 非法参数
     */
    public Claims parseToken(HttpServletRequest request)
            throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException, IllegalArgumentException {
        String token = getToken(request);

        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    /**
     * 校验 Token 有效性
     * @param token
     * @return
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.info("Invalid JWT signature.");
            logger.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {
            logger.info("Invalid JWT token.");
            logger.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            logger.info("Expired JWT token.");
            logger.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.info("Unsupported JWT token.");
            logger.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            logger.info("JWT token compact of handler are invalid.");
            logger.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }

    public long getTokenValidityInMilliseconds() {
        return tokenValidityInMilliseconds;
    }

    public void setTokenValidityInMilliseconds(long tokenValidityInMilliseconds) {
        this.tokenValidityInMilliseconds = tokenValidityInMilliseconds;
    }

    public long getTokenValidityInMillisecondsForRememberMe() {
        return tokenValidityInMillisecondsForRememberMe;
    }

    public void setTokenValidityInMillisecondsForRememberMe(long tokenValidityInMillisecondsForRememberMe) {
        this.tokenValidityInMillisecondsForRememberMe = tokenValidityInMillisecondsForRememberMe;
    }
}
