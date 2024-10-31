import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("F");
        grafo.agregarVertice("G");
        grafo.agregarVertice("H");
        grafo.agregarVertice("I");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("B", "E");
        grafo.agregarArista("C", "F");
        grafo.agregarArista("C", "G");
        grafo.agregarArista("D", "E");
        grafo.agregarArista("D", "H");
        grafo.agregarArista("E", "I");
        grafo.agregarArista("F", "G");
        grafo.agregarArista("G", "H");
        grafo.agregarArista("H", "I");
        grafo.agregarArista("I", "F");

        grafo.mostrarSecuenciaDeGrados();
    }

    public static class Grafo {
        private Map<String, List<String>> adyacencia;

        public Grafo(){
            adyacencia = new HashMap<>();
        }

        public void agregarVertice(String vertice) {
            adyacencia.putIfAbsent(vertice, new ArrayList<>());
        }

        public void agregarArista(String origen, String destino){
            this.agregarVertice(origen);
            this.agregarVertice(destino);

            adyacencia.get(origen).add(destino);
            adyacencia.get(destino).add(origen);
        }

        public void mostrarSecuenciaDeGrados() {
            System.out.println("Secuencia de Grados de Cada Vertice:");
            for (String vertice : adyacencia.keySet()) {
                List<String> adyacentes = adyacencia.get(vertice);
                int grado = adyacentes.size();
                System.out.println("Vertice " + vertice + " -> Grado: " + grado);
            }
        }
    }

}