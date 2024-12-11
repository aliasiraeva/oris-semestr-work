package com.oris_first_semestr_work;

import com.oris_first_semestr_work.config.CustomDataSource;
import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.entity.Pet;
import com.oris_first_semestr_work.entity.Room;
import com.oris_first_semestr_work.entity.User;
import com.oris_first_semestr_work.repository.impl.*;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new CustomDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UserRepository userRepository = new UserRepository(jdbcTemplate);
        PetRepository petRepository = new PetRepository(jdbcTemplate);
        RoomRepository roomRepository = new RoomRepository(jdbcTemplate);
        BookingRepository bookingRepository = new BookingRepository(jdbcTemplate);
        OrderRepository orderRepository = new OrderRepository(jdbcTemplate);
        User user = User.builder()
                .username("aliya")
                .password("1234")
                .build();
        userRepository.create(user);
        User user1 = User.builder()
                .username("pet_lover123")
                .password("12345")
                .build();
        userRepository.create(user1);
        Pet pet = Pet.builder()
                .userId(1)
                .name("Sally")
                .breed("German shepherd")
        .build();
        petRepository.create(pet);
        Room room = Room.builder()
                .name("A-12")
                .building("B")
                .terms("")
                .build();
        roomRepository.create(room);
        System.out.println(userRepository.findAll());
        System.out.println(petRepository.findAll());
        System.out.println(roomRepository.findById(1));
    }
}
