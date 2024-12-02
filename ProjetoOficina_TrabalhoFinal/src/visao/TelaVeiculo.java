/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package visao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Acessorio;
import modelos.ICrud;
import modelos.Modelo;
import modelos.Veiculo;
import persistencia.ModeloDAO;
import persistencia.VeiculoDAO;

/**
 *
 * @author Cliente
 */
public class TelaVeiculo extends javax.swing.JInternalFrame {
    private ICrud<Modelo> ModeloBD = null;
    private ICrud<Veiculo> VeiculoBD = null;
    /**
     * Creates new form TelaVeiculo
     */
    public TelaVeiculo() {
        initComponents();
        try {
            ModeloBD = new ModeloDAO();
            VeiculoBD = new VeiculoDAO();
          
            List<Modelo> listaDeModelo = new ArrayList<>();
            listaDeModelo = null;
            listaDeModelo = ModeloBD.listar();
            jComboBox_Modelo.removeAllItems();
            for(int pos = 0; pos < listaDeModelo.size(); pos++){
              jComboBox_Modelo.addItem(listaDeModelo.get(pos).toString());
            }
          mostrarVeiculoNaGrid();
        } catch (Exception erro) {
          JOptionPane.showMessageDialog(null, "Construtor Tela: "+erro.getMessage());
        }
    }
        private void limparTela(){
      jTextField_chassi.setText("");
      jTextField_kilometragem.setText("");
      jTextField_patrimonio.setText("");
      jTextField_placa.setText("");
    }
    
    private void mostrarVeiculoNaGrid(){
    try {
      List<Veiculo> listaDeVeiculo = new ArrayList<>();
      listaDeVeiculo = null;
      listaDeVeiculo = VeiculoBD.listar();
      DefaultTableModel model =  (DefaultTableModel) jTable_Saida.getModel();
      model.setNumRows(0); 
      if(listaDeVeiculo.isEmpty()) 
        throw new Exception("Lista de Acessorio BD Vazia");
      for (Veiculo objVeiculo : listaDeVeiculo){
        Calendar calendarAnoFabricacao = Calendar.getInstance();
        calendarAnoFabricacao.setTime(objVeiculo.getAnoFabricacao());
        int anoFabricacao = calendarAnoFabricacao.get(Calendar.YEAR);
        
        Calendar calendarAnoModelo = Calendar.getInstance();
        calendarAnoModelo.setTime(objVeiculo.getAnoFabricacao());
        int anoModelo = calendarAnoModelo.get(Calendar.YEAR);
        
        String[] saida = new String[8];
            saida[0] = objVeiculo.getPlaca()+ "";
            saida[1] = String.valueOf(anoFabricacao);
            saida[2] = objVeiculo.getDataRegistro()+ "";
            saida[3] = objVeiculo.getChassi()+ "";
            if(objVeiculo.getPatrimonio() == null){
                saida[4] = "null";
            }else{
                saida[4] = objVeiculo.getPatrimonio()+ "";
            }
            saida[5] = objVeiculo.getKilometragem()+ "";
            saida[6] = String.valueOf(anoModelo);
            saida[7] = objVeiculo.getModelo().getIdModelo()+ "";
        model.addRow(saida);
      }  
    } catch (Exception erro) {
        JOptionPane.showMessageDialog(rootPane, erro.getMessage());
      }    
    }
    
