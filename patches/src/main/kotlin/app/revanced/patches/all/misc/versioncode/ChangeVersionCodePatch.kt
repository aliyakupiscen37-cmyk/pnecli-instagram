package app.revanced.patches.all.misc.versioncode

import app.crimera.patches.instagram.utils.Constants.COMPATIBILITY_INSTAGRAM
import app.morphe.patcher.patch.intOption
import app.morphe.patcher.patch.resourcePatch
import app.morphe.util.getNode
import org.w3c.dom.Element

@Suppress("unused")
val changeVersionCodePatch =
    resourcePatch(
        name = "Surum kodunu degistir",
        description = "Uygulamanin surum kodunu degistirir. Bu, uygulama magazasi guncellemelerini kapatir " +
                "ve mevcut yuklemeyi daha eski bir surume dusurmeye izin verir.",
        default = true,
    ) {
        val versionCode by intOption(
            key = "versionCode",
            default = Int.MAX_VALUE,
            values =
                mapOf(
                    "En Dusuk" to 1,
                    "En Yuksek" to Int.MAX_VALUE,
                ),
            title = "Surum kodu",
            description =
                "Kullanilacak surum kodu. En yuksek deger magazadan otomatik guncellemeleri engeller.",
            required = true,
        ) { versionCode -> versionCode!! >= 1 }

        compatibleWith(COMPATIBILITY_INSTAGRAM)

        execute {
            document("AndroidManifest.xml").use { document ->
                val manifestElement = document.getNode("manifest") as Element
                manifestElement.setAttribute("android:versionCode", "$versionCode")
            }
        }
    }
