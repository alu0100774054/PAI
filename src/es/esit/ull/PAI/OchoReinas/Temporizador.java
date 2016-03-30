package es.esit.ull.PAI.OchoReinas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Temporizador extends JPanel implements Runnable {
  private final String TITULO = "Instrucciones del programa";
  private JLabel tiempo;                                        // Etiqueta que muestra el tiempo.
  private boolean cronometroActivo;                             // Define si el cronómetro está en marcha.
  private Thread hilo;                                          // Hilo del cronómetro.

  public Temporizador() {
    iniciarComponentes();
  }

  private void iniciarComponentes() {
    new JPanel();
    cronometroActivo = false;
    setBorder(BorderFactory.createTitledBorder(getTITULO()));
    setBackground(Color.WHITE);
    tiempo = new JLabel(" 00:00:000 ");
    tiempo.setFont(new Font( Font.SERIF, Font.BOLD, 50 ) );
    tiempo.setHorizontalAlignment( JLabel.CENTER );
    tiempo.setForeground( Color.BLUE );
    tiempo.setBackground( Color.WHITE );
    tiempo.setOpaque(true);

    add( tiempo, BorderLayout.CENTER );
  }

  public void iniciarCronometro() {
    setCronometroActivo(true);
    hilo = new Thread(this);
    hilo.start();
  }

  public void pararCronometro(){
    setCronometroActivo(false);
    hilo.stop();
    remove(tiempo);
    validate();
    tiempo = new JLabel();
    tiempo.setText(cambiarTexto());
    add(tiempo, BorderLayout.CENTER);
    //repaint();
    validate();
  }

  private String cambiarTexto() {
    tiempo.setText("hola");
    validate();
    return null;
  }

  private String getTITULO() {
    return TITULO;
  }

  private JLabel getTiempo() {
    return tiempo;
  }

  private void setTiempo(JLabel tiempo) {
    this.tiempo = tiempo;
  }

  private boolean isCronometroActivo() {
    return cronometroActivo;
  }

  private void setCronometroActivo(boolean cronometroActivo) {
    this.cronometroActivo = cronometroActivo;
  }

  private Thread getHilo() {
    return hilo;
  }

  private void setHilo(Thread hilo) {
    this.hilo = hilo;
  }

  @Override
  public void run() {
    Integer minutos = 0 , segundos = 0, milesimas = 0;
    //min es minutos, seg es segundos y mil es milesimas de segundo
    String min="", seg="", mil="";
    try
    {
      //Mientras cronometroActivo sea verdadero entonces seguira
      //aumentando el tiempo
      while(isCronometroActivo())
      {
        Thread.sleep( 4 );
        //Incrementamos 4 milesimas de segundo
        milesimas += 4;

        //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
        //y las milesimas de segundo de nuevo a 0
        if(milesimas == 1000)
        {
          milesimas = 0;
          segundos += 1;
          //Si los segundos llegan a 60 entonces aumenta 1 los minutos
          //y los segundos vuelven a 0
          if(segundos == 60)
          {
            segundos = 0;
            minutos++;
          }
        }

        //Esto solamente es estetica para que siempre este en formato
        //00:00:000
        if(minutos < 10) 
          min = "0" + minutos;
        else 
          min = minutos.toString();
        if(segundos < 10) 
          seg = "0" + segundos;
        else 
          seg = segundos.toString();

        if(milesimas < 10) 
          mil = "00" + milesimas;
        else if(milesimas < 100) 
          mil = "0" + milesimas;
        else 
          mil = milesimas.toString();

        //Colocamos en la etiqueta la informacion
        System.out.println( min + ":" + seg + ":" + mil );
        remove(tiempo);
        validate();
        tiempo = new JLabel();
        tiempo.setText(min + ":" + seg + ":" + mil );
        add(tiempo, BorderLayout.CENTER);
        //repaint();
        validate();
      }
    } catch(Exception e){}
    //Cuando se reincie se coloca nuevamente en 00:00:000
    //tiempo.setText( "00:00:000" );
    
  }
}
