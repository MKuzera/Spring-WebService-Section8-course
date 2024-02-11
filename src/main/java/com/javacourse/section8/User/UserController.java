package com.javacourse.section8.User;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.javacourse.section8.Exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

        User user = new User(0,"Mateusz","Kuzera", LocalDate.now().minusDays(1));
        User user1 = new User(1,"Mateusz2","Kuzera2", LocalDate.now().minusDays(1));
        User user2 = new User(2,"Mateusz3","Kuzera3", LocalDate.now().minusDays(1));
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user1);

    }

    @GetMapping(value = "/webusers/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id{" + id+"} not found"));
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder= linkTo(methodOn(this.getClass()).getListOfUsers());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;

    }

    @GetMapping(value = "/webusers")
    public List<User> getListOfUsers(){
        return userRepository.findAll();
    }
    @DeleteMapping(value = "/webusers/{iduser}")
    public void deleteUser(@PathVariable int iduser){

        Optional<User> referenceById = userRepository.findById(iduser);
        if(referenceById.isPresent()){
            userRepository.deleteById(iduser);
        }
        else{
            throw new UserNotFoundException(String.format("User of id: %x not found" , iduser));
        }
    }

    @PostMapping(value="/webusers")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User save = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }



}
