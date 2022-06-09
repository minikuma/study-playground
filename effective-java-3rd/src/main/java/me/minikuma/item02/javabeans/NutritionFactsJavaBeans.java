package me.minikuma.item02.javabeans;

/**
 * 자바빈즈
 */
public class NutritionFactsJavaBeans {
    private int servingSize;  // (mL, 1회 제공량)
    private int servings;     // (회, 총 n회 제공량)
    private int calories;     // (1회 제공량당)
    private int fat;          // (g/1회 제공량)
    private int sodium;       // (mg/1회 제공량)
    private int carbohydrate; // (g/1회 제공량)

    public NutritionFactsJavaBeans() {

    }

    public void setServingSize(int val) {
        servingSize = val;
    }

    public void setServings(int val) {
        this.servings = val;
    }

    public void setCalories(int val) {
        this.calories = val;
    }

    public void setFat(int val) {
        this.fat = val;
    }

    public void setSodium(int val) {
        this.sodium = val;
    }

    public void setCarbohydrate(int val) {
        this.carbohydrate = val;
    }

    public static void main(String[] args) {
        NutritionFactsJavaBeans nutritionFactsJavaBeans = new NutritionFactsJavaBeans();
        nutritionFactsJavaBeans.setCalories(100);
        nutritionFactsJavaBeans.setCalories(1000);
    }
}
