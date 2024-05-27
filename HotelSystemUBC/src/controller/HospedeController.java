package controller;

import java.util.List;
import model.Hospede;
import model.dao.HospedeDAO;

public class HospedeController {
    private final HospedeDAO hospedeDAO;

    public HospedeController() {
        hospedeDAO = new HospedeDAO();
    }

    public void addHospede(Hospede hospede) {
        hospedeDAO.addHospede(hospede);
    }

    public List<Hospede> getAllHospedes() {
        return hospedeDAO.getAllHospedes();
    }

    public void updateHospede(Hospede hospede) {
        hospedeDAO.updateHospede(hospede);
    }

    public void deleteHospede(int idHospedes) {
        hospedeDAO.deleteHospede(idHospedes);
    }
}
