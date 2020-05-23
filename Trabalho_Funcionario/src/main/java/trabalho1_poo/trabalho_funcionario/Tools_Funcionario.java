
package trabalho1_poo.trabalho_funcionario;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tools_Funcionario extends javax.swing.JInternalFrame {
    private ArrayList<Funcionario> f;
    private Funcionario func;
    
    public Tools_Funcionario(ArrayList<Funcionario> func) {
        initComponents();
        f = func;
        esconderCampoAdd();
    }
    
    public void limparCampos(){
        txtBusca.setText("");
        txtMatricula.setText("");
        txtNome.setText("");
        txtVlorHr.setText("");
        txtCargaHr.setText("");
        txtHorasExTotal.setText("");
        txtMatricula.requestFocus();
    }
    
    public void buscaVazia(){
        JOptionPane.showMessageDialog(null, "Preencha o campo para pesquisa!");
    }
    
    public void limparTextArea(){
        txtAreaResumo.setText("");
    }
    
    public void campoVazio(){
        JOptionPane.showMessageDialog(null, "Para cadastrar peencha todos os campos");
    }
    
    public void esconderCampoAdd(){
        txtAddHoraEx.setVisible(false);
        lblAddHrEx.setVisible(false);
        btnAddHora.setVisible(false);
    }
    
    public void mostraCampoAddHora(){
        txtAddHoraEx.setVisible(true);
        lblAddHrEx.setVisible(true);
        btnAddHora.setVisible(true);
    }
    
    public boolean verificarMatricula(){
        if(!f.isEmpty()){
            for(Funcionario fu : f){
                if(Integer.parseInt(txtMatricula.getText()) != fu.getMatricula()){
                    return true;
                }
            }
        }
        else{
            return true;
        }
        return false;
    }
    
    public void addFuncionario(){
        try {
            boolean cad = verificarMatricula();
            if(cad == true){
                func = new Funcionario();
                func.setMatricula(Integer.parseInt(txtMatricula.getText()));
                func.setNome(txtNome.getText());
                func.setValorHora(Float.parseFloat(txtVlorHr.getText().replaceAll(",", ".")));
                func.setCargaHoraria(Float.parseFloat(txtCargaHr.getText()));
                func.setHoraExtra(Float.parseFloat(txtHorasExTotal.getText()));
                f.add(func);
                for (int i = 0; i < f.size(); i++) {
                    txtAreaResumo.setText("Cadastrado funcionario" + "\nMatrícula: " + f.get(i).getMatricula());
                }
                limparCampos(); 
            } 
            else{
                txtAreaResumo.setText("Já existe um funcionário com essa matrículo. Escolha outro Dígito para a Matrícula!");
            }      
        } catch (Exception erro) {
            campoVazio();
        }
    }
    
    public void addHorasExtras(){
        try {
            if(txtBusca.getText() != ""){
                int matri = Integer.parseInt(txtBusca.getText());
                mostraCampoAddHora();
                for(Funcionario func : f){
                    if(matri == func.getMatricula()){
                        func.setHoraExtra(Float.parseFloat(txtAddHoraEx.getText()));
                        limparCampos();
                        break;
                    }
                }
                txtAreaResumo.setText(" Horas extras adicíonadas com sucesso! ");
                txtBusca.setText("");
                txtAddHoraEx.setText("");
                limparCampos();
            }
            else{
                JOptionPane.showMessageDialog(null, "Cadastro de funcionário não encontrado!");
            }
        } catch (Exception erro) {
            buscaVazia();
        }
        
        
    }
    
    public void pesquisarFuncionario(){
        try {
            if((txtBusca.getText() != "") && (!f.isEmpty())){
                int matri = Integer.parseInt(txtBusca.getText());
                mostraCampoAddHora();
                for(Funcionario func : f){
                    if(matri == func.getMatricula()){
                        txtMatricula.setText(Integer.toString(func.getMatricula()));
                        txtNome.setText(func.getNome());
                        txtVlorHr.setText(Float.toString(func.getValorHora()));
                        txtCargaHr.setText(Float.toString(func.getCargaHoraria()));
                        txtHorasExTotal.setText(Float.toString(func.getHoraExtra()));
                        limparTextArea();
                        break;
                    }
                }   
            }
            else{
                JOptionPane.showMessageDialog(null, "Cadastro de funcionário esta vazio OU Matrícula não cadastrada!");
                txtBusca.setText("");
            }
        } catch (Exception erro) {
            buscaVazia();
        }
    }
    
    public void mostrarResumo(){
        try {
            if(txtBusca.getText() != ""){
                int matri = Integer.parseInt(txtBusca.getText());
                mostraCampoAddHora();
                for(Funcionario func : f){
                    if(matri == func.getMatricula()){
                        txtAreaResumo.setText("Resumo dados funcionário: " + func.resumo());
                        break;
                    }
                } 
                limparCampos();
                esconderCampoAdd();
            }
            else{
                JOptionPane.showMessageDialog(null, "Cadastro de funcionário não encontrado!");
            }
        } catch (Exception erro) {
            buscaVazia();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAddHrEx = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtCargaHr = new javax.swing.JTextField();
        txtVlorHr = new javax.swing.JTextField();
        txtHorasExTotal = new javax.swing.JTextField();
        txtAddHoraEx = new javax.swing.JTextField();
        btnAddHora = new javax.swing.JButton();
        btnResumo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaResumo = new javax.swing.JTextArea();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro Funcionário");

        btnBusca.setText("Busca");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBusca)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusca))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Matrícula:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor hora:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Carga Horária:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Horas Extras:");

        lblAddHrEx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddHrEx.setForeground(new java.awt.Color(255, 255, 255));
        lblAddHrEx.setText("Add Hora Extra:");

        btnAddHora.setText("Add Hora Extra");
        btnAddHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHoraActionPerformed(evt);
            }
        });

        btnResumo.setText("Resumo");
        btnResumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtAreaResumo.setColumns(20);
        txtAreaResumo.setRows(5);
        jScrollPane1.setViewportView(txtAreaResumo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCargaHr, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddHora)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAddHoraEx, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAddHrEx)))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtHorasExTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtVlorHr, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnSalvar)
                        .addGap(216, 216, 216)
                        .addComponent(btnResumo)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblAddHrEx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddHoraEx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(btnAddHora))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtVlorHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargaHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorasExTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnResumo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        addFuncionario();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        pesquisarFuncionario();
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnAddHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHoraActionPerformed
        addHorasExtras();
    }//GEN-LAST:event_btnAddHoraActionPerformed

    private void btnResumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumoActionPerformed
        mostrarResumo();
    }//GEN-LAST:event_btnResumoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHora;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnResumo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddHrEx;
    private javax.swing.JTextField txtAddHoraEx;
    private javax.swing.JTextArea txtAreaResumo;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCargaHr;
    private javax.swing.JTextField txtHorasExTotal;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtVlorHr;
    // End of variables declaration//GEN-END:variables
}
