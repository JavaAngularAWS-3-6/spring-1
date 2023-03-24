package MyApp.Repository;

import MyApp.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
//    select * from user where username = ?
//    from user where username = :username
    Account findUserByUsername(String username);
}
