public class Address {
    private String houseNo;
    private String block;
    private String town;
    private String city;
    private String country;

    Address(String houseNo, String block, String town, String city, String country) {
        this.houseNo = houseNo;
        this.block = block;
        this.town = town;
        this.city = city;
        this.country = country;
    }

    public void setHouseNo(String houseNo) { 
        this.houseNo = houseNo; 
    }
    public String getHouseNo() {
        return houseNo;
    }

    public void setBlock(String block) { 
        this.block = block; 
    }
    public String getBlock() { 
        return block; 
    }

    public void setTown(String town) { 
        this.town = town; 
    }
    public String getTown() { 
        return town; 
    }

    public void setCity(String city) { 
        this.city = city; 
    }
    public String getCity() {
        return city; 
    }

    public void setCountry(String country) { 
        this.country = country; 
    }
    public String getCountry() {
        return country; 
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", houseNo, block, town, city, country);
    }
}
