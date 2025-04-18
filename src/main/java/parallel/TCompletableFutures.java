package parallel;

import java.util.concurrent.CompletableFuture;

public class TCompletableFutures {

    // Exception handling method
    private static String handleException(String service, Throwable ex) {
        System.err.println("Failed to fetch " + service + ": " + ex.getMessage());
        return null; // Return null to signify failure in that future
    }

    // Simulated API methods
    private static String getUser() {
        return "User123";
    }

    private static String getUserTransaction() {
        return "Transaction456";
    }

    private static String getUserNumber() {
        throw new RuntimeException("User number fetch failed");
    }

    public static void main(String[] args) {
        // Call each API and handle errors for each future independently
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> getUser())
                .exceptionally(ex -> handleException("User", ex));
        CompletableFuture<String> transactionFuture = CompletableFuture.supplyAsync(() -> getUserTransaction())
                .exceptionally(ex -> handleException("Transaction", ex));
        CompletableFuture<String> userNumberFuture = CompletableFuture.supplyAsync(() -> getUserNumber())
                .exceptionally(ex -> handleException("UserNumber", ex));

        // Combine results when all are complete
        CompletableFuture<Void> result = userFuture.thenCombine(transactionFuture, (user, transaction) -> {
            if (user == null || transaction == null) throw new RuntimeException("A required API failed");
            return new Result(user, transaction);
        }).thenCombine(userNumberFuture, (partialResult, userNumber) -> {
            if (userNumber == null) throw new RuntimeException("A required API failed");
            return new CompleteResult(partialResult.user, partialResult.transaction, userNumber);
        }).thenAccept(completeResult -> {
            System.out.println("Computation with: " + completeResult);
        }).exceptionally(ex -> {
            System.err.println("Processing failed: " + ex.getMessage());
            return null;
        });

        // Wait for the chain to finish processing
        result.join();
    }

    public void resolve() {
        final Integer num1 = 10;
        final Integer num2 = 20;
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
                () -> num1 + num2
        ).thenApply((y) -> {
            return y * y;
        });

        future.thenAccept(System.out::println);
    }

    // Helper classes to represent combined results
    static class Result {
        String user, transaction;

        Result(String user, String transaction) {
            this.user = user;
            this.transaction = transaction;
        }
    }

    static class CompleteResult {
        String user;
        String transaction;
        String userNumber;

        CompleteResult(String user, String transaction, String userNumber) {
            this.user = user;
            this.transaction = transaction;
            this.userNumber = userNumber;
        }

        @Override
        public String toString() {
            return "User: " + user + ", Transaction: " + transaction + ", UserNumber: " + userNumber;
        }
    }


}







