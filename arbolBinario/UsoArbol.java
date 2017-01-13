package arbolBinario;

import javax.swing.JOptionPane;

public class UsoArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 0, elemento;
		Arbol arbol = new Arbol();

		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Ingresa nuevo nodo.\n" + "2. InOrden \n" + "3. PostOrden \n" + "4. PreOrden \n"
								+ "5. Buscar dato.\n" + "6. Eliminar un dato. \n" +
								"7. Salir. \n" + "Elige una opción",
						"Menú", JOptionPane.QUESTION_MESSAGE));

				switch (opcion) {
				case 1:
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Teclea un número.",
							"Entrada de datos", JOptionPane.QUESTION_MESSAGE));
					arbol.nuevoNod(elemento);
					System.out.println("Elemento insertado correctamente. ");
					break;
				case 2:
					System.out.println("");
					arbol.imprimeInOrden();
					System.out.println("");
					break;
				case 3:
					System.out.println("");
					arbol.imprimePostOrden();
					System.out.println("");
					break;
				case 4:
					System.out.println("");
					arbol.imprimePreOrden();
					System.out.println("");
					break;
				case 5:
					if (!arbol.vacio()) {
						
					
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Teclea el número a buscar.",
							"Buscando Nodo ", JOptionPane.WARNING_MESSAGE));
					
					if (arbol.buscaNodo(elemento) != null) {
						System.out.println(arbol.buscaNodo(elemento) + "\t ¡Encontrado!.");	
						}else{
						JOptionPane.showMessageDialog(null,"El dato que ha escrito no está en el árbol binario","Sin coincidencias",JOptionPane.WARNING_MESSAGE);
					}
					}else{
						JOptionPane.showMessageDialog(null, "Árbol vacío", "Sin datos", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 6:
					/* if (!arbol.vacio()) {

						elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Teclea el número a eliminar.",
								"Elimina Nodo ", JOptionPane.WARNING_MESSAGE));
						
						if (arbol.eliminaNodo(elemento) == false) {
							JOptionPane.showMessageDialog(null,"El dato que ha escrito no está en el árbol binario","Sin coincidencias",JOptionPane.WARNING_MESSAGE);
							}else{
							System.out.println(arbol.buscaNodo(elemento) + "\t ¡Borrado!.");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Árbol vacío", "Sin datos", JOptionPane.WARNING_MESSAGE);
							} */
					break;
					case 7:	
						JOptionPane.showMessageDialog(null, "Finalizado.", "Salida", JOptionPane.INFORMATION_MESSAGE);
						break;
						
					default:
						JOptionPane.showMessageDialog(null, "Elige otra opción.", "Opción incorrecta",JOptionPane.ERROR_MESSAGE);
						break;
						}
				} catch (Exception e) {
					System.out.println("Error---> " + e.getMessage());
					opcion = 0;
					}
			} while (opcion != 7);
		}
	}
