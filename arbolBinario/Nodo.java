package arbolBinario;

public class Nodo {
	private int dato;
	private Nodo izquierda, derecha;
	
	
	public Nodo(int info){
		dato= info;
		this.izquierda = null;
		this.derecha = null;
	}
	public String toString(){
		return "dato: " + dato;
	}
	public void setEnlanceIzq(Nodo izq){
		izquierda = izq;
	}
	public void setEnlanceDer(Nodo der){
		derecha = der;
	}
	
	public Nodo dameEnlaceIzquierda(){
		return izquierda;
	}
	public Nodo dameEnlaceDerecho(){
		return derecha;
	}

	public int dameDato(){
		return dato;
	}
}
