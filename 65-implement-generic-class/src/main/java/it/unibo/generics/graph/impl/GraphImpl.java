package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    Map<N, Set<N>> edgeList = new HashMap<>();

    public void addNode(N node) {
        if (node != null && !edgeList.containsKey(node)) {
            Set<N> list = new HashSet<>();
            edgeList.put(node, list);
        }  
    }

    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            edgeList.get(source).add(target);
        }

    }

    public Set<N> nodeSet() {
        return edgeList.keySet();
    }

    public Set<N> linkedNodes(N node) {
        return edgeList.get(node);
    }

    public List<N> getPath(N source, N target) {
        List<N> path = new LinkedList<>();

        /* caso base: il nodo corrente è il target */
        if (source.equals(target)) {
            path.add(target);

        }
        /* passo ricorsivo: controllo i path dei nodi
        adiacenti, se trovo un path che raggiunge il
        target (diverso da null) aggiungo in testa il
        nodo corrente */
        else {
            for (N currEdge : edgeList.get(source)) {
                path = getPath(currEdge, target); 
                if (path != null) {
                    path.add(0, source);
                    break;
                }
            }
        }
        return path;
    }
}
