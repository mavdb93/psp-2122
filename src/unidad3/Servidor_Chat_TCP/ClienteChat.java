package unidad3.Servidor_Chat_TCP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteChat  extends JFrame implements ActionListener, Runnable {

    private static final long serialVersionUID = 1L;
    Socket socket = null;

    //streams
    DataInputStream fentrada;
    DataOutputStream fsalida;

    String nombre;
    static JTextField mensaje = new JTextField();

    private JScrollPane scrollpane1;
    static JTextArea textarea1;
    JButton botonEnviar = new JButton("Enviar");
    JButton botonSalir = new JButton("Salir");
    boolean repetir = true;

    public ClienteChat(Socket s, String nombreCliente){
        super(" CONEXIÓN DEL CLIENTE CHAT: " + nombreCliente);
        setLayout(null);

        mensaje.setBounds(10,10,400,30);
        add(mensaje);

        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10,50,400,300);
        add(scrollpane1);

        botonEnviar.setBounds(420,10,100,30);
        add(botonEnviar);
        botonSalir.setBounds(420,50,100,30);
        add(botonSalir);

        textarea1.setEditable(false);
        botonEnviar.addActionListener(this);
        botonSalir.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        socket = s;
        this.nombre = nombreCliente;

        try{
            fentrada = new DataInputStream(socket.getInputStream());
            fsalida = new DataOutputStream(socket.getOutputStream());
            String texto = " > Entra en el Chat ..." + nombre;
            fsalida.writeUTF(texto);

        }catch (IOException ioe){
            ioe.getMessage();
        }

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botonEnviar){
            if(mensaje.getText().trim().length() == 0){
                return;
            }
            String texto = nombre+" > "+mensaje.getText();

            try{
                mensaje.setText("");
                fsalida.writeUTF(texto);
            }catch (IOException ioe){
                ioe.getMessage();
            }
        }

        if(e.getSource() == botonSalir){
            String texto = " > Abandona el Chat ..." + nombre;
            try{
                fsalida.writeUTF(texto);
                fsalida.writeUTF("*");
                repetir=false;
            }catch (IOException ioe){
                ioe.getMessage();
            }
        }

    }

    public void run(){
        String texto = "";
        while (repetir){
            try{
                texto = fentrada.readUTF();
                textarea1.setText(texto);
            }catch (IOException ioe){
                JOptionPane.showMessageDialog(null, "Imposible Conectar con Servidor" + ioe.getMessage(), "Mensjae de error", JOptionPane.ERROR_MESSAGE);
                repetir = false;
            }
        }
    }

    public static void main(String[] args) {
        int puerto = 44444;
        Socket s = null;

        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick");

        if(nombre.trim().length()==0){
            System.out.println("El nombre introducido está vacío");
            return;
        }
        try{
            s = new Socket("localhost",puerto);
            ClienteChat cliente = new ClienteChat(s, nombre);
            cliente.setBounds(0,0,540,400);
            cliente.setVisible(true);
            new Thread(cliente).start();
        }catch (IOException ioe){

        }

    }

}
