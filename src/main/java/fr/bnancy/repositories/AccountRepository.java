package fr.bnancy.repositories;

import fr.bnancy.model.account.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bertrand on 30/06/17.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountByMail(String email);
    Account findByToken(String token);
}
