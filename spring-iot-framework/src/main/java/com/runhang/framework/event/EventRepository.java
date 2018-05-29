package com.runhang.framework.event;

public interface EventRepository {

    <E> int save(E event);

    <E> int delete(E event);

    <E> int update(E event);

    <E> E getById(String id);

}