    private void mostrarVeiculoNaGridBusca(Veiculo objVeiculo){
      try {

        DefaultTableModel model =  (DefaultTableModel) jTable_Saida.getModel();
        model.setNumRows(0); 
        if(objVeiculo == null) 
          throw new Exception("Lista de Busca BD Vazia");
        
        Calendar calendarAnoFabricacao = Calendar.getInstance();
        calendarAnoFabricacao.setTime(objVeiculo.getAnoFabricacao());
        int anoFabricacao = calendarAnoFabricacao.get(Calendar.YEAR);
        
        Calendar calendarAnoModelo = Calendar.getInstance();
        calendarAnoModelo.setTime(objVeiculo.getAnoFabricacao());
        int anoModelo = calendarAnoModelo.get(Calendar.YEAR);
        
        String[] saida = new String[8];
          saida[0] = objVeiculo.getPlaca()+ "";
          saida[1] = String.valueOf(anoFabricacao);
          saida[2] = objVeiculo.getDataRegistro()+ "";
          saida[3] = objVeiculo.getChassi()+ "";
          if(objVeiculo.getPatrimonio() == null){
                saida[4] = "null";
            }else{
                saida[4] = objVeiculo.getPatrimonio()+ "";
            }
          saida[5] = objVeiculo.getKilometragem()+ "";
          saida[6] = String.valueOf(anoModelo);
          saida[7] = objVeiculo.getModelo().getIdModelo()+ "";
        model.addRow(saida);
      } catch (Exception erro) {
          JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Saida = new javax.swing.JTable();
        jButtonincluir = new javax.swing.JButton();
        jButton_alterar = new javax.swing.JButton();
        jButton_buscar = new javax.swing.JButton();
        jButton_listar = new javax.swing.JButton();
        jTextField_patrimonio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_kilometragem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_placa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_chassi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_Modelo = new javax.swing.JComboBox<>();
        jYearChooser1_anomodelo = new com.toedter.calendar.JYearChooser();
        jYearChooser2_anofabricacao = new com.toedter.calendar.JYearChooser();
        jCalendar_dataRegistro = new com.toedter.calendar.JCalendar();

        setPreferredSize(new java.awt.Dimension(1119, 466));

        jTable_Saida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "placa", "anoFabricacao", "dataRegistro", "chassi", "patrimonio", "kilometragem", "anoModelo", "idModelo"
            }
        ));
        jScrollPane1.setViewportView(jTable_Saida);

        jButtonincluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonincluir.setText("INCLUIR");
        jButtonincluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonincluirActionPerformed(evt);
            }
        });

        jButton_alterar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_alterar.setText("ALTERAR");
        jButton_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_alterarActionPerformed(evt);
            }
        });

        jButton_buscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_buscar.setText("BUSCAR");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });

        jButton_listar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_listar.setText("LISTAR");
        jButton_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_listarActionPerformed(evt);
            }
        });

        jTextField_patrimonio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_patrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_patrimonioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setText("kilometragem");

        jTextField_kilometragem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("PLACA");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setText("modelo");

        jTextField_placa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel9.setText("anoFabricacao");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("chassi");

        jTextField_chassi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel10.setText("dataRegistro");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("patrimonio");

        jLabel11.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel11.setText("anoModelo");

        jComboBox_Modelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(18, 18, 18)
                                            .addComponent(jYearChooser2_anofabricacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jYearChooser1_anomodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_chassi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_kilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_patrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButtonincluir)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_alterar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_buscar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_listar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jCalendar_dataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_chassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jCalendar_dataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jYearChooser2_anofabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField_patrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_kilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jYearChooser1_anomodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel6)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonincluir)
                            .addComponent(jButton_alterar)
                            .addComponent(jButton_buscar)
                            .addComponent(jButton_listar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonincluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonincluirActionPerformed
        try {
// **Validação da Placa**
            String placa = jTextField_placa.getText().trim().toUpperCase();
            if (placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$"))
                JOptionPane.showMessageDialog(rootPane, "Placa inválida! Use o formato ABC-1234 ou ABC1D23.");

            // **Validação do Ano de Fabricação**
            int anoFabricacao = jYearChooser2_anofabricacao.getYear();
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
            if (anoFabricacao < 1900 || anoFabricacao > anoAtual)
                JOptionPane.showMessageDialog(rootPane, "Ano de fabricação inválido! Deve estar entre 1900 e " + anoAtual + ".");

            // **Validação do Ano do Modelo**
            int anoModelo = jYearChooser1_anomodelo.getYear();
            if (anoModelo > anoAtual + 1)
                JOptionPane.showMessageDialog(rootPane, "Ano do modelo inválido! Deve ser no máximo " + (anoAtual + 1) + ".");

            // **Validação da Data de Registro**
            Date dataRegistro = jCalendar_dataRegistro.getDate();
            if (dataRegistro == null)
                JOptionPane.showMessageDialog(rootPane, "Data de registro inválida! Selecione uma data válida.");

            // **Validação do Chassi**
            String chassi = jTextField_chassi.getText().trim().toUpperCase();
            if (chassi.isEmpty())
                chassi = null; 
            else if (chassi.length() != 17 || !chassi.matches("[A-Z0-9]+"))
                JOptionPane.showMessageDialog(rootPane, "Chassi inválido! Deve conter exatamente 17 caracteres alfanuméricos.");

            // **Validação do Patrimônio**
            String patrimonioTexto = jTextField_patrimonio.getText().trim();
            if (patrimonioTexto.isEmpty())
                patrimonioTexto = "-1";
            else if (!patrimonioTexto.matches("\\d+"))
                JOptionPane.showMessageDialog(rootPane, "Patrimônio inválido! Deve ser um número inteiro positivo.");
            Integer patrimonio = Integer.valueOf(patrimonioTexto);
            // **Validação da Quilometragem**
            String kilometragemTexto = jTextField_kilometragem.getText().trim();
            if (!kilometragemTexto.matches("\\d+"))
                JOptionPane.showMessageDialog(rootPane, "Quilometragem inválida! Deve ser um número inteiro não negativo.");

            int kilometragem = Integer.parseInt(kilometragemTexto);

            // **Validação do Modelo**
            String aux = (String) jComboBox_Modelo.getSelectedItem();
            if (aux == null || !aux.contains("-")) 
                JOptionPane.showMessageDialog(rootPane, "Selecione um modelo válido no campo de modelo.");
                
            String[] vetModelo = aux.split("-");
            int idModelo = Integer.parseInt(vetModelo[0]);
            Modelo modelo = new Modelo(idModelo);

            // **Criação das datas ajustadas**
            Calendar calendarAnoFabricacao = Calendar.getInstance();
            calendarAnoFabricacao.set(Calendar.YEAR, anoFabricacao);
            calendarAnoFabricacao.set(Calendar.MONTH, Calendar.JANUARY);
            calendarAnoFabricacao.set(Calendar.DAY_OF_MONTH, 1);
            Date dataAnoFabricacao = calendarAnoFabricacao.getTime();

            Calendar calendarAnoModelo = Calendar.getInstance();
            calendarAnoModelo.set(Calendar.YEAR, anoModelo);
            calendarAnoModelo.set(Calendar.MONTH, Calendar.JANUARY);
            calendarAnoModelo.set(Calendar.DAY_OF_MONTH, 1);
            Date dataAnoModelo = calendarAnoModelo.getTime();

            // **Criação do objeto Veículo**
            Veiculo objVeiculo = new Veiculo(
                placa, 
                dataAnoFabricacao, 
                dataRegistro, 
                chassi, 
                patrimonio, 
                kilometragem, 
                dataAnoModelo, 
                modelo
            );
            // **Persistência no banco**
            VeiculoBD.incluir(objVeiculo);
            limparTela();
            mostrarVeiculoNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao incluir veículo: " + erro.getMessage());
        }
    }//GEN-LAST:event_jButtonincluirActionPerformed

    private void jButton_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_alterarActionPerformed
        // TODO add your handling code here:
        try {
// **Validação da Placa**
            String placa = jTextField_placa.getText().trim().toUpperCase();
            if (placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$"))
                JOptionPane.showMessageDialog(rootPane, "Placa inválida! Use o formato ABC-1234 ou ABC1D23.");

            // **Validação do Ano de Fabricação**
            int anoFabricacao = jYearChooser2_anofabricacao.getYear();
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
            if (anoFabricacao < 1900 || anoFabricacao > anoAtual)
                JOptionPane.showMessageDialog(rootPane, "Ano de fabricação inválido! Deve estar entre 1900 e " + anoAtual + ".");

            // **Validação do Ano do Modelo**
            int anoModelo = jYearChooser1_anomodelo.getYear();
            if (anoModelo > anoAtual + 1)
                JOptionPane.showMessageDialog(rootPane, "Ano do modelo inválido! Deve ser no máximo " + (anoAtual + 1) + ".");

            // **Validação da Data de Registro**
            Date dataRegistro = jCalendar_dataRegistro.getDate();
            if (dataRegistro == null)
                JOptionPane.showMessageDialog(rootPane, "Data de registro inválida! Selecione uma data válida.");

            // **Validação do Chassi**
            String chassi = jTextField_chassi.getText().trim().toUpperCase();
            if (chassi.isEmpty())
                chassi = null; 
            else if (chassi.length() != 17 || !chassi.matches("[A-Z0-9]+"))
                JOptionPane.showMessageDialog(rootPane, "Chassi inválido! Deve conter exatamente 17 caracteres alfanuméricos.");

            // **Validação do Patrimônio**
            String patrimonioTexto = jTextField_patrimonio.getText().trim();
            if (patrimonioTexto.isEmpty())
                patrimonioTexto = "-1";
            else if (!patrimonioTexto.matches("\\d+"))
                JOptionPane.showMessageDialog(rootPane, "Patrimônio inválido! Deve ser um número inteiro positivo.");
            Integer patrimonio = Integer.valueOf(patrimonioTexto);
            // **Validação da Quilometragem**
            String kilometragemTexto = jTextField_kilometragem.getText().trim();
            if (!kilometragemTexto.matches("\\d+"))
                JOptionPane.showMessageDialog(rootPane, "Quilometragem inválida! Deve ser um número inteiro não negativo.");

            int kilometragem = Integer.parseInt(kilometragemTexto);

            // **Validação do Modelo**
            String aux = (String) jComboBox_Modelo.getSelectedItem();
            if (aux == null || !aux.contains("-")) 
                JOptionPane.showMessageDialog(rootPane, "Selecione um modelo válido no campo de modelo.");
                
            String[] vetModelo = aux.split("-");
            int idModelo = Integer.parseInt(vetModelo[0]);
            Modelo modelo = new Modelo(idModelo);

            // **Criação das datas ajustadas**
            Calendar calendarAnoFabricacao = Calendar.getInstance();
            calendarAnoFabricacao.set(Calendar.YEAR, anoFabricacao);
            calendarAnoFabricacao.set(Calendar.MONTH, Calendar.JANUARY);
            calendarAnoFabricacao.set(Calendar.DAY_OF_MONTH, 1);
            Date dataAnoFabricacao = calendarAnoFabricacao.getTime();

            Calendar calendarAnoModelo = Calendar.getInstance();
            calendarAnoModelo.set(Calendar.YEAR, anoModelo);
            calendarAnoModelo.set(Calendar.MONTH, Calendar.JANUARY);
            calendarAnoModelo.set(Calendar.DAY_OF_MONTH, 1);
            Date dataAnoModelo = calendarAnoModelo.getTime();

            // **Criação do objeto Veículo**
            Veiculo objVeiculo = new Veiculo(
                placa, 
                dataAnoFabricacao, 
                dataRegistro, 
                chassi, 
                patrimonio, 
                kilometragem, 
                dataAnoModelo, 
                modelo
            );
            VeiculoBD.alterar(objVeiculo);
            limparTela();
            mostrarVeiculoNaGrid();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Incluir Visao: "+erro.getMessage());
        }
    }//GEN-LAST:event_jButton_alterarActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        // TODO add your handling code here:
        try {
            Veiculo buscarVeiculo = new Veiculo(jTextField_placa.getText());
            mostrarVeiculoNaGridBusca(VeiculoBD.consultar(buscarVeiculo));
            limparTela();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, "Incluir Visao: "+erro.getMessage());
        }
    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jButton_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_listarActionPerformed
        // TODO add your handling code here:
        mostrarVeiculoNaGrid();
    }//GEN-LAST:event_jButton_listarActionPerformed

    private void jTextField_patrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_patrimonioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_patrimonioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_alterar;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_listar;
    private javax.swing.JButton jButtonincluir;
    private com.toedter.calendar.JCalendar jCalendar_dataRegistro;
    private javax.swing.JComboBox<String> jComboBox_Modelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Saida;
    private javax.swing.JTextField jTextField_chassi;
    private javax.swing.JTextField jTextField_kilometragem;
    private javax.swing.JTextField jTextField_patrimonio;
    private javax.swing.JTextField jTextField_placa;
    private com.toedter.calendar.JYearChooser jYearChooser1_anomodelo;
    private com.toedter.calendar.JYearChooser jYearChooser2_anofabricacao;
    // End of variables declaration//GEN-END:variables
}
