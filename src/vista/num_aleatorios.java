package vista;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class num_aleatorios extends javax.swing.JFrame {
    
    public num_aleatorios() {
        initComponents();
        this.setTitle("GENERADOR DE NUMEROS ALEATORIOS UMG");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(102, 255, 0));

        btn1.setBackground(new java.awt.Color(51, 51, 255));
        btn1.setFont(new java.awt.Font("Algerian", 2, 18)); // NOI18N
        btn1.setText("Generar .txt");
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        bt2.setBackground(new java.awt.Color(51, 51, 255));
        bt2.setFont(new java.awt.Font("Algerian", 2, 18)); // NOI18N
        bt2.setText("Ordenar .txt");
        bt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt2MouseClicked(evt);
            }
        });
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(bt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt2ActionPerformed

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked

        File file = new File("Des.txt");
        try{file.createNewFile();}catch (Exception ex) {}
        Random aleatorio = new Random();
        ArrayList<Integer> arreglo = new ArrayList<>();
        for (int i=1; i<=1000000; i++){
            int value = aleatorio.nextInt(10000000-(-10000000)+1)+(-10000000);
            arreglo.add(value);
        }
        try{
           FileWriter writer = new FileWriter(file);
            
            writer.write(arreglo.toString());
            writer.flush();
            writer.close();
            
            JOptionPane.showMessageDialog(rootPane, "Listo","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception ex) {
            
        }
        
    }//GEN-LAST:event_btn1MouseClicked

    private void bt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt2MouseClicked
        // TODO add your handling code here:
        
        File fileO = new File("Ord.txt");
        try{fileO.createNewFile();}catch (Exception ex) {}
        
        ArrayList<String> lineas = new ArrayList<>();
        try(Scanner s = new Scanner(new File("Des.txt")).useDelimiter(",")){
            while(s.hasNext()){
                lineas.add(s.next());
            }
        }catch (Exception e) {
            System.out.println("Error. "+e.getMessage());
        }
        ArrayList<Integer> resultado = getIntegerArray(lineas);
        
        Collections.sort(resultado);
        
        try{
            FileWriter writerO = new FileWriter(fileO);
            writerO.write(resultado.toString());
            writerO.flush();
            writerO.close();
            JOptionPane.showMessageDialog(rootPane, "Listo Ordenado!","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception ex) {
            
        }
        
    }//GEN-LAST:event_bt2MouseClicked

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed

    public static ArrayList<Integer> getIntegerArray(ArrayList<String>stringArray){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray){
            try{
                result.add(Integer.parseInt(stringValue.trim()));
            }catch (Exception ex) {
            }
        }
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(num_aleatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(num_aleatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(num_aleatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(num_aleatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new num_aleatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt2;
    private javax.swing.JButton btn1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
