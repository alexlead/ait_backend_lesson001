package app.controllers;

import app.domain.User;
import app.services.UserService;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private Scanner scanner;

    private UserService service;

    public UserController(Scanner scanner, UserService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void addUser () {
        System.out.println("Enter e-mail:");
        String email = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        service.addUser(email, password);
    }


    public void getUserById () {
        System.out.println("Enter user Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println( service.getUserById(id));
    }

    public void getAllUsers () {
        List<User> users = service.getAllUsers();
        for( User user : users ) {
            System.out.println(user);
        }
    }

//    TODO get One user from DB
//    TODO (Id from Client via Console)
//    TODO get all users
//    TODO result show in console

}

