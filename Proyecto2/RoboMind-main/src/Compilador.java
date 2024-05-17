
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author yisus
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProdVar;
    private ArrayList<Production> identProdLib;
    private ArrayList<Production> identProdParse;
    private ArrayList<Production> identCompd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
//
    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Documentador C-Sharp";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".sharp");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        //timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
        timerKeyReleased = new Timer(300, ((e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        }));

        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProdVar = new ArrayList<>();
        identProdLib = new ArrayList<>();
        identProdParse = new ArrayList<>();
        identCompd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"int", "double", "String", "if",
            "else", "for", "while", "do", "while"}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jtpCode);

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblTokens);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                        .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);
                executeCode(blocksOfCode, 1);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void executeCode(ArrayList<String> blocksOfCode, int repeats) {
        for (int j = 1; j <= repeats; j++) {
            int repeatCode = -1;
            for (int i = 0; i < blocksOfCode.size(); i++) {
                String blockOfCode = blocksOfCode.get(i);
                if (repeatCode != -1) {
                    int[] posicionMarcador = CodeBlock.getPositionOfBothMarkers(blocksOfCode, blockOfCode);
                    executeCode(new ArrayList<>(blocksOfCode.subList(posicionMarcador[0], posicionMarcador[1])), repeatCode);
                    repeatCode = -1;
                    i = posicionMarcador[1];
                } else {
                    String[] sentences = blockOfCode.split(";");
                    for (String sentence : sentences) {
                        sentence = sentence.trim();
                        // Llamar código de ejecución (arduino, gráfico, etc)
                        if (sentence.startsWith("pintar")) {
                            String parametro;
                            if (sentence.contains("$")) {
                                parametro = identificadores.get(sentence.substring(9, sentence.length() - 2));
                            } else {
                                parametro = sentence.substring(9, sentence.length() - 2);
                            }
                            System.out.println("Pintando de color " + parametro + "...");
                        } else if (sentence.startsWith("izquierda")) {
                            System.out.println("Moviéndose a la izquierda...");
                        } else if (sentence.startsWith("derecha")) {
                            System.out.println("Moviéndose a la derecha...");
                        } else if (sentence.startsWith("adelante")) {
                            System.out.println("Moviéndose hacia adelante");
                        } else if (sentence.contains("-->")) {
                            String[] identComp = sentence.split(" ");
                            System.out.println("Declarando identificador " + identComp[1] + " igual a " + identComp[3]);
                        } else if (sentence.startsWith("atrás")) {
                            System.out.println("Moviéndose hacia atrás");
                        } else if (sentence.startsWith("repetir")) {
                            String parametro;
                            if (sentence.contains("$")) {
                                parametro = identificadores.get(sentence.substring(10, sentence.length() - 2));
                            } else {
                                parametro = sentence.substring(10, sentence.length() - 2);
                            }
                            repeatCode = Integer.parseInt(parametro);
                        }
                    }
                }
            }
        }
    }

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);

        /* Deshabilitar mensajes y validaciones 
        gramatica.disableMessages();
        gramatica.disableValidations();*/

 /* Eliminación de errores */
        gramatica.delete(new String[]{"ERROR"}, 1);

        /*Usar librerias*/
        gramatica.group("LIBRERIAS", "PALABRAS_RESERV_USING IDENTIFICADOR");
        gramatica.group("LIBRERIAS", "PALABRAS_RESERV_USING",
                11, "Error semantico 2: librería no apta[#, %]");

        /*Agrupacion de operadores aritmeticos*/
        gramatica.group("OP_ARITMETICOS", "(OP_SUMA | OP_RESTA | OP_DIVISION | OP_MULTIPLICACION)", true);

        /*Parceo*/
        gramatica.group("PARSEO", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR PARSE PARENTESIS_A IDENTIFICADOR PARENTESIS_C", identProdParse);
        gramatica.group("PARSEO", "IDENTIFICADOR OP_ASIG IDENTIFICADOR PARSE PARENTESIS_A IDENTIFICADOR PARENTESIS_C",
                24, "Error sintactico {}: Falta el tipo de variable para almacenar el dato parseado[#, %]");
        gramatica.group("PARSEO", "(TIPO_DATO)? OP_ASIG IDENTIFICADOR PARSE PARENTESIS_A IDENTIFICADOR PARENTESIS_C",
                25, "Error sintactico {}: Falta el identificador de variable para almacenar el dato parseado[#, %]");
        gramatica.group("PARSEO", "(TIPO_DATO)? IDENTIFICADOR IDENTIFICADOR PARSE PARENTESIS_A IDENTIFICADOR PARENTESIS_C",
                26, "Error sintactico {}: Falta el operador de asignacion de variable para almacenar el dato parseado [#, %]");
        gramatica.group("PARSEO", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG PARSE PARENTESIS_A IDENTIFICADOR PARENTESIS_C",
                27, "Error sintactico {}: Falta el identificador del metodo para parsear el dato [#, %]");
        gramatica.group("PARSEO", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR PARENTESIS_A IDENTIFICADOR PARENTESIS_C",
                28, "Error sintactico {}: Falta el punto de la llamada al metodo para parsear el dato [#, %]");
        gramatica.group("PARSEO", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR PARSE IDENTIFICADOR PARENTESIS_C",
                29, "Error sintactico {}: Falta el parentesis que abre para parsear el dato [#, %]");
        gramatica.group("PARSEO", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR PARSE PARENTESIS_A PARENTESIS_C",
                30, "Error sintactico {}: Falta la cadena que quieres parsear[#, %]");
        gramatica.group("PARSEO", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR PARSE PARENTESIS_A IDENTIFICADOR",
                31, "Error sintactico {}: Falta el parentesis que cierra para parsear el dato [#, %]");

        /*Recibir*/
        gramatica.group("RECIBIR", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR LLAMAR_METODO PARENTESIS_A PARENTESIS_C");
        gramatica.group("RECIBIR", "IDENTIFICADOR OP_ASIG IDENTIFICADOR LLAMAR_METODO PARENTESIS_A PARENTESIS_C",
                16, "Error sintactico {}: Falta el tipo de variable para almacenar la cadena[#, %]");
        gramatica.group("RECIBIR", "(TIPO_DATO)? OP_ASIG IDENTIFICADOR LLAMAR_METODO PARENTESIS_A PARENTESIS_C",
                17, "Error sintactico {}: Falta el identificador de variable para almacenar la cadena[#, %]");
        gramatica.group("RECIBIR", "(TIPO_DATO)? IDENTIFICADOR IDENTIFICADOR LLAMAR_METODO PARENTESIS_A PARENTESIS_C",
                18, "Error sintactico {}: Falta el operador de asignacion de variable para almacenar la cadena[#, %]");
        gramatica.group("RECIBIR", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG LLAMAR_METODO PARENTESIS_A PARENTESIS_C",
                19, "Error sintactico {}: Falta el identificador del metodo para almacenar la cadena[#, %]");
        gramatica.group("RECIBIR", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR PARENTESIS_A PARENTESIS_C",
                20, "Error sintactico {}: Falta el punto de la llamada al metodo para almacenar la cadena[#, %]");
        gramatica.group("RECIBIR", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR LLAMAR_METODO PARENTESIS_C",
                21, "Error sintactico {}: Falta el parentesis que abre para almacenar la cadena[#, %]");
        gramatica.group("RECIBIR", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR LLAMAR_METODO PARENTESIS_A",
                22, "Error sintactico {}: Falta el parentesis que cierra para almacenar la cadena[#, %]");

        /*Agrupacion de valor*/
        gramatica.group("VALOR", "(NUMERO_INT | NUMERO_DEC | VALOR_BOOL | CADENA_TEXT)", true);
        gramatica.group("VALORS", "(VALOR | IDENTIFICADOR) (OP_ARITMETICOS (VALOR | IDENTIFICADOR))+");
        gramatica.group("VALORC", "(VALOR | VALORS)");
        
        /*Inizializacion de variables*/
        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OP_ASIG (VALORC | IDENTIFICADOR)", identProdVar);
        gramatica.group("VARIABLE", "IDENTIFICADOR OP_ASIG (VALORC | IDENTIFICADOR)");

        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OP_ASIG",
                3, "Error sintactico {}: Falta el valor en la variable[#, %]");
        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR (VALORC | IDENTIFICADOR)",
                4, "Error sintactico {}: Falta operador de asignacion en la variable[#, %]");
        gramatica.group("VARIABLE", "TIPO_DATO OP_ASIG (VALORC | IDENTIFICADOR)",
                5, "Error sintactico {}: Falta el identificador en la variable[#, %]");
        gramatica.group("VARIABLE", "IDENTIFICADOR OP_ASIG (VALORC | IDENTIFICADOR)",
                6, "Error sintactico {}: Falta el tipo de dato en la variable[#, %]");

        /*Declaracion de variables*/
        gramatica.group("INICIALIZAR_VAR", "TIPO_DATO IDENTIFICADOR");
        gramatica.group("INICIALIZAR_VAR", "TIPO_DATO",
                9, "Error sintactico {}: Falta el identificador en la inicializacion [#, %]");

        /*Eliminación de tipos de datos y operadores de asignación*/
        gramatica.delete("TIPO_DATO",
                7, "Error sintáctico {}: el tipo de dato no está en la declaración de una variable [#, %]");
        gramatica.delete("OP_ASIG",
                8, "Error sintáctico {}: el operador de asignación no está en la declaración de una variable [#, %]");

        /* Parámetros */
        gramatica.group("PARAMETROS", "IDENTIFICADOR (COMA IDENTIFICADOR)+");

        /*Print*/
        gramatica.group("PRINT", "IDENTIFICADOR LLAMAR_METODO PARENTESIS_A (PARAMETROS|VALORC)? PARENTESIS_C", true);
        gramatica.group("PRINT", "IDENTIFICADOR LLAMAR_METODO (PARAMETROS|VALORC)? PARENTESIS_C",
                13, "Error sintactico {}: Falta el parentesis que abre[#, %]");
        gramatica.group("PRINT", "IDENTIFICADOR LLAMAR_METODO PARENTESIS_A (PARAMETROS|VALORC)?",
                14, "Error sintactico {}: Falta el parentesis que cierra[#, %]");

        /*Expresiones logicas*/
        gramatica.group("OP_COMPARADOR", "(OP_COMPARADOR | MAYOR_QUE | MENOR_QUE)");
        gramatica.group("EXPRESION_S", "(IDENTIFICADOR | VALORC) OP_COMPARADOR (IDENTIFICADOR | VALORC)", identCompd);
        gramatica.group("EXPRESION_C", "EXPRESION_S (OP_LOGICO EXPRESION_S)+");
        gramatica.group("EXPRESION", "(EXPRESION_S | EXPRESION_C)");

        /*EXPRESION FOR*/
        gramatica.group("EXPRESION_FOR", "EXPRESION PUNTO_COMA");

        gramatica.delete("OP_COMPARADOR", 27,
                "Error sintactico {}:El operador de comparacion no esta en una expresion [#, %]");
        gramatica.delete("OP_LOGICO", 28,
                "Error sintactico {}:El operador de logico no esta en una expresion [#, %]");

        gramatica.finalLineColumn();
        /*Verificacion punto y coma*/
 /*Variables*/
        gramatica.group("VARIABLE_PC", "VARIABLE PUNTO_COMA");
        gramatica.group("VARIABLE_PC", "VARIABLE",
                2, "Error sintactico {}: Falta el punto y coma en la variable[#, %]");
        gramatica.group("VARIABLE_CON_PC", "VARIABLE_CON PUNTO_COMA");
        gramatica.group("VARIABLE_CON_PC", "VARIABLE_CON",
                54, "Error sintactico {}: Falta el punto y coma en la variable[#, %]");
        
        /*INICIALIZACION*/
        gramatica.group("INICIALIZAR_VAR_PC", "INICIALIZAR_VAR PUNTO_COMA");
        gramatica.group("INICIALIZAR_VAR_PC", "INICIALIZAR_VAR",
                10, "Error sintactico {}: Falta punto y coma en la inicializacion [#, %]");
        /*Librerias*/
        gramatica.group("LIBRERIAS_PC", "LIBRERIAS PUNTO_COMA");
        gramatica.group("LIBRERIAS_PC", "LIBRERIAS",
                12, "Error sintactico {}: Falta punto y coma en la utilizacion de la libreria [#, %]");
        /*PRINT*/
        gramatica.group("PRINT_PC", "PRINT PUNTO_COMA");
        gramatica.group("PRINT_PC", "PRINT",
                15, "Error sintactico {}: Falta punto y coma en la llamada de metodo [#, %]");
        /*RECIIBBIR*/
        gramatica.group("RECIBIR_PC", "RECIBIR PUNTO_COMA");
        gramatica.group("RECIBIR_PC", "RECIBIR",
                23, "Error sintactico {}: Falta punto y coma en la llamada de metodo [#, %]");
        /*PARCEO*/
        gramatica.group("PARSEO_PC", "PARSEO PUNTO_COMA");
        gramatica.group("PARSEO_PC", "PARSEO",
                24, "Error sintactico {}: Falta punto y coma en en el metodo de parseo [#, %]");

        /*Eliminacion de punto y coma*/
        gramatica.initialLineColumn();
        gramatica.delete("PUNTO_COMA", 26,
                "Error sintactivo {}: El punto y coma no esta al final de una sentencia [#, %]");

        gramatica.group("DOC", "IDENTIFICADOR OP_ARITMETICOS OP_ARITMETICOS");

        /*Sentencias*/
        gramatica.group("SENTENCIA", "(VARIABLE_PC | INICIALIZAR_VAR_PC | PRINT_PC | RECIBIR_PC | PARSEO_PC)+");
        

        /*Estructura for*/
        gramatica.group("EST_FOR", "ESTRUCTURA_FOR");
        gramatica.group("EST_FOR_COM", "EST_FOR PARENTESIS_A SENTENCIA EXPRESION_FOR DOC PARENTESIS_C LLAVE_A (SENTENCIA)? LLAVE_C");
        gramatica.group("EST_FOR_COM", "EST_FOR SENTENCIA EXPRESION_FOR DOC PARENTESIS_C LLAVE_A (SENTENCIA)? LLAVE_C", 35,
                "Error sintactico {}: Falta parentesis que abre en la sentencia for [#, %]");
        gramatica.group("EST_FOR_COM", "EST_FOR PARENTESIS_A EXPRESION_FOR DOC PARENTESIS_C LLAVE_A (SENTENCIA)? LLAVE_C", 36,
                "Error sintactico {}: Falta la inicializacion de la variable en la sentencia for [#, %]");
        gramatica.group("EST_FOR_COM", "EST_FOR PARENTESIS_A SENTENCIA DOC PARENTESIS_C LLAVE_A (SENTENCIA)? LLAVE_C", 37,
                "Error sintactico {}: Falta la expresion en la sentencia for [#, %]");
        gramatica.group("EST_FOR_COM", "EST_FOR PARENTESIS_A SENTENCIA EXPRESION_FOR PARENTESIS_C LLAVE_A (SENTENCIA)? LLAVE_C", 38,
                "Error sintactico {}: Falta el incremento o decremento en la sentencia for [#, %]");
        gramatica.group("EST_FOR_COM", "EST_FOR PARENTESIS_A SENTENCIA EXPRESION_FOR DOC LLAVE_A (SENTENCIA)? LLAVE_C", 39,
                "Error sintactico {}: Falta parentesis que cierra en la sentencia for [#, %]");
        gramatica.group("EST_FOR_COM", "EST_FOR PARENTESIS_A SENTENCIA EXPRESION_FOR DOC PARENTESIS_C (SENTENCIA)? LLAVE_C", 40,
                "Error sintactico {}: Falta la llave que abre en la sentencia for [#, %]");
        gramatica.group("EST_FOR_COM", "EST_FOR PARENTESIS_A SENTENCIA EXPRESION_FOR DOC PARENTESIS_C LLAVE_A (SENTENCIA)?", 41,
                "Error sintactico {}: Falta la llave que cierra en la sentencia for [#, %]");
        gramatica.delete("EST_FOR",
                34, " × Error sintáctico {}: La estructura de control no está declarada correctamente [#, %]");

        /*Estructura if*/
        gramatica.group("EST_IF", "ESTRUCTURA_IF");
        gramatica.group("EST_IF_COM", "EST_IF PARENTESIS_A EXPRESION PARENTESIS_C LLAVE_A (SENTENCIA)? LLAVE_C");
        gramatica.group("EST_IF_COM", "EST_IF EXPRESION PARENTESIS_C LLAVE_A (SENTENCIA)? LLAVE_C", 29,
                "Error sintactico {}: Falta el parentesis que abre en la expresion [#, %]");
        gramatica.group("EST_IF_COM", "EST_IF PARENTESIS_A PARENTESIS_C LLAVE_A (SENTENCIA)? LLAVE_C", 30,
                "Error sintactico {}: Falta la expresion a evaluar [#, %]");
        gramatica.group("EST_IF_COM", "EST_IF PARENTESIS_A EXPRESION LLAVE_A (SENTENCIA)? LLAVE_C", 31,
                "Error sintactico {}: Falta el parentesis que cierra en la expresion [#, %]");
        gramatica.group("EST_IF_COM", "EST_IF PARENTESIS_A EXPRESION PARENTESIS_C (SENTENCIA)? LLAVE_C", 32,
                "Error sintactico {}: Falta la llave que inicia la sentencia del if [#, %]");
        gramatica.group("EST_IF_COM", "EST_IF PARENTESIS_A EXPRESION PARENTESIS_C LLAVE_A (SENTENCIA)?", 33,
                "Error sintactico {}: Falta la llave que finaliza la sentencia del if [#, %]");
        gramatica.delete("EST_IF",
                34, " × Error sintáctico {}: La estructura de control no está declarada correctamente [#, %]");

        /*Main*/
        gramatica.group("SENTENCIA_COM", "(SENTENCIA | EST_FOR_COM | EST_IF_COM)+");

        gramatica.group("MAIN", "PALABRAS_RESERV_STATIC PALABRAS_RESERV_VOID");
        gramatica.group("MAIN_COM", "MAIN IDENTIFICADOR PARENTESIS_A PARENTESIS_C LLAVE_A (SENTENCIA_COM)? LLAVE_C");
        gramatica.group("MAIN_COM", "MAIN PARENTESIS_A PARENTESIS_C LLAVE_A (SENTENCIA_COM)? LLAVE_C", 35,
                "Error sintactico {}:Falta la palabra main [#, %]");
        gramatica.group("MAIN_COM", "MAIN IDENTIFICADOR PARENTESIS_C LLAVE_A (SENTENCIA_COM)? LLAVE_C", 36,
                "Error sintactico {}:Falta el parentesis que abre el metodo main [#, %]");
        gramatica.group("MAIN_COM", "MAIN IDENTIFICADOR PARENTESIS_A LLAVE_A (SENTENCIA_COM)? LLAVE_C", 37,
                "Error sintactico {}:Falta el parentesis que cierra el metodo main [#, %]");
        gramatica.group("MAIN_COM", "MAIN IDENTIFICADOR PARENTESIS_A PARENTESIS_C (SENTENCIA_COM)? LLAVE_C", 38,
                "Error sintactico {}:Falta la llave que abre el metodo main [#, %]");
        gramatica.group("MAIN_COM", "MAIN IDENTIFICADOR PARENTESIS_A PARENTESIS_C LLAVE_A (SENTENCIA_COM)?", 39,
                "Error sintactico {}:Falta la llave que cierra el metodo main [#, %]");

        /*Clase final*/
        gramatica.group("CLASS", "PALABRAS_RESERV_CLASS");
        gramatica.group("CLASS_COM", "CLASS IDENTIFICADOR LLAVE_A (MAIN_COM)? LLAVE_C");

        gramatica.show();
    }

    private void semanticAnalysis() {
        
        /*Inizializacion de variables*/
        HashMap<String, String> variablesType = new HashMap<>();
        variablesType.put("int", "NUMERO_INT");
        variablesType.put("double", "NUMERO_DEC");
        variablesType.put("bool", "VALOR_BOOL");
        variablesType.put("string", "CADENA_TEXT");
        //variablesType.put(" ", "IDENTIFICADOR");
        
        
        for (Production id: identProdVar)
        {
            if (!variablesType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1)))
            {
                errors.add(new ErrorLSSL(1, "Error semántico {}: El tipo de dato no corresponde a la variable declarada[#, %]", id, false));
            } else 
            {
                identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
            }
        }
        
        /*Uso de librerias*/
        HashMap<String, String> libreriesType = new HashMap<>();
        libreriesType.put("using", "IDENTIFICADOR");
        
        for (Production id: identProdLib)
        {
            if (!libreriesType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1)))
            {
                errors.add(new ErrorLSSL(2, "Error semantico {}: Libreria no apta [#, %]", id, false));
            } else
            {
                identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
            }
        }
        
