package co.edu.uniquindio.poo.proyecto_final.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UniEventos {
    private String nit;
    private Admin admin;
    private Map<String, String> coupons = new HashMap<>();
    private Collection<Bill> listBill = new ArrayList<>();
    private Collection<Purchase> listPurchase = new ArrayList<>();
    private Collection<Event> listEvents = new ArrayList<>();
    private Collection<User> listUsers = new ArrayList<>();

    /**
     * Aquí se genera un código de cupón único y se envía por correo electrónico
     * @param email
     */
    public void sendCoupon(String email) {
        String couponCode = generateCouponCode();
        coupons.put(email, couponCode);
        System.out.println("Se ha enviado un cupón a " + email + " con el código: " + couponCode);
    }

    /**
     * Genera un cupón aleatorio, pero no único
     * @return
     */
    private String generateCouponCode() {
        return "COUPON" + String.valueOf(Math.floor(Math.random() * (9999 - 1000 + 1)) + 1000);
    }

    /**
     * Verifica si el usuario ya ha utilizado el cupón y aplica el descuento del 15%
     * @param email
     * @param couponCode
     * @param purchase
     * @return El valor total con descuento, si el cupón no es válido, se devuelve el
     * precio total sin descuento
     */
    public double redeemCoupon(String email, String couponCode, Purchase purchase) {
        if (coupons.containsKey(email) && coupons.get(email).equals(couponCode)) {
            if (!userHasRedeemedCoupon(email)) {
                double discount = purchase.getTotalPrice() * 0.15;
                return purchase.getTotalPrice() - discount;
            } else {
                System.out.println("Este cupón ya ha sido utilizado.");
            }
        }
        System.out.println("El cupón ingresado no es válido.");
        return purchase.getTotalPrice();
    }

    private boolean userHasRedeemedCoupon(String email) {
        // Aquí podrías implementar la lógica para verificar si el usuario ya ha redimido el cupón anteriormente
        // Por ejemplo, podrías mantener un registro de usuarios que han redimido cupones en una base de datos
        // En este ejemplo simple, devolvemos siempre false, lo que significa que el usuario nunca ha redimido un cupón
        return false;
    }

    /**
     * @param user
     * @return un boolean, false si están vacíos o nulos, true sino
     */
    public boolean verifyDataUser(User user) {
        return !user.email.isBlank() && !user.password.isBlank();
    }

    /**
     * Añade un user a la lista y verifica los datos
     * @param user
     */
    public void registerUser(User user) {
    if (verifyDataUser(user) && !listUsers.contains(user)) {
        listUsers.add(user);
        }
    }
}
