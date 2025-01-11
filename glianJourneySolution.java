public class glianJourneySolution {

    // Directions in order (north, east, south, west)
    private static final String[] DIRECTION_LIST = {"north", "east", "south", "west"};

    // Helper function to get the index of a given direction
    private static int findDirectionIndex(String dir) {
        switch (dir) {
            case "north": return 0;
            case "east": return 1;
            case "south": return 2;
            case "west": return 3;
            default: return -1;
        }
    }

    // Function to calculate movement and return the updated position and current direction
    private static int[] calculateMovement(String turn, int dist, int[] currentPosition, int currentFacing) {
        switch (turn) {
            case "straight":
                if (currentFacing == 0) currentPosition[1] += dist; // north
                else if (currentFacing == 1) currentPosition[0] += dist; // east
                else if (currentFacing == 2) currentPosition[1] -= dist; // south
                else currentPosition[0] -= dist; // west
                break;
            case "left":
                currentFacing = (currentFacing + 3) % 4; // Turn left (90 degrees counterclockwise)
                if (currentFacing == 0) currentPosition[1] += dist; // north
                else if (currentFacing == 1) currentPosition[0] += dist; // east
                else if (currentFacing == 2) currentPosition[1] -= dist; // south
                else currentPosition[0] -= dist; // west
                break;
            case "right":
                currentFacing = (currentFacing + 1) % 4; // Turn right (90 degrees clockwise)
                if (currentFacing == 0) currentPosition[1] += dist; // north
                else if (currentFacing == 1) currentPosition[0] += dist; // east
                else if (currentFacing == 2) currentPosition[1] -= dist; // south
                else currentPosition[0] -= dist; // west
                break;
            case "back":
                currentFacing = (currentFacing + 2) % 4; // U-turn (180 degrees)
                if (currentFacing == 0) currentPosition[1] += dist; // north
                else if (currentFacing == 1) currentPosition[0] += dist; // east
                else if (currentFacing == 2) currentPosition[1] -= dist; // south
                else currentPosition[0] -= dist; // west
                break;
        }
        return currentPosition;
    }

    // Function to simulate the journey and compare paths
    public static void evaluateJourney(int numInstructions, String[] journeyInstructions, int[] initialPosition, int[] destinationCoords) {
        int[] agilanLocation = initialPosition.clone(); // Agilan's starting position
        int[] correctLocation = initialPosition.clone(); // Correct path's position
        int currentDirection = 0; // Agilan starts facing north

        // Variables to store the wrong turn and correct turn details
        String erroneousTurn = "";
        int erroneousDistance = 0;
        String rectifiedTurn = "";
        int rectifiedDistance = 0;

        boolean isErrorDetected = false;

        for (int i = 0; i < numInstructions; i++) {
            String[] command = journeyInstructions[i].split(" ");
            String turnDirection = command[0];
            int travelDistance = Integer.parseInt(command[1]);

            // Simulate Agilan's path
            agilanLocation = calculateMovement(turnDirection, travelDistance, agilanLocation, currentDirection);

            // Simulate the correct path
            correctLocation = calculateMovement(turnDirection, travelDistance, correctLocation, currentDirection);

            // Check if the current positions match after the move
            if (!isEqual(agilanLocation, correctLocation)) {
                if (!isErrorDetected) {
                    // Record the first discrepancy
                    erroneousTurn = turnDirection;
                    erroneousDistance = travelDistance;
                    // Determine the correct turn that should have been made
                    rectifiedTurn = getCorrectTurn(agilanLocation, correctLocation, turnDirection);
                    rectifiedDistance = travelDistance;
                    isErrorDetected = true;
                } else {
                    // If another error is detected after the first fix, we cannot correct the journey with just one fix
                    System.out.println("No");
                    return;
                }
            }
        }

        if (isErrorDetected) {
            System.out.println("Yes");
            System.out.println(erroneousTurn + " " + erroneousDistance);
            System.out.println(rectifiedTurn + " " + rectifiedDistance);
        } else {
            System.out.println("No");
        }
    }

    // Helper function to check if two positions are the same
    private static boolean isEqual(int[] positionA, int[] positionB) {
        return positionA[0] == positionB[0] && positionA[1] == positionB[1];
    }

    // Helper function to get the corrected turn
    private static String getCorrectTurn(int[] agilanPosition, int[] correctPosition, String currentTurn) {
        // Analyze the positions to determine the right turn
        // Logic can be expanded here based on exact route simulation
        return currentTurn.equals("right") ? "left" : "right";  // Example logic for correction
    }

    // Main function to execute the program
    public static void main(String[] args) {
        int N = 5;
        String[] instructions = {
                "right 5",
                "left 3",
                "left 3",
                "right 1",
                "right 2"
        };
        int[] agilanStart = {0, 0};
        int[] rabinHome = {0, 2};

        evaluateJourney(N, instructions, agilanStart, rabinHome);
    }
}