//        /*Conversión de unidades*/
//        //gramatica.group("PARSEO", "(TIPO_DATO)? IDENTIFICADOR OP_ASIG IDENTIFICADOR PARSE PARENTESIS_A IDENTIFICADOR PARENTESIS_C");
//        HashMap<String, String> parseType = new HashMap<>();
//        parseType.put("int", "IDENTIFICADOR");
//        parseType.put("double", "CADENA_TEXT");
//        parseType.put("bool", "VALOR_BOOL");
//        parseType.put("string", "CADENA_TEXT");
//        
//        for (Production id: identProdParse)
//        {
//            if (!parseType.get(id.lexemeRank(0)).equals("PARSEO_PC"))
//            {
//                errors.add(new ErrorLSSL(3, "Error semántico {}: Datos no compatibles para el PARSEO [#, %]", id, false));
//            } else
//            {
//                identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
//            }
//        }
        
        //Comparar variables 
//        HashMap<String, String> parseOperador = new HashMap<>();
//        parseType.put("int", "int");
//        parseType.put("double", "double");
//        parseType.put("bool", "bool");
//        parseType.put("string", "string");
//        
//        for (Production id: identProdParse)
//        {
//            if (!parseType.get(id.lexemeRank(0)).equals("IDENTIFICADOR"))
//            {
//                errors.add(new ErrorLSSL(4, "Error semántico {}: Datos no compatibles para ser comparados [#, %]", id, false));
//            } else
//            {
//                identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
//            }
//        }
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexer;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexer.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        //jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProdVar.clear();
        identProdParse.clear();
        identProdLib.clear();
        identCompd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
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
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
