package cc.carretera;

import java.util.HashMap;
import java.util.Map;

import org.jcsp.lang.*;

public class CarreteraCSP implements Carretera, CSProcess {
  private class Estado {
    private class EstadoCoche {
      private int tks;
      private int segmento = 0;
      private bool circulando = false;
      private One2OneChannel channel;

      public EstadoCoche(int tks) {
        this.tks = tks;
      }

      public void entra(int tks) {
        // TODO
      }
      
      public void circula() {
        // TODO
      }
        
      public void avanza(int tks) {
        // TODO
      }
        
      public void sale() {
        // TODO
      }
        
      public void tick() {
        // TODO
      }
    }
    
    // Esto es un mapa de coches. Con put(key, value) meto en la posicion
    // key el valor value. Con get(key), leo. Con remove(key), elimino.
    private Map<String, EstadoCoche> coches = new HashMap<>();

    public void entra(String id, int tks) {
      EstadoCoche estado = new EstadoCoche(tks);
      this.coches.put(id, estado);
      estado.entra();
    }

    public void circula(String id) {
      this.coches.get(id).circula();
    }

    public void avanza(String id, int tks) {
      this.coches.get(id).avanza(tks);
    }

    public void sale(String id) {
      this.coches.remove(id).sale();
    }

    public void tick() {
      // Esto es mas avanzado, pero es un bucle for.
      this.coches.entrySet().parallelStream().forEach((entry) -> entry.getValue().tick());
    }
  }


  // TODO: Declaración de canales
  // Ej. private Any2One chOp;
  private final Any2OneChannel[] Avanzar;
  private final Any2OneChannel[] Tks;
  private final One2OneChannel Circulando;

  // Configuración de la carretera
  private final int segmentos;
  private final int carriles;

  public CarreteraCSP(int segmentos, int carriles) {
    this.segmentos = segmentos;
    this.carriles = carriles;

    this.Avanzar = new Any2OneChannel[segmentos + 2];
    for(int i = 0; i < segmentos + 2; i++) {
    	Avanzar[i] = Channel.any2one();
    }

    this.Tks = new Any2OneChannel[segmentos + 2];
    for(int i = 0; i < segmentos;i++) {
    	Tks[i] = Channel.any2one();
    }

    Circulando = Channel.one2one();

    coches = new HashMap<>();
    // Puesta en marcha del servidor: alternativa sucia (desde el
    // punto de vista de CSP) a Parallel que nos ofrece JCSP para
    // poner en marcha un CSProcess
    new ProcessManager(this).start();
  }

  public Pos entrar(String car, int tks) {
    // TODO: código que ejecuta el cliente para enviar/recibir un
    // mensaje al server para que ejecute entrar

    return null;
  }

  public Pos avanzar(String car, int tks) {
    // TODO: código que ejecuta el cliente para enviar/recibir un
    // mensaje al server para que ejecute avanzar
    return null;
  }

  public void salir(String car) {
    // TODO: código que ejecuta el cliente para enviar un mensaje al
    // server para que ejecute salir
  }

  public void circulando(String car) {
    // TODO: código que ejecuta el cliente para enviar un mensaje al
    // server para que ejecute circulando
  }

  public void tick() {
    // TODO: código que ejecuta el cliente para enviar un mensaje al
    // server para que ejecute tick
  }

  // Código del servidor
  public void run() {
    // TODO: declaración e inicialización del estado del recurso

    // TODO: declaración e inicialización de estructuras de datos para
    // almacenar peticiones de los clientes

    // TODO: declaración e inicialización de arrays necesarios para
    // poder hacer la recepción no determinista (Alternative)

    // TODO: cambiar null por el array de canales
    Alternative servicios = new Alternative(null);

    // Bucle principal del servicio
    while(true){
      // TODO: declaración de variables auxiliares
      int servicio;

      // TODO: cálculo de las guardas

      // TODO: cambiar null por el array de guardas
      servicio = servicios.fairSelect(null);

      // TODO: ejecutar la operación solicitada por el cliente
      switch (servicio){
      case 0:
        // TODO: ejecutar operación 0 o almacenar la petición y
        // responder al cliente si es posible

        break;
      }

      // TODO: atender peticiones pendientes que puedan ser atendidas
    }
  }
}
