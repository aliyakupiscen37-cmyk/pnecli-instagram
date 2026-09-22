/*
 * Copyright (C) 2026 piko <https://github.com/crimera/piko>
 *
 * See the included NOTICE file for GPLv3 §7(b) terms that apply to this code.
 */

package app.crimera.patches.instagram.misc.distractionFree

import app.crimera.patches.instagram.misc.settings.settingsPatch
import app.crimera.patches.instagram.utils.Constants.COMPATIBILITY_INSTAGRAM
import app.crimera.patches.instagram.utils.Constants.PREF_CALL_DESCRIPTOR
import app.crimera.patches.instagram.utils.Constants.USER_SESSION_CLASS
import app.crimera.patches.instagram.utils.enableSettings
import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructionsWithLabels
import app.morphe.patcher.extensions.InstructionExtensions.getInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.util.smali.ExternalLabel
import app.morphe.util.findFreeRegister
import app.morphe.util.indexOfFirstInstruction
import com.android.tools.smali.dexlib2.Opcode

internal object ShareSheetItemsBinderFingerprint : Fingerprint(
    returnType = "V",
    parameters = listOf("Ljava/util/List;", "Z", USER_SESSION_CLASS),
    definingClass = "Lcom/instagram/direct/fragment/sharesheet/view/DirectShareSheetFragmentMessageComposerViewBinder;",
)

@Suppress("unused")
val hideGroupCreationOnShareSheetPatch =
    bytecodePatch(
        name = "Paylasim menusundeki grup olusturma dugmesini gizle",
        description = "Paylasim sayfasindaki grup olusturma butonunu gizler.",
        default = false,
    ) {
        compatibleWith(COMPATIBILITY_INSTAGRAM)
        dependsOn(settingsPatch)
        execute {
            try {
                ShareSheetItemsBinderFingerprint.method.apply {
                    val firstGoto16Index = indexOfFirstInstruction(Opcode.GOTO_16)
                    if (firstGoto16Index == -1) return@execute
                    val firstInvokeStaticAfterGoto = indexOfFirstInstruction(firstGoto16Index, Opcode.INVOKE_STATIC)
                    if (firstInvokeStaticAfterGoto == -1) return@execute

                    val conditionIndex = firstGoto16Index + 2
                    val freeRegister = findFreeRegister(conditionIndex + 1)

                    addInstructionsWithLabels(
                        conditionIndex,
                        """
                        ${PREF_CALL_DESCRIPTOR}->hideGroupCreationOnSharesheet()Z
                         move-result v$freeRegister
                         if-eqz v$freeRegister, :piko
                         return-void
                        """.trimIndent(),
                        ExternalLabel("piko", getInstruction(firstInvokeStaticAfterGoto)),
                    )

                    enableSettings("hideGroupCreationOnSharesheet")
                }
            } catch (e: Throwable) {
                // Ignore gracefully
            }
        }
    }
