package logic.components;

import java.util.ArrayList;

public class Market {
  private String name;
  private ArrayList<Food> foods;
  private ArrayList<Potion> potions;

  public Market(String name) {
    this.name = name;
    this.foods = new ArrayList<Food>();
    this.potions = new ArrayList<Potion>();
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<Food> getFoods() {
    return this.foods;
  }

  public ArrayList<Potion> getPotions() {
    return this.potions;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFoods(ArrayList<Food> foods) {
    this.foods = foods;
  }

  public void setPotions(ArrayList<Potion> potions) {
    this.potions = potions;
  }
}
