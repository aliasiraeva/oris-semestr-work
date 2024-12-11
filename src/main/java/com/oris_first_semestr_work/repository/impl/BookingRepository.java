package com.oris_first_semestr_work.repository.impl;

import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.entity.Booking;
import com.oris_first_semestr_work.mapper.impl.BookingRowMapper;
import com.oris_first_semestr_work.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class BookingRepository implements CrudRepository<Booking, Integer> {
    private final JdbcTemplate jdbcTemplate;
    private final BookingRowMapper bookingRowMapper = new BookingRowMapper();
    private static final String FIND_ALL_SQL = "select * from booking";
    private static final String FIND_BY_ID_SQL = "select * from booking where id = ?";
    private static final String CREATE_SQL = "insert into booking(pet_id, room_id, start, \"end\") values (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "update booking set pet_id = ?, room_id = ?, start = ?, \"end\" = ? where id = ?";
    private static final String DELETE_SQL = "delete from booking where id = ?";

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Booking> findAll() {
        return jdbcTemplate.execute(FIND_ALL_SQL, bookingRowMapper);
    }

    @Override
    public Optional<Booking> findById(Integer id) {
        List<Booking> entities = jdbcTemplate.execute(FIND_BY_ID_SQL, bookingRowMapper, id);
        if (entities.size() > 1) {
            throw new RuntimeException("Incorrect results size: " + entities.size());
        }
        return entities.stream().findAny();
    }

    @Override
    public void create(Booking booking) {
        jdbcTemplate.update(CREATE_SQL, booking.getPetId(), booking.getRoomId(), booking.getStart(), booking.getEnd());
    }

    @Override
    public void update(Booking booking) {
        jdbcTemplate.update(UPDATE_SQL, booking.getPetId(), booking.getRoomId(), booking.getStart(), booking.getEnd(), booking.getId());
    }

    @Override
    public void delete(Booking booking) {
        jdbcTemplate.update(DELETE_SQL, booking.getId());
    }
}
