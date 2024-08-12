package lyttpc05561.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lyttpc05561.Exception.ResourceNotFoundException;
import lyttpc05561.Model.User;
import lyttpc05561.Reponsitory.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User getUsersByID(@PathVariable int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found wiht id " + id));
	}

	@PostMapping
	public User createUsers(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/{id}")
	public User updateUsers(@PathVariable int id, @RequestBody User user) {
		User user2 = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found wiht id " + id));
		user2.setUsersId(user.getUsersId());
		user2.setFullName(user.getFullName());
		user2.setUsername(user.getUsername());
		user2.setPassword(user.getPassword());
		user2.setGender(user.getGender());
		user2.setBirthDate(user.getBirthDate());
		user2.setEmail(user.getEmail());
		user2.setPhone(user.getPhone());
		user2.setProfileImage(user.getProfileImage());
		user2.setRoleId(user.getRoleId());
		user2.setStatusId(user.getStatusId());
		return userRepository.save(user2);
	}
	@DeleteMapping("/{id}")
	public void deleteUsers(@PathVariable int id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found wiht id " + id));
		userRepository.delete(user);
	}
}
