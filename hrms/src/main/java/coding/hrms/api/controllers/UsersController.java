package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.UserService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController{
    private UserService userService;

    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<User> getById(@PathVariable(value = "id") int id) {
        return this.userService.getById(id);
    }

    @GetMapping("/getByEmail")
    public DataResult<User> getByEmail(@RequestParam(value = "email") String email) {
        return this.userService.getByEmail(email);
    }

    @PostMapping("")
    public Result save(@RequestBody User user) {
        return this.userService.save(user);
    }

    public Result verifyById(int id) {
        return this.userService.verifyById(id);
    }

    public Result verifyByEmail(String email) {
        return this.userService.verifyByEmail(email);
    }
}
