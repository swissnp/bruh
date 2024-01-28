package logic.components;

public class Food {
  public String name;
  public int price;
  public int energy;

  public Food(String name, int price, int energy) {
    this.name = name;
    if (price < 1) {
      this.price = 1;
    } else {
      this.price = price;
    }
    if (energy < 1) {
      this.energy = 1;
    } else {
      this.energy = energy;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Food food = (Food) obj;
    return this.name.equals(food.name) && this.price == food.price && this.energy == food.energy;
  }

  public String getName() {
    return this.name;
  }

  public int getPrice() {
    return this.price;
  }

  public int getEnergy() {
    return this.energy;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(int price) {
    if (price < 1) {
      this.price = 1;
    } else {
      this.price = price;
    }
  }

  public void setEnergy(int energy) {
    if (energy < 1) {
      this.energy = 1;
    } else {
      this.energy = energy;
    }
  }

}
