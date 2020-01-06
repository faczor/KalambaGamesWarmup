package com.kalamba.warmup.controller;

import com.kalamba.warmup.exception.GameNotFoundException;
import com.kalamba.warmup.exception.UserNotFoundException;
import com.kalamba.warmup.model.Action;
import com.kalamba.warmup.model.Game;
import com.kalamba.warmup.model.NewActionDto;
import com.kalamba.warmup.model.User;
import com.kalamba.warmup.repository.ActionRepository;
import com.kalamba.warmup.repository.GameRepository;
import com.kalamba.warmup.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class WarmupController {

    private static final String LOG_MESSAGE_SUCCES = "New action created";

    private final UserRepository userRepository;

    private final GameRepository gameRepository;

    private final ActionRepository actionRepository;

    public WarmupController(UserRepository userRepository, GameRepository gameRepository, ActionRepository actionRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.actionRepository = actionRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/newAction")
    public ResponseEntity makeAction(@RequestBody NewActionDto newActionDto) throws UserNotFoundException, GameNotFoundException {
        System.out.println(newActionDto.getUserId() + ", " + newActionDto.getGameId() + ", " + newActionDto.getAction());
        Optional<User> optionalUser = userRepository.findById(newActionDto.getUserId());
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id: " + newActionDto.getUserId() + " not found");
        }
        Optional<Game> gameOptional = gameRepository.findById(newActionDto.getUserId());
        if(gameOptional.isEmpty()) {
            throw new GameNotFoundException("Game with id: " + newActionDto.getGameId() + " not found");
        }
        actionRepository.save(new Action(newActionDto.getAction(), optionalUser.get(), gameOptional.get()));
        return ResponseEntity.ok(LOG_MESSAGE_SUCCES);
    }
}
