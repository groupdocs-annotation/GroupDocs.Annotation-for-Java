package com.groupdocs.examples.annotation.licensing;

import com.groupdocs.annotation.licenses.License;
import com.groupdocs.examples.annotation.utils.LicenseUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * This example demonstrates how to set license from stream.
 * </p>
 */
public class SetLicenseFromStream {

    public static void run() {
        try (final InputStream licenseStream = LicenseUtils.createLicenseStream()) {
            if (licenseStream != null) {

                License license = new License();
                license.setLicense(licenseStream);

                if (License.isValidLicense()) {
                    System.out.println("License set successfully.");
                } else {
                    System.out.println("License was NOT set.");
                }
            } else {
                System.out.println(
                        "\nWe do not ship any license with this example. " +
                                "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                                "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                                "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license." +
                                "\nCheck README.md to see how to configure the project to obtain license file"
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}