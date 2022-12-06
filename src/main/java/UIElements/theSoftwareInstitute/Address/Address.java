package UIElements.theSoftwareInstitute.Address;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {

    private
    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer addressId;

    private
    @Column(name="address")
    String address;

    private
    @Column(name = "address2")
    String address2;

    private
    @Column(name = "district")
    String district;

    private
    @Column(name = "city_id")
    Integer cityId;

    private
    @Column(name = "postal_code")
    String postalCode;

    private
    @Column(name = "phone")
    String phone;

    private
    @Column(name = "location")
    byte[] location;

    public Address() {}

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getLocation() {
        return location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }


}
