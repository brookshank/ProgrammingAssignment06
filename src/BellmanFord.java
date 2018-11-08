/**
 * Implementation of Bellman-Fords algorithm as seen in 24.1 of Intro to Algorithms
 *
 * @author Joseph Brooksbank
 */
public class BellmanFord extends SingleSourceShortestPath {

    BellmanFord(Graph graph, Vertex source){
        this.graph = graph;
        this.source = source;
    }

    boolean start(){
        initSingleSouce(source);

        for (int i = 0; i < graph.v.size() - 1; i++){
            for (Vertex aVert : graph.v){
                for (WeightedVertex anEdge : aVert.adj){
                    relax(aVert, anEdge.vertex);
                }
            }
        }
        for (Vertex aVert : graph.v){
            for (WeightedVertex anEdge : aVert.adj){
                if (anEdge.vertex.d > aVert.d + Vertex.w(aVert, anEdge.vertex)){
                    return false;
                }
            }
        }
        return true;
    }
}
