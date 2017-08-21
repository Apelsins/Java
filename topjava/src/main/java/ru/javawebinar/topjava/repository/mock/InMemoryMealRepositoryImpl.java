package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    //private Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
      //  MealsUtil.MEALS.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.getUserId() == userId) {
            if (meal.isNew()) {
                meal.setId(counter.incrementAndGet());
            }
            repository.put(meal.getId(), meal);
            return meal;
        }
        else return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        // other user cannot delete
        if (repository.get(id).getUserId() == userId)
            repository.remove(id);

        return true;
    }

    @Override
    public Meal get(int id, int userId) {
        if (repository.get(id).getUserId() != userId)
            return null;
        else return repository.get(id);
    }

    @Override
    public List<Meal> getAll(int userId) {
        return new ArrayList<>(repository.values());
    }
}

