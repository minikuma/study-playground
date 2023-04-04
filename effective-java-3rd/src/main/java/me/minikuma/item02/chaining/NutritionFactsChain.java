package me.minikuma.item02.chaining;

/**
 * 체이닝
 */
public class NutritionFactsChain {
    private final int servingSize;  // (mL, 1회 제공량)
    private final int servings;     // (회, 총 n회 제공량)
    private final int calories;     // (1회 제공량당)
    private final int fat;          // (g/1회 제공량)
    private final int sodium;       // (mg/1회 제공량)
    private final int carbohydrate; // (g/1회 제공량)


    public NutritionFactsChain(int servingSize, int servings) {
        this(servingSize, servings, 0, 0, 0, 0);
    }

    public NutritionFactsChain(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0, 0, 0);
    }

    public NutritionFactsChain(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0, 0);
    }

    public NutritionFactsChain(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFactsChain(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFactsChain nutritionFactsChain = new NutritionFactsChain(10, 100);
    }
}
