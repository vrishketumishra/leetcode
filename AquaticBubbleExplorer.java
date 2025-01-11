import java.util.*;

public class AquaticBubbleExplorer {

    static class Sphere {
        int centerX, centerY, radius;
        Sphere(int x, int y, int r) {
            this.centerX = x;
            this.centerY = y;
            this.radius = r;
        }
    }

    static class FeePath {
        int startIndex, endIndex;
        FeePath(int start, int end) {
            this.startIndex = start;
            this.endIndex = end;
        }
    }

    static int bubbleAreaDimension;
    static int vehicleRadius;
    static int vehiclePosX, vehiclePosY;
    static int targetPosX, targetPosY;
    static List<Sphere> allStructures = new ArrayList<>();
    static List<FeePath> tollPaths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the dimension of the bubble world
        bubbleAreaDimension = scanner.nextInt();

        // Read vehicle's position and size
        vehiclePosX = scanner.nextInt();
        vehiclePosY = scanner.nextInt();
        vehicleRadius = scanner.nextInt();
        targetPosX = scanner.nextInt();
        targetPosY = scanner.nextInt();
        int structureCount = scanner.nextInt();
        for (int i = 0; i < structureCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int r = scanner.nextInt();
            allStructures.add(new Sphere(x, y, r));
        }
        int tollRoadCount = scanner.nextInt();
        for (int i = 0; i < tollRoadCount; i++) {
            int from = scanner.nextInt() - 1;  // Adjusting 1-based to 0-based index
            int to = scanner.nextInt() - 1;
            tollPaths.add(new FeePath(from, to));
        }

        // Find the minimum number of toll paths to be crossed
        int result = findOptimalFeePath();

        // Output the result
        if (result == Integer.MAX_VALUE) {
            System.out.println("Unreachable");
        } else {
            System.out.println(result);
        }
    }

    private static int findOptimalFeePath() {
        int n = allStructures.size();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (FeePath path : tollPaths) {
            graph.putIfAbsent(path.startIndex, new ArrayList<>());
            graph.putIfAbsent(path.endIndex, new ArrayList<>());
            graph.get(path.startIndex).add(path.endIndex);
            graph.get(path.endIndex).add(path.startIndex);
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] taxCrossed = new int[n];
        int startBuilding = -1;
        int destBuilding = -1;

        for (int i = 0; i < n; i++) {
            if (isVehicleTouchingStructure(vehiclePosX, vehiclePosY, vehicleRadius, allStructures.get(i))) {
                startBuilding = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (targetPosX >= allStructures.get(i).centerX - allStructures.get(i).radius &&
                    targetPosX <= allStructures.get(i).centerX + allStructures.get(i).radius &&
                    targetPosY >= allStructures.get(i).centerY - allStructures.get(i).radius &&
                    targetPosY <= allStructures.get(i).centerY + allStructures.get(i).radius) {
                destBuilding = i;
                break;
            }
        }

        if (startBuilding == -1 || destBuilding == -1) {
            return Integer.MAX_VALUE; // Impossible if no valid start or destination
        }
        queue.offer(new int[]{startBuilding, 0});
        visited[startBuilding] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentBuilding = current[0];
            int currentTaxCount = current[1];

            if (currentBuilding == destBuilding) {
                return currentTaxCount;
            }

            for (int neighbor : graph.getOrDefault(currentBuilding, new ArrayList<>())) {
                if (!visited[neighbor] && !isVehicleTouchingStructure(vehiclePosX, vehiclePosY, vehicleRadius, allStructures.get(neighbor))) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, currentTaxCount + 1});
                }
            }
        }

        return Integer.MAX_VALUE;  // No valid path
    }

    private static boolean isVehicleTouchingStructure(int posX, int posY, int radius, Sphere structure) {
        int distanceBetweenCenters = (int)Math.sqrt(Math.pow(posX - structure.centerX, 2) + Math.pow(posY - structure.centerY, 2));
        return distanceBetweenCenters < (radius + structure.radius);
    }

    private static boolean isVehicleInsideBubbleWorld(int posX, int posY, int radius) {
        return posX - radius >= 0 && posX + radius <= bubbleAreaDimension && posY - radius >= 0 && posY + radius <= bubbleAreaDimension;
    }
}
