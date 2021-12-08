package unidad3.Servidor_Chat_UDP;

import unidad3.Servidor_Chat_TCP.ClienteChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class UDPMultiChat  extends JFrame implements ActionListener, Runnable{
    static MulticastSocket ms = null;
    static byte[] buf = new byte[1000];
    static InetAddress grupo = null;
    static int puerto = 12345;
    String nombre;
    static JTextField mensaje = new JTextField();

    private JScrollPane scrollpane1;
    static JTextArea textarea1;
    JButton boton = new JButton("Enviar");
    JButton desconectar = new JButton("Salir");
    boolean repetir = true;

    public UDPMultiChat(String nombreCliente){
        super(" CONEXIÓN DEL CLIENTE CHAT: " + nombreCliente);
        setLayout(null);

        mensaje.setBounds(10,10,400,30);
        add(mensaje);

        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10,50,400,300);
        add(scrollpane1);

        boton.setBounds(420,10,100,30);
        add(boton);
        desconectar.setBounds(420,50,100,30);
        add(desconectar);

        textarea1.setEditable(false);
        boton.addActionListener(this);
        desconectar.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.nombre = nombreCliente;
        try{
            String texto = " > Entra en el Chat ..." + nombre;
            DatagramPacket paquete = new DatagramPacket(texto.getBytes(),texto.length(),grupo,puerto);
            ms.send(paquete);

        }catch (IOException ioe){
            ioe.getMessage();
        }
    }

    public static void main(String[] args) throws IOException {
        String nombreInsertado = JOptionPane.showInputDialog("Introduce tu nombre o nick:");
        ms = new MulticastSocket(puerto);
        grupo = InetAddress.getByName("225.0.0.1");
        ms.joinGroup(grupo);

        if(!nombreInsertado.trim().equals("")){
            UDPMultiChat servidor = new UDPMultiChat(nombreInsertado);
            servidor.setBounds(0,0,540,400);
            servidor.setVisible(true);
            new Thread(servidor).start();
        }else{
            System.out.println("El nombre se encuentra vacío....");
        }

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton){
            String texto = nombre + ">> "+mensaje.getText();
            try{
                //ENVIANDO mensaje al grupo
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(),texto.length(),grupo,puerto);
                ms.send(paquete);
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
        if(e.getSource() == desconectar){
            String texto = "**** Abandona el chat: "+nombre+" ****";
            try{
                //ENVIANDO despedida al grupo
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(),texto.length(),grupo,puerto);
                ms.send(paquete);
                repetir = false;
                System.out.println("Abandona el chat: " + nombre);
                System.exit(0);
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

    public void run(){
        while(repetir){
            try{
                DatagramPacket p = new DatagramPacket(buf, buf.length);
                ms.receive(p);
                String texto = new String(p.getData(),0,p.getLength());
                textarea1.append(texto+"\n");
            }catch (SocketException se){
                System.out.println(se.getMessage());
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
