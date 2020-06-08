package cc.carretera;

import org.jcsp.lang.*;

public class CarreteraCSP implements Carretera, CSProcess {
  // TODO: Declaraci�n de canales
  // Ej. private Any2One chOp;
  private final Any2OneChannel[] Avanzar;

  // Configuraci�n de la carretera
  private final int segmentos;
  private final int carriles;

  public CarreteraCSP(int segmentos, int carriles) {
    
	this.segmentos = segmentos;
    this.carriles = carriles;
    this.Avanzar = new Any2OneChannel[segmentos];
    for(int i = 0;i<segmentos;i++) {
    	Avanzar[i] = Channel.any2one();
    }

    // TODO: Creaci�n de canales para comunicaci�n con el servidor
    // Ej. chOp = Channel.any2one();

    // Puesta en marcha del servidor: alternativa sucia (desde el
    // punto de vista de CSP) a Parallel que nos ofrece JCSP para
    // poner en marcha un CSProcess
    new ProcessManager(this).start();
  }

  public Pos entrar(String car, int tks) {
    // TODO: c�digo que ejecuta el cliente para enviar/recibir un
    // mensaje al server para que ejecute entrar
    return null;
  }

  public Pos avanzar(String car, int tks) {
    // TODO: c�digo que ejecuta el cliente para enviar/recibir un
    // mensaje al server para que ejecute avanzar
    return null;
  }

  public void salir(String car) {
    // TODO: c�digo que ejecuta el cliente para enviar un mensaje al
    // server para que ejecute salir
  }

  public void circulando(String car) {
    // TODO: c�digo que ejecuta el cliente para enviar un mensaje al
    // server para que ejecute circulando
  }

  public void tick() {
    // TODO: c�digo que ejecuta el cliente para enviar un mensaje al
    // server para que ejecute tick
  }

  // C�digo del servidor
  public void run() {
    // TODO: declaraci�n e inicializaci�n del estado del recurso

    // TODO: declaraci�n e inicializaci�n de estructuras de datos para
    // almacenar peticiones de los clientes

    // TODO: declaraci�n e inicializaci�n de arrays necesarios para
    // poder hacer la recepci�n no determinista (Alternative)

    // TODO: cambiar null por el array de canales
    Alternative servicios = new Alternative(null);

    // Bucle principal del servicio
    while(true){
      // TODO: declaraci�n de variables auxiliares
      int servicio;

      // TODO: c�lculo de las guardas

      // TODO: cambiar null por el array de guardas
      servicio = servicios.fairSelect(null);

      // TODO: ejecutar la operaci�n solicitada por el cliente
      switch (servicio){
      case 0:
        // TODO: ejecutar operaci�n 0 o almacenar la petici�n y
        // responder al cliente si es posible

        break;
      }

      // TODO: atender peticiones pendientes que puedan ser atendidas
    }
  }
}
