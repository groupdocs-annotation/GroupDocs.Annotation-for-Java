package com.groupdocs.annotation.examples.quick_start;

import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.licenses.License;
import java.io.File;

/**
 * <p>
 * This example demonstrates how to set license from file.
 * </p><p>
 * <hr>
 * The SetLicense method attempts to set a license from several locations
 * relative to the executable and GroupDocs.Annotation.dll. You can also use the
 * additional overload to load a license from a stream, this is useful for
 * instance when the License is stored as an embedded resource.
 * </hr></p>
 */
public class SetLicenseFromFile {

    public static void run() {
        if (new File(Constants.LicensePath).isFile()) {
            License license = new License();
            license.setLicense(Constants.LicensePath);
            System.out.println("License set successfully.");
            
            if(!License.isValidLicense()) {
               System.out.println("License set is failed");
            }
        } else {
            System.out.println(
                "\nWe do not ship any license with this example. "+
                "\nVisit the GroupDocs site to obtain either a temporary or permanent license. "+
                "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. "+
                "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license."
            );
        }
    }
}
