package dsb.estudio.calculadoraipva;

import android.os.Parcel;
import android.os.Parcelable;

public class Automovel implements Parcelable {
    String Modelo;
    String Valor;
    String Estado;

    protected Automovel(Parcel in) {
        Modelo = in.readString();
        Valor = in.readString();
        Estado = in.readString();
    }

    public static final Creator<Automovel> CREATOR = new Creator<Automovel>() {
        @Override
        public Automovel createFromParcel(Parcel in) {
            return new Automovel(in);
        }

        @Override
        public Automovel[] newArray(int size) {
            return new Automovel[size];
        }
    };

    public Automovel() {

    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Modelo);
        parcel.writeString(Valor);
        parcel.writeString(Estado);
    }
}
