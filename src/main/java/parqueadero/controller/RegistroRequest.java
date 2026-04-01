package parqueadero.controller;

public class RegistroRequest {

    private Long usuarioId;
    private Long vehiculoId;
    private Long celdaId;

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getVehiculoId() { return vehiculoId; }
    public void setVehiculoId(Long vehiculoId) { this.vehiculoId = vehiculoId; }

    public Long getCeldaId() { return celdaId; }
    public void setCeldaId(Long celdaId) { this.celdaId = celdaId; }
}