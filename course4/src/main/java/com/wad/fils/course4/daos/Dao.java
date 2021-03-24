package com.wad.fils.course4.daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
  Optional<T> get(long id);
  List<T> getAll();
  void save(T t);
  void update(T t);
  void delete(T t);
}
