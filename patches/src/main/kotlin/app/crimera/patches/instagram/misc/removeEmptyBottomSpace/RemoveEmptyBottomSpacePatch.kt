/*
 * Copyright (C) 2026 piko <https://github.com/crimera/piko>
 *
 * See the included NOTICE file for GPLv3 §7(b) terms that apply to this code.
 */

package app.crimera.patches.instagram.misc.removeEmptyBottomSpace

import app.crimera.patches.instagram.misc.settings.settingsPatch
import app.crimera.patches.instagram.utils.Constants.COMPATIBILITY_INSTAGRAM
import app.crimera.patches.instagram.utils.Constants.PREF_DESCRIPTOR
import app.crimera.patches.instagram.utils.enableSettings
import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.extensions.InstructionExtensions.addInstructionsWithLabels
import app.morphe.patcher.extensions.InstructionExtensions.getInstruction
import app.morphe.patcher.extensions.InstructionExtensions.instructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.util.smali.ExternalLabel
import app.morphe.util.indexOfFirstInstruction
import app.morphe.util.registersUsed
import com.android.tools.smali.dexlib2.Opcode

internal object NavigationBarAdjusterFingerprint : Fingerprint(
    strings = listOf("android", "config_showNavigationBar", "_hasNavigationBar_notFound"),
)

// Thanks to MyInsta
@Suppress("unused")
val removeEmptyBottomSpacePatch =
    bytecodePatch(
        name = "Alttaki bos alani kaldir",
        description = "Alt gezinti cubugunun altindaki bos alani kaldirir.",
        default = false,
    ) {
        dependsOn(settingsPatch)
        compatibleWith(COMPATIBILITY_INSTAGRAM)

        execute {
            try {
                // Thanks to MyInsta.
                NavigationBarAdjusterFingerprint.apply {
                    val strIndex = stringMatches.firstOrNull()?.index ?: return@execute

                    method.apply {
                        val lastIfGtzInstructionBeforeStr =
                            instructions.lastOrNull {
                                it.location.index < strIndex &&
                                    it.opcode == Opcode.IF_GTZ
                            } ?: return@execute
                        val index = lastIfGtzInstructionBeforeStr.location.index

                        val firstSPutIndexAfterStr = indexOfFirstInstruction(strIndex, Opcode.SPUT)
                        if (firstSPutIndexAfterStr == -1) return@execute

                        val freeRegister = instructions
                            .filter { it.location.index > index }
                            .firstOrNull { it.registersUsed.isNotEmpty() }
                            ?.registersUsed?.firstOrNull()
                            ?: lastIfGtzInstructionBeforeStr.registersUsed.firstOrNull()
                            ?: 0

                        addInstructionsWithLabels(
                            index + 1,
                            """
                            invoke-static {}, $PREF_DESCRIPTOR->removeEmptyBottomSpace()Z
                            move-result v$freeRegister
                            if-nez v$freeRegister, :piko
                            """.trimIndent(),
                            ExternalLabel("piko", getInstruction(firstSPutIndexAfterStr)),
                        )
                        enableSettings("removeEmptyBottomSpace")
                    }
                }
            } catch (e: Exception) {
                // Ignore gracefully if bytecode structure changed
            }
        }
    }
