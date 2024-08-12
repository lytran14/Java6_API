package lyttpc05561.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import lyttpc05561.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> { 

}
