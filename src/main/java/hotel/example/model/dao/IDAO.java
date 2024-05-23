package hotel.example.model.dao;

import java.util.List;
import hotel.example.model.entity.AbstractEntity;

public interface IDAO<T extends AbstractEntity> {
    // >>>>> CONTROLE DE REGISTRO
    void cadastrar(T entidade);
    void atualizar(T entidade);
    void excluir(int id);
    T buscarReserva(int id);
    List<T> listar();
    // >>>>> CONTROLE DE RESERVAS
    void reservar(T entidade);
    void cancelarReserva(int id);
    T listarReservas(int id);
    List<T> listarEmprest();
}
