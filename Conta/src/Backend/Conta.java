/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */

public class Conta {
    private int Numero;
    private float Saldo;
    private ArrayList<Transacao> Transacoes;
    private JFrame Frame;
    
    public Conta(JFrame Frame, int Numero) {
        this.Saldo =0;
        this.Numero = Numero;
        this.Frame = Frame;
        this.Transacoes = new ArrayList();
    }
    
    private void setTransacao(int Tipo, float Valor) {
        Transacao t = new Transacao();
        t.setTipo(Tipo);
        t.setValor(Valor);
        this.Transacoes.add(t);
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public float getSaldo() {
        return Saldo;
    }
    
    public void setDeposito(float Valor) {
        if (Valor > 0) {
            this.Saldo = this.Saldo + Valor;
            this.setTransacao(1, Valor);
            JOptionPane.showMessageDialog(this.Frame, "Depósito realizado com sucesso.");
        }
        else
            JOptionPane.showMessageDialog(this.Frame, "O valor do depósito deve ser superior a zero");
    }
    
    public void setSaque(float Valor) {
        if (Valor <= this.Saldo) {
            this.Saldo -= Valor;
            this.setTransacao(2, Valor);
            JOptionPane.showMessageDialog(this.Frame, "Saque realizado com sucesso.");
        }
        else 
            JOptionPane.showMessageDialog(this.Frame, "Saldo menor que o valor solicitado");                    
    }
    
    public void setTransferencia(Conta ContaCreditada, float Valor) {
        if (Valor <= this.Saldo) {
            this.Saldo -= Valor;
            this.setTransacao(4, Valor);
            ContaCreditada.Saldo += Valor;
            ContaCreditada.setTransacao(3, Valor);
            JOptionPane.showMessageDialog(this.Frame, "Transferência realizada com sucesso.");
        }
        else 
            JOptionPane.showMessageDialog(this.Frame, "Saldo menor que o valor solicitado");                    

    }
    
    public void getExtrato() {
        if (this.Transacoes.size() > 0) {
            String m = "";
            for(int i=0; i<this.Transacoes.size(); i++) {
                m = m + this.Transacoes.get(i).getTipo() + ": " + 
                        String.format("%.2f", this.Transacoes.get(i).getValor()) + "\n";
            }
            JOptionPane.showMessageDialog(Frame, "Extrato\n" + 
                    m + "\nSaldo: " + this.getSaldo());
        }
        else {
            JOptionPane.showMessageDialog(Frame, "A conta não possui transações");
        }
        
    }

}

