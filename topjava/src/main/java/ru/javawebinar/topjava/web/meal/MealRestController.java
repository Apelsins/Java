package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public Meal save(Meal meal, int userId) {
        log.info("create {}", meal, userId);
        checkNew(meal);
        return service.save(meal, userId);
    }

    public void delete(int id, int userId) {
        log.info("delete {}", id, userId);
        service.delete(id, userId);
    }

    public Meal get(int id, int userId) {
        log.info("get {}", id, userId);
        return service.get(id, userId);
    }

    public List<Meal> getAll(int userId) {
        log.info("getAll");
        return service.getAll(userId);
    }

}