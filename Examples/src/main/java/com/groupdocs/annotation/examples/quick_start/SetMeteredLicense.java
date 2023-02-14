package com.groupdocs.annotation.examples.quick_start;

import com.groupdocs.annotation.licenses.Metered;

/**
 * <p>
 * This example demonstrates how to set Metered license. Learn more about
 * Metered license at https://purchase.groupdocs.com/faqs/licensing/metered.
 * </p>
 */
public class SetMeteredLicense {

    public static void run() {
        try {
            String publicKey = "*****";
            String privateKey = "*****";
            Metered metered = new Metered();
            metered.setMeteredKey(publicKey, privateKey);
            System.out.println("License set successfully.");
        } catch (Throwable e) {
            e.getMessage();
        }
    }
}
