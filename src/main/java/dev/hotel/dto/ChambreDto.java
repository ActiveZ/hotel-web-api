package dev.hotel.dto;

import java.io.Serializable;
import java.util.Objects;

public class ChambreDto implements Serializable {
    private final String code;
    private final String numero;
    private final Float surface;

    public ChambreDto(String code, String numero, Float surface) {
        this.code = code;
        this.numero = numero;
        this.surface = surface;
    }

    public String getCode() {
        return code;
    }

    public String getNumero() {
        return numero;
    }

    public Float getSurface() {
        return surface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChambreDto entity = (ChambreDto) o;
        return Objects.equals(this.code, entity.code) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.surface, entity.surface);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, numero, surface);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "code = " + code + ", " +
                "numero = " + numero + ", " +
                "surface = " + surface + ")";
    }
}
