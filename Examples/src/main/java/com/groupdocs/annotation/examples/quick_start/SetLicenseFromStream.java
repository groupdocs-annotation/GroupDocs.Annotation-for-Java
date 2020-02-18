package com.groupdocs.annotation.examples.quick_start;

import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.license.License;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * This example demonstrates how to set license from stream.
 * </p>
 */
public class SetLicenseFromStream {

    public static void run() {
        try {
            if (new File(Constants.LicensePath).isFile()) {
                final InputStream stream = new FileInputStream(Constants.LicensePath);
                try {
                    License license = new License();
                    license.setLicense(stream);
                } finally {
                    if (stream != null) {
                        stream.close();
                    }
                }
                if(!License.isValidLicense()) {
                    System.out.println("License set is failed");
                }
                System.out.println("License set successfully.");
            } else {
                System.out.println(
                        "\nWe do not ship any license with this example. "
                        + "\nVisit the GroupDocs site to obtain either a temporary or permanent license. "
                        + "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. "
                        + "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license."
                );
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}