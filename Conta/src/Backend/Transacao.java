/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author diego
 */
public class Transacao {
    private int Tipo; //1-Depósito 2-Saque 3-Transféricia Crédito 4-Transferência Débito
    private float Valor;

    public String getTipo() {
        if (this.Tipo == 1)
            return "Depósito";
        else if (this.Tipo == 2)
            return "Saque";
        else if (this.Tipo == 3)
            return "Crédito de Transferêcia";
        else
            return "Débito de Transfeência";
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }   
}
