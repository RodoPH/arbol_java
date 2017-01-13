package arbolBinario;

import javax.swing.JOptionPane;

public class Arbol {
	private Nodo raiz,padre,enlace,reemplazo;
	int datoBusca;
	Nodo aux;
	boolean  enlanceIzq;

	public Arbol() {
		raiz = null;
	}

	// Insertar Nodo
	public void nuevoNod(int info) {

		Nodo nuevo = new Nodo(info);
		if (raiz == null) {
			raiz = nuevo;
		} else {
			Nodo aux = raiz;
			Nodo padre;
			while (true) {
				padre = aux;
				if (info < aux.dameDato()) {
					aux = aux.dameEnlaceIzquierda();
					if (aux == null) {
						padre.setEnlanceIzq(nuevo);
						return;
						// break;
					}
				} else {
					aux = aux.dameEnlaceDerecho();
					if (aux == null) {
						padre.setEnlanceDer(nuevo);
						return;
						// break;
					}
				}

			}
		}
	}

	// M�todo inOrden
	private void inOrden(Nodo raiz) {
		if (raiz != null) {
			inOrden(raiz.dameEnlaceIzquierda());
			System.out.print(raiz.dameDato() +", ");
			inOrden(raiz.dameEnlaceDerecho());
		}

	}

	// M�todo preOrden
	private void preOrden(Nodo raiz) {
		if (raiz != null) {
			System.out.print(raiz.dameDato() + ", ");
			preOrden(raiz.dameEnlaceIzquierda());
			preOrden(raiz.dameEnlaceDerecho());
		}
	}

	// M�todo postOrden
	private void postOrden(Nodo raiz) {
		if (raiz != null) {
			postOrden(raiz.dameEnlaceIzquierda());
			postOrden(raiz.dameEnlaceDerecho());
			System.out.print(raiz.dameDato() + ", ");
		}
	}

	public void imprimeInOrden() {
		if (!vacio()) {
			System.out.println("Recorrido Inorden");
			inOrden(dameRaiz());
		} else {
			JOptionPane.showMessageDialog(null, "El �rbol est� vac�o.", "Informaci�n", JOptionPane.WARNING_MESSAGE);

		}
	}

	public void imprimePreOrden() {
		if (!vacio()) {
			System.out.println("Recorrido Preorden");
			preOrden(dameRaiz());
		} else {
			JOptionPane.showMessageDialog(null, "El �rbol est� vac�o.", "Informaci�n", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void imprimePostOrden() {

		if (!vacio()) {
			System.out.println("Recorrido postorden");
			postOrden(dameRaiz());
		} else {
			JOptionPane.showMessageDialog(null, "El �rbol est� vac�o.", "Informaci�n", JOptionPane.WARNING_MESSAGE);

		}
	}

	// m�todo de b�squeda de nodo
	public Nodo buscaNodo(int n) {
		aux = dameRaiz();
			while (aux.dameDato() != n) {
				if (n < aux.dameDato()) {
					aux = aux.dameEnlaceIzquierda();
				} else {
					if (n == aux.dameDato()) {
						aux = aux.dameEnlaceDerecho();
					}
				}
			if(aux == null){
				return null;
			}
		}
		return aux;
	}
	
	/*public boolean eliminaNodo(int eliminarD){
		aux = raiz;
		padre = raiz;
		enlanceIzq =true;//para saber hacia d�nde ir
		
		while(aux.dameDato() != eliminarD){//Recorer el �rbol hasta que coincidan Nodo y dato a eliminar
			padre = aux;
			if(eliminarD < aux.dameDato()){//debe de ir por la izquierda
				enlanceIzq = true;
				aux = aux.dameEnlaceIzquierda();
			}else{//caso contrario. Se va por derecha
				enlanceIzq = false;
				aux = aux.dameEnlaceDerecho();
			}
			if(aux == null){//no existe en alg�n nodo del �rbol el dato
				return false;
			}
				
		}//cierre de while
		
		if(aux.dameEnlaceIzquierda() == null && aux.dameEnlaceDerecho()==null){ //Es una hoja
			if(aux == raiz){
				raiz = null; //se elimina la ra�z
			}else if(enlanceIzq){
				padre = padre.dameEnlaceIzquierda();
				padre = null;
				
			}else{
				padre = padre.dameEnlaceDerecho();
				padre = null;
			}
		}else if(aux.dameEnlaceDerecho() == null){ // que no hay nodo hacia la derecha
			if(aux == raiz){
				raiz = aux.dameEnlaceIzquierda(); //se elimina la ra�z
			}else if(enlanceIzq){
				padre = padre.dameEnlaceIzquierda();
				aux = aux.dameEnlaceIzquierda();
				padre = aux;				
			}else{
				padre = padre.dameEnlaceDerecho();
				aux = aux.dameEnlaceIzquierda();
				padre = aux;
			}
		}else if(aux.dameEnlaceIzquierda() == null){ //no hay nodo hacia el lado izquierdo
			if(aux == raiz){
				raiz = aux.dameEnlaceDerecho(); //se elimina la ra�z
			}else if(enlanceIzq){
				padre = padre.dameEnlaceIzquierda();
				aux = aux.dameEnlaceDerecho();
				padre = aux;				
			}else{
				padre = padre.dameEnlaceDerecho();
				aux = aux.dameEnlaceIzquierda();
				padre = aux;
			}
		}else{
			reemplazo=obtenerReemplazo(aux);
			if(aux == raiz ){
				raiz = reemplazo;
			}else if(enlanceIzq){
				padre = padre.dameEnlaceIzquierda();
				padre = reemplazo;
			}else{
				padre = padre.dameEnlaceDerecho();
				padre = reemplazo;
			}
			reemplazo = reemplazo.dameEnlaceIzquierda();
			aux = aux.dameEnlaceIzquierda();
			reemplazo = aux;
		}
		return true; //s� encontr� el nodo a eliminar
	}
*/	
	
	//Devuelve al nodo que reemplazar� a nodo eliminado
	public Nodo obtenerReemplazo(Nodo nReem){
		Nodo reePadre = nReem;
		Nodo reem = nReem;
		Nodo aux = nReem.dameEnlaceDerecho();
		
		while(aux != null){
			reePadre = reem;
			reem = aux;
			aux = aux.dameEnlaceIzquierda();
		}
		if(reem != nReem.dameEnlaceDerecho()){ //reacomodar los enlaces
			
			enlace = reem.dameEnlaceDerecho();
			reePadre = reePadre.dameEnlaceIzquierda();
			reePadre = enlace;
			
			enlace = nReem.dameEnlaceDerecho();
			reem = reem.dameEnlaceDerecho();
			reem = enlace;
			
		}
		System.out.println("El reemplazo es: " + reem);
		return reem;
	}
	
	public Nodo dameRaiz() { 
		return raiz;
	}

	public boolean vacio() {
		return raiz == null;

	}

}
