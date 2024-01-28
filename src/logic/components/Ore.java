package logic.components;

public class Ore {
  public String name;
  public int cost;

  public Ore(String name, int cost) {
    this.name = name;
    if (cost < 1) {
      this.cost = 1;
    } else {
      this.cost = cost;
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
    Ore ore = (Ore) obj;
    return this.name.equals(ore.name) && this.cost == ore.cost;
  }

  public String getName() {
    return this.name;
  }

  public int getCost() {
    return this.cost;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCost(int cost) {
    if (cost < 1) {
      this.cost = 1;
    } else {
      this.cost = cost;
    }
  }
}
