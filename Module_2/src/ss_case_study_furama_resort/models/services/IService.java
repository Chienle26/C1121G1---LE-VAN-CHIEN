package ss_case_study_furama_resort.models.services;

import java.io.IOException;

public interface IService {
    void add() throws IOException;

    void display();

    void edit();

    void returnMainMenu();
}
