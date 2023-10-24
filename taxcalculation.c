#include <stdio.h>

int main() {
    int choice;
    do {
        printf("Select an option:\n");
        printf("1. Calculate final price for a single product\n");
        printf("2. Calculate final prices for multiple products\n");
        printf("3. Exit\n");
        scanf("%d", &choice);

        if (choice == 1) {
            float actualPrice, taxPercentage;

            printf("Enter the actual price of the product: ");
            scanf("%f", &actualPrice);

            printf("Enter the tax percentage: ");
            scanf("%f", &taxPercentage);

            float totalCost = actualPrice + (actualPrice * taxPercentage / 100);
            float finalPrice = totalCost;

            printf("Final price of the product: %.2f\n", finalPrice);
        } else if (choice == 2) {
            int numProducts;

            printf("Enter the number of products: ");
            scanf("%d", &numProducts);

            for (int i = 0; i < numProducts; i++) {
                char itemName[50], itemCode[10];
                float stockPrice, taxPercentage;

                printf("\nEnter details for product %d:\n", i + 1);

                printf("Enter item name: ");
                scanf("%s", itemName);

                printf("Enter item code: ");
                scanf("%s", itemCode);

                printf("Enter stock price: ");
                scanf("%f", &stockPrice);

                printf("Enter tax percentage: ");
                scanf("%f", &taxPercentage);

                float totalCost = stockPrice + (stockPrice * taxPercentage / 100);
                float finalPrice = totalCost;

                printf("\nProduct %d - %s (%s)\n", i + 1, itemName, itemCode);
                printf("Final price: %.2f\n", finalPrice);
            }
        }
    } while (choice != 3);

    printf("Exiting the program.\n");

    return 0;
}
