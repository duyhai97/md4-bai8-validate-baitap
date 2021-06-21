package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
}
