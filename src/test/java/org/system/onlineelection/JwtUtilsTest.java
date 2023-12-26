package org.system.onlineelection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.system.onlineelection.application.service.UserDetailsImpl;
import org.system.onlineelection.infrastructure.adapter.jwt.JwtUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JwtUtilsTest {

    @InjectMocks
    private JwtUtils jwtUtils;

    private UserDetailsImpl mockUserDetails;

    @Before
    public void setUp() {
        mockUserDetails = createMockUserDetails();
    }

    @After
    public void tearDown() {
        // Realizar limpieza después de cada prueba si es necesario
    }

    @Test
    public void testGenerateJwtToken() {
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(mockUserDetails);

        String token = jwtUtils.generateJwtToken(authentication);

        assertNotNull(token);
        assertTrue(jwtUtils.validateJwtToken(token));
        assertEquals("testuser", jwtUtils.getUsernameFromJwtToken(token));
    }

    @Test
    public void testGenerateJwtTokenWithClaims() {
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(mockUserDetails);

        Map<String, Object> claims = new HashMap<>();
        claims.put("key", "value");

        String token = jwtUtils.generateJwtToken(authentication, claims);

        assertNotNull(token);
        assertTrue(jwtUtils.validateJwtToken(token));
        assertEquals("testuser", jwtUtils.getUsernameFromJwtToken(token));
    }

    @Test
    public void testValidateJwtTokenValidToken() {
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(mockUserDetails);

        String token = jwtUtils.generateJwtToken(authentication);

        assertTrue(jwtUtils.validateJwtToken(token));
    }

    @Test
    public void testValidateJwtTokenInvalidToken() {
        assertFalse(jwtUtils.validateJwtToken("invalidToken"));
    }

    private UserDetailsImpl createMockUserDetails() {
        return new UserDetailsImpl("1", "testuser", "testpassword", null);
    }
}
