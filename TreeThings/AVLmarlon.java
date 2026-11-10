
public class ArbolAVL<T extends Comparable<T>> {
    private NodeAVL<T> root;

    public ArbolAVL() {
        root = null;
    }

    public NodeAVL<T> getRaiz() {
        return root;
    }

    private int altura(NodeAVL<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    // Obtener el factor de balance de un nodo
    private int factorBalance(NodeAVL<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }

    private NodeAVL<T> rotacionDerecha(NodeAVL<T> y) {
        NodeAVL<T> x = y.getIzquierdo();
        NodeAVL<T> T2 = x.getDerecho();
        
        // Realizamos la rotacion
        x.setDerecho(y);
        y.setIzquierdo(T2);

        // Actualizar alturas
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);

        return x;
    }

    // Rotación simple a la izquierda
    private NodeAVL<T> rotacionIzquierda(NodeAVL<T> x) {
        NodeAVL<T> y = x.getDerecho();
        NodeAVL<T> T2 = y.getIzquierdo();

        // Realizar rotación
        y.setIzquierdo(x);
        x.setDerecho(T2);

        // Actualizar alturas
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);

        return y;
    }

    // Insertar un nuevo dato en el árbol
    public void insertar(T dato) {
        root = insertar(root, dato);
    }

    private NodeAVL<T> insertar(NodeAVL<T> nodo, T dato) {
        if (nodo == null) {
            return new NodeAVL<>(dato);
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertar(nodo.getDerecho(), dato));
        } else {
            // No se permiten duplicados
            return nodo;
        }

        // 2. Actualizar altura del nodo actual
        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));

        // 3. Obtener el factor de balance para verificar si está desbalanceado
        int balance = factorBalance(nodo);

        // Si el nodo está desbalanceado, hay 4 casos posibles

        // Caso izquierda-izquierda
        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) < 0) {
            return rotacionDerecha(nodo);
        }

        // Caso derecha-derecha
        if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) > 0) {
            return rotacionIzquierda(nodo);
        }

        // Caso izquierda-derecha
        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) > 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }

        // Caso derecha-izquierda
        if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) < 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        // Si no necesita balanceo, devolver el nodo sin cambios
        return nodo;
    }

    /**
     * Elimina un dato del árbol, re-balanceando en el camino de vuelta igual que insertar.
     * Si el dato no existe, el árbol queda sin cambios.
     */
    public void eliminar(T dato) {
        root = eliminar(root, dato);
    }

    private NodeAVL<T> eliminar(NodeAVL<T> nodo, T dato) {
        if (nodo == null) {
            return null; // el dato no existe, no hay nada que hacer
        }

        // 1. Eliminación normal de BST
        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(eliminar(nodo.getDerecho(), dato));
        } else {
            // Este es el nodo a eliminar
            if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {
                NodeAVL<T> hijo = (nodo.getIzquierdo() != null) ? nodo.getIzquierdo() : nodo.getDerecho();
                nodo = hijo; // 0 o 1 hijo: se reemplaza directamente (puede quedar null)
            } else {
                // 2 hijos: reemplazar por el sucesor in-order (el mínimo del subárbol derecho)
                NodeAVL<T> sucesor = minimo(nodo.getDerecho());
                nodo.setDato(sucesor.getDato());
                nodo.setDerecho(eliminar(nodo.getDerecho(), sucesor.getDato()));
            }
        }

        if (nodo == null) {
            return null; // el nodo eliminado no tenía hijos
        }

        // 2. Actualizar altura
        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));

        // 3. Re-balancear igual que en insertar, usando el factor de balance de los hijos
        int balance = factorBalance(nodo);

        if (balance > 1 && factorBalance(nodo.getIzquierdo()) >= 0) {
            return rotacionDerecha(nodo);
        }
        if (balance > 1 && factorBalance(nodo.getIzquierdo()) < 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && factorBalance(nodo.getDerecho()) <= 0) {
            return rotacionIzquierda(nodo);
        }
        if (balance < -1 && factorBalance(nodo.getDerecho()) > 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    
 }
