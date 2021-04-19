package dsb.estudio.calculadoraipva;

public class Calculadora {

    public float CalculaPorcentagem(float valorCarro, float porcentagem){

        float result = valorCarro * (porcentagem/100);

        return result;
    }
}
