package service.impl;

import model.Facility;
import repository.IServiceRepo;
import repository.impl.ServiceRepo;
import service.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
    IServiceRepo iServiceRepo = new ServiceRepo();
    @Override
    public List<Facility> findAll() {
        return this.iServiceRepo.findAll();
    }
}
