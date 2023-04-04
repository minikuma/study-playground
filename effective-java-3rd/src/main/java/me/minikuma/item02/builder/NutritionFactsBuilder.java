package me.minikuma.item02.builder;

/**
 * Builder
 */
public class NutritionFactsBuilder {
    private final int servingSize;  // (mL, 1회 제공량)
    private final int servings;     // (회, 총 n회 제공량)
    private final int calories;     // (1회 제공량당)
    private final int fat;          // (g/1회 제공량)
    private final int sodium;       // (mg/1회 제공량)
    private final int carbohydrate; // (g/1회 제공량)

    public static class Builder {
        private final int servingSize;
        private final int servings;

        // 선택 매개 변수
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        // 필수 값 세팅
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;
        }

        public NutritionFactsBuilder build() {
            return new NutritionFactsBuilder(this);
        }
    }

    private NutritionFactsBuilder(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFactsBuilder coke = new Builder(240, 10)
                .calories(100)
                .fat(100)
                .carbohydrate(1)
                .build();
    }
}
