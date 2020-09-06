package com.tg.spring5.repository.map;

import com.tg.spring5.model.BaseEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Scope("prototype")
public class MapRepository<T extends BaseEntity, ID extends Long> implements CrudRepository<T, ID> {

    private Long CURRENT_ID = 0L;

    private Map<ID, T> map = new HashMap<>();

    @Override
    public <S extends T> S save(S s) {
        if (map.containsValue(s))
            return map.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(s))
                    .findFirst()
                    .map(Map.Entry::getValue).map(t -> (S) t).get();
        ID id = (ID) (s.getId() == null || s.getId() == 0L ? getNextId() : s.getId());
        s.setId(id);
        map.put(id, s);
        return s;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> iterable) {
        iterable.forEach(this::save);
        return iterable;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.of(map.get(id));
    }

    @Override
    public boolean existsById(ID id) {
        return map.containsKey(id);
    }

    @Override
    public Iterable<T> findAll() {
        map.values().forEach(System.out::println);
        return map.values();
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> iterable) {
        List<T> returning = new ArrayList<>();
        for (ID id : iterable) {
            if (map.containsKey(id)) {
                returning.add(map.get(id));
            }
        }
        return returning;
    }

    @Override
    public long count() {
        return map.size();
    }

    @Override
    public void deleteById(ID id) {
        map.entrySet().removeIf(entry -> entry.getKey().equals(id));
    }

    @Override
    public void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));

    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {
        iterable.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        map = new HashMap<>();
    }

    public Long getNextId() {
        CURRENT_ID = CURRENT_ID + 1L;
        return CURRENT_ID;
    }

}
