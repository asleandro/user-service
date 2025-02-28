import com.projeto.user_service.model.User;
import com.projeto.user_service.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTests {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveAndRetrieveUser() {
        User user = new User();
        user.setNome("Leandro");
        user.setEmail("leandro@email.com");

        userRepository.save(user);

        User foundUser = userRepository.findById(user.getId()).orElse(null);
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getNome()).isEqualTo("Leandro");
    }

    @Test
    public void shouldReturnUserList() {
        User user1 = new User();
        user1.setNome("Leandro");
        user1.setEmail("leandro@email.com");

        User user2 = new User();
        user2.setNome("Ingrid");
        user2.setEmail("ingrid@email.com");

        List<User> users = userRepository.findAll();
        assertThat(users).extracting(User::getNome).contains("Leandro", "Ingrid");
    }
}
