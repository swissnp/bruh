package logic.components;

public class Potion {
  private String name;
  private int price;
  private Status increasingStatus;

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

  public void setIncreasingStatus(Status increasingStatus) {
    this.increasingStatus = increasingStatus;
  }

  public String getName() {
    return this.name;
  }

  public int getPrice() {
    return this.price;
  }

  public Status getIncreasingStatus() {
    return this.increasingStatus;
  }

  public Potion(String name, int price, Status increasingStatus) {
    this.setName(name);
    this.setPrice(price);
    this.setIncreasingStatus(increasingStatus);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Potion potion = (Potion) obj;
    return this.name.equals(potion.name) && this.price == potion.price
        && this.increasingStatus.equals(potion.increasingStatus);
  }
}
