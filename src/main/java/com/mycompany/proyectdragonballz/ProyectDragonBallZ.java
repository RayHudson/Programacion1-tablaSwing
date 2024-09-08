package com.mycompany.proyectdragonballz;

/**
 *
 * @author dyrv07
 */

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ProyectDragonBallZ {

    public static void main(String[] args) {
        //Se crea ventana principal
        
        JFrame framePrincipal = new JFrame("Proyecto Dragon Ball Z");
        framePrincipal.setSize(600, 400);
        
        //Se crea un ComboBox para seleccionar cada uno  de los retos
        
        String[] retos = {
            
            "Reto 1 - Selección de personajes de Dragón Ball Z",
            "Reto 2 - Selector de niveles de poder de los personajes",
            "Reto 3 - Registro de los participantes",
            "Reto 4 - Héroes y villanos de Dragon Ball Z",
            "Reto 5 - Eventos destacables de  la saga de Namekusei",
            "Reto 6 - Información de la batalla contra Majin Buu",
            "Reto 7 - Entrenamiento en la sala del tiempo",
            "Reto 8 - Buscador de las esferas del Dragón",
        };
        
        JComboBox<String> comboBoxRetos = new JComboBox<>(retos);
        
        //Se crea un panel principal donde se muestra el contenido
        JPanel panelContenido = new JPanel(new CardLayout());
        
        //Reto 1 - Selección de personajes de Dragón Ball z
        
        JPanel panelReto1 = new JPanel(new BorderLayout());
        String[] guerrerosZ = {"Goku", "Vegeta", "Trunks", "Piccolo", "Krilin", "Gohan"};
        JList<String> list = new JList<>(guerrerosZ);
        
        //Se asocia a cada uno de los peronajes sin gano o perdio como resultado
        
        HashMap<String, String> resultadosGuerrerosZ = new HashMap<>();
        resultadosGuerrerosZ.put("Goku", "Ganó");
        resultadosGuerrerosZ.put("Vegeta", "Perdió");
        resultadosGuerrerosZ.put("Trunks", "Ganó");
        resultadosGuerrerosZ.put("Piccolo", "Perdió");
        resultadosGuerrerosZ.put("Krilin", "Perdió");
        resultadosGuerrerosZ.put("Gohan", "Ganó");
        
        list.addListSelectionListener(e -> {
            String selectedValue = list.getSelectedValue();
            String resultado = resultadosGuerrerosZ.get(selectedValue);
            JOptionPane.showMessageDialog(framePrincipal, "El personaje de DragonBall Z seleccionado es " + selectedValue + " y " + resultado);
        });
        panelReto1.add(new JScrollPane(list),(BorderLayout.CENTER));
        
        //Reto 2 - Selector de niveles de poder de los personajes
        
        JPanel panelReto2 = new JPanel(new BorderLayout());
        String[] saiyayin = {"Goku", "Vegeta", "Trunks", "Gohan"};
        int[] nivelesDePoder = {9000, 8500, 7500, 8000};
        JComboBox<String> comboBox = new JComboBox<>(saiyayin);
        comboBox.addActionListener(e -> {
            int selectedIndex = comboBox.getSelectedIndex();
            String selectedValue = comboBox.getSelectedItem().toString();
            int nivelDePoder = nivelesDePoder[selectedIndex];
            JOptionPane.showMessageDialog(framePrincipal, "El nivel de poder es " + selectedValue + " es " + nivelDePoder);
        });
        panelReto2.add(comboBox, BorderLayout.CENTER);
        
        //Reto 3 - Registro de los participantes
        
        JPanel panelReto3 = new JPanel(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Edad");
        model.addColumn("Técnica");
        model.addRow(new Object[]{"Goku", 25, "Kamehameha"});
        model.addRow(new Object[]{"Vegeta", 30, "Ataque final"});
        model.addRow(new Object[]{"Trunks", 20, "Ataque Ardiente"});
        model.addRow(new Object[]{"Gohan", 8,"Makankosappo"});
        JTable table = new JTable (model);
        panelReto3.add(new JScrollPane(table), BorderLayout.CENTER);
        
        
        // Reto 4 - Héroes y villanos de Dragon Ball Z
        
        JPanel panelReto4 = new JPanel (new BorderLayout());
        String[] heroes = {"Goku", "Vegeta", "Trunks", "Gohan"};
        String[] villanos = {"Frezer", "Cell", "Majin Buu"};
        
        
        // Se crea un mapeo para asociar cada héroe y villano con su resultado}
        
        HashMap<String, String> resultadosHeroes = new HashMap<>();
        resultadosHeroes.put("Goku", "Ganó");
        resultadosHeroes.put("Vegeta", "Perdió");
        resultadosHeroes.put("Trunks", "Ganó");
        resultadosHeroes.put("Gohan", "Ganó");
        
        HashMap<String, String> resultadosVillanos = new HashMap<>();
        resultadosVillanos.put("Frezer", "Perdió");
        resultadosVillanos.put("Cell", "Perdió");
        resultadosVillanos.put("Majin Buu", "Perdió");
        
        JList<String> heroesList = new JList<>(heroes);
        JList<String> villanosList = new JList<>(villanos);
        
        heroesList.addListSelectionListener(e -> {
            String selectedValue = heroesList.getSelectedValue();
            String resultado = resultadosHeroes.get(selectedValue);
            JOptionPane.showMessageDialog(framePrincipal, "El héroe seleccionado es" + selectedValue + " y " + resultado);
        });
        
        villanosList.addListSelectionListener(e -> {
            String selectedValue = villanosList.getSelectedValue();
            String resultado = resultadosVillanos.get(selectedValue);
            JOptionPane.showMessageDialog(framePrincipal, "El villano seleccionado es" + selectedValue + " y " + resultado);
     });
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane (heroesList), new JScrollPane(villanosList));
        panelReto4.add(splitPane, BorderLayout.CENTER);
        
        //Reto 5 - Eventos destacables de  la saga de Namekusei
        
        JPanel panelReto5 = new JPanel(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Saga de Namekusei ");
        DefaultMutableTreeNode evento1 = new DefaultMutableTreeNode("Evento 1: Llegada a Namekusei");
        DefaultMutableTreeNode evento2 = new DefaultMutableTreeNode("Evento 2: Batalla contra Frizer");
        DefaultMutableTreeNode evento3 = new DefaultMutableTreeNode("Evento 3: Muerte de Krilin");
        DefaultMutableTreeNode evento4 = new DefaultMutableTreeNode("Evento 4: Goku se convierte en el legendario super Saiyayin");
        DefaultMutableTreeNode evento5 = new DefaultMutableTreeNode("Evento 5: Destrucción del planeta Namekusei");
        root.add(evento1);
        root.add(evento2);
        root.add(evento3);
        root.add(evento4);
        root.add(evento5);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        JTree tree = new JTree(treeModel);
        panelReto5.add(new JScrollPane(tree), BorderLayout.CENTER);
        
        //Reto 6 - Información de la batalla contra Majin Buu"
        
        JPanel panelReto6 = new JPanel(new BorderLayout());
        DefaultTableModel model6 = new DefaultTableModel();
        model6.addColumn("Tipo");
        model6.addColumn("Nombre");
        model6.addRow(new Object[] {"Personaje", "Goku"});
        model6.addRow(new Object[] {"Personaje", "Vegeta"});
        model6.addRow(new Object[] {"Personaje", "Gohan"});
        model6.addRow(new Object[] {"Objeto", "Espada Z"});
        model6.addRow(new Object[] {"Lugar", "Cámara del tiempo"});
        JTable table6 = new JTable(model6);
        
        String[] tipos = {"Personajes", "Objeto","Lugar"};
        JList<String> tipoList = new JList<>(tipos);
        tipoList.addListSelectionListener(e -> {
            String selectedValue = tipoList.getSelectedValue();
            String mensaje = "Infomación seleccionada: " + selectedValue;
            JOptionPane.showConfirmDialog(framePrincipal, mensaje);
        });
        
        JSplitPane splitPane6 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tipoList), new JScrollPane(table6));
        panelReto6.add(splitPane6, BorderLayout.CENTER);
        
        // Reto 7 - Entrenamiento en la sala del tiempo
        
        JPanel panelReto7 = new JPanel(new BorderLayout());
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        JButton btnEntrenamiento = new JButton ("Iniciar Entrenamiento");
        btnEntrenamiento.addActionListener(e -> {
           new Thread( () -> {
            for(int i = 0; i <=100; i++){
                progressBar.setValue(i);
                try {
                    Thread.sleep(50); // Esto simula el tiempo de entrenamiento
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(framePrincipal, "¡Entrenamiento completo!");
        }).start();
        });
        
        panelReto7.add(progressBar, BorderLayout.CENTER);
        panelReto7.add(btnEntrenamiento, BorderLayout.SOUTH);
        
        
        //Reto 8 - Buscador de las esferas del Dragón
        
        JPanel panelReto8 = new JPanel(new BorderLayout());
        JTextField textFieldEsfera = new JTextField();
        JButton btnBuscarEsfera = new JButton("Buscar esfera del dragón");
        HashMap<Integer, String> coordenadasEsferas = new HashMap<>();
        coordenadasEsferas.put(1, "Coordendas 34°N, 118°W");
        coordenadasEsferas.put(2, "Coordendas 42°N, 120°W");
        coordenadasEsferas.put(3, "Coordendas 38°N, 122°W");
        coordenadasEsferas.put(4, "Coordendas 35°N, 115°W");
        coordenadasEsferas.put(5, "Coordendas 37°N, 119°W");
        coordenadasEsferas.put(6, "Coordendas 36°N, 117°W");
        coordenadasEsferas.put(7, "Coordendas 39°N, 116°W");
        
        btnBuscarEsfera.addActionListener(e -> {
            try {
                int numeroEsfera = Integer.parseInt(textFieldEsfera.getText());
                if (coordenadasEsferas.containsKey(numeroEsfera)) {
                    JOptionPane.showMessageDialog(framePrincipal, "Esfera" + numeroEsfera + " encontrada en:" + coordenadasEsferas.get(numeroEsfera));
                } else {
                    JOptionPane.showMessageDialog(framePrincipal, "Esfera no encontrada");
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(framePrincipal, "Por favor ingrese un número válido");
            }
        });
        
        panelReto8.add(textFieldEsfera, BorderLayout.CENTER);
        panelReto8.add(btnBuscarEsfera, BorderLayout.SOUTH);
        
        //Se añaden todos los paneles del panel principal
        
            panelContenido.add(panelReto1, "Reto 1 - Selección de personajes de Dragón Ball Z");
            panelContenido.add(panelReto2, "Reto 2 - Selector de niveles de poder de los personajes");
            panelContenido.add(panelReto3, "Reto 3 - Registro de los participantes");
            panelContenido.add(panelReto4, "Reto 4 - Héroes y villanos de Dragon Ball Z");
            panelContenido.add(panelReto5, "Reto 5 - Eventos destacables de  la saga de Namekusei");
            panelContenido.add(panelReto6, "Reto 6 - Información de la batalla contra Majin Buu");
            panelContenido.add(panelReto7, "Reto 7 - Entrenamiento en la sala del tiempo");
            panelContenido.add(panelReto8, "Reto 8 - Buscador de las esferas del Dragón");
            
            //Se cambia el panel para mostrar al usuario el reto seleccionado
            
            comboBoxRetos.addActionListener(e ->{
                CardLayout cl = (CardLayout)(panelContenido.getLayout());
                cl.show(panelContenido, (String) comboBoxRetos.getSelectedItem());
            });
            
            //Se añade el comboBox y el panel de contenidos a la ventana principal
            
            framePrincipal.setLayout(new BorderLayout());
            framePrincipal.add(comboBoxRetos, BorderLayout.NORTH);
            framePrincipal.add(panelContenido, BorderLayout.CENTER);
            
            // Se muestra la ventana principal
            
            framePrincipal.setVisible(true);     
  }
}
