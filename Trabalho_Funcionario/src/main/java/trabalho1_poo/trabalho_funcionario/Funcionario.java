
package trabalho1_poo.trabalho_funcionario;

import java.text.DecimalFormat;

public class Funcionario {
    private int matricula;
    private String nome;
    private float valorHora;
    private float cargaHoraria;
    private float horaExtra;
    private float salario;
    
    public Funcionario(){}
    
    public Funcionario(int matricula, String nome, float valorHora, float cargaHoraria, float horaExtra, float salario){
        this.matricula = matricula;
        this.nome = nome;
        this.valorHora = valorHora;
        this.cargaHoraria = cargaHoraria;
        this.horaExtra = horaExtra;
        this.salario = salario;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valorHora
     */
    public float getValorHora() {
        return valorHora;
    }

    /**
     * @param valorHora the valorHora to set
     */
    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    /**
     * @return the cargaHoraria
     */
    public float getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the horaExtra
     */
    public float getHoraExtra() {
        return horaExtra;
    }

    /**
     * @param horaExtra the horaExtra to set
     */
    public void setHoraExtra(float horaExtra) {
        this.horaExtra += horaExtra;
    }

    /**
     * @return the salario
     */
    public float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    //Métodos
    public void addHoraExtra(float qtdaHora){
        this.horaExtra += qtdaHora;
    }
    
    public float calculaHoraExtra(){
        float valorHoraExtra = 0, valorReceber = 0;
        valorHoraExtra = (valorHora * 85) / 100;
        valorReceber = (valorHoraExtra + valorHora) * horaExtra;
        return valorReceber;
    }
    
    public double calculaPagamento(){
        salario = (valorHora * cargaHoraria);
        salario += calculaHoraExtra();
        return (double)salario;
    }
    
    public String resumo(){
        DecimalFormat fmt = new DecimalFormat("000.00");
        DecimalFormat fmtHr = new DecimalFormat("00hr");
        return ("\nMatricula: " + matricula + " \nNome: " + nome + " - " + "Valor hora: " + valorHora + " - " + "Carga horaria: " + cargaHoraria + 
                      "\nTotal de horas extras: " + fmtHr.format(horaExtra) + " - " + "Salario: " + fmt.format(calculaPagamento()));
    }   
}

