package org.system.onlineelection;

import org.junit.jupiter.api.Test;
import org.system.onlineelection.application.service.UserDetailsImpl;
import org.system.onlineelection.domain.model.Person;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class UserDetailsImplTest {

    @Test
    void testEqualsAndHashCode() {
        // Crear dos instancias con el mismo ID
        UserDetailsImpl user1 = new UserDetailsImpl("1", "username", "password", Collections.emptyList());
        UserDetailsImpl user2 = new UserDetailsImpl("1", "differentUsername", "differentPassword", Collections.emptyList());

        // Verificar que equals funciona correctamente
        assertThat(user1.equals(user2)).isTrue();
        assertThat(user2.equals(user1)).isTrue();

        // Verificar que hashCode funciona correctamente
        assertThat(user1.hashCode()).isEqualTo(user2.hashCode());
    }

    @Test
    void testNotEquals() {
        // Crear dos instancias con IDs diferentes
        UserDetailsImpl user1 = new UserDetailsImpl("1", "username", "password", Collections.emptyList());
        UserDetailsImpl user2 = new UserDetailsImpl("2", "differentUsername", "differentPassword", Collections.emptyList());

        // Verificar que equals funciona correctamente
        assertThat(user1.equals(user2)).isFalse();
        assertThat(user2.equals(user1)).isFalse();

        // Verificar que hashCode funciona correctamente
        assertThat(user1.hashCode()).isNotEqualTo(user2.hashCode());
    }

    @Test
    void testNotEqualsWithDifferentClass() {
        // Crear una instancia UserDetailsImpl y otra instancia de otra clase
        UserDetailsImpl user = new UserDetailsImpl("1", "username", "password", Collections.emptyList());
        Person person = new Person();

        // Verificar que equals devuelve false cuando se compara con una instancia de otra clase
        assertThat(user.equals(person)).isFalse();
    }
}
