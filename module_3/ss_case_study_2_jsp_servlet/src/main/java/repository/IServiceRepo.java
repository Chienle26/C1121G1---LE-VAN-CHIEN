package repository;

import model.Facility;

import java.util.List;

public interface IServiceRepo {
    List<Facility> findAll();
}
