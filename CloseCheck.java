import java.util.*;

public class CloseCheck {

    public static class Coordinate {
        double abscissa, ordinate;

        public Coordinate(double abscissa, double ordinate) {
            this.abscissa = abscissa;
            this.ordinate = ordinate;
        }
    }

    public static class LineSegment {
        Coordinate startPoint, endPoint;

        public LineSegment(Coordinate startPoint, Coordinate endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }
    }

    private static double calculateDistance(Coordinate pointA, Coordinate pointB) {
        return Math.round(Math.sqrt(Math.pow(pointB.abscissa - pointA.abscissa, 2) + Math.pow(pointB.ordinate - pointA.ordinate, 2)) * 100.0) / 100.0;
    }

    private static double calculatedAreas(List<Coordinate> vertexList) {
        double areaSum = 0.0;
        for (int i = 0; i < vertexList.size(); i++) {
            Coordinate current = vertexList.get(i);
            Coordinate next = vertexList.get((i + 1) % vertexList.size());
            areaSum += (current.abscissa * next.ordinate - next.abscissa * current.ordinate);
        }
        return Math.round(Math.abs(areaSum) / 2 * 100.0) / 100.0;
    }

    private static boolean intersects(LineSegment segment1, LineSegment segment2) {
        Coordinate p1 = segment1.startPoint, q1 = segment1.endPoint;
        Coordinate p2 = segment2.startPoint, q2 = segment2.endPoint;

        int orientation1 = alignment(p1, q1, p2);
        int orientation2 = alignment(p1, q1, q2);
        int orientation3 = alignment(p2, q2, p1);
        int orientation4 = alignment(p2, q2, q1);

        return orientation1 != orientation2 && orientation3 != orientation4;
    }

    private static int alignment(Coordinate coordA, Coordinate coordB, Coordinate coordC) {
        double val = (coordB.ordinate - coordA.ordinate) * (coordC.abscissa - coordB.abscissa) - (coordB.abscissa - coordA.abscissa) * (coordC.ordinate - coordB.ordinate);
        return Double.compare(val, 0);
    }

    private static Map<Coordinate, List<Integer>> buildGraph(List<LineSegment> segmentList) {
        Map<Coordinate, List<Integer>> graphStructure = new HashMap<>();
        for (int i = 0; i < segmentList.size(); i++) {
            LineSegment line = segmentList.get(i);
            graphStructure.computeIfAbsent(line.startPoint, k -> new ArrayList<>()).add(i);
            graphStructure.computeIfAbsent(line.endPoint, k -> new ArrayList<>()).add(i);
        }
        return graphStructure;
    }

    public static String figure(int segmentCount, List<LineSegment> segmentList) {
        Map<Coordinate, List<Integer>> graphStructure = buildGraph(segmentList);
        Set<Integer> visitedEdges = new HashSet<>();

        List<Coordinate> traversedPath = new ArrayList<>();
        if (!tracePath(graphStructure, segmentList, visitedEdges, traversedPath, graphStructure.keySet().iterator().next())) {
            return "No";
        }

        if (traversedPath.size() < 3) {
            return "No";
        }

        double enclosedArea = calculatedAreas(traversedPath);

        List<LineSegment> unusedSegments = new ArrayList<>();
        for (int i = 0; i < segmentList.size(); i++) {
            if (!visitedEdges.contains(i)) {
                unusedSegments.add(segmentList.get(i));
            }
        }

        if (!unusedSegments.isEmpty()) {
            List<Coordinate> leftoverPath = new ArrayList<>();
            Map<Coordinate, List<Integer>> leftoverGraph = buildGraph(unusedSegments);
            visitedEdges.clear();
            if (tracePath(leftoverGraph, unusedSegments, visitedEdges, leftoverPath, leftoverGraph.keySet().iterator().next())) {
                double leftoverArea = calculatedAreas(leftoverPath);
                return "Yes\n" + (leftoverArea == enclosedArea ? "Yes" : "No") + "\n" + enclosedArea;
            }
        }

        return "Yes\nNo\n" + enclosedArea;
    }

    private static boolean tracePath(Map<Coordinate, List<Integer>> graphStructure, List<LineSegment> segmentList, Set<Integer> visitedEdges, List<Coordinate> traversedPath, Coordinate startingNode) {
        Stack<Coordinate> traversalStack = new Stack<>();
        traversalStack.push(startingNode);

        while (!traversalStack.isEmpty()) {
            Coordinate currentPoint = traversalStack.pop();
            if (!traversedPath.contains(currentPoint)) {
                traversedPath.add(currentPoint);
            }

            for (int edge : graphStructure.getOrDefault(currentPoint, new ArrayList<>())) {
                if (!visitedEdges.contains(edge)) {
                    visitedEdges.add(edge);
                    LineSegment segment = segmentList.get(edge);
                    Coordinate nextPoint = segment.startPoint.equals(currentPoint) ? segment.endPoint : segment.startPoint;
                    traversalStack.push(nextPoint);
                }
            }
        }

        return !traversedPath.isEmpty();
    }

    public static void main(String[] args) {
        List<LineSegment> sampleSegments = Arrays.asList(
                new LineSegment(new Coordinate(2, 1), new Coordinate(2, 6)),
                new LineSegment(new Coordinate(5, 1), new Coordinate(5, 6)),
                new LineSegment(new Coordinate(0, 2), new Coordinate(6, 2)),
                new LineSegment(new Coordinate(0, 5), new Coordinate(6, 5))
        );

        String result = figure(sampleSegments.size(), sampleSegments);
        System.out.println(result);
    }
}

