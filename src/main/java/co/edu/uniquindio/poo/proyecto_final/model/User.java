package co.edu.uniquindio.poo.proyecto_final.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Person{
    private String id;
    private String fullName;
    private String phoneNum;
    private boolean hasCoupon;
    private Collection<Bill> listBill;
    private Collection<Purchase> listPurchase;
}
